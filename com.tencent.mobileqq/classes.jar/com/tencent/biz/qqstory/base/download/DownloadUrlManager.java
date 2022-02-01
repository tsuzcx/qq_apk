package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadUrlManager
  extends BaseManger
{
  private LruCache<String, List<VideoUrlEntry>> jdField_a_of_type_AndroidUtilLruCache = new LruCache(100);
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private LruCache<String, DownloadingUrlEntry> b = new LruCache(300);
  private LruCache<String, DownloadUrlManager.DownloadUrlQueryResult> c = new LruCache(200);
  
  private DownloadingUrlEntry a(String paramString, int paramInt)
  {
    Object localObject = (DownloadingUrlEntry)this.b.get(DownloadingUrlEntry.makeKey(paramString, paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = StoryManager.a(QQStoryContext.a().a().createEntityManager(), DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (DownloadingUrlEntry)((List)localObject).get(0);
      this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject);
      return localObject;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = new URL(paramString).getHost();
      if (TextUtils.isEmpty(str)) {
        break label47;
      }
      str = InnerDns.getInstance().reqDns(str, 1012);
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label32:
      label47:
      break label32;
    }
    SLog.d("Q.qqstory.DownloadUrlManager", "getIpOfDomain url: %s", new Object[] { paramString });
    return null;
  }
  
  private void a(@NonNull String paramString, @NonNull DownloadUrlManager.PullNewVideoInfoCallBack paramPullNewVideoInfoCallBack)
  {
    SLog.b("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary , vid = %s", paramString);
    Bosses.get().postJob(new DownloadUrlManager.5(this, "Q.qqstory.DownloadUrlManager", paramString, paramPullNewVideoInfoCallBack));
  }
  
  private boolean a(String paramString)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (localStoryVideoItem == null)
    {
      SLog.e("pullNewVideoInfoIfNecessaryBlock:: error get vid=%s", paramString);
      return false;
    }
    if (localStoryVideoItem.videoUrlExpireTime <= 0L) {
      return false;
    }
    if (localStoryVideoItem.videoUrlExpireTime - NetConnInfoCenter.getServerTimeMillis() > 7200000L) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localStoryVideoItem.mVid);
    ((StringBuilder)localObject).append(" request video url is expire :");
    ((StringBuilder)localObject).append(localStoryVideoItem.videoUrlExpireTime);
    SLog.d("Q.qqstory.DownloadUrlManager", ((StringBuilder)localObject).toString());
    GetVideoFullInfoListRequest localGetVideoFullInfoListRequest = new GetVideoFullInfoListRequest();
    localGetVideoFullInfoListRequest.jdField_a_of_type_JavaUtilList = new ArrayList(1);
    localGetVideoFullInfoListRequest.jdField_a_of_type_JavaUtilList.add(paramString);
    localGetVideoFullInfoListRequest.jdField_a_of_type_Long = 10000L;
    localObject = new Object();
    AtomicBoolean localAtomicBoolean1 = new AtomicBoolean(false);
    AtomicBoolean localAtomicBoolean2 = new AtomicBoolean(false);
    paramString = new DownloadUrlManager.7(this, paramString, localObject, localAtomicBoolean1, localAtomicBoolean2);
    CmdTaskManger.a().a(localGetVideoFullInfoListRequest, paramString);
    if (localStoryVideoItem.videoUrlExpireTime > NetConnInfoCenter.getServerTimeMillis())
    {
      SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url expire after 2h, so we don't lock!");
      return false;
    }
    try
    {
      SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: request video url expire, so we request video info and lock");
      try
      {
        if (!localAtomicBoolean1.get())
        {
          localAtomicBoolean2.set(true);
          localObject.wait(12000L);
        }
      }
      catch (InterruptedException paramString)
      {
        paramString.printStackTrace();
      }
      return true;
    }
    finally {}
  }
  
  private DownloadUrlManager.DownloadUrlQueryResult b(String paramString, int paramInt)
  {
    paramString = DownloadingUrlEntry.makeKey(paramString, paramInt);
    paramString = (DownloadUrlManager.DownloadUrlQueryResult)this.c.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.jdField_b_of_type_JavaLangString)) && (Math.abs(System.currentTimeMillis() - paramString.jdField_a_of_type_Long) <= 300000L)) {
      return paramString;
    }
    return null;
  }
  
  @Deprecated
  private void b(@NonNull String paramString, @NonNull DownloadUrlManager.PullNewVideoInfoCallBack paramPullNewVideoInfoCallBack)
  {
    SLog.b("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessaryInner , vid = %s", paramString);
    Object localObject = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (localObject == null)
    {
      SLog.e("Q.qqstory.DownloadUrlManager", "DownloadUrlQueryResult:: error video is null");
      paramPullNewVideoInfoCallBack.a(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime <= 0L)
    {
      paramPullNewVideoInfoCallBack.a(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime - NetConnInfoCenter.getServerTimeMillis() > 0L)
    {
      paramPullNewVideoInfoCallBack.a(false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((StoryVideoItem)localObject).mVid);
    localStringBuilder.append(" request video url is expire :");
    localStringBuilder.append(((StoryVideoItem)localObject).videoUrlExpireTime);
    SLog.d("Q.qqstory.DownloadUrlManager", localStringBuilder.toString());
    localObject = new GetVideoFullInfoListRequest();
    ((GetVideoFullInfoListRequest)localObject).jdField_a_of_type_JavaUtilList = new ArrayList(1);
    ((GetVideoFullInfoListRequest)localObject).jdField_a_of_type_JavaUtilList.add(paramString);
    ((GetVideoFullInfoListRequest)localObject).jdField_a_of_type_Long = 10000L;
    paramString = new DownloadUrlManager.6(this, paramPullNewVideoInfoCallBack, paramString);
    CmdTaskManger.a().a((NetworkRequest)localObject, paramString);
  }
  
  public DownloadUrlManager.DownloadUrlQueryResult a(String paramString, int paramInt)
  {
    AssertUtils.notMainThreadCheck();
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = new DownloadUrlManager.DownloadUrlQueryResult();
    localDownloadUrlQueryResult.jdField_a_of_type_JavaLangString = paramString;
    localDownloadUrlQueryResult.jdField_a_of_type_Int = paramInt;
    Object localObject3 = (StoryManager)SuperManager.a(5);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      int i;
      Object localObject1;
      if ((paramInt == 0) && (a(paramString)))
      {
        i = 1;
      }
      else
      {
        localObject1 = a(paramString, paramInt);
        if ((localObject1 != null) && (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted == 0))
        {
          localDownloadUrlQueryResult.jdField_b_of_type_Int = 0;
          localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          localDownloadUrlQueryResult.c = ((DownloadingUrlEntry)localObject1).compressLevel;
        }
      }
      for (;;)
      {
        localDownloadUrlQueryResult.a();
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return localDownloadUrlQueryResult;
        i = 0;
        localDownloadUrlQueryResult.jdField_a_of_type_Boolean = true;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = localObject2;
          if (a())
          {
            List localList = a(paramString);
            localObject1 = localObject2;
            if (localList != null)
            {
              localObject1 = localObject2;
              if (localList.size() > 0)
              {
                localObject2 = (VideoUrlEntry)localList.get(0);
                localObject1 = new DownloadingUrlEntry();
                ((DownloadingUrlEntry)localObject1).vid = ((VideoUrlEntry)localObject2).vid;
                ((DownloadingUrlEntry)localObject1).url = ((VideoUrlEntry)localObject2).videoUrl;
                ((DownloadingUrlEntry)localObject1).fileType = 0;
                ((DownloadingUrlEntry)localObject1).compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
                ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
                localDownloadUrlQueryResult.jdField_b_of_type_Int = 2;
                localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
                localDownloadUrlQueryResult.c = ((VideoUrlEntry)localObject2).videoUrlLevel;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (localDownloadUrlQueryResult.jdField_b_of_type_Int == -1)
        {
          localObject3 = ((StoryManager)localObject3).a(paramString);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = new DownloadingUrlEntry();
            ((DownloadingUrlEntry)localObject2).vid = ((StoryVideoItem)localObject3).mVid;
            ((DownloadingUrlEntry)localObject2).fileType = paramInt;
            if (paramInt == 0) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getVideoUrl();
            } else if (paramInt == 1) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getDownloadMaskUrl();
            } else if (paramInt == 2) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getThumbUrl();
            }
            ((DownloadingUrlEntry)localObject2).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject2).vid, ((DownloadingUrlEntry)localObject2).fileType);
            localDownloadUrlQueryResult.jdField_b_of_type_Int = 3;
            localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject2).url;
          }
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject2).url)))
        {
          localObject1 = FileCacheUtils.a(paramString, paramInt, false, false);
          if ((localObject1 == null) || (!((File)localObject1).exists()))
          {
            ((DownloadingUrlEntry)localObject2).updatedMs = System.currentTimeMillis();
            this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject2);
            QQStoryContext.a().a().createEntityManager().persistOrReplace((Entity)localObject2);
          }
        }
        if (i != 0)
        {
          SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
          paramString = a(paramString, paramInt);
          if ((paramString != null) && (TextUtils.equals(paramString.url, localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=");
            ((StringBuilder)localObject1).append(paramString.url);
            ((StringBuilder)localObject1).append(" result url=");
            ((StringBuilder)localObject1).append(localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString);
            SLog.d("Q.qqstory.DownloadUrlManager", ((StringBuilder)localObject1).toString());
            localDownloadUrlQueryResult.jdField_a_of_type_Boolean = false;
          }
          else if (paramString == null)
          {
            SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :");
            ((StringBuilder)localObject1).append(paramString.url);
            SLog.d("Q.qqstory.DownloadUrlManager", ((StringBuilder)localObject1).toString());
          }
        }
      }
      throw paramString;
    }
    finally
    {
      localDownloadUrlQueryResult.a();
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    for (;;) {}
  }
  
  public DownloadUrlManager.DownloadUrlQueryResult a(String paramString, int paramInt, boolean paramBoolean)
  {
    AssertUtils.notMainThreadCheck();
    String str = DownloadingUrlEntry.makeKey(paramString, paramInt);
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = new DownloadUrlManager.DownloadUrlQueryResult();
    localDownloadUrlQueryResult.jdField_a_of_type_JavaLangString = paramString;
    localDownloadUrlQueryResult.jdField_a_of_type_Int = paramInt;
    Object localObject3 = (StoryManager)SuperManager.a(5);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      Object localObject1 = a(paramString, paramInt);
      if ((localObject1 != null) && (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted == 0))
      {
        localDownloadUrlQueryResult.jdField_b_of_type_Int = 0;
        localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
        localDownloadUrlQueryResult.c = ((DownloadingUrlEntry)localObject1).compressLevel;
      }
      for (;;)
      {
        localDownloadUrlQueryResult.a();
        localDownloadUrlQueryResult.jdField_a_of_type_Long = System.currentTimeMillis();
        this.c.put(str, localDownloadUrlQueryResult);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return localDownloadUrlQueryResult;
        localDownloadUrlQueryResult.jdField_a_of_type_Boolean = true;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = localObject2;
          if (a())
          {
            List localList = a(paramString);
            localObject1 = localObject2;
            if (localList != null)
            {
              localObject1 = localObject2;
              if (localList.size() > 0)
              {
                localObject2 = (VideoUrlEntry)localList.get(0);
                localObject1 = new DownloadingUrlEntry();
                ((DownloadingUrlEntry)localObject1).vid = ((VideoUrlEntry)localObject2).vid;
                ((DownloadingUrlEntry)localObject1).url = ((VideoUrlEntry)localObject2).videoUrl;
                ((DownloadingUrlEntry)localObject1).fileType = 0;
                ((DownloadingUrlEntry)localObject1).compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
                ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
                localDownloadUrlQueryResult.jdField_b_of_type_Int = 2;
                localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
                localDownloadUrlQueryResult.c = ((VideoUrlEntry)localObject2).videoUrlLevel;
              }
            }
          }
        }
        localObject2 = localObject1;
        if (localDownloadUrlQueryResult.jdField_b_of_type_Int == -1)
        {
          localObject3 = ((StoryManager)localObject3).a(paramString);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = new DownloadingUrlEntry();
            ((DownloadingUrlEntry)localObject2).vid = ((StoryVideoItem)localObject3).mVid;
            ((DownloadingUrlEntry)localObject2).fileType = paramInt;
            if (paramInt == 0) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getVideoUrl();
            } else if (paramInt == 1) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getDownloadMaskUrl();
            } else if (paramInt == 2) {
              ((DownloadingUrlEntry)localObject2).url = ((StoryVideoItem)localObject3).getThumbUrl();
            }
            ((DownloadingUrlEntry)localObject2).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject2).vid, ((DownloadingUrlEntry)localObject2).fileType);
            localDownloadUrlQueryResult.jdField_b_of_type_Int = 3;
            localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject2).url;
          }
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject2).url)))
        {
          localObject1 = FileCacheUtils.a(paramString, paramInt, false, false);
          if ((localObject1 == null) || (!((File)localObject1).exists()))
          {
            ((DownloadingUrlEntry)localObject2).updatedMs = System.currentTimeMillis();
            this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject2);
            QQStoryContext.a().a().createEntityManager().persistOrReplace((Entity)localObject2);
          }
        }
        if (paramBoolean)
        {
          SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
          paramString = a(paramString, paramInt);
          if ((paramString != null) && (TextUtils.equals(paramString.url, localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString)))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=");
            ((StringBuilder)localObject1).append(paramString.url);
            ((StringBuilder)localObject1).append(" result url=");
            ((StringBuilder)localObject1).append(localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString);
            SLog.d("Q.qqstory.DownloadUrlManager", ((StringBuilder)localObject1).toString());
            localDownloadUrlQueryResult.jdField_a_of_type_Boolean = false;
          }
          else if (paramString == null)
          {
            SLog.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :");
            ((StringBuilder)localObject1).append(paramString.url);
            SLog.d("Q.qqstory.DownloadUrlManager", ((StringBuilder)localObject1).toString());
          }
        }
      }
      throw paramString;
    }
    finally
    {
      localDownloadUrlQueryResult.a();
      localDownloadUrlQueryResult.jdField_a_of_type_Long = System.currentTimeMillis();
      this.c.put(str, localDownloadUrlQueryResult);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    for (;;) {}
  }
  
  public List<VideoUrlEntry> a(String paramString)
  {
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    List localList = StoryManager.a(QQStoryContext.a().a().createEntityManager(), VideoUrlEntry.class, VideoUrlEntry.class.getSimpleName(), "vid=?", new String[] { paramString });
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList(0);
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localObject);
    return localObject;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      if (TroopStoryUtil.a(paramString)) {
        return;
      }
      Bosses.get().postJob(new DownloadUrlManager.3(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
    }
  }
  
  public void a(String paramString, int paramInt, DownloadUrlManager.QueryUrlResultUICallBack paramQueryUrlResultUICallBack)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = b(paramString, paramInt);
    if (localDownloadUrlQueryResult != null)
    {
      paramQueryUrlResultUICallBack.a(localDownloadUrlQueryResult);
      return;
    }
    if (paramInt == 0)
    {
      a(paramString, new DownloadUrlManager.1(this, paramString, paramInt, paramQueryUrlResultUICallBack));
      return;
    }
    Bosses.get().postJob(new DownloadUrlManager.2(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt, paramQueryUrlResultUICallBack));
  }
  
  public void a(List<List<VideoUrlEntry>> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    SLog.a("Q.qqstory.DownloadUrlManager", "update video url:%s", paramList);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    try
    {
      localEntityManager.getTransaction().begin();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        List localList = (List)paramList.next();
        if (!localList.isEmpty())
        {
          VideoUrlEntry localVideoUrlEntry1 = new VideoUrlEntry();
          localVideoUrlEntry1.vid = ((VideoUrlEntry)localList.get(0)).vid;
          localVideoUrlEntry1.setStatus(1001);
          localEntityManager.remove(localVideoUrlEntry1, "vid=?", new String[] { localVideoUrlEntry1.vid });
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            VideoUrlEntry localVideoUrlEntry2 = (VideoUrlEntry)localIterator.next();
            if (TextUtils.isEmpty(localVideoUrlEntry2.videoUrl))
            {
              localIterator.remove();
              SLog.d("Q.qqstory.DownloadUrlManager", "%s url error!", new Object[] { localVideoUrlEntry2.vid });
            }
            else
            {
              localEntityManager.persistOrReplace(localVideoUrlEntry2);
            }
          }
          this.jdField_a_of_type_AndroidUtilLruCache.put(localVideoUrlEntry1.vid, localList);
        }
      }
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    SLog.a("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip domain - url: %s", paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URL localURL = new URL(paramString);
        String str2 = localURL.getHost();
        if (!TextUtils.isEmpty(str2))
        {
          Object localObject1 = InnerDns.getInstance().reqDnsForIpList(str2, 1012);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            Object localObject2 = localObject1;
            if (((List)localObject1).size() > 2) {
              localObject2 = ((List)localObject1).subList(0, 2);
            }
            String[] arrayOfString = new String[((List)localObject2).size() + 1];
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localURL.getProtocol());
              ((StringBuilder)localObject1).append("://");
              ((StringBuilder)localObject1).append((String)((List)localObject2).get(i));
              ((StringBuilder)localObject1).append("/");
              ((StringBuilder)localObject1).append(localURL.getFile());
              String str1 = ((StringBuilder)localObject1).toString();
              localObject1 = str1;
              if (!str1.contains("txhost=")) {
                if (!str1.contains("&"))
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(str1);
                  ((StringBuilder)localObject1).append("?txhost=");
                  ((StringBuilder)localObject1).append(str2);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append(str1);
                  ((StringBuilder)localObject1).append("&txhost=");
                  ((StringBuilder)localObject1).append(str2);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
              }
              arrayOfString[i] = localObject1;
              SLog.a("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip ip - url: %s", localObject1);
              i += 1;
            }
            arrayOfString[(arrayOfString.length - 1)] = paramString;
            return arrayOfString;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        SLog.b("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip MalformedURLException: %s", localMalformedURLException);
      }
    }
    return new String[] { paramString };
  }
  
  public void b(String paramString, int paramInt)
  {
    Bosses.get().postJob(new DownloadUrlManager.4(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
  }
  
  public void b(List<VideoUrlEntry> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramList);
    a(localArrayList);
  }
  
  public void c(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      Object localObject = DownloadingUrlEntry.makeKey(paramString, paramInt);
      this.b.remove(localObject);
      localObject = QQStoryContext.a().a().createEntityManager();
      paramString = StoryManager.a((EntityManager)localObject, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (DownloadingUrlEntry)paramString.get(0);
        paramString.setStatus(1001);
        ((EntityManager)localObject).remove(paramString);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager
 * JD-Core Version:    0.7.0.1
 */
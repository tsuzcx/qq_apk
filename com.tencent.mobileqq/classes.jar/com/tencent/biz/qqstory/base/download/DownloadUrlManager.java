package com.tencent.biz.qqstory.base.download;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import myl;
import mym;

public class DownloadUrlManager
  extends BaseManger
{
  private LruCache jdField_a_of_type_AndroidUtilLruCache = new LruCache(100);
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private LruCache b = new LruCache(200);
  
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
  
  public DownloadUrlManager.DownloadUrlQueryResult a(String paramString, int paramInt)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = new DownloadUrlManager.DownloadUrlQueryResult();
    localDownloadUrlQueryResult.jdField_a_of_type_JavaLangString = paramString;
    localDownloadUrlQueryResult.jdField_a_of_type_Int = paramInt;
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    label462:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        localObject1 = a(paramString, paramInt);
        if ((localObject1 != null) && (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted == 0))
        {
          localDownloadUrlQueryResult.jdField_b_of_type_Int = 0;
          localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          localDownloadUrlQueryResult.c = ((DownloadingUrlEntry)localObject1).compressLevel;
          return localDownloadUrlQueryResult;
        }
        localDownloadUrlQueryResult.jdField_a_of_type_Boolean = true;
        localObject2 = null;
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
        if (localDownloadUrlQueryResult.jdField_b_of_type_Int != -1) {
          break label462;
        }
        localObject2 = localStoryManager.a(paramString);
        if (localObject2 == null) {
          break label462;
        }
        localObject1 = new DownloadingUrlEntry();
        ((DownloadingUrlEntry)localObject1).vid = ((StoryVideoItem)localObject2).mVid;
        ((DownloadingUrlEntry)localObject1).fileType = paramInt;
        if (paramInt == 0)
        {
          ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getVideoUrl();
          ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
          localDownloadUrlQueryResult.jdField_b_of_type_Int = 3;
          localDownloadUrlQueryResult.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject1).url)))
          {
            localObject2 = FileCacheUtils.a(paramString, paramInt, false, false);
            if ((localObject2 == null) || (!((File)localObject2).exists()))
            {
              ((DownloadingUrlEntry)localObject1).updatedMs = System.currentTimeMillis();
              this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject1);
              QQStoryContext.a().a().createEntityManager().b((Entity)localObject1);
            }
          }
          return localDownloadUrlQueryResult;
        }
        if (paramInt == 1)
        {
          ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getDownloadMaskUrl();
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      finally
      {
        localDownloadUrlQueryResult.a();
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getThumbUrl();
    }
  }
  
  public DownloadUrlManager.DumpInfo a(String paramString, int paramInt)
  {
    DownloadUrlManager.DumpInfo localDumpInfo = new DownloadUrlManager.DumpInfo(this);
    localDumpInfo.jdField_a_of_type_JavaLangString = String.format("UrlInfo : %s - %d :not found source", new Object[] { paramString, Integer.valueOf(paramInt) });
    localDumpInfo.jdField_a_of_type_Int = 0;
    Object localObject1 = (StoryManager)SuperManager.a(5);
    Object localObject2 = a(paramString, paramInt);
    if (localObject2 != null)
    {
      localDumpInfo.jdField_a_of_type_JavaLangString = String.format("UrlInfo : from downloadEntry: %s - %d :compressLevel = %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(((DownloadingUrlEntry)localObject2).compressLevel) });
      localDumpInfo.jdField_a_of_type_Int = ((DownloadingUrlEntry)localObject2).compressLevel;
      return localDumpInfo;
    }
    if (paramInt == 0)
    {
      localObject2 = a(paramString);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = (VideoUrlEntry)((List)localObject2).get(0);
        localDumpInfo.jdField_a_of_type_JavaLangString = String.format("UrlInfo from VideoUrlList: %s - %d :from video url list - %s", new Object[] { paramString, Integer.valueOf(paramInt), ((VideoUrlEntry)localObject1).toString() });
        localDumpInfo.jdField_a_of_type_Int = ((VideoUrlEntry)localObject1).videoUrlLevel;
        return localDumpInfo;
      }
    }
    if (((StoryManager)localObject1).a(paramString) != null)
    {
      localDumpInfo.jdField_a_of_type_JavaLangString = String.format("UrlInfo : %s - %d :from original video", new Object[] { paramString, Integer.valueOf(paramInt) });
      localDumpInfo.jdField_a_of_type_Int = 0;
      return localDumpInfo;
    }
    return localDumpInfo;
  }
  
  public List a(String paramString)
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
    if ((paramInt != 0) || (TroopStoryUtil.a(paramString))) {
      return;
    }
    Bosses.get().postJob(new myl(this, paramString, paramInt));
  }
  
  public void a(List paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    SLog.a("Q.qqstory.DownloadUrlManager", "update video url:%s", paramList);
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    for (;;)
    {
      try
      {
        localEntityManager.a().a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        List localList = (List)paramList.next();
        if (!localList.isEmpty())
        {
          VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
          localVideoUrlEntry.vid = ((VideoUrlEntry)localList.get(0)).vid;
          localVideoUrlEntry.setStatus(1001);
          localEntityManager.a(localVideoUrlEntry, "vid=?", new String[] { localVideoUrlEntry.vid });
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext()) {
            localEntityManager.b((VideoUrlEntry)localIterator.next());
          } else {
            this.jdField_a_of_type_AndroidUtilLruCache.put(localVideoUrlEntry.vid, localList);
          }
        }
      }
      finally
      {
        localEntityManager.a().b();
      }
    }
    localEntityManager.a().c();
    localEntityManager.a().b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        Object localObject = new URL(paramString);
        String str2 = ((URL)localObject).getHost();
        if (!TextUtils.isEmpty(str2))
        {
          String str1 = InnerDns.a().a(str2, 1012);
          if (!TextUtils.isEmpty(str1))
          {
            str1 = ((URL)localObject).getProtocol() + "://" + str1 + "/" + ((URL)localObject).getFile();
            localObject = str1;
            if (str1.contains("txhost=")) {
              break label205;
            }
            if (!str1.contains("&")) {
              localObject = str1 + "?txhost=" + str2;
            } else {
              localObject = str1 + "&txhost=" + str2;
            }
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        SLog.b("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip MalformedURLException: %s", localMalformedURLException);
      }
    }
    else
    {
      SLog.a("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip url: %s", paramString);
      arrayOfString[0] = paramString;
      return arrayOfString;
    }
    label205:
    arrayOfString[0] = localMalformedURLException;
    arrayOfString[1] = paramString;
    return arrayOfString;
  }
  
  public void b(String paramString, int paramInt)
  {
    Bosses.get().postJob(new mym(this, paramString, paramInt));
  }
  
  public void b(List paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramList);
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager
 * JD-Core Version:    0.7.0.1
 */
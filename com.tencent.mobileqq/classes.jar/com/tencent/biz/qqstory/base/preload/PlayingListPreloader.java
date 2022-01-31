package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import nac;
import nad;
import nae;

@TargetApi(14)
public class PlayingListPreloader
{
  private long jdField_a_of_type_Long;
  public IVideoPreloader a;
  public PlayingListPreloader.CurrentVid a;
  public PlayingListPreloader.OnVideoDownloadListener a;
  protected List a;
  public nae a;
  private boolean jdField_a_of_type_Boolean;
  protected List b = new ArrayList();
  protected List c = new ArrayList();
  
  public PlayingListPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Nae = new nae(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_Nae);
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) > 5000L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Boolean = NetworkUtil.h(BaseApplicationImpl.getContext());
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  private void b(String paramString, String... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList(this.c);
    ArrayList localArrayList2 = new ArrayList();
    boolean bool1 = localArrayList1.contains(paramString);
    boolean bool2 = VideoViewFactory.a(BaseApplicationImpl.getContext()).a();
    Object localObject1;
    Object localObject2;
    label113:
    Object localObject3;
    if (bool2)
    {
      localObject1 = DownloadTask.a(paramString, 1);
      localObject2 = DownloadTask.a(paramString, 2, bool1);
      ((DownloadTask)localObject1).f = 0;
      ((DownloadTask)localObject2).f = 1;
      localArrayList2.add(localObject1);
      ((DownloadTask)localObject1).a.put("handleCallback", Boolean.valueOf(true));
      if (paramVarArgs == null) {
        break label504;
      }
      int j = paramVarArgs.length;
      i = 0;
      if (i >= j) {
        break label504;
      }
      localObject1 = paramVarArgs[i];
      if ((localObject1 != null) && (!((String)localObject1).startsWith("fake_vid_")))
      {
        if (!bool2) {
          break label445;
        }
        localObject2 = DownloadTask.a((String)localObject1, 1);
        localArrayList2.add(localObject2);
        ((DownloadTask)localObject2).a.put("handleCallback", Boolean.valueOf(true));
        localObject2 = FileCacheUtils.a((String)localObject1, 0, true, true);
        if (localObject2 == null) {
          break label426;
        }
        localObject3 = ((DownloadUrlManager)SuperManager.a(28)).a((String)localObject1, 0);
        if ((((DownloadUrlManager.DownloadUrlQueryResult)localObject3).jdField_a_of_type_Boolean) && (((File)localObject2).exists()) && (!FileCacheUtils.a((File)localObject2)))
        {
          ((File)localObject2).delete();
          SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "%s - %d found orphan tmp , delete it", new Object[] { ((DownloadUrlManager.DownloadUrlQueryResult)localObject3).jdField_a_of_type_JavaLangString, Integer.valueOf(((DownloadUrlManager.DownloadUrlQueryResult)localObject3).jdField_a_of_type_Int) });
        }
        SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=true : TVK preload : vid=%s, url=%s", new Object[] { localObject1, ((DownloadUrlManager.DownloadUrlQueryResult)localObject3).b });
        if (((DownloadUrlManager.DownloadUrlQueryResult)localObject3).b != null) {
          TVKPreloader.a(new TVKPreloader.PreloadItem((String)localObject1, ((DownloadUrlManager.DownloadUrlQueryResult)localObject3).b, ((File)localObject2).getAbsolutePath(), ""));
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label113;
      localObject1 = DownloadTask.a(paramString, 1);
      ((DownloadTask)localObject1).f = 0;
      localObject2 = DownloadTask.a(paramString, 0, bool1);
      ((DownloadTask)localObject2).f = 0;
      localObject3 = DownloadTask.a(paramString, 2, bool1);
      ((DownloadTask)localObject3).f = 1;
      localArrayList2.add(localObject1);
      localArrayList2.add(localObject2);
      localArrayList2.add(localObject3);
      ((DownloadTask)localObject2).a.put("handleCallback", Boolean.valueOf(true));
      break;
      label426:
      SLog.e("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=true : TVK preload : ignore ! vid=%s", new Object[] { localObject1 });
      continue;
      label445:
      localArrayList2.add(DownloadTask.a((String)localObject1, 1));
      localObject1 = DownloadTask.a(paramString, 0, localArrayList1.contains(paramString));
      localArrayList2.add(localObject1);
      ((DownloadTask)localObject1).a.put("handleCallback", Boolean.valueOf(true));
    }
    label504:
    int i = 0;
    while (i < localArrayList2.size())
    {
      SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=%s : %s", new Object[] { Boolean.valueOf(bool2), localArrayList2.get(i) });
      i += 1;
    }
    this.b = localArrayList2;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList2, 0, true);
  }
  
  public String a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid = new PlayingListPreloader.CurrentVid(paramString);
    paramString = a(paramString, VideoViewFactory.a(BaseApplicationImpl.getContext()).jdField_a_of_type_Boolean);
    a(true);
    return paramString;
  }
  
  protected String a(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if ((!this.c.isEmpty()) && (this.c.contains(paramString)))
    {
      QQStoryContext.a();
      paramString = TroopStoryUtil.a(QQStoryContext.a(), paramString);
      if (!(paramString instanceof MessageForShortVideo)) {
        break label142;
      }
    }
    label142:
    for (paramString = (MessageForShortVideo)paramString;; paramString = null)
    {
      Object localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = ShortVideoUtils.a(paramString, "mp4");
        if (!FileUtils.c(paramString)) {
          break label78;
        }
        localObject1 = paramString;
      }
      label78:
      do
      {
        do
        {
          return localObject1;
          paramString = null;
          break;
          if (a(paramString))
          {
            localObject1 = FileCacheUtils.a(paramString, 0, paramBoolean, paramBoolean);
            if (localObject1 != null) {
              return ((File)localObject1).getAbsolutePath();
            }
          }
          localObject1 = localObject2;
        } while (!StoryVideoItem.isFakeVid(paramString));
        paramString = ((StoryManager)SuperManager.a(5)).a(paramString);
        localObject1 = localObject2;
      } while (paramString == null);
      return paramString.mLocalVideoPath;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = null;
  }
  
  public void a(PlayingListPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = paramOnVideoDownloadListener;
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid = new PlayingListPreloader.CurrentVid(paramString);
    paramString = new nac(this, paramString, paramVarArgs);
    paramString.setJobType(4);
    Bosses.get().postJob(paramString);
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
  
  protected void a(boolean paramBoolean)
  {
    nad localnad = new nad(this, paramBoolean);
    localnad.setJobType(4);
    Bosses.get().postJob(localnad);
  }
  
  public boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
  
  protected boolean a(List paramList1, List paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int j = paramList1.size();
    int i = 0;
    while (i < j)
    {
      if (!((DownloadTask)paramList1.get(i)).equals(paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String b(String paramString)
  {
    MessageRecord localMessageRecord = null;
    if (paramString == null) {
      throw new NullPointerException("vid should not be null");
    }
    if (new ArrayList(this.c).contains(paramString))
    {
      localMessageRecord = TroopStoryUtil.a(QQStoryContext.a(), paramString);
      if (!(localMessageRecord instanceof MessageForShortVideo)) {
        break label347;
      }
    }
    label290:
    label347:
    for (Object localObject = (MessageForShortVideo)localMessageRecord;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ShortVideoUtils.a((MessageForShortVideo)localObject, "mp4");
        SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, troop-vid=%s, path=%s", new Object[] { paramString, localObject });
        if (FileUtils.c((String)localObject))
        {
          paramString = (String)localObject;
          localObject = paramString;
        }
      }
      StoryVideoItem localStoryVideoItem;
      do
      {
        do
        {
          return localObject;
          paramString = null;
          break;
          SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, troop-vid=%s, MessageRecord=%s", new Object[] { paramString, localMessageRecord });
          return null;
          localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
          if (localStoryVideoItem == null)
          {
            SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, vid=%s, can not find StoryVideoItem", new Object[] { paramString });
            return null;
          }
          if (StoryVideoItem.isFakeVid(paramString))
          {
            SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, fake-vid=%s, path=%s", new Object[] { paramString, localStoryVideoItem.mLocalVideoPath });
            return localStoryVideoItem.mLocalVideoPath;
          }
          if (localStoryVideoItem.isMaskDownloaded() == 0)
          {
            SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, vid=%s, mask down FILE_DOWNLOAD_FAIL", new Object[] { paramString });
            return null;
          }
          localObject = FileCacheUtils.a(paramString, 0, false, false);
          if ((localObject != null) && (FileCacheUtils.a((File)localObject))) {
            return ((File)localObject).getAbsolutePath();
          }
          localObject = localMessageRecord;
        } while (!VideoViewFactory.a(BaseApplicationImpl.getContext()).a());
        if (!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) {
          break label290;
        }
        localObject = localMessageRecord;
      } while (TextUtils.isEmpty(localStoryVideoItem.mTempVideoUrl));
      localObject = FileCacheUtils.a(paramString, 0, true, true);
      if (localObject != null)
      {
        localObject = ((File)localObject).getAbsolutePath();
        SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, vid=%s, support stream, path=%s", new Object[] { paramString, localObject });
        return localObject;
      }
      SLog.e("Q.qqstory.download.preload.PlayingListPreloader", "getVideoLocalPathByVid, vid=%s, support stream, getLocalFile return null", new Object[] { paramString });
      return null;
    }
  }
  
  public void b(List paramList)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.addAll(paramList);
    this.c = localArrayList;
  }
  
  public void b(boolean paramBoolean)
  {
    List localList1 = this.jdField_a_of_type_JavaUtilList;
    String str;
    List localList2;
    int k;
    label33:
    ArrayList localArrayList;
    int i;
    label52:
    int j;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid == null)
    {
      str = "";
      localList2 = this.c;
      if (!a()) {
        break label343;
      }
      k = 3;
      localArrayList = new ArrayList();
      if (TextUtils.isEmpty(str)) {
        break label503;
      }
      i = 0;
      if (i >= localList1.size()) {
        break label498;
      }
      if (!TextUtils.equals(((StoryVideoItem)localList1.get(i)).mVid, str)) {
        break label349;
      }
      j = 1;
    }
    for (;;)
    {
      if (j == 0) {
        i = 0;
      }
      j = i;
      i = 0;
      for (;;)
      {
        int m = i;
        Object localObject;
        boolean bool;
        label152:
        DownloadTask localDownloadTask1;
        if (j < localList1.size())
        {
          localObject = (StoryVideoItem)localList1.get(j);
          if ((localList2.isEmpty()) || (!localList2.contains(((StoryVideoItem)localObject).mVid))) {
            break label356;
          }
          bool = true;
          if (!TextUtils.equals(str, ((StoryVideoItem)localObject).mVid)) {
            break label382;
          }
          localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 1);
          DownloadTask localDownloadTask2 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 0, bool);
          localObject = DownloadTask.a(((StoryVideoItem)localObject).mVid, 2, bool);
          localDownloadTask1.f = 0;
          localDownloadTask2.f = 0;
          ((DownloadTask)localObject).f = 1;
          localArrayList.add(localDownloadTask1);
          if (VideoViewFactory.a(BaseApplicationImpl.getContext()).a()) {
            break label362;
          }
          localArrayList.add(localDownloadTask2);
          localDownloadTask2.a.put("handleCallback", Boolean.valueOf(true));
          label269:
          localArrayList.add(localObject);
        }
        for (;;)
        {
          i += 1;
          if (i < k) {
            break label471;
          }
          m = i;
          SLog.a("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(m));
          if ((paramBoolean) || (!a(localArrayList, this.b))) {
            break label478;
          }
          SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download list equal , no need to set again");
          return;
          str = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid.jdField_a_of_type_JavaLangString;
          break;
          label343:
          k = 2;
          break label33;
          label349:
          i += 1;
          break label52;
          label356:
          bool = false;
          break label152;
          label362:
          localDownloadTask1.a.put("handleCallback", Boolean.valueOf(true));
          break label269;
          label382:
          localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject).mVid, 2, bool));
          localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject).mVid, 1));
          localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 0, bool);
          localDownloadTask1.a.put("handleCallback", Boolean.valueOf(true));
          localArrayList.add(localDownloadTask1);
          localArrayList.add(localDownloadTask1);
        }
        label471:
        j += 1;
      }
      label478:
      this.b = localArrayList;
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList, 0, true);
      return;
      label498:
      j = 0;
      continue;
      label503:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader
 * JD-Core Version:    0.7.0.1
 */
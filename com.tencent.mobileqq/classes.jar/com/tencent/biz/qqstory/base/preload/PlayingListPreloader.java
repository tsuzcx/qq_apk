package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TargetApi(14)
public class PlayingListPreloader
{
  private long jdField_a_of_type_Long = 0L;
  public IVideoPreloader a;
  protected PlayingListPreloader.CurrentVid a;
  public PlayingListPreloader.OnFileDownloadListener a;
  protected PlayingListPreloader.OnVideoDownloadListener a;
  protected List<StoryVideoItem> a;
  private boolean jdField_a_of_type_Boolean = false;
  protected List<DownloadTask> b = new ArrayList();
  protected List<String> c = new ArrayList();
  
  public PlayingListPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnFileDownloadListener = new PlayingListPreloader.OnFileDownloadListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnFileDownloadListener);
  }
  
  private void a(String paramString, String... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList(this.c);
    ArrayList localArrayList2 = new ArrayList();
    boolean bool1 = localArrayList1.contains(paramString);
    boolean bool2 = VideoViewFactory.a(BaseApplicationImpl.getContext()).a();
    Object localObject1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = DownloadTask.a(paramString, 1);
      localObject2 = DownloadTask.a(paramString, 2, bool1);
      ((DownloadTask)localObject1).g = 0;
      ((DownloadTask)localObject2).g = 1;
      localArrayList2.add(localObject1);
      ((DownloadTask)localObject1).a.put("handleCallback", Boolean.valueOf(true));
      if (paramVarArgs == null) {
        break label398;
      }
      int j = paramVarArgs.length;
      i = 0;
      label113:
      if (i >= j) {
        break label398;
      }
      localObject1 = paramVarArgs[i];
      if ((localObject1 != null) && (!((String)localObject1).startsWith("fake_vid_")))
      {
        if (!bool2) {
          break label339;
        }
        localObject2 = DownloadTask.a((String)localObject1, 1);
        localArrayList2.add(localObject2);
        ((DownloadTask)localObject2).a.put("handleCallback", Boolean.valueOf(true));
        localObject2 = FileCacheUtils.a((String)localObject1, 0, true, true);
        if (localObject2 == null) {
          break label320;
        }
        ((DownloadUrlManager)SuperManager.a(28)).a((String)localObject1, 0, new PlayingListPreloader.2(this, (File)localObject2, (String)localObject1));
      }
    }
    for (;;)
    {
      i += 1;
      break label113;
      localObject1 = DownloadTask.a(paramString, 1);
      ((DownloadTask)localObject1).g = 0;
      localObject2 = DownloadTask.a(paramString, 0, bool1);
      ((DownloadTask)localObject2).g = 0;
      DownloadTask localDownloadTask = DownloadTask.a(paramString, 2, bool1);
      localDownloadTask.g = 1;
      localArrayList2.add(localObject1);
      localArrayList2.add(localObject2);
      localArrayList2.add(localDownloadTask);
      ((DownloadTask)localObject2).a.put("handleCallback", Boolean.valueOf(true));
      break;
      label320:
      SLog.e("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=true : TVK preload : ignore ! vid=%s", new Object[] { localObject1 });
      continue;
      label339:
      localArrayList2.add(DownloadTask.a((String)localObject1, 1));
      localObject1 = DownloadTask.a(paramString, 0, localArrayList1.contains(paramString));
      localArrayList2.add(localObject1);
      ((DownloadTask)localObject1).a.put("handleCallback", Boolean.valueOf(true));
    }
    label398:
    int i = 0;
    while (i < localArrayList2.size())
    {
      SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=%s : %s", new Object[] { Boolean.valueOf(bool2), localArrayList2.get(i) });
      i += 1;
    }
    this.b = localArrayList2;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList2, true);
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
  
  public String a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid = new PlayingListPreloader.CurrentVid(paramString);
    paramString = a(paramString, VideoViewFactory.a(BaseApplicationImpl.getContext()).a());
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
        break label141;
      }
    }
    label141:
    for (paramString = (MessageForShortVideo)paramString;; paramString = null)
    {
      Object localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = ShortVideoUtils.getShortVideoSavePath(paramString, "mp4");
        if (!FileUtils.c(paramString)) {
          break label77;
        }
        localObject1 = paramString;
      }
      label77:
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
  
  public void a(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
  
  protected void a(boolean paramBoolean)
  {
    PlayingListPreloader.3 local3 = new PlayingListPreloader.3(this, "Q.qqstory.download.preload.PlayingListPreloader", paramBoolean);
    local3.setJobType(4);
    Bosses.get().postJob(local3);
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
  
  protected void b(boolean paramBoolean)
  {
    List localList1 = this.jdField_a_of_type_JavaUtilList;
    String str;
    List localList2;
    int k;
    label34:
    ArrayList localArrayList;
    int i;
    label53:
    int j;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid == null)
    {
      str = "";
      localList2 = this.c;
      if (!a()) {
        break label334;
      }
      k = 3;
      localArrayList = new ArrayList();
      if (TextUtils.isEmpty(str)) {
        break label471;
      }
      i = 0;
      if (i >= localList1.size()) {
        break label466;
      }
      if (!TextUtils.equals(((StoryVideoItem)localList1.get(i)).mVid, str)) {
        break label340;
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
        label152:
        DownloadTask localDownloadTask1;
        if (j < localList1.size())
        {
          localObject = (StoryVideoItem)localList1.get(j);
          if ((localList2.isEmpty()) || (!localList2.contains(((StoryVideoItem)localObject).mVid))) {
            break label347;
          }
          paramBoolean = true;
          if (!TextUtils.equals(str, ((StoryVideoItem)localObject).mVid)) {
            break label372;
          }
          localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 1);
          DownloadTask localDownloadTask2 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localObject = DownloadTask.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean);
          localDownloadTask1.g = 0;
          localDownloadTask2.g = 0;
          ((DownloadTask)localObject).g = 1;
          localArrayList.add(localDownloadTask1);
          if (VideoViewFactory.a(BaseApplicationImpl.getContext()).a()) {
            break label352;
          }
          localArrayList.add(localDownloadTask2);
          localDownloadTask2.a.put("handleCallback", Boolean.valueOf(true));
          label267:
          localArrayList.add(localObject);
        }
        for (;;)
        {
          i += 1;
          if (i < k) {
            break label459;
          }
          m = i;
          SLog.a("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(m));
          this.b = localArrayList;
          this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList, true);
          return;
          str = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$CurrentVid.a;
          break;
          label334:
          k = 2;
          break label34;
          label340:
          i += 1;
          break label53;
          label347:
          paramBoolean = false;
          break label152;
          label352:
          localDownloadTask1.a.put("handleCallback", Boolean.valueOf(true));
          break label267;
          label372:
          localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject).mVid, 2, paramBoolean));
          localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject).mVid, 1));
          localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject).mVid, 0, paramBoolean);
          localDownloadTask1.a.put("handleCallback", Boolean.valueOf(true));
          localArrayList.add(localDownloadTask1);
          localArrayList.add(localDownloadTask1);
        }
        label459:
        j += 1;
      }
      label466:
      j = 0;
      continue;
      label471:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader
 * JD-Core Version:    0.7.0.1
 */
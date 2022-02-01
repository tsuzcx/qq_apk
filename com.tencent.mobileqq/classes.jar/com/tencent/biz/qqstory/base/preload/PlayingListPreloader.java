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
import com.tencent.mobileqq.shortvideo.SVUtils;
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
  public IVideoPreloader a = new VideoPreloader();
  public PlayingListPreloader.OnFileDownloadListener b = new PlayingListPreloader.OnFileDownloadListener(this);
  protected PlayingListPreloader.OnVideoDownloadListener c;
  protected List<StoryVideoItem> d = new ArrayList();
  protected List<DownloadTask> e = new ArrayList();
  protected PlayingListPreloader.CurrentVid f;
  protected List<String> g = new ArrayList();
  private long h = 0L;
  private boolean i = false;
  
  public PlayingListPreloader()
  {
    this.a.a(0);
    this.a.a(this.b);
  }
  
  private void a(String paramString, String... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList(this.g);
    ArrayList localArrayList2 = new ArrayList();
    boolean bool1 = localArrayList1.contains(paramString);
    boolean bool2 = VideoViewFactory.a(BaseApplicationImpl.getContext()).a();
    Boolean localBoolean = Boolean.valueOf(true);
    Object localObject1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = DownloadTask.a(paramString, 1);
      localObject2 = DownloadTask.a(paramString, 2, bool1);
      ((DownloadTask)localObject1).s = 0;
      ((DownloadTask)localObject2).s = 1;
      localArrayList2.add(localObject1);
      ((DownloadTask)localObject1).l.put("handleCallback", localBoolean);
    }
    else
    {
      localObject1 = DownloadTask.a(paramString, 1);
      ((DownloadTask)localObject1).s = 0;
      localObject2 = DownloadTask.a(paramString, 0, bool1);
      ((DownloadTask)localObject2).s = 0;
      DownloadTask localDownloadTask = DownloadTask.a(paramString, 2, bool1);
      localDownloadTask.s = 1;
      localArrayList2.add(localObject1);
      localArrayList2.add(localObject2);
      localArrayList2.add(localDownloadTask);
      ((DownloadTask)localObject2).l.put("handleCallback", localBoolean);
    }
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      j = 0;
      while (j < k)
      {
        localObject1 = paramVarArgs[j];
        if ((localObject1 != null) && (!((String)localObject1).startsWith("fake_vid_"))) {
          if (bool2)
          {
            localObject2 = DownloadTask.a((String)localObject1, 1);
            localArrayList2.add(localObject2);
            ((DownloadTask)localObject2).l.put("handleCallback", localBoolean);
            localObject2 = FileCacheUtils.a((String)localObject1, 0, true, true);
            if (localObject2 != null) {
              ((DownloadUrlManager)SuperManager.a(28)).a((String)localObject1, 0, new PlayingListPreloader.2(this, (File)localObject2, (String)localObject1));
            } else {
              SLog.e("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=true : TVK preload : ignore ! vid=%s", new Object[] { localObject1 });
            }
          }
          else
          {
            localArrayList2.add(DownloadTask.a((String)localObject1, 1));
            localObject1 = DownloadTask.a(paramString, 0, localArrayList1.contains(paramString));
            localArrayList2.add(localObject1);
            ((DownloadTask)localObject1).l.put("handleCallback", localBoolean);
          }
        }
        j += 1;
      }
    }
    int j = 0;
    while (j < localArrayList2.size())
    {
      SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=%s : %s", new Object[] { Boolean.valueOf(bool2), localArrayList2.get(j) });
      j += 1;
    }
    this.e = localArrayList2;
    this.a.a(localArrayList2, true);
  }
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.h) > 5000L)
    {
      this.h = l;
      this.i = NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext());
    }
    return this.i;
  }
  
  public String a(String paramString)
  {
    this.f = new PlayingListPreloader.CurrentVid(paramString);
    paramString = a(paramString, VideoViewFactory.a(BaseApplicationImpl.getContext()).a());
    a(true);
    return paramString;
  }
  
  protected String a(String paramString, boolean paramBoolean)
  {
    if ((!this.g.isEmpty()) && (this.g.contains(paramString)))
    {
      QQStoryContext.a();
      paramString = TroopStoryUtil.a(QQStoryContext.j(), paramString);
      if ((paramString instanceof MessageForShortVideo)) {
        paramString = (MessageForShortVideo)paramString;
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = SVUtils.a(paramString, "mp4");
        if (FileUtils.d(paramString)) {
          return paramString;
        }
        return null;
      }
      return null;
    }
    if (b(paramString))
    {
      File localFile = FileCacheUtils.a(paramString, 0, paramBoolean, paramBoolean);
      if (localFile != null) {
        return localFile.getAbsolutePath();
      }
    }
    if (StoryVideoItem.isFakeVid(paramString))
    {
      paramString = ((StoryManager)SuperManager.a(5)).a(paramString);
      if (paramString != null) {
        return paramString.mLocalVideoPath;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.a.a();
    this.c = null;
  }
  
  public void a(PlayingListPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.c = paramOnVideoDownloadListener;
  }
  
  public void a(List<StoryVideoItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.d = new ArrayList(paramList);
  }
  
  protected void a(boolean paramBoolean)
  {
    PlayingListPreloader.3 local3 = new PlayingListPreloader.3(this, "Q.qqstory.download.preload.PlayingListPreloader", paramBoolean);
    local3.setJobType(4);
    Bosses.get().postJob(local3);
  }
  
  protected void b(boolean paramBoolean)
  {
    List localList1 = this.d;
    Object localObject1 = this.f;
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((PlayingListPreloader.CurrentVid)localObject1).b;
    }
    List localList2 = this.g;
    int m;
    if (b()) {
      m = 3;
    } else {
      m = 2;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      j = 0;
      while (j < localList1.size())
      {
        if (TextUtils.equals(((StoryVideoItem)localList1.get(j)).mVid, (CharSequence)localObject1))
        {
          k = 1;
          break label127;
        }
        j += 1;
      }
      k = 0;
    }
    else
    {
      k = 0;
      j = 0;
    }
    label127:
    if (k == 0) {
      j = 0;
    }
    int n = 0;
    int k = j;
    int j = n;
    for (;;)
    {
      n = j;
      if (k >= localList1.size()) {
        break;
      }
      Object localObject2 = (StoryVideoItem)localList1.get(k);
      if ((!localList2.isEmpty()) && (localList2.contains(((StoryVideoItem)localObject2).mVid))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      DownloadTask localDownloadTask1;
      if (TextUtils.equals((CharSequence)localObject1, ((StoryVideoItem)localObject2).mVid))
      {
        localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject2).mVid, 1);
        DownloadTask localDownloadTask2 = DownloadTask.a(((StoryVideoItem)localObject2).mVid, 0, paramBoolean);
        localObject2 = DownloadTask.a(((StoryVideoItem)localObject2).mVid, 2, paramBoolean);
        localDownloadTask1.s = 0;
        localDownloadTask2.s = 0;
        ((DownloadTask)localObject2).s = 1;
        localArrayList.add(localDownloadTask1);
        if (!VideoViewFactory.a(BaseApplicationImpl.getContext()).a())
        {
          localArrayList.add(localDownloadTask2);
          localDownloadTask2.l.put("handleCallback", Boolean.valueOf(true));
        }
        else
        {
          localDownloadTask1.l.put("handleCallback", Boolean.valueOf(true));
        }
        localArrayList.add(localObject2);
      }
      else
      {
        localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject2).mVid, 2, paramBoolean));
        localArrayList.add(DownloadTask.a(((StoryVideoItem)localObject2).mVid, 1));
        localDownloadTask1 = DownloadTask.a(((StoryVideoItem)localObject2).mVid, 0, paramBoolean);
        localDownloadTask1.l.put("handleCallback", Boolean.valueOf(true));
        localArrayList.add(localDownloadTask1);
        localArrayList.add(localDownloadTask1);
      }
      j += 1;
      if (j >= m)
      {
        n = j;
        break;
      }
      k += 1;
    }
    SLog.a("Q.qqstory.download.preload.PlayingListPreloader", "start download ,download count = %d", Integer.valueOf(n));
    this.e = localArrayList;
    this.a.a(localArrayList, true);
  }
  
  protected boolean b(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader
 * JD-Core Version:    0.7.0.1
 */
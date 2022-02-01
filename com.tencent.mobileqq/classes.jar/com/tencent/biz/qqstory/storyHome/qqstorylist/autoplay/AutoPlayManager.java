package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.StoryVideoDownloadedEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public class AutoPlayManager
  implements Handler.Callback, BatchHandlerListPuller.IPullResultCallback, FeedVideoPreloader.OnVideoDownloadListener, IEventReceiver
{
  protected FeedVideoPreloader a = new FeedVideoPreloader();
  private AutoPlayManager.GetVideoBasicInfoListReceiver b;
  private AutoPlayManager.GetStoryListReceiver c;
  private ConcurrentHashMap<String, StoryVideoItem> d = new ConcurrentHashMap();
  private StoryManager e = (StoryManager)SuperManager.a(5);
  private BatchHandlerListPuller f;
  private BatchHandlerListPuller g;
  private boolean h = false;
  private int i = 1;
  private Handler j = new Handler(paramLooper, this);
  private ConcurrentHashMap<String, String> k = new ConcurrentHashMap();
  private int l = 0;
  
  public AutoPlayManager(Looper paramLooper)
  {
    this.a.a(this);
    this.b = new AutoPlayManager.GetVideoBasicInfoListReceiver(this);
    this.c = new AutoPlayManager.GetStoryListReceiver(this, this);
    StoryDispatcher.a().registerSubscriber(this.b);
    StoryDispatcher.a().registerSubscriber(this.c);
  }
  
  private boolean b(String paramString)
  {
    if (this.d.get(paramString) != null) {
      return true;
    }
    paramString = this.e.a(paramString);
    return (paramString != null) && (a(paramString));
  }
  
  public int a()
  {
    return this.i;
  }
  
  public StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem2 = (StoryVideoItem)this.d.get(paramString);
    StoryVideoItem localStoryVideoItem1;
    if ((localStoryVideoItem2 != null) && (!TextUtils.isEmpty(localStoryVideoItem2.mVideoUrl)) && (localStoryVideoItem2.mVideoDuration >= 0L))
    {
      localStoryVideoItem1 = localStoryVideoItem2;
      if (localStoryVideoItem2.mSourceType != -1) {}
    }
    else
    {
      localStoryVideoItem1 = this.e.a(paramString);
    }
    return localStoryVideoItem1;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, List<StoryHomeFeed> paramList)
  {
    StoryVideoItem localStoryVideoItem = paramQQStoryAutoPlayView.getStoryVideoItem();
    if (localStoryVideoItem == null)
    {
      StoryReportor.b("story_home_dev", "feed_play_req", 0, 3, new String[0]);
      return;
    }
    this.a.a(this.e.a(localStoryVideoItem.mVid), paramList);
    boolean bool = StoryVideoItem.isPlayable(localStoryVideoItem.mVid, false);
    paramList = null;
    if (bool) {
      paramList = FileCacheUtils.a(localStoryVideoItem.mVid, 0, false, false);
    }
    if (!a(localStoryVideoItem))
    {
      SLog.a("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that need to req the storyVideoItem vid=%s cover=%s", localStoryVideoItem.mVid, localStoryVideoItem.getThumbUrl());
      if (this.k.get(localStoryVideoItem.mVid) == null)
      {
        paramQQStoryAutoPlayView = new ArrayList();
        paramQQStoryAutoPlayView.add(localStoryVideoItem.mVid);
        a(paramQQStoryAutoPlayView);
        StoryReportor.b("story_home_dev", "feed_play_req", 0, 2, new String[] { localStoryVideoItem.mVid });
      }
    }
    else
    {
      if ((bool) && (paramList != null))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AutoPlayManager that have the mp4 file,do play now vid+");
        ((StringBuilder)localObject).append(localStoryVideoItem.mVid);
        ((StringBuilder)localObject).append(" cover=");
        ((StringBuilder)localObject).append(localStoryVideoItem.getThumbUrl());
        SLog.b("Q.qqstory.home.AutoPlayManager", ((StringBuilder)localObject).toString());
        if (localStoryVideoItem.mErrorCode != 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AutoPlayManager request the error video to auto play error code=");
          ((StringBuilder)localObject).append(localStoryVideoItem.mErrorCode);
          SLog.e("Q.qqstory.home.AutoPlayManager", ((StringBuilder)localObject).toString());
        }
        localObject = FileCacheUtils.a(localStoryVideoItem.mVid, 1, false, false);
        AssertUtils.checkNotNull(paramList);
        paramQQStoryAutoPlayView.a(paramList, (File)localObject);
        StoryReportor.b("story_home_dev", "feed_play_req", 1, 0, new String[] { localStoryVideoItem.mVid });
        return;
      }
      StoryReportor.b("story_home_dev", "feed_play_req", 0, 1, new String[] { localStoryVideoItem.mVid });
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("AutoPlayManager onSuccess = ");
    paramString2.append(paramString1);
    SLog.b("Q.qqstory.home.AutoPlayManager", paramString2.toString());
    paramString2 = new FeedSegment.StoryVideoDownloadedEvent();
    paramString2.a = paramString1;
    StoryDispatcher.a().dispatch(paramString2);
    this.k.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 0, 0, new String[] { paramString1 });
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    paramString2 = new StringBuilder();
    paramString2.append("AutoPlayManager onError = ");
    paramString2.append(paramString1);
    SLog.b("Q.qqstory.home.AutoPlayManager", paramString2.toString());
    this.k.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 1, 0, new String[] { paramString1 });
  }
  
  public void a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!b(str)) {
        localArrayList.add(str);
      }
    }
    SLog.a("Q.qqstory.home.AutoPlayManager", "fetchStoryVideoItemByVid, request=%s, original=%s", new JSONArray(localArrayList), new JSONArray(paramList));
    if (localArrayList.size() > 0)
    {
      this.f = BatchHandlerListPuller.a(localArrayList);
      this.f.a("Q.qqstory.home.AutoPlayManager");
      this.f.a(this);
      this.f.b();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) && (paramStoryVideoItem.mSourceType != -1))
    {
      if (paramStoryVideoItem.mVideoDuration < 0L) {
        return false;
      }
      this.d.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.h = false;
    this.d.clear();
    StoryDispatcher.a().unRegisterSubscriber(this.b);
    StoryDispatcher.a().unRegisterSubscriber(this.c);
    this.a.a();
    BatchHandlerListPuller localBatchHandlerListPuller = this.f;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.a();
    }
    localBatchHandlerListPuller = this.g;
    if (localBatchHandlerListPuller != null) {
      localBatchHandlerListPuller.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("AutoPlayManager onPause = ");
    paramString2.append(paramString1);
    SLog.b("Q.qqstory.home.AutoPlayManager", paramString2.toString());
    this.k.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 2, 0, new String[] { paramString1 });
  }
  
  public void b(List<StoryVideoItem> paramList)
  {
    Handler localHandler = this.j;
    if (localHandler != null) {
      localHandler.sendMessage(localHandler.obtainMessage(1, paramList));
    }
  }
  
  public int c()
  {
    return this.l;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    paramMessage = ((List)paramMessage.obj).iterator();
    while (paramMessage.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramMessage.next();
      if ((localStoryVideoItem.mErrorCode == 0) && ((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (localStoryVideoItem.mVideoDuration < 0L) || (localStoryVideoItem.mSourceType == -1))) {
        AssertUtils.fail("handleMessage is illegal debug info=%s", new Object[] { localStoryVideoItem });
      }
      this.d.put(localStoryVideoItem.mVid, localStoryVideoItem);
      this.k.remove(localStoryVideoItem.mVid);
    }
    return true;
  }
  
  public boolean isValidate()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager
 * JD-Core Version:    0.7.0.1
 */
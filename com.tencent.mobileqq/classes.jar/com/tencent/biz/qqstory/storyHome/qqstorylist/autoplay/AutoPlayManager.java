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
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper, this);
  private StoryManager jdField_a_of_type_ComTencentBizQqstoryModelStoryManager = (StoryManager)SuperManager.a(5);
  private BatchHandlerListPuller jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller;
  private AutoPlayManager.GetStoryListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver;
  private AutoPlayManager.GetVideoBasicInfoListReceiver jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver;
  protected FeedVideoPreloader a;
  private ConcurrentHashMap<String, StoryVideoItem> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private BatchHandlerListPuller jdField_b_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller;
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public AutoPlayManager(Looper paramLooper)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader = new FeedVideoPreloader();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver = new AutoPlayManager.GetVideoBasicInfoListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver = new AutoPlayManager.GetStoryListReceiver(this, this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null) {}
    do
    {
      return true;
      paramString = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramString);
    } while ((paramString != null) && (a(paramString)));
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem2 = (StoryVideoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    StoryVideoItem localStoryVideoItem1;
    if ((localStoryVideoItem2 != null) && (!TextUtils.isEmpty(localStoryVideoItem2.mVideoUrl)) && (localStoryVideoItem2.mVideoDuration >= 0L))
    {
      localStoryVideoItem1 = localStoryVideoItem2;
      if (localStoryVideoItem2.mSourceType != -1) {}
    }
    else
    {
      localStoryVideoItem1 = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramString);
    }
    return localStoryVideoItem1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    }
    if (this.jdField_b_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller != null) {
      this.jdField_b_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, List<StoryHomeFeed> paramList)
  {
    StoryVideoItem localStoryVideoItem = paramQQStoryAutoPlayView.a();
    if (localStoryVideoItem == null) {
      StoryReportor.b("story_home_dev", "feed_play_req", 0, 3, new String[0]);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(localStoryVideoItem.mVid), paramList);
      bool = StoryVideoItem.isPlayable(localStoryVideoItem.mVid, false);
      paramList = null;
      if (bool) {
        paramList = FileCacheUtils.a(localStoryVideoItem.mVid, 0, false, false);
      }
      if (a(localStoryVideoItem)) {
        break;
      }
      SLog.a("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that need to req the storyVideoItem vid=%s cover=%s", localStoryVideoItem.mVid, localStoryVideoItem.getThumbUrl());
    } while (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localStoryVideoItem.mVid) != null);
    paramQQStoryAutoPlayView = new ArrayList();
    paramQQStoryAutoPlayView.add(localStoryVideoItem.mVid);
    a(paramQQStoryAutoPlayView);
    StoryReportor.b("story_home_dev", "feed_play_req", 0, 2, new String[] { localStoryVideoItem.mVid });
    return;
    if ((bool) && (paramList != null))
    {
      SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that have the mp4 file,do play now vid+" + localStoryVideoItem.mVid + " cover=" + localStoryVideoItem.getThumbUrl());
      if (localStoryVideoItem.mErrorCode != 0) {
        SLog.e("Q.qqstory.home.AutoPlayManager", "AutoPlayManager request the error video to auto play error code=" + localStoryVideoItem.mErrorCode);
      }
      File localFile = FileCacheUtils.a(localStoryVideoItem.mVid, 1, false, false);
      AssertUtils.a(paramList);
      paramQQStoryAutoPlayView.a(paramList, localFile);
      StoryReportor.b("story_home_dev", "feed_play_req", 1, 0, new String[] { localStoryVideoItem.mVid });
      return;
    }
    StoryReportor.b("story_home_dev", "feed_play_req", 0, 1, new String[] { localStoryVideoItem.mVid });
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onSuccess = " + paramString1);
    paramString2 = new FeedSegment.StoryVideoDownloadedEvent();
    paramString2.a = paramString1;
    StoryDispatcher.a().dispatch(paramString2);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 0, 0, new String[] { paramString1 });
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onError = " + paramString1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 1, 0, new String[] { paramString1 });
  }
  
  public void a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!a(str)) {
        localArrayList.add(str);
      }
    }
    SLog.a("Q.qqstory.home.AutoPlayManager", "fetchStoryVideoItemByVid, request=%s, original=%s", new JSONArray(localArrayList), new JSONArray(paramList));
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = BatchHandlerListPuller.a(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a("Q.qqstory.home.AutoPlayManager");
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    while ((TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl())) || (paramStoryVideoItem.mSourceType == -1) || (paramStoryVideoItem.mVideoDuration < 0L)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString1, String paramString2)
  {
    SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onPause = " + paramString1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 2, 0, new String[] { paramString1 });
  }
  
  public void b(List<StoryVideoItem> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramList));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = ((List)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramMessage.next();
        if ((localStoryVideoItem.mErrorCode == 0) && ((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (localStoryVideoItem.mVideoDuration < 0L) || (localStoryVideoItem.mSourceType == -1))) {
          AssertUtils.a("handleMessage is illegal debug info=%s", new Object[] { localStoryVideoItem });
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localStoryVideoItem.mVid, localStoryVideoItem);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localStoryVideoItem.mVid);
      }
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager
 * JD-Core Version:    0.7.0.1
 */
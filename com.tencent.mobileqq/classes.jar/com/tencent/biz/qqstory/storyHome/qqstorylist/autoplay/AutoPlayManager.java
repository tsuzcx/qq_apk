package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.StoryVideoDownloadedEvent;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
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
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private BatchHandlerListPuller jdField_b_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public AutoPlayManager(Looper paramLooper)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader = new FeedVideoPreloader();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver = new AutoPlayManager.GetVideoBasicInfoListReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver = new AutoPlayManager.GetStoryListReceiver(this, this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null) {
      return true;
    }
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramString);
    if ((localStoryVideoItem != null) && (a(localStoryVideoItem)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localStoryVideoItem);
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public StoryVideoItem a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetVideoBasicInfoListReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager$GetStoryListReceiver);
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
  
  public void a(QQStoryAutoPlayView paramQQStoryAutoPlayView, List paramList)
  {
    StoryVideoItem localStoryVideoItem = paramQQStoryAutoPlayView.a();
    if (localStoryVideoItem == null)
    {
      StoryReportor.b("story_home_dev", "feed_play_req", 0, 3, new String[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(localStoryVideoItem.mVid), paramList);
    boolean bool = StoryVideoItem.isPlayable(localStoryVideoItem.mVid, false);
    paramList = null;
    if (bool) {
      paramList = FileCacheUtils.a(localStoryVideoItem.mVid, 0, false, false);
    }
    if ((bool) && (paramList != null))
    {
      SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that have the mp4 file,do play now vid+" + localStoryVideoItem.mVid + " cover=" + localStoryVideoItem.getThumbUrl());
      File localFile = FileCacheUtils.a(localStoryVideoItem.mVid, 1, false, false);
      AssertUtils.a(paramList);
      paramQQStoryAutoPlayView.a(paramList, localFile);
      StoryReportor.b("story_home_dev", "feed_play_req", 1, 0, new String[] { localStoryVideoItem.mVid });
      return;
    }
    if ((!a(localStoryVideoItem)) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localStoryVideoItem.mVid) == null))
    {
      SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager that need to req the storyVideoItem vid=" + localStoryVideoItem.mVid + "cover=" + localStoryVideoItem.getThumbUrl());
      paramQQStoryAutoPlayView = new ArrayList();
      paramQQStoryAutoPlayView.add(localStoryVideoItem.mVid);
      a(paramQQStoryAutoPlayView);
      StoryReportor.b("story_home_dev", "feed_play_req", 0, 2, new String[] { localStoryVideoItem.mVid });
      return;
    }
    StoryReportor.b("story_home_dev", "feed_play_req", 0, 1, new String[] { localStoryVideoItem.mVid });
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onSuccess = " + paramString1);
    paramString2 = new FeedSegment.StoryVideoDownloadedEvent();
    paramString2.a = paramString1;
    Dispatchers.get().dispatch(paramString2);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 0, 0, new String[] { paramString1 });
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    SLog.b("Q.qqstory.home.AutoPlayManager", "AutoPlayManager onError = " + paramString1);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    StoryReportor.b("auto_play", "rsp_down", 1, 0, new String[] { paramString1 });
  }
  
  public void a(List paramList)
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
    if (paramStoryVideoItem == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl()))
    {
      paramStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramStoryVideoItem.mVid);
      return (paramStoryVideoItem != null) && (!TextUtils.isEmpty(paramStoryVideoItem.getVideoUrl()));
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
  
  public void b(List paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager
 * JD-Core Version:    0.7.0.1
 */
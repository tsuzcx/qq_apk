package com.tencent.biz.qqstory.playvideo.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetShareVideoListRequest;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoSharePlayingListSync
  extends BasePagePlayingListSync
{
  protected long a;
  protected int b;
  protected String c;
  
  protected void a()
  {
    Object localObject = (StoryManager)SuperManager.a(5);
    StoryVideoItem localStoryVideoItem;
    if (QQStoryContext.a().a(this.jdField_c_of_type_JavaLangString))
    {
      localObject = ((StoryManager)localObject).d(this.jdField_c_of_type_JavaLangString);
      if (localObject != null)
      {
        localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if ((!localStoryVideoItem.isUploadFail()) && (!localStoryVideoItem.isUploadSuc())) {
            localIterator.remove();
          }
        }
      }
      Collections.sort((List)localObject, new MyVideoSharePlayingListSync.1(this));
    }
    else
    {
      localObject = ((StoryManager)localObject).a(this.jdField_c_of_type_JavaLangString);
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        localStoryVideoItem.mOwnerUid = QQStoryContext.a().b();
      }
    }
    if (((List)localObject).size() > 0)
    {
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        if (((StoryVideoItem)localIterator.next()).mCreateTime / 1000L > this.jdField_a_of_type_Long) {
          localIterator.remove();
        }
      }
      if (((List)localObject).size() == 0) {
        return;
      }
      if (((StoryVideoItem)((List)localObject).get(((List)localObject).size() - 1)).mCreateTime / 1000L != this.jdField_a_of_type_Long) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      localObject = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_a_of_type_Boolean = true;
      ((DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent)localObject).jdField_b_of_type_Boolean = true;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    }
  }
  
  protected void b()
  {
    this.jdField_c_of_type_Boolean = true;
    GetShareVideoListRequest localGetShareVideoListRequest = new GetShareVideoListRequest(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
    localGetShareVideoListRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a(localGetShareVideoListRequest, new MyVideoSharePlayingListSync.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */
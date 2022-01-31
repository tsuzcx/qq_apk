package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedIdVidListEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ShareGroupVideoDataProvider$GetFeedIdVidListReceiver
  extends QQUIEventReceiver
{
  public ShareGroupVideoDataProvider$GetFeedIdVidListReceiver(@NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider)
  {
    super(paramShareGroupVideoDataProvider);
  }
  
  public void a(@NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider, @NonNull ShareGroupManager.GetFeedIdVidListEvent paramGetFeedIdVidListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "GetFeedIdVidListReceiver event.mVidList: " + paramGetFeedIdVidListEvent.jdField_a_of_type_JavaUtilArrayList);
    }
    paramShareGroupVideoDataProvider.a(paramGetFeedIdVidListEvent.jdField_a_of_type_JavaLangString, paramGetFeedIdVidListEvent.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupManager.GetFeedIdVidListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.ShareGroupVideoDataProvider.GetFeedIdVidListReceiver
 * JD-Core Version:    0.7.0.1
 */
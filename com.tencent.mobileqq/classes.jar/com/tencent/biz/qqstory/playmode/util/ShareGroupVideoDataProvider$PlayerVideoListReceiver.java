package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ShareGroupVideoDataProvider$PlayerVideoListReceiver
  extends QQUIEventReceiver
{
  public ShareGroupVideoDataProvider$PlayerVideoListReceiver(ShareGroupVideoDataProvider paramShareGroupVideoDataProvider1, @NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider2)
  {
    super(paramShareGroupVideoDataProvider2);
  }
  
  public void a(@NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider, @NonNull DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "GetStoryListReceiver");
    }
    paramShareGroupVideoDataProvider.a(paramPlayerVideoListEvent);
  }
  
  public Class acceptEventClass()
  {
    return DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.ShareGroupVideoDataProvider.PlayerVideoListReceiver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MemoryVideoDataProvider$PlayerVideoListReceiver
  extends QQUIEventReceiver
{
  public MemoryVideoDataProvider$PlayerVideoListReceiver(MemoryVideoDataProvider paramMemoryVideoDataProvider1, @NonNull MemoryVideoDataProvider paramMemoryVideoDataProvider2)
  {
    super(paramMemoryVideoDataProvider2);
  }
  
  public void a(@NonNull MemoryVideoDataProvider paramMemoryVideoDataProvider, @NonNull DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "GetStoryListReceiver");
    }
    paramMemoryVideoDataProvider.a(paramPlayerVideoListEvent);
  }
  
  public Class acceptEventClass()
  {
    return DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MemoryVideoDataProvider.PlayerVideoListReceiver
 * JD-Core Version:    0.7.0.1
 */
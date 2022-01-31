package com.tencent.biz.qqstory.view.widget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserIconHandler.UserIconUpdateEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;

public class StoryUserBadgeView$UserIconUpdateReceiver
  extends QQUIEventReceiver
{
  public StoryUserBadgeView$UserIconUpdateReceiver(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
  {
    super(paramStoryUserBadgeView);
  }
  
  public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull GetUserIconHandler.UserIconUpdateEvent paramUserIconUpdateEvent)
  {
    if (paramUserIconUpdateEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    while (paramUserIconUpdateEvent.jdField_a_of_type_JavaUtilHashMap.get(paramStoryUserBadgeView.a()) == null) {
      return;
    }
    paramStoryUserBadgeView.a(paramStoryUserBadgeView.a());
  }
  
  public Class acceptEventClass()
  {
    return GetUserIconHandler.UserIconUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView.UserIconUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */
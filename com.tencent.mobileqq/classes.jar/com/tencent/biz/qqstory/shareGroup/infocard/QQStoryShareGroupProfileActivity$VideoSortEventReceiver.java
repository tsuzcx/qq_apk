package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ChangeVideoSortEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$VideoSortEventReceiver
  extends QQUIEventReceiver
{
  public QQStoryShareGroupProfileActivity$VideoSortEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull ShareGroupsListAdapter.ChangeVideoSortEvent paramChangeVideoSortEvent)
  {
    if (paramChangeVideoSortEvent.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.g = true;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a();
      paramQQStoryShareGroupProfileActivity.b(true);
      paramChangeVideoSortEvent = paramQQStoryShareGroupProfileActivity.b;
      if (!paramQQStoryShareGroupProfileActivity.g) {
        break label82;
      }
    }
    label82:
    for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
    {
      StoryReportor.a("share_story", "clk_rank", 0, 0, new String[] { paramChangeVideoSortEvent, paramQQStoryShareGroupProfileActivity });
      return;
      if (paramChangeVideoSortEvent.a != 0) {
        break;
      }
      paramQQStoryShareGroupProfileActivity.g = false;
      paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupsListAdapter.ChangeVideoSortEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.VideoSortEventReceiver
 * JD-Core Version:    0.7.0.1
 */
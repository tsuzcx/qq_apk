package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ChangeVideoSortEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class QQStoryShareGroupProfileActivity$VideoSortEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, ShareGroupsListAdapter.ChangeVideoSortEvent>
{
  public QQStoryShareGroupProfileActivity$VideoSortEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull ShareGroupsListAdapter.ChangeVideoSortEvent paramChangeVideoSortEvent)
  {
    if (paramChangeVideoSortEvent.a == 1)
    {
      paramQQStoryShareGroupProfileActivity.G = true;
    }
    else if (paramChangeVideoSortEvent.a == 0)
    {
      paramQQStoryShareGroupProfileActivity.G = false;
      paramQQStoryShareGroupProfileActivity.r = false;
    }
    paramQQStoryShareGroupProfileActivity.e.b();
    paramQQStoryShareGroupProfileActivity.b(true);
    paramChangeVideoSortEvent = paramQQStoryShareGroupProfileActivity.t;
    if (paramQQStoryShareGroupProfileActivity.G) {
      paramQQStoryShareGroupProfileActivity = "1";
    } else {
      paramQQStoryShareGroupProfileActivity = "2";
    }
    StoryReportor.a("share_story", "clk_rank", 0, 0, new String[] { paramChangeVideoSortEvent, paramQQStoryShareGroupProfileActivity });
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupsListAdapter.ChangeVideoSortEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.VideoSortEventReceiver
 * JD-Core Version:    0.7.0.1
 */
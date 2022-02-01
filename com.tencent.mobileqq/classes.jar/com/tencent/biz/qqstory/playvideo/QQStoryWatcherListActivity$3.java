package com.tencent.biz.qqstory.playvideo;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class QQStoryWatcherListActivity$3
  extends ChildViewClickListener
{
  QQStoryWatcherListActivity$3(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      StoryApi.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.j)) && (this.a.k != null)) {
        StoryReportor.a("home_page", "clk_head_list", StoryReportor.a(this.a.k), 0, new String[] { "1", StoryReportor.b(this.a.l), "", this.a.j });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.3
 * JD-Core Version:    0.7.0.1
 */
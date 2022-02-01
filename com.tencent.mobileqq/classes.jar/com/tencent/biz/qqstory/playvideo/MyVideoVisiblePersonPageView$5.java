package com.tencent.biz.qqstory.playvideo;

import android.view.View;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;

class MyVideoVisiblePersonPageView$5
  extends ChildViewClickListener
{
  MyVideoVisiblePersonPageView$5(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      StoryApi.a(this.a.a, 10, paramView.uid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.List;

class HotRecommendFeedAdapter$1
  extends ChildViewClickListener
{
  HotRecommendFeedAdapter$1(HotRecommendFeedAdapter paramHotRecommendFeedAdapter) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (UIUtils.d()) {
      return;
    }
    if (paramInt >= 0)
    {
      if (paramInt >= this.a.b.size()) {
        return;
      }
      paramObject = (StoryVideoItem)this.a.b.get(paramInt);
      if (TextUtils.isEmpty(paramObject.mOwnerUid)) {
        return;
      }
      paramObject = HotRecommendFeedAdapter.a(this.a).b(paramObject.mOwnerUid);
      if (paramObject == null) {
        return;
      }
      if (paramView.getId() != 2131448770) {
        return;
      }
      if (HotRecommendFeedAdapter.b(this.a) != null) {
        HotRecommendFeedAdapter.b(this.a).a(paramView, this.a.c, paramObject, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.adapter.HotRecommendFeedAdapter.1
 * JD-Core Version:    0.7.0.1
 */
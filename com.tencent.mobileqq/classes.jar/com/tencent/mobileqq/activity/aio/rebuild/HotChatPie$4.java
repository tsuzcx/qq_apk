package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class HotChatPie$4
  implements OverScrollViewListener
{
  HotChatPie$4(HotChatPie paramHotChatPie) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    HotChatPie.a(this.a).setPullType(0);
    HotChatPie.a(this.a).c(HotChatPie.c);
    paramView = this.a;
    HotChatPie.a(paramView, 0, paramView.a.getLastPullUpEndIndex());
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.4
 * JD-Core Version:    0.7.0.1
 */
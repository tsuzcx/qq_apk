package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class ChatHistoryTroopFileFragment$1
  implements OverScrollViewListener
{
  ChatHistoryTroopFileFragment$1(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.s == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.s;
    }
    paramView.c(l);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisable");
    }
    paramView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.s == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.s;
    }
    paramView.b(l);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisableAndReleased");
    }
    paramView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.s == 0L) {
      l = System.currentTimeMillis();
    } else {
      l = this.a.s;
    }
    paramView.a(l);
    if (NetworkUtil.isNetworkAvailable(this.a.getBaseActivity()))
    {
      ChatHistoryTroopFileFragment.a(this.a).a(0, 0);
      return true;
    }
    ChatHistoryTroopFileFragment.a(this.a, 1);
    TroopFileUtils.b(this.a.a, ChatHistoryTroopFileFragment.b(this.a));
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.1
 * JD-Core Version:    0.7.0.1
 */
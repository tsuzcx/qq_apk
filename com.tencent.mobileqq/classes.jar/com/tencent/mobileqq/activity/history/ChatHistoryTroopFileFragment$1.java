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
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisable");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 2, "onViewCompleteVisableAndReleased");
    }
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.a(l);
      if (!NetworkUtil.g(this.a.getActivity())) {
        break;
      }
      ChatHistoryTroopFileFragment.a(this.a).a(0, 0);
      return true;
    }
    ChatHistoryTroopFileFragment.a(this.a, 1);
    TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ChatHistoryTroopFileFragment.a(this.a));
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
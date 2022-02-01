package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter.FileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;

class ChatHistoryC2CFileFragment$9
  extends CustomFastOnClickListener
{
  ChatHistoryC2CFileFragment$9(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    paramView = (FileManagerEntity)((ChatHistoryC2CFileAdapter.FileItemHolder)paramView.getTag()).h;
    this.a.d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.9
 * JD-Core Version:    0.7.0.1
 */
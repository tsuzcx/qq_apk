package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter;
import com.tencent.mobileqq.activity.history.adapter.ChatHistoryC2CFileAdapter.FileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ChatHistoryC2CFileFragment$6
  extends CustomFastOnClickListener
{
  ChatHistoryC2CFileFragment$6(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  public void a(View paramView)
  {
    paramView = (ChatHistoryC2CFileAdapter.FileItemHolder)paramView.getTag();
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.jdField_a_of_type_JavaLangObject;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.b(localFileManagerEntity);
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.a.a.notifyDataSetChanged();
      return;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131692602);
        return;
      }
      this.a.c(localFileManagerEntity);
      continue;
      this.a.d(localFileManagerEntity);
      continue;
      this.a.b(localFileManagerEntity);
      continue;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131692602);
        return;
      }
      this.a.a(localFileManagerEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.6
 * JD-Core Version:    0.7.0.1
 */
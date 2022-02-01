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
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.h;
    if (5 != localFileManagerEntity.cloudType) {
      FileManagerUtil.e(localFileManagerEntity);
    }
    int i = paramView.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              FMToastUtil.a(2131889577);
              return;
            }
            this.a.a(localFileManagerEntity);
          }
        }
        else {
          this.a.b(localFileManagerEntity);
        }
      }
      else
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          FMToastUtil.a(2131889577);
          return;
        }
        this.a.c(localFileManagerEntity);
      }
    }
    else {
      this.a.d(localFileManagerEntity);
    }
    this.a.s.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment.6
 * JD-Core Version:    0.7.0.1
 */
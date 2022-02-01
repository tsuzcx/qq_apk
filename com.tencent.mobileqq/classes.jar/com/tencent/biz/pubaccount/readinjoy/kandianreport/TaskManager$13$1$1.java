package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.ClipboardUtil;
import com.tencent.common.app.BaseApplicationImpl;

class TaskManager$13$1$1
  implements DialogInterface.OnClickListener
{
  TaskManager$13$1$1(TaskManager.13.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ClipboardUtil.a(BaseApplicationImpl.getContext(), this.this$2.val$rText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.13.1.1
 * JD-Core Version:    0.7.0.1
 */
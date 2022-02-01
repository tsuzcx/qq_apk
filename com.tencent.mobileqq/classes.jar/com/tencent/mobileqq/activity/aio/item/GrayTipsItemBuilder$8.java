package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;

class GrayTipsItemBuilder$8
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$8(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.c, ChatHistoryFileActivity.class);
    paramView.putExtra("uin", this.b.d.b);
    paramView.putExtra("uintype", this.b.d.a);
    paramView.putExtra("uinname", this.b.d.e);
    paramView.putExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab", this.a);
    this.b.c.startActivity(paramView);
    FileManagerReporter.a("0X800506C");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */
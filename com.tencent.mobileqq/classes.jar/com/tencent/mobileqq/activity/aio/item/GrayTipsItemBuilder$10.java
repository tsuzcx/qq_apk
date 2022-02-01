package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;

class GrayTipsItemBuilder$10
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$10(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.b(this.a.a.getCurrentAccountUin(), 3);
    FileManagerUtil.a((Activity)this.a.c, this.a.a.getCurrentAccountUin(), this.a.d.b, this.a.d.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;

class GrayTipsItemBuilder$9
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$9(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.b((Activity)this.a.c, this.a.a.getCurrentAccountUin(), this.a.d.b, this.a.d.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */
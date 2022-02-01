package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class PicItemBuilder$1
  extends UiCallBack.DownAdapter
{
  PicItemBuilder$1(PicItemBuilder paramPicItemBuilder, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    this.a.setProgressVisable(false);
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "2g diy gif onDownload");
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "2g diy gif onUpdateProgress");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
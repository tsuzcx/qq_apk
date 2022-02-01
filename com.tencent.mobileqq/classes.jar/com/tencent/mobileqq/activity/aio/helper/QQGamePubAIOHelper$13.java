package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class QQGamePubAIOHelper$13
  implements Runnable
{
  QQGamePubAIOHelper$13(QQGamePubAIOHelper paramQQGamePubAIOHelper) {}
  
  public void run()
  {
    if ((QQGamePubAIOHelper.a(this.this$0) != null) && (QQGamePubAIOHelper.a(this.this$0).V != null)) {
      QQGamePubAIOHelper.a(this.this$0).V.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper.13
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class KanDianPrivateChatPie$4
  implements Runnable
{
  KanDianPrivateChatPie$4(KanDianPrivateChatPie paramKanDianPrivateChatPie) {}
  
  public void run()
  {
    Intent localIntent = this.this$0.f.getIntent();
    localIntent.putExtra("uintype", 0);
    KanDianPrivateChatPie.a(this.this$0, localIntent);
    QLog.i("KanDianPrivateChatPie", 1, "[update] change to friend type aio.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.KanDianPrivateChatPie.4
 * JD-Core Version:    0.7.0.1
 */
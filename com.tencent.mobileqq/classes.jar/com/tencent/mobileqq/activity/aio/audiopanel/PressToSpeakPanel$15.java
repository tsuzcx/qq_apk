package com.tencent.mobileqq.activity.aio.audiopanel;

import ajya;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import bcql;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PressToSpeakPanel$15
  implements Runnable
{
  PressToSpeakPanel$15(PressToSpeakPanel paramPressToSpeakPanel, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    if ((PressToSpeakPanel.b(this.this$0)) && (PressToSpeakPanel.d(this.this$0) > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,but use once enabled and mUsedCount is " + PressToSpeakPanel.d(this.this$0));
      }
      return;
    }
    PressToSpeakPanel.b(this.this$0, true);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "delay start record runnable is run,touchValid is:" + PressToSpeakPanel.c(this.this$0));
    }
    if (!PressToSpeakPanel.c())
    {
      PressToSpeakPanel.a(true);
      PressToChangeVoicePanel.a(PressToSpeakPanel.a(this.this$0), false, "0X8006385");
    }
    Object localObject = PressToSpeakPanel.a(this.this$0).a();
    int i = PressToSpeakPanel.a(this.this$0).a().getTitleBarHeight();
    aytn.a = SystemClock.uptimeMillis();
    if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
    {
      bcql.a(BaseApplication.getContext(), 2131693600, 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.this$0).n())
    {
      bcql.a(BaseApplication.getContext(), ajya.a(2131708418), 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.this$0).c())
    {
      bcql.a(BaseApplication.getContext(), 2131695522, 0).b(i);
      return;
    }
    if (AudioHelper.b(1))
    {
      ChatActivityUtils.a(PressToSpeakPanel.a(this.this$0).a());
      return;
    }
    PressToSpeakPanel.a(this.this$0).setStatus(2);
    this.this$0.a(this.a);
    PressToSpeakPanel.a(this.this$0).k(0);
    PressToSpeakPanel.a(this.this$0).a(this.this$0, true, (QQRecorder.RecorderParam)localObject);
    this.this$0.g();
    localObject = new Rect();
    this.this$0.getWindowVisibleDisplayFrame((Rect)localObject);
    Rect localRect = new Rect();
    PressToSpeakPanel.b(this.this$0).getGlobalVisibleRect(localRect);
    localRect = new Rect();
    this.this$0.a.getGlobalVisibleRect(localRect);
    int j = localRect.bottom;
    if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
    {
      i = j;
      if (Build.MODEL.startsWith("ivvi"))
      {
        i = j;
        if (Build.VERSION.SDK_INT != 22) {}
      }
    }
    else
    {
      i = j - ((Rect)localObject).top;
    }
    if (localRect.top <= this.this$0.getResources().getDisplayMetrics().heightPixels) {
      PressToSpeakPanel.a(this.this$0, AudioPanel.a(PressToSpeakPanel.a(this.this$0).a(), ((Rect)localObject).width(), i, this.this$0, 0, 0, 0));
    }
    PressToSpeakPanel.a(this.this$0, AudioPanel.a(PressToSpeakPanel.a(this.this$0).a(), PressToSpeakPanel.b(this.this$0), this.this$0.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.15
 * JD-Core Version:    0.7.0.1
 */
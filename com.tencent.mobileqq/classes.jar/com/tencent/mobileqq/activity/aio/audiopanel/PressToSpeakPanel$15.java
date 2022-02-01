package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("delay start record runnable is run,but use once enabled and mUsedCount is ");
        ((StringBuilder)localObject1).append(PressToSpeakPanel.d(this.this$0));
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    PressToSpeakPanel.b(this.this$0, true);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("delay start record runnable is run,touchValid is:");
      ((StringBuilder)localObject1).append(PressToSpeakPanel.c(this.this$0));
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (!PressToSpeakPanel.c())
    {
      PressToSpeakPanel.a(true);
      PressToChangeVoicePanel.a(PressToSpeakPanel.a(this.this$0), false, "0X8006385");
    }
    Object localObject1 = PressToSpeakPanel.a(this.this$0).a();
    int i = PressToSpeakPanel.a(this.this$0).a().getTitleBarHeight();
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).setsCostUntilPrepare(SystemClock.uptimeMillis());
    if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject1).c))
    {
      QQToast.a(BaseApplication.getContext(), 2131693398, 0).b(i);
      return;
    }
    if (((AudioPanelAioHelper)PressToSpeakPanel.a(this.this$0).a(128)).b())
    {
      QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131708402), 0).b(i);
      return;
    }
    if (PressToSpeakPanel.a(this.this$0).isVideoChatting())
    {
      QQToast.a(BaseApplication.getContext(), 2131695163, 0).b(i);
      return;
    }
    if (AudioUtil.a(1))
    {
      ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(PressToSpeakPanel.a(this.this$0).a());
      return;
    }
    PressToSpeakPanel.a(this.this$0).setStatus(2);
    this.this$0.a(this.a);
    ((AudioPanelAioHelper)PressToSpeakPanel.a(this.this$0).a(128)).e(0);
    ((AudioPanelAioHelper)PressToSpeakPanel.a(this.this$0).a(128)).a(this.this$0, true, (RecordParams.RecorderParam)localObject1);
    this.this$0.f();
    localObject1 = new Rect();
    this.this$0.getWindowVisibleDisplayFrame((Rect)localObject1);
    Object localObject2 = new Rect();
    PressToSpeakPanel.b(this.this$0).getGlobalVisibleRect((Rect)localObject2);
    localObject2 = new Rect();
    if (ThemeUtil.isNowThemeIsSimple(PressToSpeakPanel.a(this.this$0), false, null)) {
      PressToSpeakPanel.b(this.this$0).getGlobalVisibleRect((Rect)localObject2);
    } else {
      this.this$0.a.getGlobalVisibleRect((Rect)localObject2);
    }
    int j = ((Rect)localObject2).bottom;
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
      i = j - ((Rect)localObject1).top;
    }
    if (((Rect)localObject2).top <= this.this$0.getResources().getDisplayMetrics().heightPixels)
    {
      localObject2 = this.this$0;
      PressToSpeakPanel.a((PressToSpeakPanel)localObject2, AudioPanel.a(PressToSpeakPanel.a((PressToSpeakPanel)localObject2).a(), ((Rect)localObject1).width(), i, this.this$0, 0, 0, 0));
    }
    localObject1 = this.this$0;
    PressToSpeakPanel.a((PressToSpeakPanel)localObject1, AudioPanel.a(PressToSpeakPanel.a((PressToSpeakPanel)localObject1).a(), PressToSpeakPanel.b(this.this$0), this.this$0.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.15
 * JD-Core Version:    0.7.0.1
 */
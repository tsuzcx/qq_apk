package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PressToChangeVoicePanel$3
  implements Runnable
{
  PressToChangeVoicePanel$3(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.this$0, true);
    boolean bool = ((AudioPanelAioHelper)this.this$0.a.q(128)).g();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isRecording is:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      if (((AudioPanelAioHelper)this.this$0.a.q(128)).d())
      {
        this.this$0.setClickable(false);
        ((AudioPanelAioHelper)this.this$0.a.q(128)).g(2);
      }
    }
    else
    {
      PressToChangeVoicePanel.a(this.this$0.b, true, "0X8006386");
      if (PressToChangeVoicePanel.p == null)
      {
        QQToast.makeText(BaseApplication.getContext(), 2131896458, 0).show();
        return;
      }
      ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).setsCostUntilPrepare(SystemClock.uptimeMillis());
      int i = this.this$0.a.aX().getTitleBarHeight();
      localObject1 = this.this$0.a.aU();
      if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord())
      {
        QQToast.makeText(BaseApplication.getContext(), 2131916078, 0).show(i);
      }
      else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject1).c))
      {
        QQToast.makeText(BaseApplication.getContext(), 2131890947, 0).show(i);
      }
      else if (this.this$0.b.isVideoChatting())
      {
        QQToast.makeText(BaseApplication.getContext(), 2131892896, 0).show();
      }
      else if (AudioUtil.b(1))
      {
        ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this.this$0.a.aX());
      }
      else
      {
        this.this$0.f();
        ((AudioPanelAioHelper)this.this$0.a.q(128)).a(this.this$0, false, (RecordParams.RecorderParam)localObject1);
        ((AudioPanelAioHelper)this.this$0.a.q(128)).f(2);
        this.this$0.d.setStatus(3);
        this.this$0.h();
        localObject1 = new Rect();
        Object localObject2 = new Rect();
        this.this$0.e.getGlobalVisibleRect((Rect)localObject2);
        this.this$0.getWindowVisibleDisplayFrame((Rect)localObject1);
        localObject2 = new Rect();
        if (ThemeUtil.isNowThemeIsSimple(this.this$0.b, false, null)) {
          this.this$0.e.getGlobalVisibleRect((Rect)localObject2);
        } else {
          this.this$0.f.getGlobalVisibleRect((Rect)localObject2);
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
          ((PressToChangeVoicePanel)localObject2).l = AudioPanel.a(((PressToChangeVoicePanel)localObject2).a.aX(), ((Rect)localObject1).width(), i, this.this$0, 0, 0, 0);
        }
        localObject1 = this.this$0;
        ((PressToChangeVoicePanel)localObject1).m = AudioPanel.a(((PressToChangeVoicePanel)localObject1).a.aX(), this.this$0.e, this.this$0.f);
      }
      if (((AudioPanelProvider)this.this$0.a.bq().f(2)).b) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.this$0.b, "CliOper", "", "", "0X8005472", "0X8005472", i, 0, "", "", "", "8.8.17");
      if (this.this$0.d != null) {
        this.this$0.d.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

class PressToChangeVoicePanel$1
  extends Handler
{
  PressToChangeVoicePanel$1(PressToChangeVoicePanel paramPressToChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1007: 
        this.a.a(paramMessage.arg1);
        PressToChangeVoicePanel.a(this.a).setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(((Double)paramMessage.obj).doubleValue()));
        return;
      }
    }
    catch (Exception paramMessage)
    {
      Object localObject2;
      ObjectAnimator localObjectAnimator;
      AnimatorSet localAnimatorSet;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uiHandler Error:");
      ((StringBuilder)localObject1).append(paramMessage.getMessage());
      QLog.e("PressToChangeVoicePanel", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    this.a.g();
    return;
    if (this.a.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("changevoice", 2, "recored end callback , pie is null !!");
      }
    }
    else
    {
      localObject1 = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
      localObject1 = (RecordParams.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
      this.a.c.setVisibility(8);
      ((AudioPanelAioHelper)this.a.a.q(128)).b(paramMessage, (RecordParams.RecorderParam)localObject1);
      ((IPttPreSendService)this.a.b.getRuntimeService(IPttPreSendService.class)).doPreSendIfIcan(this.a.a.ah, (RecordParams.RecorderParam)localObject1);
      localObject2 = (ListenChangeVoicePanel)this.a.k.findViewById(2131437321);
      ((ListenChangeVoicePanel)localObject2).e();
      ((ListenChangeVoicePanel)localObject2).setVisibility(0);
      ((ListenChangeVoicePanel)localObject2).setAudioPath(paramMessage, this.a.n, (RecordParams.RecorderParam)localObject1);
      this.a.d.setStatus(4);
      this.a.setVisibility(8);
      this.a.setClickable(true);
      if ((this.a.a instanceof PublicAccountChatPie)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.b, "P_CliOper", "Pb_account_lifeservice", "", "0X8005850", "0X8005850", 0, 0, "", "", Double.toString(this.a.n), "", false);
      }
      paramMessage = (ViewGroup)((ListenChangeVoicePanel)localObject2).findViewById(2131430490);
      if (VersionUtils.e())
      {
        localObject1 = ObjectAnimator.ofFloat(paramMessage, "scaleX", new float[] { 0.4F, 1.0F });
        localObject2 = ObjectAnimator.ofFloat(paramMessage, "scaleY", new float[] { 0.4F, 1.0F });
        localObjectAnimator = ObjectAnimator.ofFloat(paramMessage, "alpha", new float[] { 0.4F, 1.0F });
        localAnimatorSet = new AnimatorSet();
        localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2).with(localObjectAnimator);
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.addListener(new PressToChangeVoicePanel.1.1(this, paramMessage));
        localAnimatorSet.start();
        return;
      }
      paramMessage.setVisibility(0);
      return;
      ((AudioPanelAioHelper)this.a.a.q(128)).a((String)paramMessage.obj, null);
      this.a.g();
      return;
      localObject1 = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
      localObject1 = (RecordParams.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
      this.a.g();
      ((AudioPanelAioHelper)this.a.a.q(128)).a(paramMessage, (RecordParams.RecorderParam)localObject1);
      return;
      this.a.e();
      return;
      this.a.a();
      return;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.1
 * JD-Core Version:    0.7.0.1
 */
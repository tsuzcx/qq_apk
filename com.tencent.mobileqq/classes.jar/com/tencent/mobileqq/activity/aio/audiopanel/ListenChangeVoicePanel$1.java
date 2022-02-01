package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.IPttVoiceChangePreSender;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class ListenChangeVoicePanel$1
  extends Handler
{
  ListenChangeVoicePanel$1(ListenChangeVoicePanel paramListenChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    case 102: 
    default: 
    case 107: 
      this.a.a(???.arg1, ???.arg2, ???.obj, true);
      return;
    case 106: 
      if (ListenChangeVoicePanel.a(this.a).get() != null)
      {
        if (this.a.d.get() == null) {
          return;
        }
        ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToSend(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), ListenChangeVoicePanel.b(this.a), PressToChangeVoicePanel.p, this.a);
        int k = (int)ListenChangeVoicePanel.c(this.a);
        if (!((IPttPreSendService)((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getRuntimeService(IPttPreSendService.class)).doOnRealSend(((BaseChatPie)this.a.d.get()).ah, ListenChangeVoicePanel.d(this.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ListenChangeVoicePanel", 2, "presend not hit, do origin logic");
          }
          if (ListenChangeVoicePanel.d(this.a) > 0) {
            i = 1;
          } else {
            i = 0;
          }
          ((AudioPanelAioHelper)((BaseChatPie)this.a.d.get()).q(128)).a(ListenChangeVoicePanel.e(this.a), 4, 0, ListenChangeVoicePanel.f(this.a), i, false, 0);
        }
        ((AudioPanelAioHelper)((BaseChatPie)this.a.d.get()).q(128)).a(ListenChangeVoicePanel.e(this.a), null);
        if (ListenChangeVoicePanel.l != null)
        {
          ListenChangeVoicePanel.l.a((AppRuntime)ListenChangeVoicePanel.a(this.a).get(), ListenChangeVoicePanel.d(this.a));
          if (ListenChangeVoicePanel.d(this.a) > 0)
          {
            ??? = (AppRuntime)ListenChangeVoicePanel.a(this.a).get();
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(((BaseChatPie)this.a.d.get()).ah.a);
            localObject1 = ((StringBuilder)localObject1).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(ListenChangeVoicePanel.d(this.a));
            ReportController.b(???, "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, (String)localObject1, localStringBuilder.toString(), "", "");
          }
        }
        this.a.g();
        int j = ListenChangeVoicePanel.g(this.a);
        int i = j;
        if (this.a.k) {
          i = j + 10;
        }
        j = ListenChangeVoicePanel.d(this.a);
        int m = ListenChangeVoicePanel.h(this.a);
        this.a.a(j, m, k, i);
        return;
      }
      break;
    case 105: 
      if (ListenChangeVoicePanel.a(this.a).get() != null) {
        QQToast.makeText(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), "播放变音error", 0);
      }
      if (this.a.g != null)
      {
        this.a.g.a(1);
        return;
      }
      break;
    case 104: 
      if (this.a.g != null)
      {
        this.a.g.a(1);
        return;
      }
      break;
    case 103: 
      if ((???.obj != null) && ((???.obj instanceof Bundle)) && (this.a.g != null))
      {
        ??? = (Bundle)???.obj;
        if (??? != null)
        {
          this.a.g.a(???.getInt("progress"), ???.getInt("playTime"), ???.getInt("level"));
          return;
        }
      }
      break;
    case 101: 
      ListenChangeVoicePanel.a(this.a, -1);
      this.a.h.c = 0;
      ??? = this.a;
      ???.g = null;
      synchronized (???.f)
      {
        this.a.h.e = this.a.f;
        this.a.h.notifyDataSetChanged();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.1
 * JD-Core Version:    0.7.0.1
 */
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
        if (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
          return;
        }
        ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToSend(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), ListenChangeVoicePanel.a(this.a), PressToChangeVoicePanel.a, this.a);
        int k = (int)ListenChangeVoicePanel.a(this.a);
        if (!((IPttPreSendService)((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getRuntimeService(IPttPreSendService.class)).doOnRealSend(((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a, ListenChangeVoicePanel.a(this.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ListenChangeVoicePanel", 2, "presend not hit, do origin logic");
          }
          if (ListenChangeVoicePanel.a(this.a) > 0) {
            i = 1;
          } else {
            i = 0;
          }
          ((AudioPanelAioHelper)((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a(128)).a(ListenChangeVoicePanel.a(this.a), 4, 0, ListenChangeVoicePanel.a(this.a), i, false, 0);
        }
        ((AudioPanelAioHelper)((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a(128)).a(ListenChangeVoicePanel.a(this.a), null);
        if (ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender != null)
        {
          ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender.a((AppRuntime)ListenChangeVoicePanel.a(this.a).get(), ListenChangeVoicePanel.a(this.a));
          if (ListenChangeVoicePanel.a(this.a) > 0)
          {
            ??? = (AppRuntime)ListenChangeVoicePanel.a(this.a).get();
            Object localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a);
            localObject1 = ((StringBuilder)localObject1).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(ListenChangeVoicePanel.a(this.a));
            ReportController.b(???, "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, (String)localObject1, localStringBuilder.toString(), "", "");
          }
        }
        this.a.f();
        int j = ListenChangeVoicePanel.b(this.a);
        int i = j;
        if (this.a.jdField_a_of_type_Boolean) {
          i = j + 10;
        }
        j = ListenChangeVoicePanel.a(this.a);
        int m = ListenChangeVoicePanel.c(this.a);
        this.a.a(j, m, k, i);
        return;
      }
      break;
    case 105: 
      if (ListenChangeVoicePanel.a(this.a).get() != null) {
        QQToast.a(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), "播放变音error", 0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
        return;
      }
      break;
    case 104: 
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
        return;
      }
      break;
    case 103: 
      if ((???.obj != null) && ((???.obj instanceof Bundle)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null))
      {
        ??? = (Bundle)???.obj;
        if (??? != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(???.getInt("progress"), ???.getInt("playTime"), ???.getInt("level"));
          return;
        }
      }
      break;
    case 101: 
      ListenChangeVoicePanel.a(this.a, -1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.b = 0;
      ??? = this.a;
      ???.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = null;
      synchronized (???.b)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.a = this.a.b;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.notifyDataSetChanged();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.1
 * JD-Core Version:    0.7.0.1
 */
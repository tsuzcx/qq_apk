package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$12
  extends Handler
{
  TroopChatPie$12(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          return;
          this.a.a(null, false);
          return;
          paramMessage = paramMessage.obj;
        } while (!(paramMessage instanceof SelfGagInfo));
        this.a.a((SelfGagInfo)paramMessage);
        return;
        paramMessage = (PlusPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
      } while (paramMessage == null);
      paramMessage.a();
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, str, i).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.12
 * JD-Core Version:    0.7.0.1
 */
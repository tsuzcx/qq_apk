package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$10
  extends Handler
{
  TroopChatPie$10(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            String str = (String)paramMessage.obj;
            i = paramMessage.arg1;
            QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, i).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
            return;
          }
          paramMessage = (PlusPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
          if (paramMessage != null) {
            paramMessage.a();
          }
        }
      }
      else
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof SelfGagInfo)) {
          this.a.a((SelfGagInfo)paramMessage);
        }
      }
    }
    else {
      this.a.a(null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.10
 * JD-Core Version:    0.7.0.1
 */
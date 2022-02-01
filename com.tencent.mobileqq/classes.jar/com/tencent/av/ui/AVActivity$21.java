package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVActivity$21
  implements View.OnClickListener
{
  AVActivity$21(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isDestroyed()) {}
    label237:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!((SessionInfo)localObject).x)
      {
        int i = ((SessionInfo)localObject).d;
        long l = AudioHelper.b();
        QLog.w(this.a.b, 1, "onMsgClick, sessionType[" + i + "], state[" + ((SessionInfo)localObject).jdField_g_of_type_Int + "], seq[" + l + "]");
        if ((i == 1) || (i == 2))
        {
          if (!((SessionInfo)localObject).o()) {
            this.a.a(l, this.a.c, this.a.d, this.a.k);
          }
        }
        else {
          for (;;)
          {
            if (AVActivity.a(this.a) == null) {
              break label237;
            }
            AVActivity.a(this.a).a();
            break;
            if ((i == 3) || (i == 4))
            {
              localObject = String.valueOf(((SessionInfo)localObject).jdField_g_of_type_Long);
              String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.d, (String)localObject, null);
              this.a.a(l, (String)localObject, this.a.d, str);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.21
 * JD-Core Version:    0.7.0.1
 */
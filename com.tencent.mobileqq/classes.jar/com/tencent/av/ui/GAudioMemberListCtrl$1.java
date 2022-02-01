package com.tencent.av.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class GAudioMemberListCtrl$1
  implements View.OnClickListener
{
  GAudioMemberListCtrl$1(GAudioMemberListCtrl paramGAudioMemberListCtrl) {}
  
  public void onClick(View paramView)
  {
    GAudioMemberListCtrl.GAudioMemberInfo localGAudioMemberInfo = (GAudioMemberListCtrl.GAudioMemberInfo)paramView.getTag();
    if (GAudioMemberListCtrl.a(this.a) != null)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009E26", "0X8009E26", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onItemClick # mRelationUinStr = ");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(" # memberUin = ");
        ((StringBuilder)localObject).append(String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long));
        QLog.d("GAudioMemberListCtrl", 2, ((StringBuilder)localObject).toString());
      }
      GAudioMemberListCtrl.a(this.a).getCurrentAccountUin();
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.GaudioOpenTroopCard");
      ((Intent)localObject).putExtra("troopUin", String.valueOf(this.a.jdField_a_of_type_Long));
      ((Intent)localObject).putExtra("memberUin", String.valueOf(localGAudioMemberInfo.jdField_a_of_type_Long));
      int i = 0;
      if (this.a.jdField_a_of_type_Int == 1) {
        i = 1000;
      } else if (this.a.jdField_a_of_type_Int == 2) {
        i = 1004;
      }
      ((Intent)localObject).putExtra("uinType", i);
      ((Intent)localObject).setPackage(GAudioMemberListCtrl.a(this.a).getApplication().getPackageName());
      GAudioMemberListCtrl.a(this.a).getApp().sendBroadcast((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.1
 * JD-Core Version:    0.7.0.1
 */
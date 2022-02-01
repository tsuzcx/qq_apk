package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AuthDevActivity$3
  implements View.OnClickListener
{
  AuthDevActivity$3(AuthDevActivity paramAuthDevActivity, List paramList, RelativeLayout paramRelativeLayout, int paramInt, SvcDevLoginInfo paramSvcDevLoginInfo) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = this.jdField_a_of_type_JavaUtilList.equals(AuthDevActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity));
    if (bool2) {
      localObject = "0X800AC55";
    } else {
      localObject = "0X800AC57";
    }
    ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    Object localObject = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((SvcDevLoginInfo)localObject).stDeviceItemDes);
    boolean bool3 = Arrays.equals(NetConnInfoCenter.GUID, ((SvcDevLoginInfo)localObject).vecGuid);
    AuthDevActivity localAuthDevActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
    String str1 = ((SvcDevLoginInfo)localObject).strDeviceName;
    String str2 = AuthDevActivity.access$700(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
    int i = this.jdField_a_of_type_Int;
    boolean bool1;
    if (((SvcDevLoginInfo)localObject).iLoginPlatform == 3L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AuthDevActivity.access$800(localAuthDevActivity, str1, localArrayList, str2, i, bool1, bool3, ((SvcDevLoginInfo)localObject).iAppId, ((SvcDevLoginInfo)localObject).iLoginTime, this.jdField_a_of_type_QQServiceSvcDevLoginInfo.vecGuid, bool2, (SvcDevLoginInfo)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.3
 * JD-Core Version:    0.7.0.1
 */
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

class AuthDevActivity$4
  implements View.OnClickListener
{
  AuthDevActivity$4(AuthDevActivity paramAuthDevActivity, List paramList, RelativeLayout paramRelativeLayout, int paramInt, SvcDevLoginInfo paramSvcDevLoginInfo) {}
  
  public void onClick(View paramView)
  {
    boolean bool3 = this.jdField_a_of_type_JavaUtilList.equals(AuthDevActivity.access$500(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity));
    Object localObject1;
    ArrayList localArrayList;
    Object localObject2;
    boolean bool1;
    String str1;
    String str2;
    int i;
    if (bool3)
    {
      localObject1 = "0X800AC55";
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
      localObject1 = (SvcDevLoginInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag();
      localArrayList = new ArrayList();
      localArrayList.add(((SvcDevLoginInfo)localObject1).stDeviceItemDes);
      localObject2 = NetConnInfoCenter.GUID;
      bool1 = false;
      if (Arrays.equals((byte[])localObject2, ((SvcDevLoginInfo)localObject1).vecGuid)) {
        bool1 = true;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity;
      str1 = ((SvcDevLoginInfo)localObject1).strDeviceName;
      str2 = AuthDevActivity.access$600(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevActivity);
      i = this.jdField_a_of_type_Int;
      if (((SvcDevLoginInfo)localObject1).iLoginPlatform != 3L) {
        break label198;
      }
    }
    label198:
    for (boolean bool2 = true;; bool2 = false)
    {
      AuthDevActivity.access$700((AuthDevActivity)localObject2, str1, localArrayList, str2, i, bool2, bool1, ((SvcDevLoginInfo)localObject1).iAppId, ((SvcDevLoginInfo)localObject1).iLoginTime, this.jdField_a_of_type_QQServiceSvcDevLoginInfo.vecGuid, bool3, (SvcDevLoginInfo)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = "0X800AC57";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.4
 * JD-Core Version:    0.7.0.1
 */
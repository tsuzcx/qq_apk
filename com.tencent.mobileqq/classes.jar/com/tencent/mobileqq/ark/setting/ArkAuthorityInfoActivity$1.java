package com.tencent.mobileqq.ark.setting;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkAuthorityInfoActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  ArkAuthorityInfoActivity$1(ArkAuthorityInfoActivity paramArkAuthorityInfoActivity, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    IArkModuleAPIAuthority localIArkModuleAPIAuthority = (IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class);
    String str1 = ArkAuthorityInfoActivity.a(this.b);
    String str2 = ArkAuthorityInfoActivity.a()[this.a];
    String str3 = this.b.app.getCurrentAccountUin();
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localIArkModuleAPIAuthority.updateArkAuthorityInfo(str1, str2, str3, i);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */
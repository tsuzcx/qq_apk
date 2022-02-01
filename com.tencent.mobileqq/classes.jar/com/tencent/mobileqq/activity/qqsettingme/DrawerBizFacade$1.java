package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.PrivExtV2Rsp;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class DrawerBizFacade$1
  extends VipInfoObserver
{
  DrawerBizFacade$1(DrawerBizFacade paramDrawerBizFacade) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt >= 0) && (this.a.a != null))
    {
      SharedPreferences localSharedPreferences = this.a.a.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("key_selfvip_growthvalue", paramInt).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoObserver");
      }
      this.a.a("d_head_vip").g();
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1 = (QQSettingMeSuperMemberProcessor)this.a.a("d_vip_identity");
    if (paramInt == 1)
    {
      if (paramBoolean)
      {
        paramObject = (PrivExtV2Rsp)paramObject;
        Object localObject2 = paramObject.vipInfo;
        if ((localObject2 != null) && (((VipUserInfo)localObject2).bUpdate == 1))
        {
          localObject2 = ((VipUserInfo)localObject2).sUri;
          if (localObject2 != null)
          {
            if (localObject1 != null) {
              ((QQSettingMeSuperMemberProcessor)localObject1).b().a = ((String)localObject2);
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("vip url = ");
              ((StringBuilder)localObject1).append((String)localObject2);
              QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
            }
            this.a.a.getApplication().getSharedPreferences(this.a.a.getCurrentAccountUin(), 4).edit().putString("VIPCenter_url_key", (String)localObject2).apply();
          }
        }
        this.a.a("d_head_vip").g();
        if (paramObject.medalInfoList != null) {
          PrettyAccountUtil.a(paramObject.medalInfoList.lhNumFlag, paramObject.medalInfoList.lhLogoLv);
        }
        ThreadManagerV2.getUIHandlerV2().post(new DrawerBizFacade.1.1(this));
      }
      this.a.a("d_pretty_num").g();
      return;
    }
    if ((paramBoolean) && (paramInt == 6))
    {
      this.a.a("d_pretty_num").g();
      return;
    }
    if (paramInt == 4)
    {
      ThreadManagerV2.getUIHandlerV2().post(new DrawerBizFacade.1.2(this, (QQSettingMeSuperMemberProcessor)localObject1));
      return;
    }
    if (paramInt == 5) {
      ThreadManagerV2.getUIHandlerV2().post(new DrawerBizFacade.1.3(this, paramObject, (QQSettingMeSuperMemberProcessor)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.1
 * JD-Core Version:    0.7.0.1
 */
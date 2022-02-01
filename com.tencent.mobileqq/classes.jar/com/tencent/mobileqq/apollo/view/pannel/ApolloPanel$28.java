package com.tencent.mobileqq.apollo.view.pannel;

import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloPanel$28
  implements Runnable
{
  ApolloPanel$28(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool4 = false;
    boolean bool3 = false;
    if ((this.this$0.a == null) || (this.this$0.a.a == null)) {
      return;
    }
    bool1 = bool3;
    boolean bool2;
    label54:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1) {
        break label396;
      }
      bool2 = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get();
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "parseShopRedTouchManager:", localObject, ", isNewRed：", Boolean.valueOf(bool2), ",refreshByGetUserAction:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          localObject = localJSONObject.optString("_show_mission");
          localJSONObject = localJSONObject.optJSONObject("msg");
          bool1 = bool3;
          if (localJSONObject != null)
          {
            localJSONObject = localJSONObject.optJSONObject((String)localObject);
            bool1 = bool3;
            if (localJSONObject != null)
            {
              ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.this$0.a.a.getRuntimeService(IApolloManagerService.class, "all");
              ApolloPanel.a(this.this$0, localApolloManagerServiceImpl.parseApolloRedTouchContent(this.jdField_a_of_type_JavaLangString, (String)localObject, localJSONObject, bool2, 6));
              localObject = ApolloPanel.a(this.this$0);
              bool1 = bool3;
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException1)
        {
          label396:
          bool1 = bool4;
        }
        try
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "parseShopRedTouchManager pushItem:", ApolloPanel.a(this.this$0).toString() });
            }
            ApolloPanel.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, ApolloPanel.a(this.this$0).icon_url);
            ApolloPanel.a(this.this$0);
            VipUtils.a(this.this$0.a.a, "cmshow", "Apollo", "house_new_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.this$0.a.b()), 0, new String[] { ApolloPanel.a(this.this$0).msg_id });
          }
          bool1 = true;
          ApolloPanel.a(this.this$0, bool1);
          if (bool1) {
            break;
          }
          ApolloPanel.b(this.this$0);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool1 = true;
          }
        }
      }
      bool2 = false;
      break label54;
      QLog.e("ApolloPanel", 1, "parseShopRedTouchManager error :", localException1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.28
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.view;

import airz;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloPanel$31
  implements Runnable
{
  ApolloPanel$31(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, String paramString) {}
  
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
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1) {
        break label385;
      }
      bool2 = true;
      localObject = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get();
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
              airz localairz = (airz)this.this$0.a.a.getManager(153);
              ApolloPanel.a(this.this$0, localairz.a(this.jdField_a_of_type_JavaLangString, (String)localObject, localJSONObject, bool2, 6));
              localObject = ApolloPanel.a(this.this$0);
              bool1 = bool3;
              if (localObject == null) {}
            }
          }
        }
        catch (Exception localException1)
        {
          label385:
          bool1 = bool4;
        }
        try
        {
          if (!this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "parseShopRedTouchManager pushItem:", ApolloPanel.a(this.this$0).toString() });
            }
            ApolloPanel.a(this.this$0, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, ApolloPanel.a(this.this$0).icon_url);
            ApolloPanel.c(this.this$0);
            VipUtils.a(this.this$0.a.a, "cmshow", "Apollo", "house_new_view", ApolloUtil.b(this.this$0.a.b()), 0, new String[] { ApolloPanel.a(this.this$0).msg_id });
          }
          bool1 = true;
          ApolloPanel.a(this.this$0, bool1);
          if (bool1) {
            break;
          }
          ApolloPanel.d(this.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.31
 * JD-Core Version:    0.7.0.1
 */
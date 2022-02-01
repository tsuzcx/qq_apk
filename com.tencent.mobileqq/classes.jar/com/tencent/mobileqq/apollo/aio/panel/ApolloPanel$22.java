package com.tencent.mobileqq.apollo.aio.panel;

import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ApolloPanel$22
  implements Runnable
{
  ApolloPanel$22(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (ApolloPanel.g(this.this$0) != null)
    {
      if (ApolloPanel.g(this.this$0).d == null) {
        return;
      }
      Object localObject = this.a;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool1 = bool4;
      if (localObject != null)
      {
        boolean bool2;
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localObject = this.a.buffer.get();
        bool1 = bool4;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "parseShopRedTouchManager:", localObject, ", isNewRed：", Boolean.valueOf(bool2), ",refreshByGetUserAction:", Boolean.valueOf(this.b) });
          }
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localObject = localJSONObject.optString("_show_mission");
            localJSONObject = localJSONObject.optJSONObject("msg");
            if (localJSONObject == null) {
              return;
            }
            localJSONObject = localJSONObject.optJSONObject((String)localObject);
            if (localJSONObject == null) {
              return;
            }
            ApolloPanel.a(this.this$0, ApolloPanel.i(this.this$0).parseApolloRedTouchContent(this.c, (String)localObject, localJSONObject, bool2, 6));
            localObject = ApolloPanel.G(this.this$0);
            if (localObject == null) {
              return;
            }
            try
            {
              if (this.b) {
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "parseShopRedTouchManager pushItem:", ApolloPanel.G(this.this$0).toString() });
              }
              ApolloPanel.a(this.this$0, this.a, ApolloPanel.G(this.this$0).icon_url);
              ApolloPanel.H(this.this$0);
              VipUtils.a(ApolloPanel.g(this.this$0).d, "cmshow", "Apollo", "house_new_view", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.g(this.this$0).F()), 0, new String[] { ApolloPanel.G(this.this$0).msg_id });
              bool1 = true;
            }
            catch (Exception localException1)
            {
              bool1 = true;
            }
            QLog.e("[cmshow]ApolloPanel", 1, "parseShopRedTouchManager error :", localException2);
          }
          catch (Exception localException2)
          {
            bool1 = bool3;
          }
        }
      }
      ApolloPanel.a(this.this$0, bool1);
      if (!bool1) {
        ApolloPanel.I(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.22
 * JD-Core Version:    0.7.0.1
 */
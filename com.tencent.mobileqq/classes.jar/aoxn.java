import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aoxn
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  aoxn(aoxm paramaoxm, bjbs parambjbs, String paramString1, String paramString2, String paramString3) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    if ((paramAppPathInfo != null) && (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightAppOpenAction", 2, new Object[] { "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", paramAppPathInfo.path });
      }
      paramObject = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(paramObject)) {
        break label426;
      }
      paramString = ArkAppCacheMgr.getApplicationLauncher(paramAppPathInfo.path);
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        paramAppPathInfo = paramObject;
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramObject = this.b;
      if (TextUtils.isEmpty(paramObject)) {
        paramObject = "{}";
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          aqca.a(null, this.c, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
          if (this.jdField_a_of_type_Aoxm.a != null) {
            ArkFullScreenAppActivity.a(this.jdField_a_of_type_Aoxm.a, this.c, paramAppPathInfo, "0.0.0.1", paramObject, aqbx.a(), null, 1);
          }
        }
        do
        {
          do
          {
            return;
            paramAppPathInfo = paramString;
            paramInt = 1;
            paramString = null;
            break;
            paramObject = new Intent();
            paramObject.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
            paramObject.putExtra("param_force_internal_browser", true);
            paramObject.putExtra("url", paramString);
            paramObject.putExtra("injectrecommend", false);
            paramObject.putExtra("browserType", 3);
            if (!TextUtils.isEmpty(this.c))
            {
              paramObject.putExtra("h5_ark_app_name", this.c);
              paramString = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.c, paramAppPathInfo, null, false);
              if (!TextUtils.isEmpty(paramString))
              {
                paramObject.putExtra("h5_ark_app_path", paramString);
                paramString = ArkAppCacheMgr.getApplicationDesc(this.c);
                if (!TextUtils.isEmpty(paramString)) {
                  paramObject.putExtra("h5_ark_app_des", paramString);
                }
              }
            }
            paramString = arca.b(186);
            if (paramString != null)
            {
              paramString = paramString.a();
              if (!TextUtils.isEmpty(paramString)) {
                paramObject.putExtra("h5_ark_check_config", paramString);
              }
            }
            paramObject.addFlags(603979776);
          } while (this.jdField_a_of_type_Aoxm.a == null);
          this.jdField_a_of_type_Aoxm.a.startActivity(paramObject);
          return;
          QQToast.a(this.jdField_a_of_type_Aoxm.a, 2131690094, 0).a();
        } while (!QLog.isColorLevel());
        QLog.d("LightAppOpenAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
        return;
      }
      label426:
      paramAppPathInfo = paramObject;
      paramString = null;
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxn
 * JD-Core Version:    0.7.0.1
 */
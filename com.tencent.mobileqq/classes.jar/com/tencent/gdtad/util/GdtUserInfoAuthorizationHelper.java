package com.tencent.gdtad.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Window;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationDialog;
import com.tencent.widget.AuthorizationItem;
import com.tencent.widget.AuthorizationItem.ItemType;
import java.util.Iterator;
import java.util.List;

public class GdtUserInfoAuthorizationHelper
{
  private GdtUserInfoAuthorizationHelper.UserInfoEntity a(String paramString1, String paramString2, String paramString3, List<AuthorizationItem.ItemType> paramList)
  {
    if (paramList.contains(AuthorizationItem.a))
    {
      if (!paramList.contains(AuthorizationItem.b)) {
        break label57;
      }
      label26:
      if (!paramList.contains(AuthorizationItem.c)) {
        break label63;
      }
    }
    for (;;)
    {
      return new GdtUserInfoAuthorizationHelper.UserInfoEntity(paramString1, paramString2, paramString3, null);
      paramString1 = "";
      break;
      label57:
      paramString2 = "";
      break label26;
      label63:
      paramString3 = "";
    }
  }
  
  private void a(Activity paramActivity, boolean paramBoolean, GdtUserInfoAuthorizationHelper.UserInfoEntity paramUserInfoEntity, GdtUserInfoAuthorizationHelper.UserInfoCallback paramUserInfoCallback, List<AuthorizationItem.ItemType> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult: entity -> " + paramUserInfoEntity);
    }
    if (paramBoolean)
    {
      if (a(paramActivity, paramList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult has authorized, return info direct ");
        }
        if (paramUserInfoCallback != null)
        {
          paramUserInfoEntity.a = 0;
          paramUserInfoCallback.a(paramUserInfoEntity);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult show authorize dialog to authorize user info");
      }
      paramActivity = new AuthorizationDialog(paramActivity, paramUserInfoEntity, paramUserInfoCallback, paramList);
      paramUserInfoEntity = paramActivity.getWindow();
      if (paramUserInfoEntity != null) {
        paramUserInfoEntity.setWindowAnimations(2131755014);
      }
      paramActivity.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GdtUserInfoAuthorizationHelper", 2, "handleInfoResult get result fail");
    }
    if (paramUserInfoCallback != null) {
      paramUserInfoCallback.a(GdtUserInfoAuthorizationHelper.UserInfoEntity.a());
    }
    Toast.makeText(paramActivity, paramActivity.getString(2131690311), 0).show();
  }
  
  private boolean a(Context paramContext, List<AuthorizationItem.ItemType> paramList)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!paramContext.getBoolean(((AuthorizationItem.ItemType)paramList.next()).b, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtUserInfoAuthorizationHelper", 2, "checkAuthorize user phone not authorize");
        }
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper
 * JD-Core Version:    0.7.0.1
 */
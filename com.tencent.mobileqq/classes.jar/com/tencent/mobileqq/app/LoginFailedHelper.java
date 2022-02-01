package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;
import tencent.im.login.GatewayVerify.RspTipsInfo;

public class LoginFailedHelper
{
  private HashMap<String, Integer> a = new HashMap();
  
  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d("LoginFailedHelper", 1, "getTipsScenesId tlvData is null");
      return 0;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() != 1)
      {
        QLog.d("LoginFailedHelper", 1, "getTipsScenesId not area im");
        return 0;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getTipsScenesId scene_id=");
      paramArrayOfByte.append(localRspBody.msg_rsp_tips_info.uint32_scene_id.get());
      QLog.d("LoginFailedHelper", 1, paramArrayOfByte.toString());
      int i = localRspBody.msg_rsp_tips_info.uint32_scene_id.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("LoginFailedHelper", 1, "getTipsScenesId error: ", paramArrayOfByte);
    }
    return 0;
  }
  
  private void a(Context paramContext, String paramString)
  {
    DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131904275), paramString, 2131889471, 2131892267, new LoginFailedHelper.3(this), null).show();
  }
  
  private static void a(Context paramContext, String paramString1, AppRuntime paramAppRuntime, LoginFailedHelper.FrozenDialogCallback paramFrozenDialogCallback, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    localQQCustomDialog.setTitle(2131897863);
    if (TextUtils.isEmpty(paramString2)) {
      localQQCustomDialog.setMessage(2131897862);
    } else {
      localQQCustomDialog.setMessage(paramString2);
    }
    localQQCustomDialog.setPositiveButton(2131892267, new LoginFailedHelper.4(paramContext, paramString1, paramAppRuntime, paramFrozenDialogCallback));
    if (paramFrozenDialogCallback != null) {
      localQQCustomDialog.setOnCancelListener(new LoginFailedHelper.5(paramFrozenDialogCallback));
    }
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, int paramInt, String paramString2, Runnable paramRunnable)
  {
    if (paramRunnable == null)
    {
      QLog.e("LoginFailedHelper", 1, "onClick action is null");
      return;
    }
    DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131904275), paramString2, 2131889471, 2131892267, new LoginFailedHelper.1(this, paramAppRuntime, paramString1, paramInt), new LoginFailedHelper.2(this, paramRunnable, paramAppRuntime, paramString1, paramInt)).show();
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2)
  {
    String str;
    if (a(paramString1)) {
      str = paramString1;
    } else {
      str = "";
    }
    ReportController.a(paramAppRuntime, "dc00898", "", str, paramString2, paramString2, paramInt, 0, ((Integer)this.a.get(paramString1)).toString(), "", paramString1, "");
  }
  
  public static boolean a(Context paramContext, String paramString, AppRuntime paramAppRuntime, byte[] paramArrayOfByte, LoginFailedHelper.FrozenDialogCallback paramFrozenDialogCallback)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("LoginFailedHelper", 1, "shouldGoToMainLogin tlvData is null");
      return false;
    }
    int i;
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      i = localRspBody.msg_rsp_tips_info.uint32_guid_to_main_login_flag.get();
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      try
      {
        paramArrayOfByte = localRspBody.msg_rsp_tips_info.str_guid_to_main_login_wording.get();
      }
      catch (Exception paramArrayOfByte) {}
      QLog.e("LoginFailedHelper", 1, "shouldGoToMainLogin error: ", paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      i = 1;
    }
    paramArrayOfByte = "";
    if (i != 0)
    {
      a(paramContext, paramString, paramAppRuntime, paramFrozenDialogCallback, paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.charAt(0) != '0') && (paramString.length() >= 5))
    {
      if (paramString.length() > 12) {
        return false;
      }
      paramString = paramString.toCharArray();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        if (!Character.isDigit(paramString[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      HashMap localHashMap = this.a;
      localHashMap.put(paramString, Integer.valueOf(((Integer)localHashMap.get(paramString)).intValue() + 1));
      return;
    }
    this.a.put(paramString, Integer.valueOf(1));
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString1, int paramInt, String paramString2, Runnable paramRunnable)
  {
    if ((paramAppRuntime != null) && (paramActivity != null) && (paramString1 != null))
    {
      if (paramActivity.isFinishing())
      {
        QLog.d("LoginFailedHelper", 1, "activity is not running.");
        return;
      }
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      b(paramString1);
      if (((Integer)this.a.get(paramString1)).intValue() >= 3)
      {
        a(paramAppRuntime, paramActivity, paramString1, paramInt, str, paramRunnable);
        a(paramAppRuntime, paramString1, paramInt, "0X800B8F5");
        return;
      }
      a(paramActivity, str);
      a(paramAppRuntime, paramString1, paramInt, "0X800B8F4");
      return;
    }
    QLog.e("LoginFailedHelper", 1, "either app, activity or uin is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginFailedHelper
 * JD-Core Version:    0.7.0.1
 */
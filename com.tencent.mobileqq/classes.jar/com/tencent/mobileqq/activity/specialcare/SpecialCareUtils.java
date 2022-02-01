package com.tencent.mobileqq.activity.specialcare;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.config.QFlutterDPC;
import com.tencent.mobileqq.flutter.router.QFlutterPageRouter;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class SpecialCareUtils
{
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramInt == 3) && (QFlutterDPC.a().c()))
    {
      localObject = new HashMap();
      ((Map)localObject).put("uin", paramString);
      ((Map)localObject).put("from", Integer.valueOf(3));
      QFlutterPageRouter.a(paramActivity, "specialCareFriendSetting", "SpecialCareFriendSettingPage", (Map)localObject);
      return;
    }
    Object localObject = new Intent(paramActivity, QQSpecialCareSettingActivity.class);
    ((Intent)localObject).putExtra("key_friend_uin", paramString);
    ((Intent)localObject).putExtra("key_start_from", 3);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new SpecialCareUtils.1(paramQQAppInterface), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecialCareUtils
 * JD-Core Version:    0.7.0.1
 */
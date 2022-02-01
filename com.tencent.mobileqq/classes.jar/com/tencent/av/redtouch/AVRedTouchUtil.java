package com.tencent.av.redtouch;

import android.text.TextUtils;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavAvatar2dEntranceABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AVRedTouchUtil
{
  public static final String a = String.valueOf(105000);
  
  public static BusinessInfoCheckUpdate.AppInfo a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    int j = 0;
    Object localObject = paramVideoAppInterface.b();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((VideoController)localObject).k() != null) {
        i = ((VideoController)localObject).k().g;
      }
    }
    localObject = a(paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("tryGetRedTouch failed. appId[");
      paramVideoAppInterface.append((String)localObject);
      paramVideoAppInterface.append("]");
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
      return null;
    }
    if (!a(paramVideoAppInterface, paramInt, i))
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("tryGetRedTouch failed. can not show red touch. appId = ");
      paramVideoAppInterface.append((String)localObject);
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
      return null;
    }
    paramVideoAppInterface = a(paramVideoAppInterface, (String)localObject);
    if (a(paramVideoAppInterface)) {
      return paramVideoAppInterface;
    }
    return null;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    if (paramVideoAppInterface != null) {
      return paramVideoAppInterface.j(paramString);
    }
    return null;
  }
  
  public static RedTouch a(VideoAppInterface paramVideoAppInterface, View paramView, int paramInt)
  {
    if (paramVideoAppInterface != null)
    {
      if (paramView == null) {
        return null;
      }
      String str = a(paramInt);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramVideoAppInterface, paramInt);
      if (a(localAppInfo))
      {
        Object localObject = paramView.getParent();
        if ((localObject instanceof RedTouch)) {
          localObject = (RedTouch)localObject;
        } else {
          localObject = new RedTouch(paramVideoAppInterface.getApplication(), paramView).c(53).a();
        }
        ((RedTouch)localObject).a(localAppInfo);
        if ("105000.105100".equals(str)) {
          paramVideoAppInterface.l(a);
        }
        paramVideoAppInterface.l(str);
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("tryGetRedTouchAndShowRedDot suc. appId[");
        paramVideoAppInterface.append(str);
        paramVideoAppInterface.append("], view[");
        paramVideoAppInterface.append(paramView);
        paramVideoAppInterface.append("], redTouch[");
        paramVideoAppInterface.append(localObject);
        paramVideoAppInterface.append("]");
        QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
        return localObject;
      }
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("tryGetRedTouchAndShowRedDot fail. appId[");
      paramVideoAppInterface.append(str);
      paramVideoAppInterface.append("], view[");
      paramVideoAppInterface.append(paramView);
      paramVideoAppInterface.append("], appInfo[");
      paramVideoAppInterface.append(localAppInfo);
      paramVideoAppInterface.append("], hasRedDot[false]");
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 14: 
      return "105000.105200.105230.105232";
    case 13: 
      return "105000.105200.105230.105231";
    case 12: 
      return "105000.105200.105230";
    case 11: 
      return "105000.105200";
    case 10: 
      return "105000.105100.105150";
    case 9: 
      return "105000.105100.105140";
    case 8: 
      return "105000.105100.105130.105131";
    case 7: 
      return "105000.105100.105130";
    case 6: 
      return "105000.105100.105120";
    case 5: 
      return "105000.105100.105110.105111.105117";
    case 4: 
      return "105000.105100.105110.105111.105116";
    case 3: 
      return "105000.105100.105110.105111";
    case 2: 
      return "105000.105100.105110";
    case 1: 
      return "105000.105100";
    }
    return a;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, RedTouch paramRedTouch, int paramInt)
  {
    if (paramVideoAppInterface != null)
    {
      if (paramRedTouch == null) {
        return;
      }
      String str = a(paramInt);
      if (TextUtils.isEmpty(str))
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("clearRedDot falied. appId[");
        paramVideoAppInterface.append(str);
        paramVideoAppInterface.append("], redTouch[");
        paramVideoAppInterface.append(paramRedTouch);
        paramVideoAppInterface.append("]");
        QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
        return;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramVideoAppInterface, str);
      if (a(localAppInfo))
      {
        if (("105000.105100".equals(str)) || ("105000.105200".equals(str))) {
          paramVideoAppInterface.k(a);
        }
        paramVideoAppInterface.k(str);
        paramRedTouch.g();
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("clearRedDot successfully. appId[");
        paramVideoAppInterface.append(str);
        paramVideoAppInterface.append("], redTouch[");
        paramVideoAppInterface.append(paramRedTouch);
        paramVideoAppInterface.append("]");
        QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
        return;
      }
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("clearRedDot falied. appId[");
      paramVideoAppInterface.append(str);
      paramVideoAppInterface.append("], redTouch[");
      paramVideoAppInterface.append(paramRedTouch);
      paramVideoAppInterface.append("], appInfo[");
      paramVideoAppInterface.append(localAppInfo);
      paramVideoAppInterface.append("], hasRedDot[");
      paramVideoAppInterface.append(a(localAppInfo));
      paramVideoAppInterface.append("]");
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramVideoAppInterface == null) {
      return false;
    }
    boolean bool4 = true;
    boolean bool1 = bool3;
    switch (paramInt1)
    {
    default: 
      bool1 = bool3;
      break;
    case 14: 
      if ((paramInt2 == 2) || (paramInt2 == 1)) {
        bool2 = true;
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = c(paramVideoAppInterface, 14);
      }
      break;
    case 13: 
      if (paramInt2 != 2)
      {
        bool2 = bool5;
        if (paramInt2 != 1) {}
      }
      else
      {
        bool2 = true;
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = c(paramVideoAppInterface, 13);
      }
      break;
    case 12: 
      if (paramInt2 != 2)
      {
        bool1 = bool6;
        if (paramInt2 != 1) {}
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = c(paramVideoAppInterface, 12);
      }
      bool1 = bool2;
      if (bool2)
      {
        bool2 = a(paramVideoAppInterface, 13, paramInt2);
        bool1 = bool2;
        if (!bool2) {
          bool1 = a(paramVideoAppInterface, 14, paramInt2);
        }
      }
      break;
    case 11: 
      if ((paramInt2 != 2) && (paramInt2 != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = c(paramVideoAppInterface, 11);
      }
      if (bool2)
      {
        bool1 = bool3;
        if (a(paramVideoAppInterface, 12, paramInt2))
        {
          bool1 = bool3;
          if (QavAvatar2dEntranceABTestUtils.a(paramVideoAppInterface.getCurrentAccountUin())) {
            bool1 = true;
          }
        }
      }
      else
      {
        bool1 = bool2;
      }
      break;
    case 10: 
      if (paramInt2 != 1)
      {
        bool1 = bool3;
        if (paramInt2 != 2) {
          break;
        }
      }
      else
      {
        bool1 = bool3;
        if (QAVConfigUtils.r()) {
          bool1 = c(paramVideoAppInterface, 10);
        }
      }
      break;
    case 9: 
      bool1 = c(paramVideoAppInterface, 9);
      break;
    case 8: 
      if (paramInt2 != 2)
      {
        bool2 = bool7;
        if (paramInt2 != 4) {}
      }
      else
      {
        bool2 = true;
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = EffectsRenderController.c();
      }
      break;
    case 7: 
      if (paramInt2 != 2)
      {
        bool1 = bool8;
        if (paramInt2 != 4) {}
      }
      else
      {
        bool1 = EffectsRenderController.c();
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = c(paramVideoAppInterface, 7);
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = a(paramVideoAppInterface, 8, paramInt2);
      }
      break;
    case 6: 
      bool1 = c(paramVideoAppInterface, 6);
      break;
    case 5: 
      if (paramInt2 == 2) {
        bool1 = bool4;
      } else {
        bool1 = false;
      }
      if (bool1) {
        bool1 = c(paramVideoAppInterface, 5);
      }
      if (bool1) {
        bool1 = bool3;
      }
      break;
    case 3: 
      if (paramInt2 != 2)
      {
        bool1 = bool9;
        if (paramInt2 != 4) {}
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = c(paramVideoAppInterface, 3);
      }
      bool1 = bool2;
      if (bool2)
      {
        bool2 = a(paramVideoAppInterface, 4, paramInt2);
        bool1 = bool2;
        if (!bool2) {
          bool1 = a(paramVideoAppInterface, 5, paramInt2);
        }
      }
      break;
    case 2: 
      if (paramInt2 != 2)
      {
        bool1 = bool10;
        if (paramInt2 != 4) {}
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1) {
        bool2 = c(paramVideoAppInterface, 2);
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = a(paramVideoAppInterface, 3, paramInt2);
      }
      break;
    case 1: 
      bool2 = c(paramVideoAppInterface, 1);
      bool1 = bool2;
      if (bool2)
      {
        bool2 = a(paramVideoAppInterface, 2, paramInt2);
        bool1 = bool2;
        if (!bool2) {
          bool1 = a(paramVideoAppInterface, 6, paramInt2);
        }
        bool2 = bool1;
        if (!bool1) {
          bool2 = a(paramVideoAppInterface, 7, paramInt2);
        }
        bool3 = bool2;
        if (!bool2) {
          bool3 = a(paramVideoAppInterface, 9, paramInt2);
        }
        bool1 = bool3;
        if (!bool3) {
          if (paramInt2 != 1)
          {
            bool1 = bool3;
            if (paramInt2 != 2) {
              break;
            }
          }
          else
          {
            bool1 = bool3;
            if (!QAVConfigUtils.r()) {
              break;
            }
          }
        }
      }
      break;
    }
    try
    {
      bool1 = a(paramVideoAppInterface, 10, paramInt2);
      if (QLog.isColorLevel())
      {
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("canShowRedTouch, id[");
        paramVideoAppInterface.append(paramInt1);
        paramVideoAppInterface.append("], show[");
        paramVideoAppInterface.append(bool1);
        paramVideoAppInterface.append("]");
        QLog.i("AVRedTouchUtil", 2, paramVideoAppInterface.toString());
      }
      return bool1;
    }
    catch (Throwable paramVideoAppInterface)
    {
      throw paramVideoAppInterface;
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return false;
    }
    if (paramAppInfo.iNewFlag.get() != 0)
    {
      if (paramAppInfo.exposure_max.get() < 0) {
        return false;
      }
      if (paramAppInfo.red_display_info.get() != null)
      {
        if (paramAppInfo.red_display_info.red_type_info.get() == null) {
          return false;
        }
        return paramAppInfo.red_display_info.red_type_info.get().size() != 0;
      }
    }
    return false;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      return;
    }
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("clearRedDot falied. appId[");
      paramVideoAppInterface.append(str);
      paramVideoAppInterface.append("]");
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramVideoAppInterface, str);
    if (a(localAppInfo))
    {
      if (("105000.105100".equals(str)) || ("105000.105200".equals(str))) {
        paramVideoAppInterface.k(a);
      }
      paramVideoAppInterface.k(str);
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("clearRedDot successfully. appId[");
      paramVideoAppInterface.append(str);
      paramVideoAppInterface.append("]");
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
      return;
    }
    paramVideoAppInterface = new StringBuilder();
    paramVideoAppInterface.append("clearRedDot falied. appId[");
    paramVideoAppInterface.append(str);
    paramVideoAppInterface.append("], appInfo[");
    paramVideoAppInterface.append(localAppInfo);
    paramVideoAppInterface.append("], hasRedDot[");
    paramVideoAppInterface.append(a(localAppInfo));
    paramVideoAppInterface.append("]");
    QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
  }
  
  private static boolean c(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("hasRedDot falied. appId = ");
      paramVideoAppInterface.append(str);
      QLog.d("AVRedTouchUtil", 1, paramVideoAppInterface.toString());
      return false;
    }
    paramVideoAppInterface = a(paramVideoAppInterface, str);
    if (a(paramVideoAppInterface)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasRedDot falied. appId = ");
    localStringBuilder.append(str);
    localStringBuilder.append(", appInfo = ");
    localStringBuilder.append(paramVideoAppInterface);
    localStringBuilder.append(", hasRedDot = false");
    QLog.d("AVRedTouchUtil", 1, localStringBuilder.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.redtouch.AVRedTouchUtil
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;

public class bdoi
{
  public static int a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if ((paramCustomOnlineStatusMsg != null) && (paramCustomOnlineStatusMsg.uUpdateInterval.get() > 0)) {
      return paramCustomOnlineStatusMsg.uUpdateInterval.get();
    }
    return 30000;
  }
  
  public static String a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg != null) {
      try
      {
        if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
        {
          String str = paramCustomOnlineStatusMsg.sCustomDesc.get();
          paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
          if ((str != null) && (paramCustomOnlineStatusMsg != null))
          {
            paramCustomOnlineStatusMsg = str + paramCustomOnlineStatusMsg;
            return paramCustomOnlineStatusMsg;
          }
        }
      }
      catch (Exception paramCustomOnlineStatusMsg)
      {
        QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
      }
    }
    return "";
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      QLog.e("CustomOnlineStatusManager", 1, "activity == null");
      return;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localObject = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1";
    if ("panel".equals(paramString))
    {
      paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=1";
      localObject = "0X8009F76";
    }
    for (;;)
    {
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString, 256L, localIntent, false, -1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      azmj.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      return;
      if ("settings".equals(paramString))
      {
        paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=2";
        localObject = "0X8009F77";
      }
      else if ("aio".equals(paramString))
      {
        paramString = "https://club.vip.qq.com/onlinestatus/set?_wv=67109895&_wvx=10&_proxy=1" + "&src=3";
        localObject = "0X8009F78";
      }
      else
      {
        String str = "";
        paramString = (String)localObject;
        localObject = str;
      }
    }
  }
  
  private static void a(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(1);
    try
    {
      localFriendListHandler.c(paramString, false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CustomOnlineStatusManager", 1, paramString, new Object[0]);
    }
  }
  
  public static void a(SubMsgType0x27.FrdCustomOnlineStatusChange paramFrdCustomOnlineStatusChange)
  {
    long l = paramFrdCustomOnlineStatusChange.uint64_uin.get();
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "onPush uni = " + paramFrdCustomOnlineStatusChange.uint64_uin.get());
    }
    if (l == BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "sync owner");
      }
      b();
    }
    while (TextUtils.isEmpty(String.valueOf(l))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "sync friend");
    }
    a(String.valueOf(l));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static int b(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg != null) {
      return paramCustomOnlineStatusMsg.uHasCustomInfo.get();
    }
    return 0;
  }
  
  public static String b(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    if (paramCustomOnlineStatusMsg != null) {
      try
      {
        if (paramCustomOnlineStatusMsg.uHasCustomInfo.get() == 1)
        {
          paramCustomOnlineStatusMsg = paramCustomOnlineStatusMsg.sCustomModel.get();
          if (paramCustomOnlineStatusMsg != null) {
            return paramCustomOnlineStatusMsg;
          }
        }
      }
      catch (Exception paramCustomOnlineStatusMsg)
      {
        QLog.d("CustomOnlineStatusManager", 1, paramCustomOnlineStatusMsg, new Object[0]);
      }
    }
    return "";
  }
  
  private static void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((ambd)localQQAppInterface.a(27)).a(localQQAppInterface.getLongAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoi
 * JD-Core Version:    0.7.0.1
 */
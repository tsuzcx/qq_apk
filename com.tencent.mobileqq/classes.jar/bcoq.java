import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bcoq
{
  public static Intent a(Activity paramActivity, String paramString1, String paramString2)
  {
    paramString1 = TroopMemberListActivity.a(paramActivity, paramString1, 14);
    paramString1.putExtra("custom_title_name", paramActivity.getString(2131698169));
    paramString1.putExtra("troop_gift_from", paramString2);
    return paramString1;
  }
  
  public static String a(int paramInt)
  {
    return bdzf.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.troop/pic_effects/" + paramInt + ".mp4");
  }
  
  public static String a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    String str = b(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.isInteract()) {
      return a(str);
    }
    return a(str, paramMessageForDeliverGiftTips.animationType);
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(alof.cu).append(paramString + "_NEW").append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt == 1) {
      localStringBuffer.append(alof.cu).append(paramString + "_V").append(File.separator);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(alof.cu).append(paramString + "_HD").append(File.separator);
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean) {
      localStringBuffer.append(alof.cu).append(File.separator).append(paramString).append("_NEW.zip");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (paramInt == 1) {
        localStringBuffer.append(alof.cu).append(File.separator).append(paramString).append("_V.zip");
      } else {
        localStringBuffer.append(alof.cu).append(File.separator).append(paramString).append("_HD.zip");
      }
    }
  }
  
  public static List<String> a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    ArrayList localArrayList = new ArrayList();
    paramMessageForDeliverGiftTips = new File(a(paramMessageForDeliverGiftTips));
    if (paramMessageForDeliverGiftTips.exists())
    {
      paramMessageForDeliverGiftTips = paramMessageForDeliverGiftTips.listFiles();
      int i = 0;
      while (i < paramMessageForDeliverGiftTips.length)
      {
        if (paramMessageForDeliverGiftTips[i].getAbsolutePath().endsWith(".png")) {
          localArrayList.add(paramMessageForDeliverGiftTips[i].getAbsolutePath());
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static JSONObject a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(alof.cu).append(paramString + "_NEW").append(File.separator).append("info.json");
    paramString = bdhb.a(new File(localStringBuffer.toString()));
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    if (paramIntent == null) {
      return;
    }
    a(paramActivity, paramIntent.getStringExtra("troop_uin"), paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"), paramIntent.getStringExtra("troop_gift_from"), paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    TroopInfo localTroopInfo;
    int i;
    if (paramQQAppInterface != null)
    {
      localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1);
      if (localTroopInfo != null)
      {
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label133;
        }
        i = 0;
      }
    }
    for (;;)
    {
      azqs.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "exp", 0, 0, paramString1, i + "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "startSendGiftActivity from:" + paramString2);
      }
      paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2), 12005);
      paramActivity.overridePendingTransition(2130771997, 2130771990);
      return;
      label133:
      if (localTroopInfo.isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramQQAppInterface, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramActivity == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        str1 = Base64.encodeToString(paramString3.getBytes("UTF-8"), 0);
        Object localObject = null;
        if (paramQQAppInterface != null)
        {
          bcos localbcos = bcos.a();
          String str2 = localbcos.a("troop_gift");
          localObject = str2;
          if (!TextUtils.isEmpty(str2))
          {
            localObject = new bcot();
            ((bcot)localObject).a = paramString1;
            ((bcot)localObject).c = paramString4;
            ((bcot)localObject).b = paramString2;
            ((bcot)localObject).e = paramString3;
            localObject = localbcos.a(str2, (bcot)localObject);
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label446;
        }
        paramString3 = new Bundle();
        paramString3.putString("troopUin", paramString1);
        paramString3.putString("uin", paramString2);
        paramString3.putString("name", str1);
        paramString3.putString("from", paramString4);
        paramString3.putString("_wv", "1031");
        paramString3.putString("_bid", "2204");
        paramString2 = "https://qun.qq.com/qunpay/gifts/index.html?" + ndd.a(paramString3);
        paramString3 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString2);
        if ((paramMap != null) && (paramMap.size() > 0))
        {
          paramString4 = paramMap.entrySet().iterator();
          if (paramString4.hasNext())
          {
            paramMap = (Map.Entry)paramString4.next();
            paramString3.putExtra((String)paramMap.getKey(), (String)paramMap.getValue());
            continue;
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str1 = paramString3;
        continue;
        paramActivity.startActivityForResult(paramString3, 13001);
        if (paramQQAppInterface != null)
        {
          paramActivity = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1);
          if (paramActivity != null)
          {
            if (!paramActivity.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
              break label427;
            }
            i = 0;
            azqs.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "send_page", 0, 0, paramString1, i + "", "", "");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopUtils", 2, "openSendTroopGiftUrl url:" + paramString2);
      return;
      label427:
      if (paramActivity.isAdmin())
      {
        i = 1;
      }
      else
      {
        i = 2;
        continue;
        label446:
        paramString2 = localUnsupportedEncodingException;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt < 40003) || (paramInt > 40005)) {}
    long l;
    do
    {
      return true;
      File localFile = new File(a(paramInt));
      if (!localFile.exists()) {
        break;
      }
      l = localFile.length();
    } while (((paramInt == 40003) && (l == 827720L)) || ((paramInt == 40004) && (l == 355077L)) || ((paramInt == 40005) && (l == 796025L)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopUtils", 2, "isTroopPicEffectVideoValid = false, id:" + paramInt);
    }
    return false;
  }
  
  public static boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    return (paramMessageForDeliverGiftTips != null) && ((paramMessageForDeliverGiftTips.animationPackageId > 0) || (paramMessageForDeliverGiftTips.isToAll()));
  }
  
  public static boolean a(File paramFile)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    if (paramFile.exists())
    {
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append("check.ini");
      localObject = new File(localStringBuffer.toString());
      if (((File)localObject).exists()) {}
    }
    else
    {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = bdhb.b((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split("&");
        if (localObject == null) {
          break;
        }
        i = 0;
        if (i >= localObject.length) {
          break label203;
        }
        localStringBuffer.setLength(0);
        localStringBuffer.append(paramFile.getAbsolutePath()).append(File.separator).append(localObject[i].toString());
        File localFile = new File(localStringBuffer.toString());
        if (localFile.exists()) {
          break label196;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_giftTroopUtils", 2, "isAnimationPackageValid File not exist:" + localFile.getName());
        return false;
      }
      catch (IOException paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopUtils", 2, "isAnimationPackageValid IOException");
      return false;
      label196:
      i += 1;
    }
    label203:
    return true;
  }
  
  public static boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = a(paramString);; paramString = a(paramString, paramInt)) {
      return a(new File(paramString));
    }
  }
  
  public static boolean a(List<?> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static String b(int paramInt)
  {
    return "http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effect_" + paramInt + ".mp4";
  }
  
  public static String b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (paramMessageForDeliverGiftTips == null) {
      return null;
    }
    if (paramMessageForDeliverGiftTips.isToAll()) {
      return String.valueOf(paramMessageForDeliverGiftTips.exflag);
    }
    return String.valueOf(paramMessageForDeliverGiftTips.animationPackageId);
  }
  
  public static String c(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    String str = b(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.isInteract()) {
      return "http://pub.idqqimg.com/pc/misc/groupgift/" + str + "_NEW.zip";
    }
    if (paramMessageForDeliverGiftTips.animationType == 1) {
      return "http://pub.idqqimg.com/pc/misc/groupgift/" + str + "_V.zip";
    }
    return "http://pub.idqqimg.com/pc/misc/groupgift/" + str + "_HD.zip";
  }
  
  public static String d(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    paramMessageForDeliverGiftTips = new File(a(paramMessageForDeliverGiftTips) + "/video.mp4");
    if (paramMessageForDeliverGiftTips.exists()) {
      return paramMessageForDeliverGiftTips.getAbsolutePath();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoq
 * JD-Core Version:    0.7.0.1
 */
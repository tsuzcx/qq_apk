import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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

public class bglb
{
  public static Intent a(Activity paramActivity, String paramString1, String paramString2)
  {
    paramString1 = TroopMemberListActivity.a(paramActivity, paramString1, 14);
    paramString1.putExtra("custom_title_name", paramActivity.getString(2131697487));
    paramString1.putExtra("troop_gift_from", paramString2);
    return paramString1;
  }
  
  public static String a(int paramInt)
  {
    return VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.troop/pic_effects/" + paramInt + ".mp4");
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
    localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(paramString + "_NEW").append(File.separator);
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt == 1) {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(paramString + "_V").append(File.separator);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(paramString + "_HD").append(File.separator);
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean) {
      localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(File.separator).append(paramString).append("_NEW.zip");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (paramInt == 1) {
        localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(File.separator).append(paramString).append("_V.zip");
      } else {
        localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(File.separator).append(paramString).append("_HD.zip");
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
    localStringBuffer.append(AppConstants.SDCARD_GIFT_SAVE).append(paramString + "_NEW").append(File.separator).append("info.json");
    paramString = FileUtils.readFileContent(new File(localStringBuffer.toString()));
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
      localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      if (localTroopInfo != null)
      {
        if (!localTroopInfo.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
          break label134;
        }
        i = 0;
      }
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "exp", 0, 0, paramString1, i + "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("TroopUtils", 2, "startSendGiftActivity from:" + paramString2);
      }
      paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2), 12005);
      paramActivity.overridePendingTransition(2130771997, 2130771990);
      return;
      label134:
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
          bgld localbgld = bgld.a();
          String str2 = arkl.a().troopGiftUrl;
          localObject = str2;
          if (!TextUtils.isEmpty(str2))
          {
            localObject = new bgle();
            ((bgle)localObject).a = paramString1;
            ((bgle)localObject).c = paramString4;
            ((bgle)localObject).b = paramString2;
            ((bgle)localObject).e = paramString3;
            localObject = localbgld.a(str2, (bgle)localObject);
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label445;
        }
        paramString3 = new Bundle();
        paramString3.putString("troopUin", paramString1);
        paramString3.putString("uin", paramString2);
        paramString3.putString("name", str1);
        paramString3.putString("from", paramString4);
        paramString3.putString("_wv", "1031");
        paramString3.putString("_bid", "2204");
        paramString2 = "https://qun.qq.com/qunpay/gifts/index.html?" + HttpUtil.encodeUrl(paramString3);
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
          paramActivity = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
          if (paramActivity != null)
          {
            if (!paramActivity.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
              break label426;
            }
            i = 0;
            bdla.b(paramQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "send_page", 0, 0, paramString1, i + "", "", "");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopUtils", 2, "openSendTroopGiftUrl url:" + paramString2);
      return;
      label426:
      if (paramActivity.isAdmin())
      {
        i = 1;
      }
      else
      {
        i = 2;
        continue;
        label445:
        paramString2 = localUnsupportedEncodingException;
      }
    }
  }
  
  public static void a(File paramFile, String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      String[] arrayOfString = paramString.list();
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfString[i];
        if (("__MACOSX".equalsIgnoreCase((String)localObject)) || (((String)localObject).endsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          String str = paramFile.getAbsolutePath().replace(".zip", "/");
          localObject = new File(paramString, (String)localObject);
          if (((File)localObject).exists())
          {
            FileUtils.copyDirectory(((File)localObject).getAbsolutePath(), str, true);
            FileUtils.deleteDirectory(paramString.getAbsolutePath());
          }
        }
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
        localObject = FileUtils.readFileToString((File)localObject);
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
    return "https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effect_" + paramInt + ".mp4";
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
    if ((arkl.a().isEnable()) && (!TextUtils.isEmpty(paramMessageForDeliverGiftTips.animationPackageUrl))) {
      return paramMessageForDeliverGiftTips.animationPackageUrl;
    }
    if (paramMessageForDeliverGiftTips.isInteract()) {
      return "https://pub.idqqimg.com/pc/misc/groupgift/" + str + "_NEW.zip";
    }
    if (paramMessageForDeliverGiftTips.animationType == 1) {
      return "https://pub.idqqimg.com/pc/misc/groupgift/" + str + "_V.zip";
    }
    return "https://pub.idqqimg.com/pc/misc/groupgift/" + str + "_HD.zip";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglb
 * JD-Core Version:    0.7.0.1
 */
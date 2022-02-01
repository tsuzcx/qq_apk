import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.2;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class beyy
{
  public static final Integer a = Integer.valueOf(1);
  public static final Integer b = Integer.valueOf(4);
  public static final Integer c = Integer.valueOf(2);
  public static final Integer d = Integer.valueOf(3);
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "file_homework_troop_aio_has_unread", 0).getInt(paramString, 0);
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    try
    {
      int i = paramString.lastIndexOf(".");
      str1 = str2;
      if (i != -1) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    catch (Exception paramString)
    {
      do
      {
        String str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.e("hw_troop", 2, "getFileSuffix:", paramString);
    }
    return str1;
    return "";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qun.qq.com/homework/features/guide.html?ishw=1&_wv=1027&_bid=2146&gid=" + paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(Context paramContext, String paramString, Integer paramInteger)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev4/classinfo?gc=%1$s&from=%2$s", new Object[] { paramString, paramInteger }));
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("url", String.format("https://admin.qun.qq.com/mcreatev3/joingroup.html?_bid=206&_wv=2098179&groupCode=%1$s&source=%2$s&uin=%3$s", new Object[] { paramString2, paramString3, paramString1 }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertTroopHomeworkPriseGrayTips:" + paramTroopTipsEntity.troopUin + ", optContent:" + paramTroopTipsEntity.optContent + ", , remindFlag:" + paramTroopTipsEntity.grayTipsRemindFlag + ", serviceType:3, msgSeq:" + paramTroopTipsEntity.msgSeq + ", time:" + paramTroopTipsEntity.time + ", expireTime:" + paramTroopTipsEntity.expireTime + ", isOfflineMsg:" + paramTroopTipsEntity.isOfflineMsg + ", optShowLatest:" + paramTroopTipsEntity.optShowLatest + ", highlightItems:" + paramTroopTipsEntity.highlightItems + ", highLightNum:" + paramTroopTipsEntity.highlightNum);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bbli.a(-2043);
    localMessageForGrayTips.frienduin = paramTroopTipsEntity.troopUin;
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, -2043, 1, paramTroopTipsEntity.msgSeq);
    if (paramTroopTipsEntity.highlightNum != 0) {
      bfdz.a(localMessageForGrayTips, paramTroopTipsEntity.highlightItems);
    }
    if (paramTroopTipsEntity.optShowLatest == 1) {
      localMessageForGrayTips.shmsgseq = 0L;
    }
    if (!amwh.a(paramQQAppInterface, localMessageForGrayTips, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "insertTroopHomeworkPriseGrayTips, after msgFilter:" + paramTroopTipsEntity.troopUin);
      }
      paramQQAppInterface.getMessageFacade().addMessage(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
      if (!((bfas)paramQQAppInterface.getManager(132)).a(paramTroopTipsEntity.troopUin))
      {
        bdyi localbdyi = new bdyi();
        Object localObject1 = new bdyi();
        ((bdyi)localObject1).a.a(4, localMessageForGrayTips.shmsgseq, localMessageForGrayTips.uniseq);
        localbdyi.a((bdyi)localObject1);
        localMessageForGrayTips.mMessageInfo = ((bdyi)localObject1);
        ((avtd)paramQQAppInterface.getManager(37)).a(paramTroopTipsEntity.troopUin, localbdyi);
        Object localObject2 = new abvu(paramQQAppInterface);
        localObject1 = ((abvu)localObject2).jdField_a_of_type_Anuz;
        localObject2 = ((abvu)localObject2).jdField_a_of_type_JavaUtilMap;
        localObject1 = (RecentUser)((anuz)localObject1).findRecentUserByUin(paramTroopTipsEntity.troopUin, 1);
        int i = localbdyi.b(paramQQAppInterface, true, paramTroopTipsEntity.troopUin);
        if (i >= ((RecentUser)localObject1).msgType)
        {
          ((RecentUser)localObject1).msgType = i;
          ((RecentUser)localObject1).msg = besd.a(paramQQAppInterface, paramTroopTipsEntity.troopUin, localbdyi, ((RecentUser)localObject1).msg, localMessageForGrayTips, true);
          ((Map)localObject2).put(abwz.a(paramTroopTipsEntity.troopUin, 1), localObject1);
        }
        ((anca)paramQQAppInterface.getBusinessHandler(20)).notifyUI(80, true, null);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, 0);
    String str = String.valueOf(1104445552);
    ((anca)paramQQAppInterface.getBusinessHandler(20)).notifyUI(61, true, new Object[] { paramString, str, Boolean.valueOf(false) });
    a(paramQQAppInterface, paramString, str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin() + "_" + "file_homework_troop_aio_has_unread", 0).edit().putInt(paramString, paramInt).commit();
    ThreadManager.post(new HWTroopUtils.3(paramQQAppInterface, paramString), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, "insertAddHWTroopGrayTips:" + paramString);
    }
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)bbli.a(-1013);
    localMessageForGrayTips.frienduin = paramString;
    Object localObject = BaseApplicationImpl.getApplication().getResources();
    String str = ((Resources)localObject).getString(2131696975);
    localObject = ((Resources)localObject).getString(2131696971);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, str, NetConnInfoCenter.getServerTime(), -1013, 1, paramInt);
    localMessageForGrayTips.time = paramLong;
    paramString = new Bundle();
    paramString.putInt("key_action", 10);
    paramInt = str.indexOf((String)localObject);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject).length() + paramInt, paramString);
    if (!amwh.a(paramQQAppInterface, localMessageForGrayTips, false)) {
      paramQQAppInterface.getMessageFacade().addMessage(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      if (paramString1 != null) {
        break label64;
      }
    }
    for (String str = "";; str = paramString1)
    {
      QLog.d("hw_troop", 2, new Object[] { "clearHomeworkTroopRedPointWith0x8c2. troopUin=", str, ", type=", paramString2 });
      label64:
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!TextUtils.isEmpty(paramString1)) {
          bfdg.a(paramQQAppInterface, paramString1, i);
        }
        return;
      }
      catch (NumberFormatException paramQQAppInterface) {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, beza parambeza, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        parambeza = new StringBuilder().append("checkIdentity error. app null: ");
        if (paramQQAppInterface != null) {
          break label112;
        }
      }
      label112:
      for (paramBoolean = true;; paramBoolean = false)
      {
        parambeza = parambeza.append(String.valueOf(paramBoolean)).append(", troopUin: ");
        paramQQAppInterface = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramQQAppInterface = "";
        }
        paramString1 = parambeza.append(paramQQAppInterface).append(", memberUin: ");
        paramQQAppInterface = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = "";
        }
        QLog.i("hw_troop", 2, paramQQAppInterface);
        return;
      }
    }
    ((TroopManager)paramQQAppInterface.getManager(52)).a(paramString1, paramString2, new beyz(paramString1, paramString2, paramBoolean, paramQQAppInterface, parambeza));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean(paramString2, paramBoolean).commit();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 332) || (paramInt == 333) || (paramInt == 334) || (paramInt == 335);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = new File(paramString1);
      if (!((File)localObject1).exists()) {
        break label405;
      }
      if (((File)localObject1).isDirectory()) {
        return false;
      }
      FileInfo localFileInfo = new FileInfo();
      localFileInfo.d(paramString2);
      localFileInfo.b(false);
      localFileInfo.e(((File)localObject1).getPath());
      localFileInfo.a(((File)localObject1).length());
      localFileInfo.b(((File)localObject1).lastModified());
      Object localObject2 = aszt.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
      localForwardFileInfo.d(3);
      localForwardFileInfo.b(10000);
      localForwardFileInfo.a(localFileInfo.c());
      localForwardFileInfo.d(localFileInfo.d());
      localForwardFileInfo.d(localFileInfo.a());
      localObject1 = new Intent(paramContext, FileBrowserActivity.class);
      ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
      if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localFileInfo);
        aslg.a((ArrayList)localObject2);
        ((Intent)localObject1).putExtra("clicked_file_hashcode", localFileInfo.hashCode());
      }
      ((Intent)localObject1).putExtra("selectMode", false);
      ((Intent)localObject1).putExtra("enableDelete", false);
      ((Intent)localObject1).putExtra("peerType", 0);
      ((Intent)localObject1).putExtra("busiType", 0);
      ((Intent)localObject1).putExtra("enterfrom", 0);
      ((Intent)localObject1).putExtra("sendprepare", -100);
      ((Intent)localObject1).putExtra("apautocreate", false);
      ((Intent)localObject1).putExtra("qlinkselect", false);
      ((Intent)localObject1).putExtra("max_select_size", 0);
      ((Intent)localObject1).putExtra("max_select_count", 20);
      ((Intent)localObject1).putExtra("rootEntrace", false);
      ((Intent)localObject1).setFlags(268435456);
      paramContext.startActivity((Intent)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "openLocalFilePreview:" + paramString1 + "," + paramString2);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("hw_troop", 2, "openLocalFilePreview:", paramContext);
        }
      }
    }
    return true;
    label405:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("homework_troop_config" + paramQQAppInterface.getCurrentUin(), 0).getBoolean(paramString2, false);
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    return (paramTroopMemberInfo != null) && (a(paramTroopMemberInfo.level));
  }
  
  private static void b(beza parambeza, int paramInt)
  {
    if (parambeza == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      parambeza.a(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new HWTroopUtils.2(parambeza, paramInt));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt != 332) && (paramInt != 333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */
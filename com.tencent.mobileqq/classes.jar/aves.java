import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.data.QGameBusEvent;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.2;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.ArrayList<Lcooperation.wadl.ipc.WadlResult;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aves
{
  public static int a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().getConversationFacade() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).getMessageFacade().getConversationFacade().a("2747277822", 1008);
    }
    return 0;
  }
  
  public static long a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp_mutiprocess", 4).getLong(localBaseApplicationImpl.getRuntime().getAccount() + "preload_time", 0L);
  }
  
  public static long a(ArrayList<WadlResult> paramArrayList)
  {
    long l2 = 0L;
    Object localObject2 = "";
    int i = 0;
    Object localObject1 = "";
    long l1 = l2;
    if (paramArrayList != null)
    {
      l1 = l2;
      if (paramArrayList.size() > 0)
      {
        Iterator localIterator = paramArrayList.iterator();
        l1 = 0L;
        paramArrayList = (ArrayList<WadlResult>)localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (WadlResult)localIterator.next();
          if ((((WadlResult)localObject2).b != 6) || (((WadlResult)localObject2).c <= l1)) {
            break label242;
          }
          l1 = ((WadlResult)localObject2).c;
          localObject1 = ((WadlResult)localObject2).a.a;
          i = ((WadlResult)localObject2).a.e;
          paramArrayList = ((WadlResult)localObject2).a.f;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<WadlResult>)localObject2;
      break;
      l1 = l2;
      if (!TextUtils.isEmpty(paramArrayList))
      {
        int j = abuf.a((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "appVersionCode = " + j + " lastGameVer=" + i);
        }
        if (j < i) {
          break label227;
        }
        l1 = l2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "getLastGameAppID gameAppId=" + l1);
        }
        return l1;
        try
        {
          label227:
          l1 = Long.parseLong(paramArrayList);
        }
        catch (NumberFormatException paramArrayList)
        {
          l1 = l2;
        }
      }
      label242:
      localObject2 = paramArrayList;
      paramArrayList = (ArrayList<WadlResult>)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("settingInfo", "");
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    localIntent.putExtra("moduleId", "cmshowgame_module");
    localIntent.putExtra("startTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("unreadNum", a());
    return localIntent;
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
  }
  
  public static FullPopData a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    try
    {
      if (((!(paramMessageRecord instanceof MessageForArkApp)) && (!(paramMessageRecord instanceof MessageForPubAccount)) && (!(paramMessageRecord instanceof MessageForStructing))) || (TextUtils.isEmpty(paramMessageRecord.extStr))) {
        break label149;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord.extStr).optString("report_key_bytes_oac_msg_extend", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label149;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optString("game_extra", "");
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break label149;
      }
      paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("full_pop");
      paramMessageRecord = new FullPopData(paramMessageRecord.optString("url"), paramMessageRecord.optString("jump_url"), paramMessageRecord.optLong("begin_time"), paramMessageRecord.optLong("end_time"), paramMessageRecord.optString("id", ""));
    }
    catch (Throwable paramMessageRecord)
    {
      for (;;)
      {
        paramMessageRecord.printStackTrace();
        paramMessageRecord = null;
      }
    }
    return paramMessageRecord;
  }
  
  public static GmpEnterInfoRsp a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    GmpEnterInfoRsp localGmpEnterInfoRsp = new GmpEnterInfoRsp();
    localGmpEnterInfoRsp.url = localSharedPreferences.getString(str, "");
    localGmpEnterInfoRsp.bubble_id = localSharedPreferences.getString((String)localObject, "");
    return localGmpEnterInfoRsp;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    localSharedPreferences.edit().putString(str, "").apply();
    localSharedPreferences.edit().putString((String)localObject, "").apply();
  }
  
  public static void a(int paramInt)
  {
    QGameBusEvent localQGameBusEvent = new QGameBusEvent(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(localQGameBusEvent);
  }
  
  public static void a(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, new Object[] { "publicAccountTianshuReport---> action=" + paramInt1, "   position=" + paramInt2 });
    }
    if (paramQQGameMsgInfo == null) {}
    String str1;
    do
    {
      return;
      if (paramInt1 == 117) {
        apau.a(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
      }
      str1 = "";
      if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
        str1 = paramQQGameMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str1));
    apau.a(paramInt1, paramInt2, str1, paramQQGameMsgInfo.triggerInfo);
    if (paramInt1 == 117) {}
    for (String str2 = "207701";; str2 = "207702")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(2), str1);
      localHashMap.put(Integer.valueOf(6), paramInt1 + "");
      localHashMap.put(Integer.valueOf(24), "1");
      abuf.a(amwn.a(), "769", str2, paramQQGameMsgInfo.gameAppId, "76926", "1", "160", localHashMap);
      return;
      if (paramInt1 != 118) {
        break;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp_mutiprocess", 4);
        localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "preload_time";
        localSharedPreferences.edit().putLong((String)localObject, paramLong).apply();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameHelper", 2, QLog.getStackTraceString(localThrowable));
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = a();
    if (aveq.c())
    {
      PublicFragmentActivityForTool.b(paramContext, localIntent, QQGameFeedWebFragment.class);
      c();
      return;
    }
    PublicFragmentActivity.a(paramContext, localIntent, QQGamePubAccountFragment.class);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    localSharedPreferences.edit().putString(str, paramGmpEnterInfoRsp.url).apply();
    localSharedPreferences.edit().putString((String)localObject, paramGmpEnterInfoRsp.bubble_id).apply();
  }
  
  public static void a(NavBarQQGamePub paramNavBarQQGamePub, GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    if ((!TextUtils.isEmpty(paramGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubble_id))) {
      if (paramNavBarQQGamePub != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "show game enter cache icon");
        }
        paramNavBarQQGamePub.setCurType(3);
        paramNavBarQQGamePub.a(paramGmpEnterInfoRsp.url);
        paramNavBarQQGamePub.setmBubbleid(paramGmpEnterInfoRsp.bubble_id);
        paramNavBarQQGamePub.a(true);
      }
    }
    while (paramNavBarQQGamePub == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "show game enter");
    }
    paramNavBarQQGamePub.setCurType(1);
    paramNavBarQQGamePub.a(false);
    paramNavBarQQGamePub.setmBubbleid("");
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if ((!aveq.a()) || (!aveq.c())) {
      break label12;
    }
    label12:
    while (paramList == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramList.size() <= 0) {
          break label12;
        }
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (MessageRecord)paramList.next();
          if (!"2747277822".equals(((MessageRecord)localObject).frienduin)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQGameHelper", 1, "enter qqgame message handle");
          }
          paramList = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
          if (paramList == null) {
            break label202;
          }
          localArrayList.add(paramList);
        }
        if (localArrayList.size() <= 0) {
          break label12;
        }
        paramList = new Intent("action_qgame_tool_messgae");
        paramList.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        Object localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_get_msg", localArrayList);
        paramList.putExtras((Bundle)localObject);
        BaseApplicationImpl.getApplication().sendBroadcast(paramList);
        return;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQGameHelper", 1, "send qqgame message fail by:" + paramList.getMessage());
      return;
      label202:
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 1, "parse qqgame message fail");
      }
    }
  }
  
  public static boolean a(avfh paramavfh)
  {
    return ((paramavfh instanceof GameArkView)) && (a(paramavfh.a()));
  }
  
  public static boolean a(String paramString)
  {
    return "com.tencent.gamecenter.newvideo".equals(paramString);
  }
  
  public static int b()
  {
    if (!aveq.e())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 2, "OpenQQGameCenterByHippy not allow");
      }
      return -1;
    }
    if (UpdateSetting.getInstance().getModuleVersion("QQGameCenter") <= 0)
    {
      QLog.d("QQGameHelper", 1, "OpenQQGameCenterByHippy js bundle not exist");
      new HippyQQUpdateManager().checkUpdate("QQGameCenter", null);
      return -2;
    }
    if (!HippyQQLibraryManager.getInstance().isLibrayExists())
    {
      QLog.d("QQGameHelper", 1, "OpenQQGameCenterByHippy so not exist");
      return -3;
    }
    return 0;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGameHelper", 1, "===preloadSw===");
    }
    biij.a().a(new avet(4096));
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = a();
    if (aveq.c())
    {
      PublicFragmentActivityForTool.b((Activity)paramContext, localIntent, QQGameFeedWebFragment.class, 10000);
      c();
      return;
    }
    PublicFragmentActivity.a((Activity)paramContext, localIntent, QQGamePubAccountFragment.class, 10000);
  }
  
  private static boolean b()
  {
    if (!aveq.d()) {
      QLog.i("QQGameHelper", 2, "===can't preLoad because config switch is not open===");
    }
    while (aveq.a() <= 0) {
      return false;
    }
    long l = a();
    if (NetConnInfoCenter.getServerTimeMillis() - l < aveq.a() * 24 * 60 * 60 * 1000)
    {
      QLog.i("QQGameHelper", 2, "===can't preLoad because time is not in===" + BaseApplicationImpl.processName);
      return false;
    }
    return true;
  }
  
  public static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelper.2());
  }
  
  public static void d()
  {
    if (!aveq.f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 2, "preloadQQGameCenterByHippy not allow");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isPreload", true);
    localBundle.putBoolean("isInToolProcess", false);
    localBundle.putString("bundleName", "QQGameCenter");
    HippyAccessHelper.checkAndPreloadHippyPage(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aves
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Locale;

public class aqqn
  extends QIPCModule
{
  private static aqqn a;
  
  private aqqn(String paramString)
  {
    super(paramString);
  }
  
  public static aqqn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqqn("CampusCircleIpcServer_Model");
      }
      return a;
    }
    finally {}
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcServer", 2, "isInTroopAIO, app is null");
        }
        return null;
      }
      boolean bool = aqzo.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, "isInTroopAIO, isInAIO " + bool);
      }
      paramString = new EIPCResult();
      paramString.data = new Bundle();
      paramString.data.putBoolean("isInTroopAIO", bool);
      return paramString;
    }
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = null;
    if ((!"action_get_red_point".equals(paramString)) || (paramBundle == null)) {
      return null;
    }
    paramBundle = new Bundle();
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = paramBundle;
    paramString = localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "getRedPoint, app is null");
      }
      paramBundle.putBoolean("hasRedTouch", false);
      paramBundle.putInt("type", -1);
      paramBundle.putInt("count", 0);
      paramBundle.putLong("seq", -1L);
      paramBundle.putInt("code", -1);
      localEIPCResult.code = -1;
    }
    for (;;)
    {
      return localEIPCResult;
      paramString = ((aysq)paramString.getManager(160)).a(103421);
      if (paramString != null)
      {
        paramBundle.putBoolean("hasRedTouch", paramString.unReadFlag);
        paramBundle.putInt("type", paramString.redtouchType);
        paramBundle.putInt("count", paramString.count);
        paramBundle.putLong("seq", paramString.curSeq);
        paramBundle.putInt("code", 0);
        localEIPCResult.code = 0;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcServer", 2, "getRedPoint, unreadMsg is null");
        }
        paramBundle.putBoolean("hasRedTouch", false);
        paramBundle.putInt("type", -1);
        paramBundle.putInt("count", 0);
        paramBundle.putLong("seq", -1L);
        paramBundle.putInt("code", -1);
        localEIPCResult.code = -1;
      }
    }
  }
  
  private EIPCResult b(String paramString, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "updateConfessSwitch action: %s", new Object[] { paramString }));
    }
    if (!"action_confess_update_switch".equals(paramString))
    {
      paramString = null;
      return paramString;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcServer", 2, "updateConfessSwitch, app is null");
        }
        return null;
      }
      int i = paramBundle.getInt("nSwitchValue");
      paramString = (ajwm)paramString.getManager(295);
      paramBundle = paramString.a(1);
      paramString.a(paramBundle, (short)i);
      paramString.a(paramBundle);
      paramBundle = new EIPCResult();
      paramBundle.data = new Bundle();
      paramBundle.data.putInt("ret", 0);
      paramString = paramBundle;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CampusCircleIpcServer", 2, "updateConfessSwitch, nSwitchValue: " + i);
      return paramBundle;
    }
  }
  
  private EIPCResult b(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((!"action_report_red_point".equals(paramString)) || (paramBundle == null)) {
      return null;
    }
    long l1 = paramBundle.getLong("seq", -1L);
    if (l1 < 0L) {
      QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, webSeq < 0:" + l1);
    }
    paramString = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, app is null");
      }
      return null;
    }
    aysq localaysq = (aysq)paramString.getManager(160);
    RedTouchItem localRedTouchItem = localaysq.a(103421);
    if (localRedTouchItem == null)
    {
      QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, unReadMsg is null, return");
      paramString = new EIPCResult();
      paramString.data = null;
      paramString.code = -1;
      super.callbackResult(paramInt, paramString);
      return null;
    }
    long l2 = localRedTouchItem.curSeq;
    if (l1 >= l2) {
      localaysq.a(103421);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, localSeq=" + l2 + ", webSeq=" + l1 + ", unreadMsg=" + localRedTouchItem);
      }
      aogf.a(paramString);
      paramString = new EIPCResult();
      paramString.data = paramBundle;
      paramString.code = 0;
      super.callbackResult(paramInt, paramString);
      return null;
      localRedTouchItem.count = ((int)Math.abs(l2 - l1));
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "unreadmsg.coung set to " + localRedTouchItem.count);
      }
      localaysq.a(103421, true, l1, true, true);
    }
  }
  
  private EIPCResult c(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "reportMedalRedPoint action: %s", new Object[] { paramString }));
    }
    if (!"action_report_medal_red_point".equals(paramString)) {
      return null;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MedalWallMng", 2, "reportMedalRedPoint, app is null");
        return null;
      }
      ((MedalWallMng)paramString.getManager(250)).a(2, null);
      paramString = new EIPCResult();
      paramString.data = paramBundle;
      paramString.code = 0;
      super.callbackResult(paramInt, paramString);
      return null;
    }
  }
  
  private EIPCResult d(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "reportConfessRedPoint action: %s", new Object[] { paramString }));
    }
    if (!"action_confess_clear_red_point".equals(paramString)) {
      return null;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MedalWallMng", 2, "reportRedPoint_confess, app is null");
        return null;
      }
      if ("frd_rec_confess".equals(paramBundle.getString("tag"))) {
        aqyt.b(paramString, false);
      }
      paramString = new EIPCResult();
      paramString.data = paramBundle;
      paramString.code = 0;
      super.callbackResult(paramInt, paramString);
      return null;
    }
  }
  
  private EIPCResult e(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "getTroopMembers action: %s", new Object[] { paramString }));
    }
    paramBundle = aqzo.a(paramBundle.getString("troopUin"));
    paramString = new EIPCResult();
    paramString.data = new Bundle();
    if ((paramBundle != null) && (paramBundle.length == 3))
    {
      paramString.code = 0;
      boolean bool1 = ((Boolean)paramBundle[0]).booleanValue();
      boolean bool2 = ((Boolean)paramBundle[1]).booleanValue();
      paramBundle = (ArrayList)paramBundle[2];
      if (paramBundle != null) {
        paramString.data.putSerializable("troopUin", paramBundle);
      }
      paramString.data.putBoolean("isAdmin", bool1);
      paramString.data.putBoolean("enableMemInvite", bool2);
      return paramString;
    }
    paramString.code = -1;
    return paramString;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleIpcServer", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if (paramBundle == null) {
      QLog.d("CampusCircleIpcServer", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
    }
    do
    {
      return null;
      if ("action_get_red_point".equals(paramString)) {
        return a(paramString, paramBundle, paramInt);
      }
      if ("action_report_red_point".equals(paramString)) {
        return b(paramString, paramBundle, paramInt);
      }
      if ("action_report_medal_red_point".equals(paramString)) {
        return c(paramString, paramBundle, paramInt);
      }
      if ("action_allpeoplevote_getredpoint".equals(paramString)) {
        return biur.b(paramString, paramBundle, paramInt);
      }
      if ("action_allpeoplevote_clearredpoint".equals(paramString)) {
        return biur.a(paramString, paramBundle, paramInt);
      }
      if ("action_confess_clear_red_point".equals(paramString)) {
        return d(paramString, paramBundle, paramInt);
      }
      if ("action_confess_get_troop_members".equals(paramString)) {
        return e(paramString, paramBundle, paramInt);
      }
      if ("action_confess_is_in_troop_aio".equals(paramString)) {
        return a(paramString, paramBundle);
      }
      if ("action_confess_update_switch".equals(paramString)) {
        return b(paramString, paramBundle);
      }
    } while (!QLog.isColorLevel());
    QLog.d("CampusCircleIpcServer", 1, "onCall, invalid action:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqn
 * JD-Core Version:    0.7.0.1
 */
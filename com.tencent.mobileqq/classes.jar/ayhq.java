import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ayhq
  extends ayht
{
  private final int[] a;
  
  public ayhq()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { 1104864054, 1200000003, 1104651886, 1106658188, 1107930043, 1104864062, 100719166, 1104864064, 1101487426, 1104864066, 1104864068, 1104864070, 1104788679, 1101678813, 1104536706, 1200000002, 1200000008 };
    a(new aygo());
  }
  
  private long a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    paramSessionInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramSessionInfo.curFriendUin);
    int i;
    if (paramSessionInfo.isTroopOwner(paramQQAppInterface.getCurrentUin()))
    {
      i = 1;
      if (!paramSessionInfo.isAdmin()) {
        break label61;
      }
    }
    for (;;)
    {
      return (i & 0x1) << 2 | (j & 0x1) << 1 | 0x1;
      i = 0;
      break;
      label61:
      j = 0;
    }
  }
  
  @Nullable
  private List<TroopAIOAppInfo> a(@NotNull SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = bduw.a(paramQQAppInterface).a(bdvb.a(paramSessionInfo.curFriendUin));
    paramSessionInfo = paramQQAppInterface;
    if (AudioHelper.e())
    {
      paramSessionInfo = paramQQAppInterface;
      if (AudioHelper.a(4) == 1)
      {
        AudioHelper.a(amtj.a(2131707410));
        paramSessionInfo = null;
      }
    }
    return paramSessionInfo;
  }
  
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("CommonTroopPlusPanelStrategy", 1, "reloadTroop, local, troopAppInfos[" + this.jdField_a_of_type_ArrayOfInt.length + "]");
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfInt[i];
      if ((k == 1106114157) && (!ScribbleResMgr.c(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin()))) {}
      for (;;)
      {
        i += 1;
        break;
        a(paramBaseChatPie.sessionInfo.curType, k);
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, long paramLong, List<TroopAIOAppInfo> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("CommonTroopPlusPanelStrategy", 1, "reloadTroop, server, troopAppInfos[" + paramList.size() + "]");
    }
    a(paramBaseChatPie.sessionInfo.curType);
    paramList = paramList.iterator();
    boolean bool = false;
    while (paramList.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)paramList.next();
      if (!a(paramLong, localTroopAIOAppInfo)) {
        bool = a(paramBaseChatPie, paramQQAppInterface, bool, localTroopAIOAppInfo);
      }
    }
  }
  
  private boolean a(long paramLong, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if ((!TextUtils.isEmpty(paramTroopAIOAppInfo.minVersion)) && (AppSetting.a(paramTroopAIOAppInfo.minVersion) < 0)) {}
    do
    {
      return true;
      if ((paramTroopAIOAppInfo.identifyMask & paramLong) != 0L) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d(".troop.troop_appCommonTroopPlusPanelStrategy", 1, new Object[] { "reloadTroop, appInfo is filtered: info: ", String.valueOf(paramTroopAIOAppInfo), " userIdentify: ", Long.toBinaryString(paramLong) });
    return true;
    return false;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, boolean paramBoolean, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int i = 0;
    int m = this.jdField_a_of_type_Ayfw.a.size();
    int j = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break label112;
      }
      int n = this.jdField_a_of_type_Ayfw.a.keyAt(j);
      if (paramTroopAIOAppInfo.appid == n)
      {
        k = 1;
        i = 1;
        if ((n != 1106114157) || (ScribbleResMgr.c(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin()))) {
          break;
        }
      }
      j += 1;
    }
    a(this.jdField_a_of_type_Ayfw.b(paramTroopAIOAppInfo, paramBaseChatPie.sessionInfo.curType));
    label112:
    if (k == 0) {
      a(this.jdField_a_of_type_Ayfw.a(paramTroopAIOAppInfo, paramBaseChatPie.sessionInfo.curType));
    }
    return paramBoolean;
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.sessionInfo;
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    long l = a((SessionInfo)localObject, localQQAppInterface);
    localObject = a((SessionInfo)localObject, localQQAppInterface);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      a(paramBaseChatPie, localQQAppInterface, l, (List)localObject);
      return;
    }
    a(paramBaseChatPie, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhq
 * JD-Core Version:    0.7.0.1
 */
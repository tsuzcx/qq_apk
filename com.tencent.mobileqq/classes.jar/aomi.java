import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aomi
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    int k = 0;
    int m = 0;
    int j = 1;
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(String.valueOf(paramLong));
    if (localTroopInfo == null)
    {
      localTroopInfo = new TroopInfo();
      localTroopInfo.cmdUinFlagEx2 = paramInt;
    }
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, groupMemberFlagEx2=" + paramInt + ", troopUin=" + paramLong + ", hummer message cmdUinFlagEx2=" + localTroopInfo.cmdUinFlagEx2);
      }
      if (localTroopInfo.cmdUinFlagEx2 != paramInt)
      {
        i = m;
        if (TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512) != TroopInfo.isCmdUinFlagEx2Open(paramInt, 512)) {
          i = 1;
        }
        localTroopInfo.cmdUinFlagEx2 = paramInt;
        paramInt = j;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          localTroopManager.b(localTroopInfo);
          if (i != 0) {
            a(paramQQAppInterface, localTroopInfo);
          }
        }
        return;
        paramInt = i;
        i = k;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    if (TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 512)) {}
    for (int i = 1;; i = 0)
    {
      FriendsStatusUtil.a(paramQQAppInterface, paramTroopInfo.troopuin, 1, i);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map<String, Boolean> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {}
      for (int i = 1;; i = 0)
      {
        FriendsStatusUtil.a(paramQQAppInterface, (String)localEntry.getKey(), 1, i);
        break;
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    int i = 0;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopStatusUtil", 2, new Object[] { "HummerMessage::updateTroopRingId: invoked. ", " ringId: ", Integer.valueOf(paramInt), " groupCode: ", Long.valueOf(paramLong) });
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo2 = localTroopManager.b(String.valueOf(paramLong));
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.udwCmdUinRingtoneID = paramInt;
      i = 1;
    }
    if (localTroopInfo1.udwCmdUinRingtoneID != paramInt)
    {
      localTroopInfo1.udwCmdUinRingtoneID = paramInt;
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        localTroopManager.b(localTroopInfo1);
        aqne.a(paramQQAppInterface).a(paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomi
 * JD-Core Version:    0.7.0.1
 */
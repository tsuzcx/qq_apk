import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bbfn
{
  private static bbfq a;
  
  public static int a()
  {
    return a().d;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
    int k = a(((TroopManager)localObject2).c(paramString));
    long l = System.currentTimeMillis();
    Object localObject1 = "getGroupMemberNum, groupUin[" + paramString + "], memberCount[" + k + "]";
    int i;
    if (k - 10 < c())
    {
      Object localObject3 = ((TroopManager)localObject2).b(String.valueOf(paramString));
      if (localObject3 != null)
      {
        paramString = (balw)paramQQAppInterface.getManager(203);
        localObject2 = (bdto)paramQQAppInterface.getManager(165);
        localObject3 = ((List)localObject3).iterator();
        paramQQAppInterface = (QQAppInterface)localObject1;
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (TroopMemberInfo)((Iterator)localObject3).next();
          if ((paramString.b(((TroopMemberInfo)localObject1).memberuin)) || (((bdto)localObject2).f(((TroopMemberInfo)localObject1).memberuin))) {
            paramQQAppInterface = paramQQAppInterface + "\nisRobotUin[" + ((TroopMemberInfo)localObject1).memberuin + "]";
          } else {
            i += 1;
          }
        }
        localObject1 = paramQQAppInterface + "\nCalcCount[" + i + "]";
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = k;
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVGroupConfig", 1, "" + (String)localObject1 + ", time[" + (System.currentTimeMillis() - l) + "]");
      }
      return j;
      i = 0;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    int i = 0;
    if (paramQQAppInterface != null)
    {
      if (paramBoolean) {
        i = a(paramQQAppInterface, paramString);
      }
    }
    else {
      return i;
    }
    return ((ajvk)paramQQAppInterface.getManager(53)).a(paramString);
  }
  
  static int a(TroopInfo paramTroopInfo)
  {
    int i = paramTroopInfo.wMemberNumClient;
    if (AudioHelper.e()) {
      QLog.w("QAVGroupConfig", 1, "getMemberNum, troopuin[" + paramTroopInfo.troopuin + "], wMemberNumClient[" + paramTroopInfo.wMemberNumClient + "], wMemberNum[" + paramTroopInfo.wMemberNum + "], uin[" + paramTroopInfo.uin + "], troopcode[" + paramTroopInfo.troopcode + "]");
    }
    return i;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int k = a(paramQQAppInterface, true, paramString);
    int m = paramQQAppInterface.b(paramString);
    Object localObject = (bakk)paramQQAppInterface.getManager(48);
    boolean bool3 = ((bakk)localObject).a(paramString, paramQQAppInterface.getCurrentAccountUin());
    boolean bool4 = ((bakk)localObject).a(paramString);
    boolean bool5 = ((bakk)localObject).b(paramString);
    paramQQAppInterface = ((bakk)localObject).a(paramString);
    int j = 0;
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((!bool5) && (bool3))
    {
      i = 2131695943;
      bool1 = true;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("mask", m);
      ((Bundle)localObject).putInt("num", k);
      ((Bundle)localObject).putBoolean("isAdmin", bool4);
      ((Bundle)localObject).putBoolean("isOwner", bool5);
      ((Bundle)localObject).putBoolean("forceDisableInviteBox", bool1);
      ((Bundle)localObject).putInt("errId", i);
      paramString = new StringBuilder().append("getGroupMask, troopUin[").append(paramString).append("], mask[").append(m).append("], num[").append(k).append("], isOwner[").append(bool5).append("], isMemberGaged[").append(bool3).append("], isAdmin[").append(bool4).append("], gagTimeStamp[");
      if ((paramQQAppInterface == null) || (paramQQAppInterface.a == 0L)) {
        break label310;
      }
    }
    label310:
    for (bool2 = true;; bool2 = false)
    {
      QLog.w("QAVGroupConfig", 1, bool2 + "], forceDisableInviteBox[" + bool1 + "]");
      return localObject;
      bool1 = bool2;
      i = j;
      if (bool4) {
        break;
      }
      bool1 = bool2;
      i = j;
      if (paramQQAppInterface == null) {
        break;
      }
      bool1 = bool2;
      i = j;
      if (paramQQAppInterface.a == 0L) {
        break;
      }
      i = 2131695942;
      bool1 = true;
      break;
    }
  }
  
  public static bbfq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = bbfq.a(lcy.b(276).a);
      }
      return a;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    paramString = bbfq.a(paramString);
    try
    {
      a = paramString;
      return;
    }
    finally {}
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    akhq localakhq = (akhq)paramQQAppInterface.a(20);
    if (localakhq == null) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(paramString2);
        if (l == 0L) {
          continue;
        }
        paramString1 = paramString1 + "_" + AudioHelper.b();
        String str = String.valueOf(l);
        paramQQAppInterface.addObserver(new bbfo(l, paramString1, paramQQAppInterface, str));
        localakhq.b(l, 480, 0);
        paramString2 = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString2);
        if (paramString2.maxInviteMemNum == 0)
        {
          paramQQAppInterface.addObserver(new bbfp(str, paramQQAppInterface, paramString1));
          localakhq.j(str);
        }
        QLog.w("QAVGroupConfig", 1, "getGroupInfo[" + paramString1 + "], troopuin[" + l + "], maxInviteMemNum[" + paramString2.maxInviteMemNum + "]");
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
        }
      }
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = false;
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", String.valueOf(paramLong));
    paramVideoAppInterface = paramVideoAppInterface.a(6, 0, 0, localBundle, null);
    int i;
    int j;
    if (paramVideoAppInterface != null)
    {
      int k = paramVideoAppInterface.getInt("mask", 1);
      int m = paramVideoAppInterface.getInt("num");
      boolean bool2 = paramVideoAppInterface.getBoolean("forceDisableInviteBox");
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.i("QAVGroupConfig", 2, "canShowInviteBox, forceDisableInviteBox[" + bool2 + "], mask[" + k + "], num[" + m + "]");
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        paramBoolean = true;
      }
      do
      {
        return paramBoolean;
        if (1 != j) {
          break label254;
        }
        if (!AudioHelper.d()) {
          break;
        }
        j = AudioHelper.a(6);
        if (j == 1) {
          return true;
        }
        paramBoolean = bool1;
      } while (j == 0);
      paramVideoAppInterface = a();
      if (i > paramVideoAppInterface.e)
      {
        QLog.w("QAVGroupConfig", 1, "onGAudioInvite, 成员太多, relationId[" + paramLong + "], show_invite_box[" + paramVideoAppInterface.e + "], MemberNum[" + i + "]");
        return false;
      }
      return true;
      label254:
      bbfs.a(j);
      return false;
      i = 0;
      j = 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (bakk)paramQQAppInterface.getManager(48);
    boolean bool1 = paramQQAppInterface.a(paramString);
    boolean bool2 = paramQQAppInterface.b(paramString);
    if ((bool1) || (bool2)) {}
    for (bool1 = true; 1 == AudioHelper.a(7); bool1 = false)
    {
      AudioHelper.a(ajyc.a(2131708917));
      return true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString2);
    boolean bool1 = false;
    boolean bool3;
    boolean bool4;
    label53:
    String str;
    int i;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.dwAdditionalFlag & 1L) != 1L) {
        break label585;
      }
      bool3 = true;
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) != 1L) {
        break label591;
      }
      bool4 = true;
      str = "";
      i = a(localTroopInfo);
      bool1 = false;
      if ((localTroopInfo.troopPrivilegeFlag & 0x6100000) != 0L) {
        break label597;
      }
      bool1 = true;
      str = ajyc.a(2131708914);
      label91:
      if ((!bool1) || (!localTroopInfo.isAdmin())) {
        break label735;
      }
      str = str + ajyc.a(2131708919);
    }
    label158:
    label210:
    label597:
    label732:
    label735:
    for (boolean bool5 = false;; bool5 = bool1)
    {
      boolean bool2 = false;
      int j = localTroopInfo.getMemNumForAutoInviteIntoGroup(paramQQAppInterface);
      if (j >= 0) {
        if (i >= j)
        {
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {
            break label732;
          }
          str = str + ajyc.a(2131708918);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if ((bool5) || (bool2))
        {
          bool1 = false;
          paramQQAppInterface = ((bakk)paramQQAppInterface.getManager(48)).a(paramString2);
          paramString1 = new StringBuilder().append("getCanAutoInviteMemIntoTroop[").append(paramString1).append("], groupUin[").append(paramString2).append("][").append(localTroopInfo.troopname).append("], \n群禁言时间戳[").append(localTroopInfo.dwGagTimeStamp).append("], \n群禁言[");
          if (paramQQAppInterface != null) {
            break label723;
          }
        }
        for (long l = 0L;; l = paramQQAppInterface.a)
        {
          QLog.w("QAVGroupConfig", 1, l + "], \n被禁言到期时间戳[" + localTroopInfo.dwGagTimeStamp_me + "], \n群成员数量[" + localTroopInfo.wMemberNum + "], \n群成员数量Client[" + localTroopInfo.wMemberNumClient + "], \n最大的邀请自动入群人数[" + localTroopInfo.maxInviteMemNum + "|" + j + "], \n后台配置_每次选人上限[" + b() + "], \n后台配置_通话成员邀请上限[" + c() + "], \nmMemberInvitingFlag[" + localTroopInfo.mMemberInvitingFlag + "], \nisOnlyTroopMemberInviteOption[" + localTroopInfo.isOnlyTroopMemberInviteOption() + "], \n群能力标记位troopPrivilegeFlag[" + localTroopInfo.troopPrivilegeFlag + "], \n群标记位dwGroupFlagExt3[" + localTroopInfo.dwGroupFlagExt3 + "], \n群的加入方式cGroupOption[" + localTroopInfo.cGroupOption + "], \nneedAdminCheck[" + bool5 + "], \nneedAgree[" + bool2 + "], \nbOwner[" + bool3 + "_" + localTroopInfo.dwAdditionalFlag + "], \nbAdmin[" + bool4 + "_" + localTroopInfo.dwCmdUinUinFlag + "], \nisAdmin[" + localTroopInfo.isAdmin() + "], \nlog[" + str + "], \n可以邀请[" + bool1 + "]");
          return bool1;
          bool3 = false;
          break;
          bool4 = false;
          break label53;
          if ((localTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            if (i > 50) {}
            for (bool1 = true;; bool1 = false)
            {
              str = ajyc.a(2131708915);
              break;
            }
          }
          if ((localTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            if (i > 100) {}
            for (bool1 = true;; bool1 = false)
            {
              str = ajyc.a(2131708916);
              break;
            }
          }
          if ((localTroopInfo.troopPrivilegeFlag & 0x100000) != 1048576L) {
            break label91;
          }
          bool1 = false;
          str = ajyc.a(2131708920);
          break label91;
          bool1 = false;
          break label158;
          bool1 = true;
          break label210;
        }
      }
    }
  }
  
  public static int b()
  {
    return a().c;
  }
  
  public static int c()
  {
    return a().b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfn
 * JD-Core Version:    0.7.0.1
 */
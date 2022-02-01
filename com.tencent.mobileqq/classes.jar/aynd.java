import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aynd
{
  public static int a(TroopInfo paramTroopInfo, String paramString)
  {
    int j = 1;
    int i = j;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin == null) || (!paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        break label30;
      }
      i = 3;
    }
    label30:
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramTroopInfo.Administrator == null);
      i = j;
    } while (!paramTroopInfo.Administrator.contains(paramString));
    return 2;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 3) {
      str = "0";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "1";
      }
    } while (paramInt != 1);
    return "2";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Card paramCard)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramString2, paramQQAppInterface.getCurrentAccountUin()))
        {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
          paramString1 = paramQQAppInterface;
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            paramString1 = paramString2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("troop_member_card", 2, "getNickName, nick=" + paramString1);
          break;
        }
        Object localObject = (amsw)paramQQAppInterface.getManager(51);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
        localObject = ((amsw)localObject).b(paramString2);
        TroopMemberInfo localTroopMemberInfo = paramQQAppInterface.b(paramString1, paramString2);
        if (localObject == null) {
          break label322;
        }
        if (((Friends)localObject).isFriend())
        {
          paramString1 = ((Friends)localObject).remark;
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramQQAppInterface = ((Friends)localObject).name;
          }
          paramString1 = paramQQAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.i("troop_member_card", 2, "getNickName, Friends!=null, remark=" + ((Friends)localObject).remark + " name=" + ((Friends)localObject).name);
            paramString1 = paramQQAppInterface;
          }
          localObject = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            localObject = paramString1;
            if (localTroopMemberInfo != null)
            {
              paramQQAppInterface = localTroopMemberInfo.friendnick;
              localObject = paramQQAppInterface;
              if (QLog.isColorLevel())
              {
                QLog.i("troop_member_card", 2, "getNickName, TroopMemberInfo!=null, friendnick=" + localTroopMemberInfo.friendnick);
                localObject = paramQQAppInterface;
              }
            }
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          paramQQAppInterface = (QQAppInterface)localObject;
          if (paramCard == null) {
            continue;
          }
          paramString1 = paramCard.strNick;
          paramQQAppInterface = paramString1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("troop_member_card", 2, "getNickName, mFriendCard!=null, strNick=" + paramCard.strNick);
          paramQQAppInterface = paramString1;
          continue;
        }
        paramString1 = "";
      }
      catch (Exception paramQQAppInterface)
      {
        return paramString2;
      }
      continue;
      label322:
      paramString1 = "";
    }
    return paramString1;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    ProfileActivity.AllInOne localAllInOne = null;
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramIntent == null)) {}
    String str2;
    String str1;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("memberUin");
      str1 = paramIntent.getStringExtra("troopUin");
    } while (TextUtils.isEmpty(str2));
    Object localObject = ((amsw)paramQQAppInterface.getManager(51)).e(str2);
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(str1);
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localAllInOne = new ProfileActivity.AllInOne(str2, 20);
      localAllInOne.h = ((Friends)localObject).name;
      localAllInOne.i = ((Friends)localObject).remark;
      localAllInOne.c = str1;
      if (localTroopInfo != null)
      {
        paramQQAppInterface = localTroopInfo.troopcode;
        localAllInOne.d = paramQQAppInterface;
      }
    }
    for (paramQQAppInterface = localAllInOne;; paramQQAppInterface = (QQAppInterface)localObject)
    {
      paramQQAppInterface.a = aabc.a(str1, 1);
      paramIntent.putExtra("AllInOne", paramQQAppInterface);
      paramContext.startActivity(paramIntent);
      return;
      paramQQAppInterface = null;
      break;
      localObject = new ProfileActivity.AllInOne(str2, 21);
      ((ProfileActivity.AllInOne)localObject).c = str1;
      paramQQAppInterface = localAllInOne;
      if (localTroopInfo != null) {
        paramQQAppInterface = localTroopInfo.troopcode;
      }
      ((ProfileActivity.AllInOne)localObject).d = paramQQAppInterface;
      ((ProfileActivity.AllInOne)localObject).l = paramInt;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (((bfdm)paramQQAppInterface.getManager(203)).b(paramString2))
    {
      bezm.a(paramContext, paramString1, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramString1, paramString2, paramInt1, paramInt2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = ((amsw)paramQQAppInterface.getManager(51)).a(paramString2);
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramString1, false, false);
    if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
    {
      localObject1 = new ProfileActivity.AllInOne(paramString2, 20);
      ((ProfileActivity.AllInOne)localObject1).h = ((Friends)localObject2).name;
      ((ProfileActivity.AllInOne)localObject1).i = ((Friends)localObject2).remark;
      ((ProfileActivity.AllInOne)localObject1).c = paramString1;
      if (localTroopInfo != null)
      {
        paramQQAppInterface = localTroopInfo.troopcode;
        ((ProfileActivity.AllInOne)localObject1).d = paramQQAppInterface;
      }
    }
    for (paramQQAppInterface = (QQAppInterface)localObject1;; paramQQAppInterface = (QQAppInterface)localObject2)
    {
      paramQQAppInterface.a = aabc.a(paramString1, 1);
      localObject1 = new Intent(paramContext, FriendProfileCardActivity.class);
      ((Intent)localObject1).putExtra("AllInOne", paramQQAppInterface);
      ((Intent)localObject1).putExtra("troopUin", paramString1);
      ((Intent)localObject1).putExtra("memberUin", paramString2);
      ((Intent)localObject1).putExtra("fromFlag", paramInt1);
      if (paramBundle != null) {
        ((Intent)localObject1).putExtras(paramBundle);
      }
      if (!(paramContext instanceof Activity)) {
        break label252;
      }
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramInt2);
      return;
      paramQQAppInterface = null;
      break;
      localObject2 = new ProfileActivity.AllInOne(paramString2, 21);
      ((ProfileActivity.AllInOne)localObject2).c = paramString1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localTroopInfo != null) {
        paramQQAppInterface = localTroopInfo.troopcode;
      }
      ((ProfileActivity.AllInOne)localObject2).d = paramQQAppInterface;
      ((ProfileActivity.AllInOne)localObject2).l = 11;
    }
    label252:
    ((Intent)localObject1).setFlags(268435456);
    paramContext.startActivity((Intent)localObject1);
  }
  
  public static boolean a(TroopInfo paramTroopInfo, TroopMemberCard paramTroopMemberCard, TextView paramTextView)
  {
    if ((paramTroopInfo == null) || (paramTroopMemberCard == null) || (paramTextView == null)) {
      return false;
    }
    boolean bool1;
    label27:
    boolean bool2;
    label38:
    boolean bool3;
    label49:
    boolean bool5;
    String str;
    int i;
    if (!TextUtils.isEmpty(paramTroopMemberCard.mUniqueTitle))
    {
      bool1 = true;
      if (paramTroopMemberCard.memberRole != 3) {
        break label183;
      }
      bool2 = true;
      if (paramTroopMemberCard.memberRole != 2) {
        break label189;
      }
      bool3 = true;
      boolean bool4 = paramTroopInfo.isQidianPrivateTroop();
      bool5 = paramTroopInfo.isHomeworkTroop();
      if (!bool4) {
        break label195;
      }
      paramTroopMemberCard = beda.a().a(bool2, bool3);
      if (paramTroopMemberCard == null) {
        break label364;
      }
      str = paramTroopMemberCard.jdField_a_of_type_JavaLangString;
      i = paramTroopMemberCard.b;
    }
    for (;;)
    {
      label92:
      int j;
      if (1 == paramTroopInfo.cGroupRankUserFlag)
      {
        j = 1;
        label103:
        if ((bbyp.b()) || (j == 0))
        {
          str = "";
          if (!bool2) {
            break label348;
          }
          str = amtj.a(2131719288);
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label362;
        }
        paramTextView.setText(" " + str + " ");
        beda.a(paramTextView, i);
        return true;
        bool1 = false;
        break label27;
        label183:
        bool2 = false;
        break label38;
        label189:
        bool3 = false;
        break label49;
        label195:
        if ((bool5) && (!beyy.a(paramTroopMemberCard.titleId))) {
          break;
        }
        bedb localbedb = beda.a().a(paramTroopMemberCard.titleId, bool1, bool2, bool3);
        if (localbedb != null)
        {
          str = localbedb.jdField_a_of_type_JavaLangString;
          j = localbedb.b;
          if (localbedb.jdField_a_of_type_Int == 302) {
            str = paramTroopMemberCard.mUniqueTitle;
          }
          i = j;
          if (localbedb.jdField_a_of_type_Int != 315) {
            break label92;
          }
          str = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
          i = j;
          break label92;
        }
        if (paramTroopMemberCard.titleId != 315) {
          break label364;
        }
        str = (String)paramTroopInfo.getTroopLevelMap().get(Integer.valueOf(paramTroopMemberCard.realLevel));
        i = Color.parseColor("#8EBDF9");
        break label92;
        j = 0;
        break label103;
        label348:
        if (bool3) {
          str = amtj.a(2131719285);
        }
      }
      label362:
      break;
      label364:
      str = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynd
 * JD-Core Version:    0.7.0.1
 */
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.Arrays;

public class bfzz
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bgcz[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgcz.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bgab(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static ajvr a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ajvr localajvr = new ajvr();
    localajvr.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((anvk)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localajvr.jdField_b_of_type_JavaLangString = ContactUtils.getTroopMemberName(paramQQAppInterface, paramTroopMemberInfo.troopuin, localajvr.jdField_a_of_type_JavaLangString, true);
      localajvr.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localajvr.b(paramTroopMemberInfo.friendnick);
        localajvr.d(paramTroopMemberInfo.pyAll_friendnick);
        localajvr.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localajvr.e(((Friends)localObject).remark);
        localajvr.h(ChnToSpell.a(localajvr.jdField_j_of_type_JavaLangString, 1));
        localajvr.f(ChnToSpell.a(localajvr.jdField_j_of_type_JavaLangString, 2));
        localajvr.g(((Friends)localObject).remark);
        localajvr.i(paramTroopMemberInfo.troopnick);
        localajvr.a(paramTroopMemberInfo.troopColorNickId);
        localajvr.k(paramTroopMemberInfo.pyAll_troopnick);
        localajvr.j(paramTroopMemberInfo.pyFirst_troopnick);
        localajvr.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localajvr.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localajvr.jdField_b_of_type_Int = paramTroopMemberInfo.level;
        localajvr.jdField_d_of_type_Int = paramTroopMemberInfo.realLevel;
        localajvr.e = paramTroopMemberInfo.newRealLevel;
        localajvr.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localajvr.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localajvr.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localajvr.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localajvr.f = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopMemberInfo.troopuin, localajvr.jdField_a_of_type_JavaLangString);
        if ((d1 == -1000.0D) || (d1 == -100.0D)) {
          break label693;
        }
        double d2 = d1 / 1000.0D;
        d1 = d2;
        if (d2 < 0.01D) {
          d1 = 0.01D;
        }
        if (d1 <= 10.0D) {
          break label650;
        }
        localajvr.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localajvr.u = paramTroopMemberInfo.mUniqueTitle;
          localajvr.jdField_c_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localajvr.jdField_g_of_type_Int = paramTroopMemberInfo.mVipType;
        localajvr.jdField_h_of_type_Int = paramTroopMemberInfo.mVipLevel;
        localajvr.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajvr.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localajvr.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localajvr.jdField_l_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajvr.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localajvr), 2);
        localajvr.a(ChnToSpell.a(c(localajvr), 1));
        localajvr.v = c(localajvr);
        localajvr.x = localajvr.jdField_c_of_type_JavaLangString;
        localajvr.w = localajvr.jdField_d_of_type_JavaLangString;
        return localajvr;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label650:
        paramQQAppInterface = new DecimalFormat("#.##");
        localajvr.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label693:
        localajvr.t = "";
      }
    }
  }
  
  public static bgcz a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bgcz[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgcz.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new bgaa(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(ajvr paramajvr)
  {
    if (!TextUtils.isEmpty(paramajvr.m)) {
      return paramajvr.m;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_g_of_type_JavaLangString)) {
      return paramajvr.jdField_g_of_type_JavaLangString;
    }
    return paramajvr.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bgcz[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bgcz.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      int i = 0;
      while (i < paramEditText.length)
      {
        if (paramQQAppInterface.b(paramEditText[i].a())) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    String str = paramTroopInfo.Administrator;
    return (paramQQAppInterface.getCurrentAccountUin().equals(paramTroopInfo.troopowneruin)) || ((str != null) && (str.contains(paramQQAppInterface.getCurrentAccountUin())));
  }
  
  public static boolean a(String paramString, TroopInfo paramTroopInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopInfo == null)) {}
    do
    {
      return false;
      paramTroopInfo = paramTroopInfo.Administrator;
    } while ((paramTroopInfo == null) || (!paramTroopInfo.contains(paramString)));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.toLowerCase().contains(paramString2.toLowerCase());
  }
  
  public static int b(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bgcz[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgcz.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bgac(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(ajvr paramajvr)
  {
    if (!TextUtils.isEmpty(paramajvr.jdField_j_of_type_JavaLangString)) {
      return paramajvr.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_b_of_type_JavaLangString)) {
      return paramajvr.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajvr.m)) {
      return paramajvr.m;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_g_of_type_JavaLangString)) {
      return paramajvr.jdField_g_of_type_JavaLangString;
    }
    return paramajvr.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    return (paramTroopInfo.isNewTroop) && (paramTroopInfo.wMemberNum <= 20);
  }
  
  public static boolean b(String paramString, TroopInfo paramTroopInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopInfo == null)) {
      return false;
    }
    return paramString.equals(paramTroopInfo.troopowneruin);
  }
  
  public static String c(ajvr paramajvr)
  {
    if (!TextUtils.isEmpty(paramajvr.jdField_j_of_type_JavaLangString)) {
      return paramajvr.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajvr.m)) {
      return paramajvr.m;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_g_of_type_JavaLangString)) {
      return paramajvr.jdField_g_of_type_JavaLangString;
    }
    return paramajvr.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(ajvr paramajvr)
  {
    if (!TextUtils.isEmpty(paramajvr.jdField_k_of_type_JavaLangString)) {
      return paramajvr.jdField_k_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajvr.n)) {
      return paramajvr.n;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_h_of_type_JavaLangString)) {
      return paramajvr.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(ajvr paramajvr)
  {
    if (!TextUtils.isEmpty(paramajvr.jdField_l_of_type_JavaLangString)) {
      return paramajvr.jdField_l_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajvr.o)) {
      return paramajvr.o;
    }
    if (!TextUtils.isEmpty(paramajvr.jdField_i_of_type_JavaLangString)) {
      return paramajvr.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzz
 * JD-Core Version:    0.7.0.1
 */
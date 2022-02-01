import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class best
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bevq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bevq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new besv(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static ajac a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (amsw)paramQQAppInterface.getManager(51);
    ajac localajac = new ajac();
    localajac.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((amsw)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localajac.jdField_b_of_type_JavaLangString = ContactUtils.getTroopMemberName(paramQQAppInterface, paramTroopMemberInfo.troopuin, localajac.jdField_a_of_type_JavaLangString, true);
      localajac.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localajac.b(paramTroopMemberInfo.friendnick);
        localajac.d(paramTroopMemberInfo.pyAll_friendnick);
        localajac.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localajac.e(((Friends)localObject).remark);
        localajac.h(ChnToSpell.a(localajac.jdField_j_of_type_JavaLangString, 1));
        localajac.f(ChnToSpell.a(localajac.jdField_j_of_type_JavaLangString, 2));
        localajac.g(((Friends)localObject).remark);
        localajac.i(paramTroopMemberInfo.troopnick);
        localajac.k(paramTroopMemberInfo.pyAll_troopnick);
        localajac.j(paramTroopMemberInfo.pyFirst_troopnick);
        localajac.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localajac.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localajac.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localajac.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localajac.jdField_d_of_type_Int = paramTroopMemberInfo.newRealLevel;
        localajac.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localajac.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localajac.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localajac.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localajac.e = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localajac.jdField_a_of_type_JavaLangString);
        if ((d1 == -1000.0D) || (d1 == -100.0D)) {
          break label680;
        }
        double d2 = d1 / 1000.0D;
        d1 = d2;
        if (d2 < 0.01D) {
          d1 = 0.01D;
        }
        if (d1 <= 10.0D) {
          break label638;
        }
        localajac.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localajac.u = paramTroopMemberInfo.mUniqueTitle;
          localajac.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localajac.f = paramTroopMemberInfo.mVipType;
        localajac.jdField_g_of_type_Int = paramTroopMemberInfo.mVipLevel;
        localajac.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajac.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localajac.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localajac.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajac.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localajac), 2);
        localajac.a(ChnToSpell.a(c(localajac), 1));
        localajac.v = c(localajac);
        localajac.x = localajac.jdField_c_of_type_JavaLangString;
        localajac.w = localajac.jdField_d_of_type_JavaLangString;
        return localajac;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label638:
        paramQQAppInterface = new DecimalFormat("#.##");
        localajac.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label680:
        localajac.t = "";
      }
    }
  }
  
  public static bevq a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bevq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bevq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new besu(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(ajac paramajac)
  {
    if (!TextUtils.isEmpty(paramajac.m)) {
      return paramajac.m;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_g_of_type_JavaLangString)) {
      return paramajac.jdField_g_of_type_JavaLangString;
    }
    return paramajac.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bevq[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bevq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bfdm)paramQQAppInterface.getManager(203);
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
    paramEditText = (bevq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bevq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new besw(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(ajac paramajac)
  {
    if (!TextUtils.isEmpty(paramajac.jdField_j_of_type_JavaLangString)) {
      return paramajac.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_b_of_type_JavaLangString)) {
      return paramajac.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajac.m)) {
      return paramajac.m;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_g_of_type_JavaLangString)) {
      return paramajac.jdField_g_of_type_JavaLangString;
    }
    return paramajac.jdField_a_of_type_JavaLangString;
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
  
  public static String c(ajac paramajac)
  {
    if (!TextUtils.isEmpty(paramajac.jdField_j_of_type_JavaLangString)) {
      return paramajac.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajac.m)) {
      return paramajac.m;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_g_of_type_JavaLangString)) {
      return paramajac.jdField_g_of_type_JavaLangString;
    }
    return paramajac.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(ajac paramajac)
  {
    if (!TextUtils.isEmpty(paramajac.jdField_k_of_type_JavaLangString)) {
      return paramajac.jdField_k_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajac.n)) {
      return paramajac.n;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_h_of_type_JavaLangString)) {
      return paramajac.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(ajac paramajac)
  {
    if (!TextUtils.isEmpty(paramajac.l)) {
      return paramajac.l;
    }
    if (!TextUtils.isEmpty(paramajac.o)) {
      return paramajac.o;
    }
    if (!TextUtils.isEmpty(paramajac.jdField_i_of_type_JavaLangString)) {
      return paramajac.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     best
 * JD-Core Version:    0.7.0.1
 */
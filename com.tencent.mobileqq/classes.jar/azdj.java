import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.Arrays;

public class azdj
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (azef[])localEditable.getSpans(0, paramEditText.getSelectionStart(), azef.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new azdl(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static afou a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (ajjj)paramQQAppInterface.getManager(51);
    afou localafou = new afou();
    localafou.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((ajjj)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localafou.jdField_b_of_type_JavaLangString = babh.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localafou.jdField_a_of_type_JavaLangString, true);
      localafou.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localafou.b(paramTroopMemberInfo.friendnick);
        localafou.d(paramTroopMemberInfo.pyAll_friendnick);
        localafou.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localafou.e(((Friends)localObject).remark);
        localafou.h(ChnToSpell.a(localafou.jdField_j_of_type_JavaLangString, 1));
        localafou.f(ChnToSpell.a(localafou.jdField_j_of_type_JavaLangString, 2));
        localafou.g(((Friends)localObject).remark);
        localafou.i(paramTroopMemberInfo.troopnick);
        localafou.k(paramTroopMemberInfo.pyAll_troopnick);
        localafou.j(paramTroopMemberInfo.pyFirst_troopnick);
        localafou.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localafou.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localafou.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localafou.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localafou.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localafou.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localafou.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localafou.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localafou.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localafou.jdField_a_of_type_JavaLangString);
        if ((d1 == -1000.0D) || (d1 == -100.0D)) {
          break label671;
        }
        double d2 = d1 / 1000.0D;
        d1 = d2;
        if (d2 < 0.01D) {
          d1 = 0.01D;
        }
        if (d1 <= 10.0D) {
          break label629;
        }
        localafou.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localafou.u = paramTroopMemberInfo.mUniqueTitle;
          localafou.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localafou.e = paramTroopMemberInfo.mVipType;
        localafou.f = paramTroopMemberInfo.mVipLevel;
        localafou.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localafou.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localafou.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localafou.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localafou.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localafou), 2);
        localafou.a(ChnToSpell.a(c(localafou), 1));
        localafou.v = c(localafou);
        localafou.x = localafou.jdField_c_of_type_JavaLangString;
        localafou.w = localafou.jdField_d_of_type_JavaLangString;
        return localafou;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        localafou.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        localafou.t = "";
      }
    }
  }
  
  public static azef a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (azef[])localEditable.getSpans(0, paramEditText.getSelectionStart(), azef.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new azdk(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(afou paramafou)
  {
    if (!TextUtils.isEmpty(paramafou.m)) {
      return paramafou.m;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_g_of_type_JavaLangString)) {
      return paramafou.jdField_g_of_type_JavaLangString;
    }
    return paramafou.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (azef[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), azef.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (azks)paramQQAppInterface.getManager(203);
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
    paramEditText = (azef[])localEditable.getSpans(0, paramEditText.getSelectionStart(), azef.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new azdm(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(afou paramafou)
  {
    if (!TextUtils.isEmpty(paramafou.jdField_j_of_type_JavaLangString)) {
      return paramafou.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_b_of_type_JavaLangString)) {
      return paramafou.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramafou.m)) {
      return paramafou.m;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_g_of_type_JavaLangString)) {
      return paramafou.jdField_g_of_type_JavaLangString;
    }
    return paramafou.jdField_a_of_type_JavaLangString;
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
  
  public static String c(afou paramafou)
  {
    if (!TextUtils.isEmpty(paramafou.jdField_j_of_type_JavaLangString)) {
      return paramafou.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramafou.m)) {
      return paramafou.m;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_g_of_type_JavaLangString)) {
      return paramafou.jdField_g_of_type_JavaLangString;
    }
    return paramafou.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(afou paramafou)
  {
    if (!TextUtils.isEmpty(paramafou.k)) {
      return paramafou.k;
    }
    if (!TextUtils.isEmpty(paramafou.n)) {
      return paramafou.n;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_h_of_type_JavaLangString)) {
      return paramafou.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(afou paramafou)
  {
    if (!TextUtils.isEmpty(paramafou.l)) {
      return paramafou.l;
    }
    if (!TextUtils.isEmpty(paramafou.o)) {
      return paramafou.o;
    }
    if (!TextUtils.isEmpty(paramafou.jdField_i_of_type_JavaLangString)) {
      return paramafou.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdj
 * JD-Core Version:    0.7.0.1
 */
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

public class baee
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bafh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new baeg(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static agau a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (ajxn)paramQQAppInterface.getManager(51);
    agau localagau = new agau();
    localagau.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((ajxn)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localagau.jdField_b_of_type_JavaLangString = bbcl.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localagau.jdField_a_of_type_JavaLangString, true);
      localagau.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localagau.b(paramTroopMemberInfo.friendnick);
        localagau.d(paramTroopMemberInfo.pyAll_friendnick);
        localagau.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localagau.e(((Friends)localObject).remark);
        localagau.h(ChnToSpell.a(localagau.jdField_j_of_type_JavaLangString, 1));
        localagau.f(ChnToSpell.a(localagau.jdField_j_of_type_JavaLangString, 2));
        localagau.g(((Friends)localObject).remark);
        localagau.i(paramTroopMemberInfo.troopnick);
        localagau.k(paramTroopMemberInfo.pyAll_troopnick);
        localagau.j(paramTroopMemberInfo.pyFirst_troopnick);
        localagau.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localagau.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localagau.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localagau.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localagau.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localagau.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localagau.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localagau.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localagau.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localagau.jdField_a_of_type_JavaLangString);
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
        localagau.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localagau.u = paramTroopMemberInfo.mUniqueTitle;
          localagau.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localagau.e = paramTroopMemberInfo.mVipType;
        localagau.f = paramTroopMemberInfo.mVipLevel;
        localagau.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localagau.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localagau.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localagau.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localagau.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localagau), 2);
        localagau.a(ChnToSpell.a(c(localagau), 1));
        localagau.v = c(localagau);
        localagau.x = localagau.jdField_c_of_type_JavaLangString;
        localagau.w = localagau.jdField_d_of_type_JavaLangString;
        return localagau;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        localagau.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        localagau.t = "";
      }
    }
  }
  
  public static bafh a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bafh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new baef(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(agau paramagau)
  {
    if (!TextUtils.isEmpty(paramagau.m)) {
      return paramagau.m;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_g_of_type_JavaLangString)) {
      return paramagau.jdField_g_of_type_JavaLangString;
    }
    return paramagau.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bafh[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bafh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (balw)paramQQAppInterface.getManager(203);
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
    paramEditText = (bafh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new baeh(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(agau paramagau)
  {
    if (!TextUtils.isEmpty(paramagau.jdField_j_of_type_JavaLangString)) {
      return paramagau.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_b_of_type_JavaLangString)) {
      return paramagau.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagau.m)) {
      return paramagau.m;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_g_of_type_JavaLangString)) {
      return paramagau.jdField_g_of_type_JavaLangString;
    }
    return paramagau.jdField_a_of_type_JavaLangString;
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
  
  public static String c(agau paramagau)
  {
    if (!TextUtils.isEmpty(paramagau.jdField_j_of_type_JavaLangString)) {
      return paramagau.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagau.m)) {
      return paramagau.m;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_g_of_type_JavaLangString)) {
      return paramagau.jdField_g_of_type_JavaLangString;
    }
    return paramagau.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(agau paramagau)
  {
    if (!TextUtils.isEmpty(paramagau.k)) {
      return paramagau.k;
    }
    if (!TextUtils.isEmpty(paramagau.n)) {
      return paramagau.n;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_h_of_type_JavaLangString)) {
      return paramagau.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(agau paramagau)
  {
    if (!TextUtils.isEmpty(paramagau.l)) {
      return paramagau.l;
    }
    if (!TextUtils.isEmpty(paramagau.o)) {
      return paramagau.o;
    }
    if (!TextUtils.isEmpty(paramagau.jdField_i_of_type_JavaLangString)) {
      return paramagau.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baee
 * JD-Core Version:    0.7.0.1
 */
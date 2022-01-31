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

public class baes
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bafv[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafv.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new baeu(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static agas a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (ajxl)paramQQAppInterface.getManager(51);
    agas localagas = new agas();
    localagas.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((ajxl)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localagas.jdField_b_of_type_JavaLangString = bbcz.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localagas.jdField_a_of_type_JavaLangString, true);
      localagas.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localagas.b(paramTroopMemberInfo.friendnick);
        localagas.d(paramTroopMemberInfo.pyAll_friendnick);
        localagas.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localagas.e(((Friends)localObject).remark);
        localagas.h(ChnToSpell.a(localagas.jdField_j_of_type_JavaLangString, 1));
        localagas.f(ChnToSpell.a(localagas.jdField_j_of_type_JavaLangString, 2));
        localagas.g(((Friends)localObject).remark);
        localagas.i(paramTroopMemberInfo.troopnick);
        localagas.k(paramTroopMemberInfo.pyAll_troopnick);
        localagas.j(paramTroopMemberInfo.pyFirst_troopnick);
        localagas.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localagas.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localagas.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localagas.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localagas.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localagas.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localagas.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localagas.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localagas.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localagas.jdField_a_of_type_JavaLangString);
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
        localagas.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localagas.u = paramTroopMemberInfo.mUniqueTitle;
          localagas.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localagas.e = paramTroopMemberInfo.mVipType;
        localagas.f = paramTroopMemberInfo.mVipLevel;
        localagas.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localagas.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localagas.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localagas.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localagas.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localagas), 2);
        localagas.a(ChnToSpell.a(c(localagas), 1));
        localagas.v = c(localagas);
        localagas.x = localagas.jdField_c_of_type_JavaLangString;
        localagas.w = localagas.jdField_d_of_type_JavaLangString;
        return localagas;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        localagas.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        localagas.t = "";
      }
    }
  }
  
  public static bafv a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bafv[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafv.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new baet(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(agas paramagas)
  {
    if (!TextUtils.isEmpty(paramagas.m)) {
      return paramagas.m;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_g_of_type_JavaLangString)) {
      return paramagas.jdField_g_of_type_JavaLangString;
    }
    return paramagas.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bafv[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bafv.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bamk)paramQQAppInterface.getManager(203);
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
    paramEditText = (bafv[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bafv.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new baev(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(agas paramagas)
  {
    if (!TextUtils.isEmpty(paramagas.jdField_j_of_type_JavaLangString)) {
      return paramagas.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_b_of_type_JavaLangString)) {
      return paramagas.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagas.m)) {
      return paramagas.m;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_g_of_type_JavaLangString)) {
      return paramagas.jdField_g_of_type_JavaLangString;
    }
    return paramagas.jdField_a_of_type_JavaLangString;
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
  
  public static String c(agas paramagas)
  {
    if (!TextUtils.isEmpty(paramagas.jdField_j_of_type_JavaLangString)) {
      return paramagas.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramagas.m)) {
      return paramagas.m;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_g_of_type_JavaLangString)) {
      return paramagas.jdField_g_of_type_JavaLangString;
    }
    return paramagas.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(agas paramagas)
  {
    if (!TextUtils.isEmpty(paramagas.k)) {
      return paramagas.k;
    }
    if (!TextUtils.isEmpty(paramagas.n)) {
      return paramagas.n;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_h_of_type_JavaLangString)) {
      return paramagas.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(agas paramagas)
  {
    if (!TextUtils.isEmpty(paramagas.l)) {
      return paramagas.l;
    }
    if (!TextUtils.isEmpty(paramagas.o)) {
      return paramagas.o;
    }
    if (!TextUtils.isEmpty(paramagas.jdField_i_of_type_JavaLangString)) {
      return paramagas.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baes
 * JD-Core Version:    0.7.0.1
 */
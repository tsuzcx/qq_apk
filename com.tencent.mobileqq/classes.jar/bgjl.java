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

public class bgjl
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bgme[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgme.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bgjn(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static akfc a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (anyw)paramQQAppInterface.getManager(51);
    akfc localakfc = new akfc();
    localakfc.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((anyw)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localakfc.jdField_b_of_type_JavaLangString = bhlg.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localakfc.jdField_a_of_type_JavaLangString, true);
      localakfc.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localakfc.b(paramTroopMemberInfo.friendnick);
        localakfc.d(paramTroopMemberInfo.pyAll_friendnick);
        localakfc.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localakfc.e(((Friends)localObject).remark);
        localakfc.h(ChnToSpell.a(localakfc.jdField_j_of_type_JavaLangString, 1));
        localakfc.f(ChnToSpell.a(localakfc.jdField_j_of_type_JavaLangString, 2));
        localakfc.g(((Friends)localObject).remark);
        localakfc.i(paramTroopMemberInfo.troopnick);
        localakfc.k(paramTroopMemberInfo.pyAll_troopnick);
        localakfc.j(paramTroopMemberInfo.pyFirst_troopnick);
        localakfc.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localakfc.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localakfc.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localakfc.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localakfc.jdField_d_of_type_Int = paramTroopMemberInfo.newRealLevel;
        localakfc.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localakfc.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localakfc.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localakfc.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localakfc.e = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localakfc.jdField_a_of_type_JavaLangString);
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
        localakfc.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localakfc.u = paramTroopMemberInfo.mUniqueTitle;
          localakfc.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localakfc.f = paramTroopMemberInfo.mVipType;
        localakfc.jdField_g_of_type_Int = paramTroopMemberInfo.mVipLevel;
        localakfc.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localakfc.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localakfc.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localakfc.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localakfc.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localakfc), 2);
        localakfc.a(ChnToSpell.a(c(localakfc), 1));
        localakfc.v = c(localakfc);
        localakfc.x = localakfc.jdField_c_of_type_JavaLangString;
        localakfc.w = localakfc.jdField_d_of_type_JavaLangString;
        return localakfc;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label638:
        paramQQAppInterface = new DecimalFormat("#.##");
        localakfc.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label680:
        localakfc.t = "";
      }
    }
  }
  
  public static bgme a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bgme[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgme.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new bgjm(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(akfc paramakfc)
  {
    if (!TextUtils.isEmpty(paramakfc.m)) {
      return paramakfc.m;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_g_of_type_JavaLangString)) {
      return paramakfc.jdField_g_of_type_JavaLangString;
    }
    return paramakfc.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bgme[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bgme.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bgty)paramQQAppInterface.getManager(203);
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
    paramEditText = (bgme[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bgme.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bgjo(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(akfc paramakfc)
  {
    if (!TextUtils.isEmpty(paramakfc.jdField_j_of_type_JavaLangString)) {
      return paramakfc.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_b_of_type_JavaLangString)) {
      return paramakfc.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramakfc.m)) {
      return paramakfc.m;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_g_of_type_JavaLangString)) {
      return paramakfc.jdField_g_of_type_JavaLangString;
    }
    return paramakfc.jdField_a_of_type_JavaLangString;
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
  
  public static String c(akfc paramakfc)
  {
    if (!TextUtils.isEmpty(paramakfc.jdField_j_of_type_JavaLangString)) {
      return paramakfc.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramakfc.m)) {
      return paramakfc.m;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_g_of_type_JavaLangString)) {
      return paramakfc.jdField_g_of_type_JavaLangString;
    }
    return paramakfc.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(akfc paramakfc)
  {
    if (!TextUtils.isEmpty(paramakfc.jdField_k_of_type_JavaLangString)) {
      return paramakfc.jdField_k_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramakfc.n)) {
      return paramakfc.n;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_h_of_type_JavaLangString)) {
      return paramakfc.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(akfc paramakfc)
  {
    if (!TextUtils.isEmpty(paramakfc.l)) {
      return paramakfc.l;
    }
    if (!TextUtils.isEmpty(paramakfc.o)) {
      return paramakfc.o;
    }
    if (!TextUtils.isEmpty(paramakfc.jdField_i_of_type_JavaLangString)) {
      return paramakfc.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjl
 * JD-Core Version:    0.7.0.1
 */
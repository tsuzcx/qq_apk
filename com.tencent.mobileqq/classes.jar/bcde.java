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

public class bcde
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bceh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bceh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bcdg(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static ahyq a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (aloz)paramQQAppInterface.getManager(51);
    ahyq localahyq = new ahyq();
    localahyq.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((aloz)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localahyq.jdField_b_of_type_JavaLangString = bdbt.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localahyq.jdField_a_of_type_JavaLangString, true);
      localahyq.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localahyq.b(paramTroopMemberInfo.friendnick);
        localahyq.d(paramTroopMemberInfo.pyAll_friendnick);
        localahyq.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localahyq.e(((Friends)localObject).remark);
        localahyq.h(ChnToSpell.a(localahyq.jdField_j_of_type_JavaLangString, 1));
        localahyq.f(ChnToSpell.a(localahyq.jdField_j_of_type_JavaLangString, 2));
        localahyq.g(((Friends)localObject).remark);
        localahyq.i(paramTroopMemberInfo.troopnick);
        localahyq.k(paramTroopMemberInfo.pyAll_troopnick);
        localahyq.j(paramTroopMemberInfo.pyFirst_troopnick);
        localahyq.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localahyq.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localahyq.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localahyq.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localahyq.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localahyq.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localahyq.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localahyq.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localahyq.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localahyq.jdField_a_of_type_JavaLangString);
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
        localahyq.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localahyq.u = paramTroopMemberInfo.mUniqueTitle;
          localahyq.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localahyq.e = paramTroopMemberInfo.mVipType;
        localahyq.f = paramTroopMemberInfo.mVipLevel;
        localahyq.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localahyq.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localahyq.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localahyq.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localahyq.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localahyq), 2);
        localahyq.a(ChnToSpell.a(c(localahyq), 1));
        localahyq.v = c(localahyq);
        localahyq.x = localahyq.jdField_c_of_type_JavaLangString;
        localahyq.w = localahyq.jdField_d_of_type_JavaLangString;
        return localahyq;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        localahyq.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        localahyq.t = "";
      }
    }
  }
  
  public static bceh a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bceh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bceh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new bcdf(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(ahyq paramahyq)
  {
    if (!TextUtils.isEmpty(paramahyq.m)) {
      return paramahyq.m;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_g_of_type_JavaLangString)) {
      return paramahyq.jdField_g_of_type_JavaLangString;
    }
    return paramahyq.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bceh[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bceh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bckx)paramQQAppInterface.getManager(203);
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
    paramEditText = (bceh[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bceh.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bcdh(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(ahyq paramahyq)
  {
    if (!TextUtils.isEmpty(paramahyq.jdField_j_of_type_JavaLangString)) {
      return paramahyq.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_b_of_type_JavaLangString)) {
      return paramahyq.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramahyq.m)) {
      return paramahyq.m;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_g_of_type_JavaLangString)) {
      return paramahyq.jdField_g_of_type_JavaLangString;
    }
    return paramahyq.jdField_a_of_type_JavaLangString;
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
  
  public static String c(ahyq paramahyq)
  {
    if (!TextUtils.isEmpty(paramahyq.jdField_j_of_type_JavaLangString)) {
      return paramahyq.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramahyq.m)) {
      return paramahyq.m;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_g_of_type_JavaLangString)) {
      return paramahyq.jdField_g_of_type_JavaLangString;
    }
    return paramahyq.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(ahyq paramahyq)
  {
    if (!TextUtils.isEmpty(paramahyq.k)) {
      return paramahyq.k;
    }
    if (!TextUtils.isEmpty(paramahyq.n)) {
      return paramahyq.n;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_h_of_type_JavaLangString)) {
      return paramahyq.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(ahyq paramahyq)
  {
    if (!TextUtils.isEmpty(paramahyq.l)) {
      return paramahyq.l;
    }
    if (!TextUtils.isEmpty(paramahyq.o)) {
      return paramahyq.o;
    }
    if (!TextUtils.isEmpty(paramahyq.jdField_i_of_type_JavaLangString)) {
      return paramahyq.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcde
 * JD-Core Version:    0.7.0.1
 */
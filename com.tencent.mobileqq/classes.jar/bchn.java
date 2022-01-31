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

public class bchn
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bciq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bciq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bchp(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static aidf a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (alto)paramQQAppInterface.getManager(51);
    aidf localaidf = new aidf();
    localaidf.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((alto)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localaidf.jdField_b_of_type_JavaLangString = bdgc.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localaidf.jdField_a_of_type_JavaLangString, true);
      localaidf.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localaidf.b(paramTroopMemberInfo.friendnick);
        localaidf.d(paramTroopMemberInfo.pyAll_friendnick);
        localaidf.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localaidf.e(((Friends)localObject).remark);
        localaidf.h(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 1));
        localaidf.f(ChnToSpell.a(localaidf.jdField_j_of_type_JavaLangString, 2));
        localaidf.g(((Friends)localObject).remark);
        localaidf.i(paramTroopMemberInfo.troopnick);
        localaidf.k(paramTroopMemberInfo.pyAll_troopnick);
        localaidf.j(paramTroopMemberInfo.pyFirst_troopnick);
        localaidf.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localaidf.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localaidf.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localaidf.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localaidf.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localaidf.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localaidf.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localaidf.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localaidf.jdField_d_of_type_Int = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localaidf.jdField_a_of_type_JavaLangString);
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
        localaidf.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localaidf.u = paramTroopMemberInfo.mUniqueTitle;
          localaidf.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localaidf.e = paramTroopMemberInfo.mVipType;
        localaidf.f = paramTroopMemberInfo.mVipLevel;
        localaidf.jdField_g_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localaidf.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localaidf.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localaidf.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localaidf.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localaidf), 2);
        localaidf.a(ChnToSpell.a(c(localaidf), 1));
        localaidf.v = c(localaidf);
        localaidf.x = localaidf.jdField_c_of_type_JavaLangString;
        localaidf.w = localaidf.jdField_d_of_type_JavaLangString;
        return localaidf;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label629:
        paramQQAppInterface = new DecimalFormat("#.##");
        localaidf.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label671:
        localaidf.t = "";
      }
    }
  }
  
  public static bciq a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bciq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bciq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new bcho(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(aidf paramaidf)
  {
    if (!TextUtils.isEmpty(paramaidf.m)) {
      return paramaidf.m;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_g_of_type_JavaLangString)) {
      return paramaidf.jdField_g_of_type_JavaLangString;
    }
    return paramaidf.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bciq[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bciq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bcpg)paramQQAppInterface.getManager(203);
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
    paramEditText = (bciq[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bciq.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bchq(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(aidf paramaidf)
  {
    if (!TextUtils.isEmpty(paramaidf.jdField_j_of_type_JavaLangString)) {
      return paramaidf.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_b_of_type_JavaLangString)) {
      return paramaidf.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramaidf.m)) {
      return paramaidf.m;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_g_of_type_JavaLangString)) {
      return paramaidf.jdField_g_of_type_JavaLangString;
    }
    return paramaidf.jdField_a_of_type_JavaLangString;
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
  
  public static String c(aidf paramaidf)
  {
    if (!TextUtils.isEmpty(paramaidf.jdField_j_of_type_JavaLangString)) {
      return paramaidf.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramaidf.m)) {
      return paramaidf.m;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_g_of_type_JavaLangString)) {
      return paramaidf.jdField_g_of_type_JavaLangString;
    }
    return paramaidf.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(aidf paramaidf)
  {
    if (!TextUtils.isEmpty(paramaidf.k)) {
      return paramaidf.k;
    }
    if (!TextUtils.isEmpty(paramaidf.n)) {
      return paramaidf.n;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_h_of_type_JavaLangString)) {
      return paramaidf.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(aidf paramaidf)
  {
    if (!TextUtils.isEmpty(paramaidf.l)) {
      return paramaidf.l;
    }
    if (!TextUtils.isEmpty(paramaidf.o)) {
      return paramaidf.o;
    }
    if (!TextUtils.isEmpty(paramaidf.jdField_i_of_type_JavaLangString)) {
      return paramaidf.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchn
 * JD-Core Version:    0.7.0.1
 */
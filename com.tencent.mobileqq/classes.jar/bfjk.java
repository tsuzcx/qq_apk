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

public class bfjk
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bfmd[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bfmd.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bfjm(localEditable));
    return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static ajtt a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (anmw)paramQQAppInterface.getManager(51);
    ajtt localajtt = new ajtt();
    localajtt.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {}
    for (localObject = ((anmw)localObject).b(paramTroopMemberInfo.memberuin);; localObject = null)
    {
      localajtt.jdField_b_of_type_JavaLangString = bglf.c(paramQQAppInterface, paramTroopMemberInfo.troopuin, localajtt.jdField_a_of_type_JavaLangString, true);
      localajtt.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
      if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
      {
        localajtt.b(paramTroopMemberInfo.friendnick);
        localajtt.d(paramTroopMemberInfo.pyAll_friendnick);
        localajtt.c(paramTroopMemberInfo.pyFirst_friendnick);
      }
      double d1;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
      {
        localajtt.e(((Friends)localObject).remark);
        localajtt.h(ChnToSpell.a(localajtt.jdField_j_of_type_JavaLangString, 1));
        localajtt.f(ChnToSpell.a(localajtt.jdField_j_of_type_JavaLangString, 2));
        localajtt.g(((Friends)localObject).remark);
        localajtt.i(paramTroopMemberInfo.troopnick);
        localajtt.k(paramTroopMemberInfo.pyAll_troopnick);
        localajtt.j(paramTroopMemberInfo.pyFirst_troopnick);
        localajtt.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
        localajtt.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
        localajtt.jdField_a_of_type_Int = paramTroopMemberInfo.level;
        localajtt.jdField_c_of_type_Int = paramTroopMemberInfo.realLevel;
        localajtt.jdField_d_of_type_Int = paramTroopMemberInfo.newRealLevel;
        localajtt.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
        localajtt.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
        localajtt.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
        localajtt.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
        localajtt.e = paramTroopMemberInfo.globalTroopLevel;
        d1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramTroopMemberInfo.troopuin, localajtt.jdField_a_of_type_JavaLangString);
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
        localajtt.t = ((int)d1 + "km");
      }
      for (;;)
      {
        if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
        {
          localajtt.u = paramTroopMemberInfo.mUniqueTitle;
          localajtt.jdField_b_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
        }
        localajtt.f = paramTroopMemberInfo.mVipType;
        localajtt.jdField_g_of_type_Int = paramTroopMemberInfo.mVipLevel;
        localajtt.jdField_h_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajtt.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
        localajtt.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
        localajtt.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
        localajtt.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localajtt), 2);
        localajtt.a(ChnToSpell.a(c(localajtt), 1));
        localajtt.v = c(localajtt);
        localajtt.x = localajtt.jdField_c_of_type_JavaLangString;
        localajtt.w = localajtt.jdField_d_of_type_JavaLangString;
        return localajtt;
        if ((paramTroopMemberInfo.autoremark == null) || (paramTroopMemberInfo.autoremark.length() <= 0) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
        break;
        label638:
        paramQQAppInterface = new DecimalFormat("#.##");
        localajtt.t = (paramQQAppInterface.format(d1) + "km");
        continue;
        label680:
        localajtt.t = "";
      }
    }
  }
  
  public static bfmd a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (bfmd[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bfmd.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return null;
    }
    Arrays.sort(paramEditText, new bfjl(localEditable));
    return paramEditText[(paramEditText.length - 1)];
  }
  
  public static String a(ajtt paramajtt)
  {
    if (!TextUtils.isEmpty(paramajtt.m)) {
      return paramajtt.m;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_g_of_type_JavaLangString)) {
      return paramajtt.jdField_g_of_type_JavaLangString;
    }
    return paramajtt.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (bfmd[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), bfmd.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {}
    for (;;)
    {
      return false;
      paramQQAppInterface = (bftx)paramQQAppInterface.getManager(203);
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
    paramEditText = (bfmd[])localEditable.getSpans(0, paramEditText.getSelectionStart(), bfmd.class);
    if ((paramEditText == null) || (paramEditText.length == 0)) {
      return -1;
    }
    Arrays.sort(paramEditText, new bfjn(localEditable));
    return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
  }
  
  public static String b(ajtt paramajtt)
  {
    if (!TextUtils.isEmpty(paramajtt.jdField_j_of_type_JavaLangString)) {
      return paramajtt.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_b_of_type_JavaLangString)) {
      return paramajtt.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajtt.m)) {
      return paramajtt.m;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_g_of_type_JavaLangString)) {
      return paramajtt.jdField_g_of_type_JavaLangString;
    }
    return paramajtt.jdField_a_of_type_JavaLangString;
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
  
  public static String c(ajtt paramajtt)
  {
    if (!TextUtils.isEmpty(paramajtt.jdField_j_of_type_JavaLangString)) {
      return paramajtt.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajtt.m)) {
      return paramajtt.m;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_g_of_type_JavaLangString)) {
      return paramajtt.jdField_g_of_type_JavaLangString;
    }
    return paramajtt.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(ajtt paramajtt)
  {
    if (!TextUtils.isEmpty(paramajtt.jdField_k_of_type_JavaLangString)) {
      return paramajtt.jdField_k_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramajtt.n)) {
      return paramajtt.n;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_h_of_type_JavaLangString)) {
      return paramajtt.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(ajtt paramajtt)
  {
    if (!TextUtils.isEmpty(paramajtt.l)) {
      return paramajtt.l;
    }
    if (!TextUtils.isEmpty(paramajtt.o)) {
      return paramajtt.o;
    }
    if (!TextUtils.isEmpty(paramajtt.jdField_i_of_type_JavaLangString)) {
      return paramajtt.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjk
 * JD-Core Version:    0.7.0.1
 */
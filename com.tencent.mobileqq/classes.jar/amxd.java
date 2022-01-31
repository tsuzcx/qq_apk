import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amxd
{
  private static amxb a;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 += 1L;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    String str1 = paramQQAppInterface.getAccount();
    a = amxa.a(paramQQAppInterface);
    int k = amxc.a(localBaseApplication, str1);
    long l = amxc.a(localBaseApplication, str1);
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", uinType = " + paramInt + ", selfUin = " + str1 + ", time = " + paramLong1 + ", msgseq = " + paramLong2 + ", msgUid = " + paramLong3 + ", times = " + k + ", lastShowTime = " + l);
    }
    int i;
    if (AudioHelper.a(10) == 1)
    {
      i = 1;
      j = i;
      if (i != 0)
      {
        AudioHelper.a(ajjy.a(2131649031) + a.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(a.jdField_a_of_type_JavaLangString)) {
          break label483;
        }
      }
    }
    label483:
    for (int j = 1;; j = 0)
    {
      if (((a.jdField_a_of_type_Boolean) && (k < a.jdField_a_of_type_Int) && (paramLong1 - l > 30L) && (!paramString2.equals(str1))) || (j != 0))
      {
        String str2 = a.jdField_a_of_type_JavaLangString;
        String str3 = str2 + a.b;
        paramString1 = new aqax(paramString1, paramString2, str3, paramInt, -5040, 3276801, paramLong1);
        paramString1.d = (String.valueOf(paramLong2) + "_" + String.valueOf(paramLong1));
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocGrayTipsUtils", 2, "addGrayTipMsg grayTipParam.grayTipKey = " + paramString1.d);
        }
        paramString2 = new Bundle();
        paramString2.putInt("key_action", 1);
        paramString2.putString("key_action_DATA", a.c);
        paramString1.a(str2.length(), str3.length(), paramString2);
        paramString2 = new MessageForUniteGrayTip();
        paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
        if (aqay.a(paramQQAppInterface, paramString2))
        {
          amxc.b(localBaseApplication, str1, k + 1);
          amxc.b(localBaseApplication, str1, paramLong1);
          amxi.a("0X80094AA");
        }
      }
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(String paramString)
  {
    if (a == null) {
      a = amxa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    if (paramString.equals(a.c)) {
      amxi.a("0X80094AB");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */
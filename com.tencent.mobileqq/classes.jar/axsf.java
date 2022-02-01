import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class axsf
{
  public static void a(QQAppInterface paramQQAppInterface) {}
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      String str3 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      String str4 = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str2))
      {
        long l1 = axsr.b(str2);
        long l2 = axsr.a(str2);
        if ((axsr.b(l1)) && (l2 >= 0L))
        {
          String str5 = axsr.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bdll.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E4", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipExposure id:" + str2 + " willDowngradeSoon:" + str3 + " grayID:" + paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt, String paramString)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      paramQQAppInterface = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClickWebLink id:" + paramQQAppInterface + " willDowngradeSoon:" + paramMessageForUniteGrayTip + " url:" + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axtj paramaxtj)
  {
    if (paramaxtj != null)
    {
      bdll.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", axsr.a(paramaxtj.a, paramaxtj.b), (int)(paramaxtj.a * 10L + paramaxtj.b), 0, "" + paramaxtj.h, "", "", "");
      switch ((int)paramaxtj.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramaxtj, paramQQAppInterface, "C2C_click");
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      bdll.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "" + paramaxtj.h, "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axtj paramaxtj1, axtj paramaxtj2)
  {
    if (paramaxtj1 != null) {
      bdll.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", axsr.a(paramaxtj1.a, paramaxtj1.b), (int)(paramaxtj1.a * 10L + paramaxtj1.b), 0, "" + paramaxtj1.h, "", "", "");
    }
    if (paramaxtj2 != null) {
      bdll.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", axsr.a(paramaxtj2.a, paramaxtj2.b), (int)(paramaxtj2.a * 10L + paramaxtj2.b), 0, "" + paramaxtj2.h, "", "", "");
    }
    bdll.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      String str3 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      String str4 = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str2))
      {
        long l1 = axsr.b(str2);
        long l2 = axsr.a(str2);
        if ((axsr.b(l1)) && (l2 >= 0L))
        {
          String str5 = axsr.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bdll.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E5", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str2 + " willDowngradeSoon:" + str3 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsf
 * JD-Core Version:    0.7.0.1
 */
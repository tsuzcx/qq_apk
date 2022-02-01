import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class axlo
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
        long l1 = axma.b(str2);
        long l2 = axma.a(str2);
        if ((axma.b(l1)) && (l2 >= 0L))
        {
          String str5 = axma.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bdla.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E4", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axms paramaxms)
  {
    if (paramaxms != null)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", axma.a(paramaxms.a, paramaxms.b), (int)(paramaxms.a * 10L + paramaxms.b), 0, "" + paramaxms.h, "", "", "");
      switch ((int)paramaxms.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramaxms, paramQQAppInterface, "C2C_click");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "" + paramaxms.h, "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axms paramaxms1, axms paramaxms2)
  {
    if (paramaxms1 != null) {
      bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", axma.a(paramaxms1.a, paramaxms1.b), (int)(paramaxms1.a * 10L + paramaxms1.b), 0, "" + paramaxms1.h, "", "", "");
    }
    if (paramaxms2 != null) {
      bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", axma.a(paramaxms2.a, paramaxms2.b), (int)(paramaxms2.a * 10L + paramaxms2.b), 0, "" + paramaxms2.h, "", "", "");
    }
    bdla.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = axma.b(str2);
        long l2 = axma.a(str2);
        if ((axma.b(l1)) && (l2 >= 0L))
        {
          String str5 = axma.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bdla.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E5", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str2 + " willDowngradeSoon:" + str3 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlo
 * JD-Core Version:    0.7.0.1
 */
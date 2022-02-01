import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class awzm
{
  public static void a(QQAppInterface paramQQAppInterface) {}
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str1))
      {
        long l1 = awzy.b(str1);
        long l2 = awzy.a(str1);
        if ((awzy.b(l1)) && (l2 >= 0L)) {
          bcst.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", awzy.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipExposure id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt, String paramString)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      paramQQAppInterface = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClickWebLink id:" + paramQQAppInterface + " willDowngradeSoon:" + paramMessageForUniteGrayTip + " url:" + paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axap paramaxap)
  {
    if (paramaxap != null)
    {
      bcst.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", awzy.a(paramaxap.a, paramaxap.b), (int)(paramaxap.a * 10L + paramaxap.b), 0, "", "", "", "");
      switch ((int)paramaxap.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramaxap, paramQQAppInterface, "C2C_click");
      bcst.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      bcst.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      bcst.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axap paramaxap1, axap paramaxap2)
  {
    if (paramaxap1 != null) {
      bcst.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", awzy.a(paramaxap1.a, paramaxap1.b), (int)(paramaxap1.a * 10L + paramaxap1.b), 0, "", "", "", "");
    }
    if (paramaxap2 != null) {
      bcst.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", awzy.a(paramaxap2.a, paramaxap2.b), (int)(paramaxap2.a * 10L + paramaxap2.b), 0, "", "", "", "");
    }
    bcst.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str1))
      {
        long l1 = awzy.b(str1);
        long l2 = awzy.a(str1);
        if ((awzy.b(l1)) && (l2 >= 0L)) {
          bcst.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", awzy.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzm
 * JD-Core Version:    0.7.0.1
 */
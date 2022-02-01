import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class awfm
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
        long l1 = awfy.b(str2);
        long l2 = awfy.a(str2);
        if ((awfy.b(l1)) && (l2 >= 0L))
        {
          String str5 = awfy.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bcef.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E4", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, awgq paramawgq)
  {
    if (paramawgq != null)
    {
      bcef.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", awfy.a(paramawgq.a, paramawgq.b), (int)(paramawgq.a * 10L + paramawgq.b), 0, "" + paramawgq.h, "", "", "");
      switch ((int)paramawgq.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramawgq, paramQQAppInterface, "C2C_click");
      bcef.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      bcef.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      bcef.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "" + paramawgq.h, "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, awgq paramawgq1, awgq paramawgq2)
  {
    if (paramawgq1 != null) {
      bcef.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", awfy.a(paramawgq1.a, paramawgq1.b), (int)(paramawgq1.a * 10L + paramawgq1.b), 0, "" + paramawgq1.h, "", "", "");
    }
    if (paramawgq2 != null) {
      bcef.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", awfy.a(paramawgq2.a, paramawgq2.b), (int)(paramawgq2.a * 10L + paramawgq2.b), 0, "" + paramawgq2.h, "", "", "");
    }
    bcef.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = awfy.b(str2);
        long l2 = awfy.a(str2);
        if ((awfy.b(l1)) && (l2 >= 0L))
        {
          String str5 = awfy.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          bcef.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E5", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str2 + " willDowngradeSoon:" + str3 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfm
 * JD-Core Version:    0.7.0.1
 */
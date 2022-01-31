import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class ausg
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
        long l1 = auss.b(str1);
        long l2 = auss.a(str1);
        if ((auss.b(l1)) && (l2 >= 0L)) {
          azqs.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", auss.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, autj paramautj)
  {
    if (paramautj != null)
    {
      azqs.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", auss.a(paramautj.a, paramautj.b), (int)(paramautj.a * 10L + paramautj.b), 0, "", "", "", "");
      switch ((int)paramautj.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramautj, paramQQAppInterface, "C2C_click");
      azqs.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      azqs.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      azqs.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, autj paramautj1, autj paramautj2)
  {
    if (paramautj1 != null) {
      azqs.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", auss.a(paramautj1.a, paramautj1.b), (int)(paramautj1.a * 10L + paramautj1.b), 0, "", "", "", "");
    }
    if (paramautj2 != null) {
      azqs.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", auss.a(paramautj2.a, paramautj2.b), (int)(paramautj2.a * 10L + paramautj2.b), 0, "", "", "", "");
    }
    azqs.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = auss.b(str1);
        long l2 = auss.a(str1);
        if ((auss.b(l1)) && (l2 >= 0L)) {
          azqs.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", auss.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausg
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class aunx
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
        long l1 = auoj.b(str1);
        long l2 = auoj.a(str1);
        if ((auoj.b(l1)) && (l2 >= 0L)) {
          azmj.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", auoj.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aupa paramaupa)
  {
    if (paramaupa != null)
    {
      azmj.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", auoj.a(paramaupa.a, paramaupa.b), (int)(paramaupa.a * 10L + paramaupa.b), 0, "", "", "", "");
      switch ((int)paramaupa.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramaupa, paramQQAppInterface, "C2C_click");
      azmj.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      azmj.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      azmj.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aupa paramaupa1, aupa paramaupa2)
  {
    if (paramaupa1 != null) {
      azmj.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", auoj.a(paramaupa1.a, paramaupa1.b), (int)(paramaupa1.a * 10L + paramaupa1.b), 0, "", "", "", "");
    }
    if (paramaupa2 != null) {
      azmj.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", auoj.a(paramaupa2.a, paramaupa2.b), (int)(paramaupa2.a * 10L + paramaupa2.b), 0, "", "", "", "");
    }
    azmj.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = auoj.b(str1);
        long l2 = auoj.a(str1);
        if ((auoj.b(l1)) && (l2 >= 0L)) {
          azmj.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", auoj.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aunx
 * JD-Core Version:    0.7.0.1
 */
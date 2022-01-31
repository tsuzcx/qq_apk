import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class asxa
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
        long l1 = asxm.b(str1);
        long l2 = asxm.a(str1);
        if ((asxm.b(l1)) && (l2 >= 0L)) {
          axqy.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", asxm.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, asyd paramasyd)
  {
    if (paramasyd != null)
    {
      axqy.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", asxm.a(paramasyd.a, paramasyd.b), (int)(paramasyd.a * 10L + paramasyd.b), 0, "", "", "", "");
      switch ((int)paramasyd.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramasyd, paramQQAppInterface, "C2C_click");
      axqy.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      axqy.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      axqy.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, asyd paramasyd1, asyd paramasyd2)
  {
    if (paramasyd1 != null) {
      axqy.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", asxm.a(paramasyd1.a, paramasyd1.b), (int)(paramasyd1.a * 10L + paramasyd1.b), 0, "", "", "", "");
    }
    if (paramasyd2 != null) {
      axqy.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", asxm.a(paramasyd2.a, paramasyd2.b), (int)(paramasyd2.a * 10L + paramasyd2.b), 0, "", "", "", "");
    }
    axqy.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = asxm.b(str1);
        long l2 = asxm.a(str1);
        if ((asxm.b(l1)) && (l2 >= 0L)) {
          axqy.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", asxm.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxa
 * JD-Core Version:    0.7.0.1
 */
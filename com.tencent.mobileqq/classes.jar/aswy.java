import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class aswy
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
        long l1 = asxk.b(str1);
        long l2 = asxk.a(str1);
        if ((asxk.b(l1)) && (l2 >= 0L)) {
          axqw.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E4", asxk.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, asyb paramasyb)
  {
    if (paramasyb != null)
    {
      axqw.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", asxk.a(paramasyb.a, paramasyb.b), (int)(paramasyb.a * 10L + paramasyb.b), 0, "", "", "", "");
      switch ((int)paramasyb.a)
      {
      }
    }
    for (;;)
    {
      VipUtils.a(paramString, paramasyb, paramQQAppInterface, "C2C_click");
      axqw.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
      axqw.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
      return;
      axqw.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, asyb paramasyb1, asyb paramasyb2)
  {
    if (paramasyb1 != null) {
      axqw.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", asxk.a(paramasyb1.a, paramasyb1.b), (int)(paramasyb1.a * 10L + paramasyb1.b), 0, "", "", "", "");
    }
    if (paramasyb2 != null) {
      axqw.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", asxk.a(paramasyb2.a, paramasyb2.b), (int)(paramasyb2.a * 10L + paramasyb2.b), 0, "", "", "", "");
    }
    axqw.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
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
        long l1 = asxk.b(str1);
        long l2 = asxk.a(str1);
        if ((asxk.b(l1)) && (l2 >= 0L)) {
          axqw.b(paramQQAppInterface, "dc00898", "", paramMessageForUniteGrayTip, "0X800A7E5", asxk.a(l1, l2), (int)(l1 * 10L + l2), 0, "", "", "", "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkBusinessLogicHelper", 2, "reportMutualMarkGrayTipClick id:" + str1 + " willDowngradeSoon:" + str2 + " grayID:" + paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aswy
 * JD-Core Version:    0.7.0.1
 */
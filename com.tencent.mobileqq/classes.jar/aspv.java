import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class aspv
{
  private static aspv a;
  
  public static aspv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aspv();
      }
      return a;
    }
    finally {}
  }
  
  public aslt a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewAdapterBuilder", 2, "getAdapter panelType = " + paramInt2);
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      return null;
    case 1: 
      return new assh(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr, paramBaseChatPie, paramInt4);
    case 6: 
      return new aslv(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramBaseChatPie, paramInt4);
    case 8: 
      return new asme(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    case 7: 
      return new asox(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    case 4: 
      return new asqo(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr, paramBaseChatPie);
    case 5: 
      return new asra(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    case 3: 
      return new asro(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr, paramInt4, paramBoolean);
    case 2: 
      return new asrx(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramBaseChatPie, paramInt4);
    case 9: 
      return new assa(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr, paramInt4);
    case 12: 
      return new asov(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramasmr);
    case 13: 
      return new asmh(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr, paramBaseChatPie);
    }
    return new aspa(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspv
 * JD-Core Version:    0.7.0.1
 */
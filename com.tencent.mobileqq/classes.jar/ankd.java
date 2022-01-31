import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class ankd
{
  private static ankd a;
  
  public static ankd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ankd();
      }
      return a;
    }
    finally {}
  }
  
  public angu a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anhs paramanhs, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new anmd(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs, paramBaseChatPie, paramInt4);
    case 6: 
      return new angw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramBaseChatPie, paramInt4);
    case 8: 
      return new anhf(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    case 7: 
      return new anji(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    case 4: 
      return new ankm(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs, paramBaseChatPie);
    case 5: 
      return new ankw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs);
    case 3: 
      return new anlk(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs, paramInt4, paramBoolean);
    case 2: 
      return new anlt(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramBaseChatPie, paramInt4);
    case 9: 
      return new anlw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs, paramInt4);
    case 12: 
      return new anjg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanhs);
    }
    return new anhi(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankd
 * JD-Core Version:    0.7.0.1
 */
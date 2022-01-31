import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class aoam
{
  private static aoam a;
  
  public static aoam a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aoam();
      }
      return a;
    }
    finally {}
  }
  
  public anxd a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyb paramanyb, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new aocn(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb, paramBaseChatPie, paramInt4);
    case 6: 
      return new anxf(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramBaseChatPie, paramInt4);
    case 8: 
      return new anxo(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramInt4);
    case 7: 
      return new anzr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramInt4);
    case 4: 
      return new aoav(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb, paramBaseChatPie);
    case 5: 
      return new aobg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb);
    case 3: 
      return new aobu(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb, paramInt4, paramBoolean);
    case 2: 
      return new aocd(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramBaseChatPie, paramInt4);
    case 9: 
      return new aocg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb, paramInt4);
    case 12: 
      return new anzp(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyb);
    }
    return new anxr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoam
 * JD-Core Version:    0.7.0.1
 */
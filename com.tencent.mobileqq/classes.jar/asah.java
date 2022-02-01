import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class asah
{
  private static asah a;
  
  public static asah a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new asah();
      }
      return a;
    }
    finally {}
  }
  
  public arwf a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, arxd paramarxd, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new asct(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd, paramBaseChatPie, paramInt4);
    case 6: 
      return new arwh(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramBaseChatPie, paramInt4);
    case 8: 
      return new arwq(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramInt4);
    case 7: 
      return new arzj(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramInt4);
    case 4: 
      return new asba(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd, paramBaseChatPie);
    case 5: 
      return new asbm(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd);
    case 3: 
      return new asca(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd, paramInt4, paramBoolean);
    case 2: 
      return new ascj(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramBaseChatPie, paramInt4);
    case 9: 
      return new ascm(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd, paramInt4);
    case 12: 
      return new arzh(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramarxd);
    case 13: 
      return new arwt(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd, paramBaseChatPie);
    }
    return new arzm(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramarxd, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asah
 * JD-Core Version:    0.7.0.1
 */
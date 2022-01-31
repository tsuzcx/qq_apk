import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class apwx
{
  private static apwx a;
  
  public static apwx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new apwx();
      }
      return a;
    }
    finally {}
  }
  
  public apte a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, apuc paramapuc, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new apyy(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc, paramBaseChatPie, paramInt4);
    case 6: 
      return new aptg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramBaseChatPie, paramInt4);
    case 8: 
      return new aptp(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramInt4);
    case 7: 
      return new apwc(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramInt4);
    case 4: 
      return new apxg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc, paramBaseChatPie);
    case 5: 
      return new apxr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc);
    case 3: 
      return new apyf(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc, paramInt4, paramBoolean);
    case 2: 
      return new apyo(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramBaseChatPie, paramInt4);
    case 9: 
      return new apyr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc, paramInt4);
    case 12: 
      return new apwa(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramapuc);
    }
    return new apts(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwx
 * JD-Core Version:    0.7.0.1
 */
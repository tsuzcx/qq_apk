import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class aoar
{
  private static aoar a;
  
  public static aoar a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aoar();
      }
      return a;
    }
    finally {}
  }
  
  public anxi a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyg paramanyg, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new aocs(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg, paramBaseChatPie, paramInt4);
    case 6: 
      return new anxk(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramBaseChatPie, paramInt4);
    case 8: 
      return new anxt(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    case 7: 
      return new anzw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    case 4: 
      return new aoba(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg, paramBaseChatPie);
    case 5: 
      return new aobl(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg);
    case 3: 
      return new aobz(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg, paramInt4, paramBoolean);
    case 2: 
      return new aoci(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramBaseChatPie, paramInt4);
    case 9: 
      return new aocl(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg, paramInt4);
    case 12: 
      return new anzu(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramanyg);
    }
    return new anxw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyg, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoar
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class apso
{
  private static apso a;
  
  public static apso a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new apso();
      }
      return a;
    }
    finally {}
  }
  
  public apov a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, appt paramappt, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
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
      return new apup(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt, paramBaseChatPie, paramInt4);
    case 6: 
      return new apox(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramBaseChatPie, paramInt4);
    case 8: 
      return new appg(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    case 7: 
      return new aprt(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    case 4: 
      return new apsx(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt, paramBaseChatPie);
    case 5: 
      return new apti(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt);
    case 3: 
      return new aptw(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt, paramInt4, paramBoolean);
    case 2: 
      return new apuf(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramBaseChatPie, paramInt4);
    case 9: 
      return new apui(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt, paramInt4);
    case 12: 
      return new aprr(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramappt);
    }
    return new appj(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramappt, paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apso
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import java.util.List;

public class aygk
  implements aygj
{
  private int a(List<PlusPanelAppInfo> paramList)
  {
    if (paramList.size() > 0)
    {
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        if (209 == ((PlusPanelAppInfo)paramList.get(i)).getAppID()) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(aygw paramaygw, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (((paramaygw instanceof ayhc)) && (!((ayhc)paramaygw).a()))
    {
      paramaygw.b(1000000006);
      if (!bbyp.a()) {
        paramaygw.b(219);
      }
      paramQQAppInterface = paramaygw.a();
      paramInt = a(paramQQAppInterface);
      if (paramInt >= 0)
      {
        paramString = (PlusPanelAppInfo)paramQQAppInterface.get(paramInt);
        paramaygw.b(209);
        if (paramQQAppInterface.size() >= 10) {
          break label91;
        }
        paramQQAppInterface.add(paramString);
      }
    }
    return;
    label91:
    paramQQAppInterface.add(10, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygk
 * JD-Core Version:    0.7.0.1
 */
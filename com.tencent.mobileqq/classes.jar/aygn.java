import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import java.util.Iterator;
import java.util.List;

public abstract class aygn
  implements aygj
{
  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a(aygw paramaygw, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (bcoo.a())
    {
      paramaygw = paramaygw.a().iterator();
      while (paramaygw.hasNext()) {
        if (!a(((PlusPanelAppInfo)paramaygw.next()).getAppID(), a())) {
          paramaygw.remove();
        }
      }
    }
  }
  
  protected abstract int[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygn
 * JD-Core Version:    0.7.0.1
 */
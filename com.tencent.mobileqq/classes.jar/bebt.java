import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class bebt
{
  private bebu a;
  
  public bebt(bebu parambebu)
  {
    this.a = parambebu;
  }
  
  public void a(int paramInt)
  {
    label348:
    try
    {
      localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      Iterator localIterator1;
      localException.printStackTrace();
      return;
      return;
    }
    finally
    {
      if (this.a == null) {
        break label348;
      }
      this.a.a();
    }
    localObject1 = new becj((QQAppInterface)localObject1).a(1L);
    if (localObject1 != null)
    {
      localIterator1 = ((List)localObject1).iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (beco)localIterator1.next();
        if ((((beco)localObject1).b == paramInt) && (((beco)localObject1).a != null))
        {
          Iterator localIterator2 = ((beco)localObject1).a.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject3 = (becn)localIterator2.next();
            if (!TextUtils.isEmpty(((becn)localObject3).i))
            {
              localObject1 = ((becn)localObject3).f;
              if (!TextUtils.isEmpty(((becn)localObject3).g)) {
                localObject1 = ((becn)localObject3).g;
              }
              if (localObject1 != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQProtect.QSec", 2, String.format("ExtraInfo: %s path: %s", new Object[] { ((becn)localObject3).i, localObject1 }));
                }
                localObject3 = new JSONObject(((becn)localObject3).i);
                int i = ((JSONObject)localObject3).getInt("id");
                int j = ((JSONObject)localObject3).getInt("type");
                int k = ((JSONObject)localObject3).getInt("flag");
                int m = ((JSONObject)localObject3).getInt("mode");
                localObject3 = ((JSONObject)localObject3).getString("ver");
                if (this.a != null) {
                  this.a.a((String)localObject1, (String)localObject3, i, j, k, m);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bebt
 * JD-Core Version:    0.7.0.1
 */
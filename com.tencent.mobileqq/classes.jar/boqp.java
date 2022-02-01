import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class boqp
  implements BusinessObserver
{
  public void a(double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "handleChangeMapViewAngle= " + paramDouble1 + "|" + paramDouble2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onGetLBSPoiList, isSuccess  = " + paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, "onGetRedPackPage, isSuccess  = " + paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void f(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, new Object[] { "onUpdata, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        return;
        c(paramBoolean, paramBundle);
        return;
        d(paramBoolean, paramBundle);
        return;
        e(paramBoolean, paramBundle);
        return;
        f(paramBoolean, paramBundle);
        return;
        b(paramBoolean, paramBundle);
        return;
        a(paramBoolean, paramBundle);
        return;
      } while (paramBundle == null);
      a(paramBundle.getDouble("latitude"), paramBundle.getDouble("longitude"));
      return;
    }
    ArrayList localArrayList = null;
    paramInt = i;
    if (paramBundle != null)
    {
      localArrayList = paramBundle.getStringArrayList("key_lbs_template_ids");
      paramInt = paramBundle.getInt("key_lbs_template_cookie", -1);
    }
    a(paramInt, paramBoolean, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqp
 * JD-Core Version:    0.7.0.1
 */
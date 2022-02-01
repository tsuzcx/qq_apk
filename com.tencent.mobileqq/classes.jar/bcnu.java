import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bcnu
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("KidModeObserver", 1, new Object[] { "unknown type: ", Integer.valueOf(paramInt) });
      }
      return;
    case 3: 
      b(paramBoolean, paramBundle);
      return;
    case 4: 
      a(paramBoolean, paramBundle);
      return;
    case 1: 
      paramInt = paramBundle.getInt("advance_setting_field");
      paramBundle.getInt("advance_setting_value");
      a(paramBoolean, paramInt);
      return;
    case 2: 
      e(paramBoolean, paramBundle);
      return;
    case 5: 
      d(paramBoolean, paramBundle);
      return;
    }
    c(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnu
 * JD-Core Version:    0.7.0.1
 */
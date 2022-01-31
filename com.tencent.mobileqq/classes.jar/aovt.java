import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aovt
  extends aouf<aovs>
{
  @NonNull
  public static aovs c()
  {
    aovs localaovs2 = (aovs)aoks.a().a(562);
    aovs localaovs1 = localaovs2;
    if (localaovs2 == null) {
      localaovs1 = aovs.a();
    }
    return localaovs1;
  }
  
  public int a()
  {
    return 562;
  }
  
  @NonNull
  public aovs a()
  {
    return aovs.a();
  }
  
  @NonNull
  public aovs a(@NonNull aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.ConfigProcessor", 1, paramArrayOfaoko[0].a);
    }
    return aovs.a(paramArrayOfaoko[0].a);
  }
  
  public Class<aovs> a()
  {
    return aovs.class;
  }
  
  @NonNull
  public aovs b()
  {
    return aovs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovt
 * JD-Core Version:    0.7.0.1
 */
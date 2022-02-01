import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class arml
  extends armf<armi>
{
  @NonNull
  public static armi c()
  {
    armi localarmi2 = (armi)aran.a().a(541);
    armi localarmi1 = localarmi2;
    if (localarmi2 == null) {
      localarmi1 = armi.a();
    }
    return localarmi1;
  }
  
  @NonNull
  public armi a()
  {
    return armi.a();
  }
  
  @NonNull
  public armi a(@NonNull araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfaraj[0].a);
    }
    return armi.a(paramArrayOfaraj[0].a);
  }
  
  @NonNull
  public armi b()
  {
    return armi.a();
  }
  
  public Class<armi> clazz()
  {
    return armi.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arml
 * JD-Core Version:    0.7.0.1
 */
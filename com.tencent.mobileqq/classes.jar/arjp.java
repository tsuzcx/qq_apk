import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class arjp
  extends arjj<arjm>
{
  @NonNull
  public static arjm c()
  {
    arjm localarjm2 = (arjm)aqxe.a().a(541);
    arjm localarjm1 = localarjm2;
    if (localarjm2 == null) {
      localarjm1 = arjm.a();
    }
    return localarjm1;
  }
  
  @NonNull
  public arjm a()
  {
    return arjm.a();
  }
  
  @NonNull
  public arjm a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfaqxa[0].a);
    }
    return arjm.a(paramArrayOfaqxa[0].a);
  }
  
  @NonNull
  public arjm b()
  {
    return arjm.a();
  }
  
  public Class<arjm> clazz()
  {
    return arjm.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjp
 * JD-Core Version:    0.7.0.1
 */
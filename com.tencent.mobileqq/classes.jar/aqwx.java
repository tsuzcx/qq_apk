import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqwx
  extends aqwr<aqwu>
{
  @NonNull
  public static aqwu c()
  {
    aqwu localaqwu2 = (aqwu)aqlk.a().a(541);
    aqwu localaqwu1 = localaqwu2;
    if (localaqwu2 == null) {
      localaqwu1 = aqwu.a();
    }
    return localaqwu1;
  }
  
  @NonNull
  public aqwu a()
  {
    return aqwu.a();
  }
  
  @NonNull
  public aqwu a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfaqlg[0].a);
    }
    return aqwu.a(paramArrayOfaqlg[0].a);
  }
  
  @NonNull
  public aqwu b()
  {
    return aqwu.a();
  }
  
  public Class<aqwu> clazz()
  {
    return aqwu.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwx
 * JD-Core Version:    0.7.0.1
 */
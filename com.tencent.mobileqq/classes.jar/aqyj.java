import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqyj
  extends aqwr<aqyi>
{
  @NonNull
  public static aqyi c()
  {
    aqyi localaqyi2 = (aqyi)aqlk.a().a(562);
    aqyi localaqyi1 = localaqyi2;
    if (localaqyi2 == null) {
      localaqyi1 = aqyi.a();
    }
    return localaqyi1;
  }
  
  @NonNull
  public aqyi a()
  {
    return aqyi.a();
  }
  
  @NonNull
  public aqyi a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.ConfigProcessor", 1, paramArrayOfaqlg[0].a);
    }
    return aqyi.a(paramArrayOfaqlg[0].a);
  }
  
  @NonNull
  public aqyi b()
  {
    return aqyi.a();
  }
  
  public Class<aqyi> clazz()
  {
    return aqyi.class;
  }
  
  public int type()
  {
    return 562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyj
 * JD-Core Version:    0.7.0.1
 */
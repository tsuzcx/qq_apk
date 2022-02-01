import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqhy
  extends aqgc<aqhx>
{
  @NonNull
  public static aqhx c()
  {
    aqhx localaqhx2 = (aqhx)apub.a().a(562);
    aqhx localaqhx1 = localaqhx2;
    if (localaqhx2 == null) {
      localaqhx1 = aqhx.a();
    }
    return localaqhx1;
  }
  
  @NonNull
  public aqhx a()
  {
    return aqhx.a();
  }
  
  @NonNull
  public aqhx a(@NonNull aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.ConfigProcessor", 1, paramArrayOfaptx[0].a);
    }
    return aqhx.a(paramArrayOfaptx[0].a);
  }
  
  @NonNull
  public aqhx b()
  {
    return aqhx.a();
  }
  
  public Class<aqhx> clazz()
  {
    return aqhx.class;
  }
  
  public int type()
  {
    return 562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhy
 * JD-Core Version:    0.7.0.1
 */
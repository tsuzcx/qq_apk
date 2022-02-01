import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqyu
  extends aqwr<aqyo>
{
  @NonNull
  public static aqyo c()
  {
    aqyo localaqyo2 = (aqyo)aqlk.a().a(628);
    aqyo localaqyo1 = localaqyo2;
    if (localaqyo2 == null) {
      localaqyo1 = aqyo.a();
    }
    return localaqyo1;
  }
  
  @NonNull
  public aqyo a()
  {
    return aqyo.a();
  }
  
  @NonNull
  public aqyo a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.TROOP_FILE.ConfigProcessor", 1, paramArrayOfaqlg[0].a);
    }
    return aqyo.a(paramArrayOfaqlg[0].a);
  }
  
  @NonNull
  public aqyo b()
  {
    return aqyo.a();
  }
  
  public Class<aqyo> clazz()
  {
    return aqyo.class;
  }
  
  public int type()
  {
    return 628;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyu
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqgi
  extends aqgc<aqgf>
{
  @NonNull
  public static aqgf c()
  {
    aqgf localaqgf2 = (aqgf)apub.a().a(541);
    aqgf localaqgf1 = localaqgf2;
    if (localaqgf2 == null) {
      localaqgf1 = aqgf.a();
    }
    return localaqgf1;
  }
  
  @NonNull
  public aqgf a()
  {
    return aqgf.a();
  }
  
  @NonNull
  public aqgf a(@NonNull aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KC.ConfigProcessor", 1, paramArrayOfaptx[0].a);
    }
    return aqgf.a(paramArrayOfaptx[0].a);
  }
  
  @NonNull
  public aqgf b()
  {
    return aqgf.a();
  }
  
  public Class<aqgf> clazz()
  {
    return aqgf.class;
  }
  
  public int type()
  {
    return 541;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgi
 * JD-Core Version:    0.7.0.1
 */
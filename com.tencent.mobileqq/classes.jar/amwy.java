import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwy
  extends ampb<amwx>
{
  public int a()
  {
    return 361;
  }
  
  @NonNull
  public amwx a(int paramInt)
  {
    return new amwx();
  }
  
  @Nullable
  public amwx a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amwx localamwx = amwx.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamwx;
    }
    return null;
  }
  
  public Class<amwx> a()
  {
    return amwx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwx paramamwx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramamwx.toString());
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwy
 * JD-Core Version:    0.7.0.1
 */
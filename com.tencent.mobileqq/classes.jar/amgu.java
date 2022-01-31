import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgu
  extends alzl<amgt>
{
  public int a()
  {
    return 361;
  }
  
  @NonNull
  public amgt a(int paramInt)
  {
    return new amgt();
  }
  
  @Nullable
  public amgt a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amgt localamgt = amgt.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamgt;
    }
    return null;
  }
  
  public Class<amgt> a()
  {
    return amgt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amgt paramamgt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramamgt.toString());
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
 * Qualified Name:     amgu
 * JD-Core Version:    0.7.0.1
 */
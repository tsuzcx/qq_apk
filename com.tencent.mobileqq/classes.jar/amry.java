import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amry
  extends ampb<amrx>
{
  public static amrx a()
  {
    return (amrx)ampm.a().a(452);
  }
  
  public int a()
  {
    return 452;
  }
  
  @NonNull
  public amrx a(int paramInt)
  {
    return new amrx().b("0");
  }
  
  @Nullable
  public amrx a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amrx localamrx = amrx.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamrx;
    }
    return null;
  }
  
  public Class<amrx> a()
  {
    return amrx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amrx paramamrx) {}
  
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
 * Qualified Name:     amry
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvm
  extends ampb<amvl>
{
  public static amvl a()
  {
    return (amvl)ampm.a().a(292);
  }
  
  public int a()
  {
    return 292;
  }
  
  @NonNull
  public amvl a(int paramInt)
  {
    return new amvl();
  }
  
  @Nullable
  public amvl a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfampi);
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfampi[0].a);
      }
      return amvl.a(paramArrayOfampi[0].a);
    }
    return null;
  }
  
  public Class<amvl> a()
  {
    return amvl.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvl paramamvl) {}
  
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
 * Qualified Name:     amvm
 * JD-Core Version:    0.7.0.1
 */
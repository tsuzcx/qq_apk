import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwg
  extends ampb<amwe>
{
  public int a()
  {
    return 418;
  }
  
  @NonNull
  public amwe a(int paramInt)
  {
    return new amwe();
  }
  
  @Nullable
  public amwe a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      new amwe();
      return amwe.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amwe> a()
  {
    return amwe.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwe paramamwe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramamwe.toString());
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     amwg
 * JD-Core Version:    0.7.0.1
 */
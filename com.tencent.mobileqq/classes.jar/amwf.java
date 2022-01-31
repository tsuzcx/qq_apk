import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwf
  extends ampa<amwd>
{
  public int a()
  {
    return 418;
  }
  
  @NonNull
  public amwd a(int paramInt)
  {
    return new amwd();
  }
  
  @Nullable
  public amwd a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      new amwd();
      return amwd.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amwd> a()
  {
    return amwd.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwd paramamwd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramamwd.toString());
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
 * Qualified Name:     amwf
 * JD-Core Version:    0.7.0.1
 */
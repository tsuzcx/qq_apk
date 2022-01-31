import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgc
  extends alzl<amga>
{
  public int a()
  {
    return 418;
  }
  
  @NonNull
  public amga a(int paramInt)
  {
    return new amga();
  }
  
  @Nullable
  public amga a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      new amga();
      return amga.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amga> a()
  {
    return amga.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amga paramamga)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramamga.toString());
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
 * Qualified Name:     amgc
 * JD-Core Version:    0.7.0.1
 */
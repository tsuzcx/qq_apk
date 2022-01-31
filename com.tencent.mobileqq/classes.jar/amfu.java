import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfu
  extends alzl<amft>
{
  public static amft a()
  {
    return (amft)alzw.a().a(426);
  }
  
  public int a()
  {
    return 426;
  }
  
  @NonNull
  public amft a(int paramInt)
  {
    return new amft();
  }
  
  @Nullable
  public amft a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      new amft();
      return amft.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amft> a()
  {
    return amft.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amft paramamft)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKShareConfProcessor", 2, "onUpdate " + paramamft.toString());
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
 * Qualified Name:     amfu
 * JD-Core Version:    0.7.0.1
 */
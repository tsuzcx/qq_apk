import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgw
  extends alzl<amgv>
{
  public int a()
  {
    return 207;
  }
  
  @NonNull
  public amgv a(int paramInt)
  {
    return new amgv();
  }
  
  @Nullable
  public amgv a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amgv localamgv = amgv.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfalzs[0].a);
      }
      return localamgv;
    }
    return null;
  }
  
  public Class<amgv> a()
  {
    return amgv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amgv paramamgv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramamgv.toString());
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
 * Qualified Name:     amgw
 * JD-Core Version:    0.7.0.1
 */
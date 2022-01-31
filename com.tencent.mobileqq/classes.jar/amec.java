import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amec
  extends alzl<ameb>
{
  public int a()
  {
    return 488;
  }
  
  @NonNull
  public ameb a(int paramInt)
  {
    return new ameb();
  }
  
  @Nullable
  public ameb a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      ameb localameb = ameb.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localameb;
    }
    return null;
  }
  
  public Class<ameb> a()
  {
    return ameb.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(ameb paramameb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramameb.toString());
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
 * Qualified Name:     amec
 * JD-Core Version:    0.7.0.1
 */
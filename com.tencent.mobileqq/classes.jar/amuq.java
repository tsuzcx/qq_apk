import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amuq
  extends ampb<amup>
{
  public int a()
  {
    return 390;
  }
  
  @NonNull
  public amup a(int paramInt)
  {
    return new amup();
  }
  
  @Nullable
  public amup a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amup localamup = amup.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamup;
    }
    return new amup();
  }
  
  public Class<amup> a()
  {
    return amup.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amup paramamup)
  {
    ((asep)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramamup);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramamup);
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
 * Qualified Name:     amuq
 * JD-Core Version:    0.7.0.1
 */
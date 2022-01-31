import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amek
  extends alzl<amej>
{
  public int a()
  {
    return 390;
  }
  
  @NonNull
  public amej a(int paramInt)
  {
    return new amej();
  }
  
  @Nullable
  public amej a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amej localamej = amej.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamej;
    }
    return new amej();
  }
  
  public Class<amej> a()
  {
    return amej.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amej paramamej)
  {
    ((arin)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramamej);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramamej);
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
 * Qualified Name:     amek
 * JD-Core Version:    0.7.0.1
 */
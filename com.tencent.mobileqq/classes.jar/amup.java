import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amup
  extends ampa<amuo>
{
  public int a()
  {
    return 390;
  }
  
  @NonNull
  public amuo a(int paramInt)
  {
    return new amuo();
  }
  
  @Nullable
  public amuo a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amuo localamuo = amuo.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamuo;
    }
    return new amuo();
  }
  
  public Class<amuo> a()
  {
    return amuo.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amuo paramamuo)
  {
    ((aser)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramamuo);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramamuo);
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
 * Qualified Name:     amup
 * JD-Core Version:    0.7.0.1
 */
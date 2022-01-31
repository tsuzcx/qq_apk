import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aolt
  extends aofy<aols>
{
  public int a()
  {
    return 390;
  }
  
  @NonNull
  public aols a(int paramInt)
  {
    return new aols();
  }
  
  @Nullable
  public aols a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aols localaols = aols.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaols;
    }
    return new aols();
  }
  
  public Class<aols> a()
  {
    return aols.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aols paramaols)
  {
    ((atvr)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramaols);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramaols);
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
 * Qualified Name:     aolt
 * JD-Core Version:    0.7.0.1
 */
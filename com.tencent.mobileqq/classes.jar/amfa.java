import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfa
  extends alzl<amez>
{
  public static amez a()
  {
    return (amez)alzw.a().a(441);
  }
  
  public int a()
  {
    return 441;
  }
  
  @NonNull
  public amez a(int paramInt)
  {
    return new amez();
  }
  
  @Nullable
  public amez a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      new amez();
      return amez.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amez> a()
  {
    return amez.class;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amez paramamez)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramamez.toString());
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
 * Qualified Name:     amfa
 * JD-Core Version:    0.7.0.1
 */
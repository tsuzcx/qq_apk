import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosn
  extends aokh<aosm>
{
  public int a()
  {
    return 361;
  }
  
  @NonNull
  public aosm a(int paramInt)
  {
    return new aosm();
  }
  
  @Nullable
  public aosm a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aosm localaosm = aosm.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaosm;
    }
    return null;
  }
  
  public Class<aosm> a()
  {
    return aosm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aosm paramaosm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramaosm.toString());
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
 * Qualified Name:     aosn
 * JD-Core Version:    0.7.0.1
 */
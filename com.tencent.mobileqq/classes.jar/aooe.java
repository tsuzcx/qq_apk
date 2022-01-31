import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooe
  extends aofy<aood>
{
  public int a()
  {
    return 361;
  }
  
  @NonNull
  public aood a(int paramInt)
  {
    return new aood();
  }
  
  @Nullable
  public aood a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aood localaood = aood.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaood;
    }
    return null;
  }
  
  public Class<aood> a()
  {
    return aood.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aood paramaood)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramaood.toString());
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
 * Qualified Name:     aooe
 * JD-Core Version:    0.7.0.1
 */
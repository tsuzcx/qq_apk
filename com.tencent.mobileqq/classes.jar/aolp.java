import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aolp
  extends aokh<aolq>
{
  public int a()
  {
    return 597;
  }
  
  @NonNull
  public aolq a(int paramInt)
  {
    return new aolq();
  }
  
  @Nullable
  public aolq a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aolq localaolq = aolq.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaolq;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    ajfv.a(true);
    return null;
  }
  
  public Class<aolq> a()
  {
    return aolq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    ajfv.a(true);
  }
  
  public void a(aolq paramaolq)
  {
    if (paramaolq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramaolq.toString());
    }
    ajfv.a(true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "migrateOldVersion");
    }
    ajfv.a(true);
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
 * Qualified Name:     aolp
 * JD-Core Version:    0.7.0.1
 */
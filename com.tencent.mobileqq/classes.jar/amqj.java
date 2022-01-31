import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amqj
  extends ampb<amqk>
{
  public int a()
  {
    return 597;
  }
  
  @NonNull
  public amqk a(int paramInt)
  {
    return new amqk();
  }
  
  @Nullable
  public amqk a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amqk localamqk = amqk.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamqk;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    ahjz.a(true);
    return null;
  }
  
  public Class<amqk> a()
  {
    return amqk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    ahjz.a(true);
  }
  
  public void a(amqk paramamqk)
  {
    if (paramamqk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramamqk.toString());
    }
    ahjz.a(true);
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
    ahjz.a(true);
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
 * Qualified Name:     amqj
 * JD-Core Version:    0.7.0.1
 */
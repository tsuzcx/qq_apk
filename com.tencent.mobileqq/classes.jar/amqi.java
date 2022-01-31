import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amqi
  extends ampa<amqj>
{
  public int a()
  {
    return 597;
  }
  
  @NonNull
  public amqj a(int paramInt)
  {
    return new amqj();
  }
  
  @Nullable
  public amqj a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amqj localamqj = amqj.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamqj;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    ahjx.a(true);
    return null;
  }
  
  public Class<amqj> a()
  {
    return amqj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    ahjx.a(true);
  }
  
  public void a(amqj paramamqj)
  {
    if (paramamqj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramamqj.toString());
    }
    ahjx.a(true);
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
    ahjx.a(true);
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
 * Qualified Name:     amqi
 * JD-Core Version:    0.7.0.1
 */
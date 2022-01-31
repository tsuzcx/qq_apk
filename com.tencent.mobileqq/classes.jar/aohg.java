import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aohg
  extends aofy<aohh>
{
  public int a()
  {
    return 597;
  }
  
  @NonNull
  public aohh a(int paramInt)
  {
    return new aohh();
  }
  
  @Nullable
  public aohh a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aohh localaohh = aohh.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaohh;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    ajbg.a(true);
    return null;
  }
  
  public Class<aohh> a()
  {
    return aohh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    ajbg.a(true);
  }
  
  public void a(aohh paramaohh)
  {
    if (paramaohh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramaohh.toString());
    }
    ajbg.a(true);
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
    ajbg.a(true);
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
 * Qualified Name:     aohg
 * JD-Core Version:    0.7.0.1
 */
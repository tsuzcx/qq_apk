import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoko
  extends aofy<aokn>
{
  public int a()
  {
    return 578;
  }
  
  @NonNull
  public aokn a(int paramInt)
  {
    return new aokn();
  }
  
  @Nullable
  public aokn a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aokn localaokn = aokn.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaokn;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aokn> a()
  {
    return aokn.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aokn paramaokn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onUpdate " + paramaokn.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     aoko
 * JD-Core Version:    0.7.0.1
 */
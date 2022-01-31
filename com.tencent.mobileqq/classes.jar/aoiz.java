import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoiz
  extends aofy<aoiy>
{
  public int a()
  {
    return 528;
  }
  
  @NonNull
  public aoiy a(int paramInt)
  {
    return new aoiy();
  }
  
  @Nullable
  public aoiy a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aoiy localaoiy = aoiy.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaoiy;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aoiy> a()
  {
    return aoiy.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aoiy paramaoiy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramaoiy.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     aoiz
 * JD-Core Version:    0.7.0.1
 */
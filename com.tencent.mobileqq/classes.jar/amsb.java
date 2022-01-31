import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsb
  extends ampa<amsa>
{
  public int a()
  {
    return 528;
  }
  
  @NonNull
  public amsa a(int paramInt)
  {
    return new amsa();
  }
  
  @Nullable
  public amsa a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amsa localamsa = amsa.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamsa;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amsa> a()
  {
    return amsa.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsa paramamsa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramamsa.toString());
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
 * Qualified Name:     amsb
 * JD-Core Version:    0.7.0.1
 */
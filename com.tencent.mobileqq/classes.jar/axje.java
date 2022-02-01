import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class axje
  extends arac<axjf>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    if (b) {
      return a;
    }
    b = true;
    a = b();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean b()
  {
    axjf localaxjf2 = (axjf)aran.a().a(522);
    axjf localaxjf1 = localaxjf2;
    if (localaxjf2 == null)
    {
      localaxjf2 = new axjf();
      localaxjf1 = localaxjf2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localaxjf1 = localaxjf2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localaxjf1);
    }
    return localaxjf1.a();
  }
  
  @NonNull
  public axjf a(int paramInt)
  {
    return new axjf();
  }
  
  @Nullable
  public axjf a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfaraj[0].a);
      }
      return axjf.a(paramArrayOfaraj[0].a);
    }
    return new axjf();
  }
  
  public void a(axjf paramaxjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramaxjf);
    }
    if (paramaxjf != null) {
      a = paramaxjf.a();
    }
  }
  
  public Class<axjf> clazz()
  {
    return axjf.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public int type()
  {
    return 522;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axje
 * JD-Core Version:    0.7.0.1
 */
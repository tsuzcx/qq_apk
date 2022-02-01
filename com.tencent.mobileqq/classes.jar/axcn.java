import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class axcn
  extends aqwt<axco>
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
    axco localaxco2 = (axco)aqxe.a().a(522);
    axco localaxco1 = localaxco2;
    if (localaxco2 == null)
    {
      localaxco2 = new axco();
      localaxco1 = localaxco2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localaxco1 = localaxco2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localaxco1);
    }
    return localaxco1.a();
  }
  
  @NonNull
  public axco a(int paramInt)
  {
    return new axco();
  }
  
  @Nullable
  public axco a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfaqxa[0].a);
      }
      return axco.a(paramArrayOfaqxa[0].a);
    }
    return new axco();
  }
  
  public void a(axco paramaxco)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramaxco);
    }
    if (paramaxco != null) {
      a = paramaxco.a();
    }
  }
  
  public Class<axco> clazz()
  {
    return axco.class;
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
 * Qualified Name:     axcn
 * JD-Core Version:    0.7.0.1
 */
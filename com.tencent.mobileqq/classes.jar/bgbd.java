import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bgbd
  extends aqwt<bgbc>
{
  @NonNull
  public bgbc a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bgbc();
  }
  
  @Nullable
  public bgbc a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bgbc.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bgbc parambgbc) {}
  
  public Class<bgbc> clazz()
  {
    return bgbc.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
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
    QLog.d("TroopShortcutBarConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbd
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bgkp
  extends arac<bgko>
{
  @NonNull
  public bgko a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bgko();
  }
  
  @Nullable
  public bgko a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bgko.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(bgko parambgko) {}
  
  public Class<bgko> clazz()
  {
    return bgko.class;
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
 * Qualified Name:     bgkp
 * JD-Core Version:    0.7.0.1
 */
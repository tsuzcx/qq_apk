import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfme
  extends arac<bfmd>
{
  @NonNull
  public bfmd a(int paramInt)
  {
    QLog.d("TroopBlockConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfmd();
  }
  
  @Nullable
  public bfmd a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bfmd.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(bfmd parambfmd) {}
  
  public Class<bfmd> clazz()
  {
    return bfmd.class;
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
    QLog.d("TroopBlockConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 673;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfme
 * JD-Core Version:    0.7.0.1
 */
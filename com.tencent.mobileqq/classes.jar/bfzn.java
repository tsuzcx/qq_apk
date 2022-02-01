import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfzn
  extends arac<bfzm>
{
  @NonNull
  public bfzm a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfzm();
  }
  
  @Nullable
  public bfzm a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bfzm.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(bfzm parambfzm) {}
  
  public Class<bfzm> clazz()
  {
    return bfzm.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 605;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzn
 * JD-Core Version:    0.7.0.1
 */
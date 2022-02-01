import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfpy
  extends aqwt<bfpx>
{
  @NonNull
  public bfpx a(int paramInt)
  {
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfpx();
  }
  
  @Nullable
  public bfpx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfpx.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bfpx parambfpx) {}
  
  public Class<bfpx> clazz()
  {
    return bfpx.class;
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
 * Qualified Name:     bfpy
 * JD-Core Version:    0.7.0.1
 */
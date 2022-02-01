import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfcr
  extends aqwt<bfcq>
{
  @NonNull
  public bfcq a(int paramInt)
  {
    QLog.d("TroopBlockConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfcq();
  }
  
  @Nullable
  public bfcq a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfcq.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(bfcq parambfcq) {}
  
  public Class<bfcq> clazz()
  {
    return bfcq.class;
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
 * Qualified Name:     bfcr
 * JD-Core Version:    0.7.0.1
 */
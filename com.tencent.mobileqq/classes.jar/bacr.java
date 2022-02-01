import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bacr
  extends aqwt<bacq>
{
  @NonNull
  public bacq a(int paramInt)
  {
    QLog.d("TroopFansEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bacq();
  }
  
  @Nullable
  public bacq a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bacq.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bacq parambacq) {}
  
  public Class<bacq> clazz()
  {
    return bacq.class;
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
    QLog.d("TroopFansEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 701;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bacr
 * JD-Core Version:    0.7.0.1
 */
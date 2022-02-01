import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class bfcl
  extends aqwt<bfck>
{
  @NonNull
  public bfck a(int paramInt)
  {
    QLog.d("TroopAssociationsEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfck();
  }
  
  @Nullable
  public bfck a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfck.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bfck parambfck) {}
  
  public Class<bfck> clazz()
  {
    return bfck.class;
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
    QLog.d("TroopAssociationsEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 686;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcl
 * JD-Core Version:    0.7.0.1
 */
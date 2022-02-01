import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bffa
  extends arac<bfez>
{
  @NonNull
  public bfez a(int paramInt)
  {
    QLog.d("TroopActiveRankingConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bfez();
  }
  
  @Nullable
  public bfez a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopActiveRankingConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bfez.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(bfez parambfez) {}
  
  public Class<bfez> clazz()
  {
    return bfez.class;
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
    QLog.d("TroopActiveRankingConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 664;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffa
 * JD-Core Version:    0.7.0.1
 */
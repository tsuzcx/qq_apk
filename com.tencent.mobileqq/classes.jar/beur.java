import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class beur
  extends aqwt<beuq>
{
  @NonNull
  public beuq a(int paramInt)
  {
    QLog.d("TroopActiveRankingConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new beuq();
  }
  
  @Nullable
  public beuq a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopActiveRankingConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return beuq.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(beuq parambeuq) {}
  
  public Class<beuq> clazz()
  {
    return beuq.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beur
 * JD-Core Version:    0.7.0.1
 */
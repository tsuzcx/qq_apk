import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdno
  extends aptq<bdnn>
{
  @NonNull
  public bdnn a(int paramInt)
  {
    QLog.d("TroopActiveRankingConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bdnn();
  }
  
  @Nullable
  public bdnn a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopActiveRankingConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return bdnn.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(bdnn parambdnn) {}
  
  public Class<bdnn> clazz()
  {
    return bdnn.class;
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
 * Qualified Name:     bdno
 * JD-Core Version:    0.7.0.1
 */
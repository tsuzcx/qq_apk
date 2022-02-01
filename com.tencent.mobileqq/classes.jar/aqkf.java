import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqkf
  extends aptq<aqkd>
{
  public static aqkd a()
  {
    return (aqkd)apub.a().a(569);
  }
  
  @NonNull
  public aqkd a(int paramInt)
  {
    return new aqkd();
  }
  
  @Nullable
  public aqkd a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqkd.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqkd paramaqkd) {}
  
  public Class<aqkd> clazz()
  {
    return aqkd.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TencentDocFormKeyWordsProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 569;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkf
 * JD-Core Version:    0.7.0.1
 */
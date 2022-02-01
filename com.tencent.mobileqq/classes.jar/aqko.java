import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqko
  extends aptq<aqkm>
{
  public static aqkm a()
  {
    return (aqkm)apub.a().a(525);
  }
  
  @NonNull
  public aqkm a(int paramInt)
  {
    return new aqkm();
  }
  
  @Nullable
  public aqkm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqkm.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqkm paramaqkm) {}
  
  public Class<aqkm> clazz()
  {
    return aqkm.class;
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
    QLog.d("TencentDocLocalCooperationProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 525;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqko
 * JD-Core Version:    0.7.0.1
 */
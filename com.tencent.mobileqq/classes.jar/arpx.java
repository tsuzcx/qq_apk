import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpx
  extends arac<arpw>
{
  public static arpw a()
  {
    return (arpw)aran.a().a(261);
  }
  
  @NonNull
  public arpw a(int paramInt)
  {
    return new arpw();
  }
  
  @Nullable
  public arpw a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arpw.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arpw paramarpw) {}
  
  public Class<arpw> clazz()
  {
    return arpw.class;
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
    QLog.d("TencentDocConvertConfigProcessor", 1, "TIM_CONVERT_TEAMWORK_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 261;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpx
 * JD-Core Version:    0.7.0.1
 */
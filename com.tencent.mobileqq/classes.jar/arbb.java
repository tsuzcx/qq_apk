import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbb
  extends aqkz<arax>
{
  public static arax a()
  {
    return (arax)aqlk.a().a(525);
  }
  
  @NonNull
  public arax a(int paramInt)
  {
    return new arax();
  }
  
  @Nullable
  public arax a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arax.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arax paramarax) {}
  
  public Class<arax> clazz()
  {
    return arax.class;
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
 * Qualified Name:     arbb
 * JD-Core Version:    0.7.0.1
 */
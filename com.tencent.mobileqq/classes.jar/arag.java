import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arag
  extends aqkz<araf>
{
  public static araf a()
  {
    return (araf)aqlk.a().a(261);
  }
  
  @NonNull
  public araf a(int paramInt)
  {
    return new araf();
  }
  
  @Nullable
  public araf a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return araf.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(araf paramaraf) {}
  
  public Class<araf> clazz()
  {
    return araf.class;
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
 * Qualified Name:     arag
 * JD-Core Version:    0.7.0.1
 */
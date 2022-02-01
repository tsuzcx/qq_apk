import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class araq
  extends aqkz<arao>
{
  public static arao a()
  {
    return (arao)aqlk.a().a(569);
  }
  
  @NonNull
  public arao a(int paramInt)
  {
    return new arao();
  }
  
  @Nullable
  public arao a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arao.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arao paramarao) {}
  
  public Class<arao> clazz()
  {
    return arao.class;
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
 * Qualified Name:     araq
 * JD-Core Version:    0.7.0.1
 */
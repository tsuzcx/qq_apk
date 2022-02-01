import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arqh
  extends arac<arqf>
{
  public static arqf a()
  {
    return (arqf)aran.a().a(569);
  }
  
  @NonNull
  public arqf a(int paramInt)
  {
    return new arqf();
  }
  
  @Nullable
  public arqf a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arqf.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arqf paramarqf) {}
  
  public Class<arqf> clazz()
  {
    return arqf.class;
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
 * Qualified Name:     arqh
 * JD-Core Version:    0.7.0.1
 */
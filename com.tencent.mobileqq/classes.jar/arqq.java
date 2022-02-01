import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arqq
  extends arac<arqo>
{
  public static arqo a()
  {
    return (arqo)aran.a().a(525);
  }
  
  @NonNull
  public arqo a(int paramInt)
  {
    return new arqo();
  }
  
  @Nullable
  public arqo a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arqo.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arqo paramarqo) {}
  
  public Class<arqo> clazz()
  {
    return arqo.class;
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
 * Qualified Name:     arqq
 * JD-Core Version:    0.7.0.1
 */
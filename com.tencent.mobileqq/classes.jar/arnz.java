import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arnz
  extends aqwt<arnx>
{
  public static arnx a()
  {
    return (arnx)aqxe.a().a(525);
  }
  
  @NonNull
  public arnx a(int paramInt)
  {
    return new arnx();
  }
  
  @Nullable
  public arnx a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnx.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnx paramarnx) {}
  
  public Class<arnx> clazz()
  {
    return arnx.class;
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
 * Qualified Name:     arnz
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arng
  extends aqwt<arnf>
{
  public static arnf a()
  {
    return (arnf)aqxe.a().a(261);
  }
  
  @NonNull
  public arnf a(int paramInt)
  {
    return new arnf();
  }
  
  @Nullable
  public arnf a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnf.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnf paramarnf) {}
  
  public Class<arnf> clazz()
  {
    return arnf.class;
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
 * Qualified Name:     arng
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqjv
  extends aptq<aqju>
{
  public static aqju a()
  {
    return (aqju)apub.a().a(261);
  }
  
  @NonNull
  public aqju a(int paramInt)
  {
    return new aqju();
  }
  
  @Nullable
  public aqju a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqju.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqju paramaqju) {}
  
  public Class<aqju> clazz()
  {
    return aqju.class;
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
 * Qualified Name:     aqjv
 * JD-Core Version:    0.7.0.1
 */
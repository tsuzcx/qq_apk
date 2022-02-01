import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqjp
  extends aptq<aqjo>
{
  public static aqjo a()
  {
    return (aqjo)apub.a().a(334);
  }
  
  @NonNull
  public aqjo a(int paramInt)
  {
    return new aqjo();
  }
  
  @Nullable
  public aqjo a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqjo.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqjo paramaqjo) {}
  
  public Class<aqjo> clazz()
  {
    return aqjo.class;
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
    QLog.d("TencentDocAIOPlusPanelEntryConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 334;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqjp
 * JD-Core Version:    0.7.0.1
 */
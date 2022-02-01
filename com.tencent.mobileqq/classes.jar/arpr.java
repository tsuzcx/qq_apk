import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpr
  extends arac<arpq>
{
  public static arpq a()
  {
    return (arpq)aran.a().a(334);
  }
  
  @NonNull
  public arpq a(int paramInt)
  {
    return new arpq();
  }
  
  @Nullable
  public arpq a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arpq.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arpq paramarpq) {}
  
  public Class<arpq> clazz()
  {
    return arpq.class;
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
 * Qualified Name:     arpr
 * JD-Core Version:    0.7.0.1
 */
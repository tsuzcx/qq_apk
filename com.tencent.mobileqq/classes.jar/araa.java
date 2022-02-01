import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class araa
  extends aqkz<aqzz>
{
  public static aqzz a()
  {
    return (aqzz)aqlk.a().a(334);
  }
  
  @NonNull
  public aqzz a(int paramInt)
  {
    return new aqzz();
  }
  
  @Nullable
  public aqzz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqzz.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqzz paramaqzz) {}
  
  public Class<aqzz> clazz()
  {
    return aqzz.class;
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
 * Qualified Name:     araa
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpt
  extends arac<arps>
{
  public static arps a()
  {
    return (arps)aran.a().a(342);
  }
  
  @NonNull
  public arps a(int paramInt)
  {
    return new arps();
  }
  
  @Nullable
  public arps a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arps.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arps paramarps) {}
  
  public Class<arps> clazz()
  {
    return arps.class;
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
    QLog.d("TencentDocAIOShowGuideDialogProcessor", 1, "TENCENT_DOC_AIO_SHOW_GUIDE_DIALOG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 342;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpt
 * JD-Core Version:    0.7.0.1
 */
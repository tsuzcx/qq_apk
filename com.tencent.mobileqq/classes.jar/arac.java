import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arac
  extends aqkz<arab>
{
  public static arab a()
  {
    return (arab)aqlk.a().a(342);
  }
  
  @NonNull
  public arab a(int paramInt)
  {
    return new arab();
  }
  
  @Nullable
  public arab a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arab.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arab paramarab) {}
  
  public Class<arab> clazz()
  {
    return arab.class;
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
 * Qualified Name:     arac
 * JD-Core Version:    0.7.0.1
 */
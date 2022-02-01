import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqjr
  extends aptq<aqjq>
{
  public static aqjq a()
  {
    return (aqjq)apub.a().a(342);
  }
  
  @NonNull
  public aqjq a(int paramInt)
  {
    return new aqjq();
  }
  
  @Nullable
  public aqjq a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqjq.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqjq paramaqjq) {}
  
  public Class<aqjq> clazz()
  {
    return aqjq.class;
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
 * Qualified Name:     aqjr
 * JD-Core Version:    0.7.0.1
 */
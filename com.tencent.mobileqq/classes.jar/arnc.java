import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arnc
  extends aqwt<arnb>
{
  public static arnb a()
  {
    return (arnb)aqxe.a().a(342);
  }
  
  @NonNull
  public arnb a(int paramInt)
  {
    return new arnb();
  }
  
  @Nullable
  public arnb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnb.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnb paramarnb) {}
  
  public Class<arnb> clazz()
  {
    return arnb.class;
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
 * Qualified Name:     arnc
 * JD-Core Version:    0.7.0.1
 */
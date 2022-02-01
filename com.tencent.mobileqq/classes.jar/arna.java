import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arna
  extends aqwt<armz>
{
  public static armz a()
  {
    return (armz)aqxe.a().a(334);
  }
  
  @NonNull
  public armz a(int paramInt)
  {
    return new armz();
  }
  
  @Nullable
  public armz a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return armz.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(armz paramarmz) {}
  
  public Class<armz> clazz()
  {
    return armz.class;
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
 * Qualified Name:     arna
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aroj
  extends aqwt<aroi>
{
  public static aroi a()
  {
    return (aroi)aqxe.a().a(335);
  }
  
  @NonNull
  public aroi a(int paramInt)
  {
    return new aroi();
  }
  
  @Nullable
  public aroi a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aroi.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aroi paramaroi) {}
  
  public Class<aroi> clazz()
  {
    return aroi.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    QLog.d("TencentDocSelectAddDocsProcessor", 1, "handleTencentDocUniversalEntry FILE_SELECT_ADD_DOCS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroj
 * JD-Core Version:    0.7.0.1
 */
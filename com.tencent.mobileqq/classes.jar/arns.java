import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arns
  extends aqwt<arnr>
{
  public static arnr a()
  {
    return (arnr)aqxe.a().a(338);
  }
  
  @NonNull
  public arnr a(int paramInt)
  {
    return new arnr();
  }
  
  @Nullable
  public arnr a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnr.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnr paramarnr) {}
  
  public Class<arnr> clazz()
  {
    return arnr.class;
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
    QLog.d("TencentDocGrayTipsProcessor", 1, "TENCENT_DOC_GRAY_TIPS failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 338;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arns
 * JD-Core Version:    0.7.0.1
 */
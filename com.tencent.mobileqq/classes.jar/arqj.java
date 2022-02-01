import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arqj
  extends arac<arqi>
{
  public static arqi a()
  {
    return (arqi)aran.a().a(338);
  }
  
  @NonNull
  public arqi a(int paramInt)
  {
    return new arqi();
  }
  
  @Nullable
  public arqi a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arqi.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arqi paramarqi) {}
  
  public Class<arqi> clazz()
  {
    return arqi.class;
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
 * Qualified Name:     arqj
 * JD-Core Version:    0.7.0.1
 */
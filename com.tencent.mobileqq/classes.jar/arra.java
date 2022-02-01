import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arra
  extends arac<arqz>
{
  public static arqz a()
  {
    return (arqz)aran.a().a(335);
  }
  
  @NonNull
  public arqz a(int paramInt)
  {
    return new arqz();
  }
  
  @Nullable
  public arqz a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arqz.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arqz paramarqz) {}
  
  public Class<arqz> clazz()
  {
    return arqz.class;
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
 * Qualified Name:     arra
 * JD-Core Version:    0.7.0.1
 */
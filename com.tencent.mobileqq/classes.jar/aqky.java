import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqky
  extends aptq<aqkx>
{
  public static aqkx a()
  {
    return (aqkx)apub.a().a(335);
  }
  
  @NonNull
  public aqkx a(int paramInt)
  {
    return new aqkx();
  }
  
  @Nullable
  public aqkx a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqkx.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqkx paramaqkx) {}
  
  public Class<aqkx> clazz()
  {
    return aqkx.class;
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
 * Qualified Name:     aqky
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqkh
  extends aptq<aqkg>
{
  public static aqkg a()
  {
    return (aqkg)apub.a().a(338);
  }
  
  @NonNull
  public aqkg a(int paramInt)
  {
    return new aqkg();
  }
  
  @Nullable
  public aqkg a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqkg.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqkg paramaqkg) {}
  
  public Class<aqkg> clazz()
  {
    return aqkg.class;
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
 * Qualified Name:     aqkh
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdc
  extends aptq<aqda>
{
  @NonNull
  public aqda a(int paramInt)
  {
    return new aqda();
  }
  
  @Nullable
  public aqda a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      new aqda();
      return aqda.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqda paramaqda)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramaqda.toString());
    }
  }
  
  public Class<aqda> clazz()
  {
    return aqda.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdc
 * JD-Core Version:    0.7.0.1
 */
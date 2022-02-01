import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdz
  extends aptq<aqdy>
{
  @NonNull
  public aqdy a(int paramInt)
  {
    return new aqdy();
  }
  
  @Nullable
  public aqdy a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      aqdy localaqdy = aqdy.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfaptx[0].a);
      }
      return localaqdy;
    }
    return null;
  }
  
  public void a(aqdy paramaqdy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramaqdy.toString());
    }
  }
  
  public Class<aqdy> clazz()
  {
    return aqdy.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdz
 * JD-Core Version:    0.7.0.1
 */
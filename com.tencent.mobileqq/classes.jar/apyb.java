import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apyb
  extends aptq<apya>
{
  @NonNull
  public apya a(int paramInt)
  {
    return new apya();
  }
  
  @Nullable
  public apya a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      apya localapya = apya.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapya;
    }
    return null;
  }
  
  public void a(apya paramapya)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramapya.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramapya.toString());
    }
  }
  
  public Class<apya> clazz()
  {
    return apya.class;
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
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyb
 * JD-Core Version:    0.7.0.1
 */
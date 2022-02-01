import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class arho
  extends aqwt<arhn>
{
  @NonNull
  public arhn a(int paramInt)
  {
    return new arhn();
  }
  
  @Nullable
  public arhn a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arhn localarhn2 = arhn.a(paramArrayOfaqxa[0].a);
      arhn localarhn1 = localarhn2;
      if (localarhn2 == null) {
        localarhn1 = new arhn();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherConfProcessor", 0, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarhn1;
    }
    return new arhn();
  }
  
  public void a(arhn paramarhn) {}
  
  public Class<arhn> clazz()
  {
    return arhn.class;
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
    return 653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arho
 * JD-Core Version:    0.7.0.1
 */
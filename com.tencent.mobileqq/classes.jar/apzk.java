import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apzk
  extends aptq<apzj>
{
  public static apzj a()
  {
    return (apzj)apub.a().a(426);
  }
  
  public static boolean a()
  {
    apzj localapzj = a();
    if (localapzj != null) {}
    for (boolean bool = localapzj.b();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public apzj a(int paramInt)
  {
    return new apzj();
  }
  
  @Nullable
  public apzj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      new apzj();
      return apzj.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apzj paramapzj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramapzj.toString());
    }
  }
  
  public Class<apzj> clazz()
  {
    return apzj.class;
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
    return 426;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzk
 * JD-Core Version:    0.7.0.1
 */
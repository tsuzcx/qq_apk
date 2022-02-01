import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arcn
  extends aqwt<arcm>
{
  public static arcm a()
  {
    return (arcm)aqxe.a().a(426);
  }
  
  public static boolean a()
  {
    arcm localarcm = a();
    if (localarcm != null) {}
    for (boolean bool = localarcm.b();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arcm a(int paramInt)
  {
    return new arcm();
  }
  
  @Nullable
  public arcm a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      new arcm();
      return arcm.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arcm paramarcm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramarcm.toString());
    }
  }
  
  public Class<arcm> clazz()
  {
    return arcm.class;
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
 * Qualified Name:     arcn
 * JD-Core Version:    0.7.0.1
 */
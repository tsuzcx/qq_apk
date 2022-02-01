import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqqm
  extends aqkz<aqql>
{
  public static aqql a()
  {
    return (aqql)aqlk.a().a(426);
  }
  
  public static boolean a()
  {
    aqql localaqql = a();
    if (localaqql != null) {}
    for (boolean bool = localaqql.b();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aqql a(int paramInt)
  {
    return new aqql();
  }
  
  @Nullable
  public aqql a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      new aqql();
      return aqql.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqql paramaqql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramaqql.toString());
    }
  }
  
  public Class<aqql> clazz()
  {
    return aqql.class;
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
 * Qualified Name:     aqqm
 * JD-Core Version:    0.7.0.1
 */
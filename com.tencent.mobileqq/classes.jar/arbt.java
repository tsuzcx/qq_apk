import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class arbt
  extends aqkz<arbs>
{
  public static arbs a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (arbs)aqlk.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    arbs localarbs = a();
    return (localarbs != null) && (localarbs.a()) && (localarbs.a(paramString));
  }
  
  @NonNull
  public arbs a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arbs();
  }
  
  @Nullable
  public arbs a(aqlg[] paramArrayOfaqlg)
  {
    return arbs.a(paramArrayOfaqlg);
  }
  
  public void a(arbs paramarbs)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public Class<arbs> clazz()
  {
    return arbs.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */
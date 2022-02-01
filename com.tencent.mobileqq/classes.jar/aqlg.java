import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aqlg
  extends aptq<aqlf>
{
  public static aqlf a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (aqlf)apub.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    aqlf localaqlf = a();
    return (localaqlf != null) && (localaqlf.a()) && (localaqlf.a(paramString));
  }
  
  @NonNull
  public aqlf a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aqlf();
  }
  
  @Nullable
  public aqlf a(aptx[] paramArrayOfaptx)
  {
    return aqlf.a(paramArrayOfaptx);
  }
  
  public void a(aqlf paramaqlf)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public Class<aqlf> clazz()
  {
    return aqlf.class;
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
 * Qualified Name:     aqlg
 * JD-Core Version:    0.7.0.1
 */
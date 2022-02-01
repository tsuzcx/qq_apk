import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class arri
  extends arac<arrh>
{
  public static arrh a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (arrh)aran.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    arrh localarrh = a();
    return (localarrh != null) && (localarrh.a()) && (localarrh.a(paramString));
  }
  
  @NonNull
  public arrh a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arrh();
  }
  
  @Nullable
  public arrh a(araj[] paramArrayOfaraj)
  {
    return arrh.a(paramArrayOfaraj);
  }
  
  public void a(arrh paramarrh)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public Class<arrh> clazz()
  {
    return arrh.class;
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
 * Qualified Name:     arri
 * JD-Core Version:    0.7.0.1
 */
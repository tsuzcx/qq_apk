import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class ancy
  extends ampb<ancx>
{
  public static ancx a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (ancx)ampm.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    ancx localancx = a();
    return (localancx != null) && (localancx.a()) && (localancx.a(paramString));
  }
  
  public int a()
  {
    return 559;
  }
  
  @NonNull
  public ancx a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new ancx();
  }
  
  @Nullable
  public ancx a(ampi[] paramArrayOfampi)
  {
    return ancx.a(paramArrayOfampi);
  }
  
  public Class<ancx> a()
  {
    return ancx.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(ancx paramancx)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancy
 * JD-Core Version:    0.7.0.1
 */
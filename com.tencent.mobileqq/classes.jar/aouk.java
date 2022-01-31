import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aouk
  extends aofy<aouj>
{
  public static aouj a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (aouj)aogj.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    aouj localaouj = a();
    return (localaouj != null) && (localaouj.a()) && (localaouj.a(paramString));
  }
  
  public int a()
  {
    return 559;
  }
  
  @NonNull
  public aouj a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aouj();
  }
  
  @Nullable
  public aouj a(aogf[] paramArrayOfaogf)
  {
    return aouj.a(paramArrayOfaogf);
  }
  
  public Class<aouj> a()
  {
    return aouj.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aouj paramaouj)
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
 * Qualified Name:     aouk
 * JD-Core Version:    0.7.0.1
 */
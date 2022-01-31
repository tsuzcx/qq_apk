import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class ammr
  extends alzl<ammq>
{
  public static ammq a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (ammq)alzw.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    ammq localammq = a();
    return (localammq != null) && (localammq.a()) && (localammq.a(paramString));
  }
  
  public int a()
  {
    return 559;
  }
  
  @NonNull
  public ammq a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new ammq();
  }
  
  @Nullable
  public ammq a(alzs[] paramArrayOfalzs)
  {
    return ammq.a(paramArrayOfalzs);
  }
  
  public Class<ammq> a()
  {
    return ammq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(ammq paramammq)
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
 * Qualified Name:     ammr
 * JD-Core Version:    0.7.0.1
 */
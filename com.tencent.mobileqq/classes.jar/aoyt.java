import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aoyt
  extends aokh<aoys>
{
  public static aoys a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (aoys)aoks.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    aoys localaoys = a();
    return (localaoys != null) && (localaoys.a()) && (localaoys.a(paramString));
  }
  
  public int a()
  {
    return 559;
  }
  
  @NonNull
  public aoys a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aoys();
  }
  
  @Nullable
  public aoys a(aoko[] paramArrayOfaoko)
  {
    return aoys.a(paramArrayOfaoko);
  }
  
  public Class<aoys> a()
  {
    return aoys.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aoys paramaoys)
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
 * Qualified Name:     aoyt
 * JD-Core Version:    0.7.0.1
 */
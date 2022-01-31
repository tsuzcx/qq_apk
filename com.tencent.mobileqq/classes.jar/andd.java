import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class andd
  extends ampa<andc>
{
  public static andc a()
  {
    QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
    return (andc)ampl.a().a(559);
  }
  
  public static boolean a(String paramString)
  {
    andc localandc = a();
    return (localandc != null) && (localandc.a()) && (localandc.a(paramString));
  }
  
  public int a()
  {
    return 559;
  }
  
  @NonNull
  public andc a(int paramInt)
  {
    QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new andc();
  }
  
  @Nullable
  public andc a(amph[] paramArrayOfamph)
  {
    return andc.a(paramArrayOfamph);
  }
  
  public Class<andc> a()
  {
    return andc.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(andc paramandc)
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
 * Qualified Name:     andd
 * JD-Core Version:    0.7.0.1
 */
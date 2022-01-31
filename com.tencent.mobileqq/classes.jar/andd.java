import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class andd
  extends ampb<andc>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    andc.a(false, (andc)ampm.a().a(482));
  }
  
  public int a()
  {
    return 482;
  }
  
  @NonNull
  public andc a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new andc();
  }
  
  @Nullable
  public andc a(ampi[] paramArrayOfampi)
  {
    return andc.a(paramArrayOfampi);
  }
  
  public Class<andc> a()
  {
    return andc.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(andc paramandc)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    andc.a(true, paramandc);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
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
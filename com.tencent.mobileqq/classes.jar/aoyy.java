import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aoyy
  extends aokh<aoyx>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    aoyx.a(false, (aoyx)aoks.a().a(482));
  }
  
  public int a()
  {
    return 482;
  }
  
  @NonNull
  public aoyx a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aoyx();
  }
  
  @Nullable
  public aoyx a(aoko[] paramArrayOfaoko)
  {
    return aoyx.a(paramArrayOfaoko);
  }
  
  public Class<aoyx> a()
  {
    return aoyx.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aoyx paramaoyx)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    aoyx.a(true, paramaoyx);
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
 * Qualified Name:     aoyy
 * JD-Core Version:    0.7.0.1
 */
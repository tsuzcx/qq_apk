import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aoza
  extends aokh<aoyz>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    aoyz.a(false, (aoyz)aoks.a().a(501));
  }
  
  public int a()
  {
    return 501;
  }
  
  @NonNull
  public aoyz a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aoyz();
  }
  
  @Nullable
  public aoyz a(aoko[] paramArrayOfaoko)
  {
    return aoyz.a(paramArrayOfaoko);
  }
  
  public Class<aoyz> a()
  {
    return aoyz.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aoyz paramaoyz)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    aoyz.a(true, paramaoyz);
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
 * Qualified Name:     aoza
 * JD-Core Version:    0.7.0.1
 */
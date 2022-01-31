import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aoup
  extends aofy<aouo>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    aouo.a(false, (aouo)aogj.a().a(482));
  }
  
  public int a()
  {
    return 482;
  }
  
  @NonNull
  public aouo a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aouo();
  }
  
  @Nullable
  public aouo a(aogf[] paramArrayOfaogf)
  {
    return aouo.a(paramArrayOfaogf);
  }
  
  public Class<aouo> a()
  {
    return aouo.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aouo paramaouo)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    aouo.a(true, paramaouo);
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
 * Qualified Name:     aoup
 * JD-Core Version:    0.7.0.1
 */
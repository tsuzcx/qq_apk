import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aour
  extends aofy<aouq>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    aouq.a(false, (aouq)aogj.a().a(501));
  }
  
  public int a()
  {
    return 501;
  }
  
  @NonNull
  public aouq a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aouq();
  }
  
  @Nullable
  public aouq a(aogf[] paramArrayOfaogf)
  {
    return aouq.a(paramArrayOfaogf);
  }
  
  public Class<aouq> a()
  {
    return aouq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aouq paramaouq)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    aouq.a(true, paramaouq);
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
 * Qualified Name:     aour
 * JD-Core Version:    0.7.0.1
 */
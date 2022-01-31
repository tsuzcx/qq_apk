import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class andi
  extends ampa<andh>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    andh.a(false, (andh)ampl.a().a(482));
  }
  
  public int a()
  {
    return 482;
  }
  
  @NonNull
  public andh a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new andh();
  }
  
  @Nullable
  public andh a(amph[] paramArrayOfamph)
  {
    return andh.a(paramArrayOfamph);
  }
  
  public Class<andh> a()
  {
    return andh.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(andh paramandh)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    andh.a(true, paramandh);
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
 * Qualified Name:     andi
 * JD-Core Version:    0.7.0.1
 */
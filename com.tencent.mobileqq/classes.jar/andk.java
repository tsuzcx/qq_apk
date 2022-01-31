import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class andk
  extends ampa<andj>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    andj.a(false, (andj)ampl.a().a(501));
  }
  
  public int a()
  {
    return 501;
  }
  
  @NonNull
  public andj a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new andj();
  }
  
  @Nullable
  public andj a(amph[] paramArrayOfamph)
  {
    return andj.a(paramArrayOfamph);
  }
  
  public Class<andj> a()
  {
    return andj.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(andj paramandj)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    andj.a(true, paramandj);
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
 * Qualified Name:     andk
 * JD-Core Version:    0.7.0.1
 */
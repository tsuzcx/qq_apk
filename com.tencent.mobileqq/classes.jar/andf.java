import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class andf
  extends ampb<ande>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    ande.a(false, (ande)ampm.a().a(501));
  }
  
  public int a()
  {
    return 501;
  }
  
  @NonNull
  public ande a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new ande();
  }
  
  @Nullable
  public ande a(ampi[] paramArrayOfampi)
  {
    return ande.a(paramArrayOfampi);
  }
  
  public Class<ande> a()
  {
    return ande.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(ande paramande)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    ande.a(true, paramande);
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
 * Qualified Name:     andf
 * JD-Core Version:    0.7.0.1
 */
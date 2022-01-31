import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class ammw
  extends alzl<ammv>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    ammv.a(false, (ammv)alzw.a().a(482));
  }
  
  public int a()
  {
    return 482;
  }
  
  @NonNull
  public ammv a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new ammv();
  }
  
  @Nullable
  public ammv a(alzs[] paramArrayOfalzs)
  {
    return ammv.a(paramArrayOfalzs);
  }
  
  public Class<ammv> a()
  {
    return ammv.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(ammv paramammv)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    ammv.a(true, paramammv);
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
 * Qualified Name:     ammw
 * JD-Core Version:    0.7.0.1
 */
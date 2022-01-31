import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class ammy
  extends alzl<ammx>
{
  public static void b()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    ammx.a(false, (ammx)alzw.a().a(501));
  }
  
  public int a()
  {
    return 501;
  }
  
  @NonNull
  public ammx a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new ammx();
  }
  
  @Nullable
  public ammx a(alzs[] paramArrayOfalzs)
  {
    return ammx.a(paramArrayOfalzs);
  }
  
  public Class<ammx> a()
  {
    return ammx.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(ammx paramammx)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    ammx.a(true, paramammx);
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
 * Qualified Name:     ammy
 * JD-Core Version:    0.7.0.1
 */
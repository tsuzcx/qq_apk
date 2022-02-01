import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqsx
  extends aqkz<aqsw>
{
  public static aqsw a()
  {
    return (aqsw)aqlk.a().a(292);
  }
  
  @NonNull
  public aqsw a(int paramInt)
  {
    return new aqsw();
  }
  
  @Nullable
  public aqsw a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaqlg);
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaqlg[0].a);
      }
      return aqsw.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(aqsw paramaqsw) {}
  
  public Class<aqsw> clazz()
  {
    return aqsw.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsx
 * JD-Core Version:    0.7.0.1
 */
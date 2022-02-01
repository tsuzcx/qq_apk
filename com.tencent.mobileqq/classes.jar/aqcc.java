import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqcc
  extends aptq<aqcb>
{
  public static aqcb a()
  {
    return (aqcb)apub.a().a(292);
  }
  
  @NonNull
  public aqcb a(int paramInt)
  {
    return new aqcb();
  }
  
  @Nullable
  public aqcb a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaptx);
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaptx[0].a);
      }
      return aqcb.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(aqcb paramaqcb) {}
  
  public Class<aqcb> clazz()
  {
    return aqcb.class;
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
 * Qualified Name:     aqcc
 * JD-Core Version:    0.7.0.1
 */
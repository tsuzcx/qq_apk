import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfh
  extends aqwt<arfg>
{
  public static arfg a()
  {
    return (arfg)aqxe.a().a(292);
  }
  
  @NonNull
  public arfg a(int paramInt)
  {
    return new arfg();
  }
  
  @Nullable
  public arfg a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaqxa);
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaqxa[0].a);
      }
      return arfg.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(arfg paramarfg) {}
  
  public Class<arfg> clazz()
  {
    return arfg.class;
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
 * Qualified Name:     arfh
 * JD-Core Version:    0.7.0.1
 */
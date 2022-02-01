import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqbr
  extends aptq<aqbu>
{
  @NonNull
  public aqbu a(int paramInt)
  {
    return new aqbu();
  }
  
  @Nullable
  public aqbu a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqbu.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqbu paramaqbu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramaqbu != null) {
      aqbu.a(paramaqbu);
    }
    arev.a().a();
  }
  
  public Class<aqbu> clazz()
  {
    return aqbu.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 545;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbr
 * JD-Core Version:    0.7.0.1
 */
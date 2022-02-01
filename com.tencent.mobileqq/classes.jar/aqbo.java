import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqbo
  extends aptq<aqbn>
{
  public static aqbn a()
  {
    return (aqbn)apub.a().a(631);
  }
  
  @NonNull
  public aqbn a(int paramInt)
  {
    return new aqbn();
  }
  
  @Nullable
  public aqbn a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      new aqbn();
      return aqbn.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqbn paramaqbn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramaqbn.toString());
    }
  }
  
  public Class<aqbn> clazz()
  {
    return aqbn.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbo
 * JD-Core Version:    0.7.0.1
 */
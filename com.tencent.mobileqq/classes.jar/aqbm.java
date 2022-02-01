import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqbm
  extends aptq<aqbl>
{
  public static aqbl a()
  {
    return (aqbl)apub.a().a(441);
  }
  
  @NonNull
  public aqbl a(int paramInt)
  {
    return new aqbl();
  }
  
  @Nullable
  public aqbl a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      new aqbl();
      return aqbl.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqbl paramaqbl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramaqbl.toString());
    }
  }
  
  public Class<aqbl> clazz()
  {
    return aqbl.class;
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
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbm
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxw
  extends aptq<apxv>
{
  public static apxv a()
  {
    return (apxv)apub.a().a(660);
  }
  
  @NonNull
  public apxv a(int paramInt)
  {
    return new apxv();
  }
  
  @Nullable
  public apxv a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterEnterConfProc", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apxv.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apxv paramapxv) {}
  
  public Class<apxv> clazz()
  {
    return apxv.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 660;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxw
 * JD-Core Version:    0.7.0.1
 */
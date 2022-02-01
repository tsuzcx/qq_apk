import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class araz
  extends aqwt<aray>
{
  public static aray a()
  {
    return (aray)aqxe.a().a(660);
  }
  
  @NonNull
  public aray a(int paramInt)
  {
    return new aray();
  }
  
  @Nullable
  public aray a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterEnterConfProc", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aray.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aray paramaray) {}
  
  public Class<aray> clazz()
  {
    return aray.class;
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
 * Qualified Name:     araz
 * JD-Core Version:    0.7.0.1
 */
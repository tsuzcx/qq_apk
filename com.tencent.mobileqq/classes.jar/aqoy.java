import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqoy
  extends aqkz<aqox>
{
  public static aqox a()
  {
    return (aqox)aqlk.a().a(660);
  }
  
  @NonNull
  public aqox a(int paramInt)
  {
    return new aqox();
  }
  
  @Nullable
  public aqox a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterEnterConfProc", 2, "GameCenterEnterConfProcessor onParsed ");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqox.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqox paramaqox) {}
  
  public Class<aqox> clazz()
  {
    return aqox.class;
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
 * Qualified Name:     aqoy
 * JD-Core Version:    0.7.0.1
 */
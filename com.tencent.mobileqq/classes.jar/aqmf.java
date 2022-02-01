import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqmf
  extends aqkz<aqmg>
{
  public static aqmg a()
  {
    return (aqmg)aqlk.a().a(655);
  }
  
  @NonNull
  public aqmg a(int paramInt)
  {
    return new aqmg();
  }
  
  @Nullable
  public aqmg a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqmg.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqmg paramaqmg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionConfProcessor", 2, "AIORelatedEmotionConfProcessor onUpdate");
    }
  }
  
  public Class<aqmg> clazz()
  {
    return aqmg.class;
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
    return 655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmf
 * JD-Core Version:    0.7.0.1
 */
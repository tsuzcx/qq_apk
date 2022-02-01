import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqyd
  extends aqwt<aqye>
{
  public static aqye a()
  {
    return (aqye)aqxe.a().a(655);
  }
  
  @NonNull
  public aqye a(int paramInt)
  {
    return new aqye();
  }
  
  @Nullable
  public aqye a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aqye.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aqye paramaqye)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionConfProcessor", 2, "AIORelatedEmotionConfProcessor onUpdate");
    }
  }
  
  public Class<aqye> clazz()
  {
    return aqye.class;
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
 * Qualified Name:     aqyd
 * JD-Core Version:    0.7.0.1
 */
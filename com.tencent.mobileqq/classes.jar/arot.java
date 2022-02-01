import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arot
  extends arac<aros>
{
  @NonNull
  public aros a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aros();
  }
  
  @Nullable
  public aros a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return aros.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(aros paramaros)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaros == null) {
        break label58;
      }
    }
    label58:
    for (String str = paramaros.toString();; str = " empty")
    {
      QLog.d("TroopRobotConfProcessor", 2, str);
      if (paramaros != null) {
        bgpy.a(paramaros.a(), paramaros.a());
      }
      return;
    }
  }
  
  public Class<aros> clazz()
  {
    return aros.class;
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
      QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arot
 * JD-Core Version:    0.7.0.1
 */
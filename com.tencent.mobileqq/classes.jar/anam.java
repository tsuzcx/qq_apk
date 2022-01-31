import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anam
  extends ampa<anal>
{
  public int a()
  {
    return 460;
  }
  
  @NonNull
  public anal a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anal();
  }
  
  @Nullable
  public anal a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return anal.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<anal> a()
  {
    return anal.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anal paramanal)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanal == null) {
        break label58;
      }
    }
    label58:
    for (String str = paramanal.toString();; str = " empty")
    {
      QLog.d("TroopRobotConfProcessor", 2, str);
      if (paramanal != null) {
        bail.a(paramanal.a(), paramanal.a());
      }
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anam
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aond
  extends aofy<aone>
{
  public int a()
  {
    return 551;
  }
  
  @NonNull
  public aone a(int paramInt)
  {
    return new aone();
  }
  
  @Nullable
  public aone a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null)) {
      return aone.a(paramArrayOfaogf[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aone> a()
  {
    return aone.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aone paramaone)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onUpdate " + paramaone.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     aond
 * JD-Core Version:    0.7.0.1
 */
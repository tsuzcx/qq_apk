import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoni
  extends aofy<aonj>
{
  public int a()
  {
    return 607;
  }
  
  @NonNull
  public aonj a(int paramInt)
  {
    return new aonj();
  }
  
  @Nullable
  public aonj a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null)) {
      return aonj.a(paramArrayOfaogf[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aonj> a()
  {
    return aonj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aonj paramaonj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onUpdate " + paramaonj.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     aoni
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class auez
  extends aofy<aufa>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    if (b) {
      return a;
    }
    b = true;
    a = f();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean f()
  {
    aufa localaufa2 = (aufa)aogj.a().a(522);
    aufa localaufa1 = localaufa2;
    if (localaufa2 == null)
    {
      localaufa2 = new aufa();
      localaufa1 = localaufa2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localaufa1 = localaufa2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localaufa1);
    }
    return localaufa1.a();
  }
  
  public int a()
  {
    return 522;
  }
  
  @NonNull
  public aufa a(int paramInt)
  {
    return new aufa();
  }
  
  @Nullable
  public aufa a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfaogf[0].a);
      }
      return aufa.a(paramArrayOfaogf[0].a);
    }
    return new aufa();
  }
  
  public Class<aufa> a()
  {
    return aufa.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public void a(aufa paramaufa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramaufa);
    }
    if (paramaufa != null) {
      a = paramaufa.a();
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
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auez
 * JD-Core Version:    0.7.0.1
 */
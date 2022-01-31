import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class asoa
  extends ampa<asob>
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
    asob localasob2 = (asob)ampl.a().a(522);
    asob localasob1 = localasob2;
    if (localasob2 == null)
    {
      localasob2 = new asob();
      localasob1 = localasob2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localasob1 = localasob2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localasob1);
    }
    return localasob1.a();
  }
  
  public int a()
  {
    return 522;
  }
  
  @NonNull
  public asob a(int paramInt)
  {
    return new asob();
  }
  
  @Nullable
  public asob a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfamph[0].a);
      }
      return asob.a(paramArrayOfamph[0].a);
    }
    return new asob();
  }
  
  public Class<asob> a()
  {
    return asob.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public void a(asob paramasob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramasob);
    }
    if (paramasob != null) {
      a = paramasob.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asoa
 * JD-Core Version:    0.7.0.1
 */
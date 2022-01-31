import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class asny
  extends ampb<asnz>
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
    asnz localasnz2 = (asnz)ampm.a().a(522);
    asnz localasnz1 = localasnz2;
    if (localasnz2 == null)
    {
      localasnz2 = new asnz();
      localasnz1 = localasnz2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localasnz1 = localasnz2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localasnz1);
    }
    return localasnz1.a();
  }
  
  public int a()
  {
    return 522;
  }
  
  @NonNull
  public asnz a(int paramInt)
  {
    return new asnz();
  }
  
  @Nullable
  public asnz a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfampi[0].a);
      }
      return asnz.a(paramArrayOfampi[0].a);
    }
    return new asnz();
  }
  
  public Class<asnz> a()
  {
    return asnz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public void a(asnz paramasnz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramasnz);
    }
    if (paramasnz != null) {
      a = paramasnz.a();
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
 * Qualified Name:     asny
 * JD-Core Version:    0.7.0.1
 */
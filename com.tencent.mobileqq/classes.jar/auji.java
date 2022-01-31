import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class auji
  extends aokh<aujj>
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
    aujj localaujj2 = (aujj)aoks.a().a(522);
    aujj localaujj1 = localaujj2;
    if (localaujj2 == null)
    {
      localaujj2 = new aujj();
      localaujj1 = localaujj2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localaujj1 = localaujj2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localaujj1);
    }
    return localaujj1.a();
  }
  
  public int a()
  {
    return 522;
  }
  
  @NonNull
  public aujj a(int paramInt)
  {
    return new aujj();
  }
  
  @Nullable
  public aujj a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfaoko[0].a);
      }
      return aujj.a(paramArrayOfaoko[0].a);
    }
    return new aujj();
  }
  
  public Class<aujj> a()
  {
    return aujj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public void a(aujj paramaujj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramaujj);
    }
    if (paramaujj != null) {
      a = paramaujj.a();
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
 * Qualified Name:     auji
 * JD-Core Version:    0.7.0.1
 */
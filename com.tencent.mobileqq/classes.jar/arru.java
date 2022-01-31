import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arru
  extends alzl<arrv>
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
    arrv localarrv2 = (arrv)alzw.a().a(522);
    arrv localarrv1 = localarrv2;
    if (localarrv2 == null)
    {
      localarrv2 = new arrv();
      localarrv1 = localarrv2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        localarrv1 = localarrv2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + localarrv1);
    }
    return localarrv1.a();
  }
  
  public int a()
  {
    return 522;
  }
  
  @NonNull
  public arrv a(int paramInt)
  {
    return new arrv();
  }
  
  @Nullable
  public arrv a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfalzs[0].a);
      }
      return arrv.a(paramArrayOfalzs[0].a);
    }
    return new arrv();
  }
  
  public Class<arrv> a()
  {
    return arrv.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public void a(arrv paramarrv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + paramarrv);
    }
    if (paramarrv != null) {
      a = paramarrv.a();
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
 * Qualified Name:     arru
 * JD-Core Version:    0.7.0.1
 */
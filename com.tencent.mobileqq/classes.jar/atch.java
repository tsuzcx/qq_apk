import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class atch
{
  private static atch jdField_a_of_type_Atch;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private atcj jdField_a_of_type_Atcj;
  private atck jdField_a_of_type_Atck = new atck();
  private lwl jdField_a_of_type_Lwl;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public static atch a()
  {
    if (jdField_a_of_type_Atch == null) {}
    try
    {
      if (jdField_a_of_type_Atch == null) {
        jdField_a_of_type_Atch = new atch();
      }
      return jdField_a_of_type_Atch;
    }
    finally {}
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lwl == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lwl.a(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "setSoundEnable: " + QLog.getStackTraceString(localRemoteException));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int != -1) {
      if (this.jdField_a_of_type_Int != 0) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Atck.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atcj != null)
    {
      BaseApplicationImpl.getApplication().unbindService(this.jdField_a_of_type_Atcj);
      this.jdField_a_of_type_Atcj = null;
    }
    this.jdField_a_of_type_Lwl = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (a(paramInt))
    {
      b(false);
      return;
    }
    f();
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if ((!this.c) && (!this.d)) {
      this.jdField_a_of_type_Atck.a(paramInt1, paramString1, paramInt2, paramLong, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    if ((!this.c) && (!this.d)) {
      this.jdField_a_of_type_Atck.a(paramInt, paramString1, 10, paramLong, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lwl == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Lwl.a(paramLong);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Atck.a();
      this.jdField_a_of_type_Lwl = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomAVController", 2, "exitRoom: " + QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_Lwl == null) {}
    do
    {
      return;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).a().d())) {
          this.jdField_a_of_type_Lwl.c();
        }
        this.jdField_a_of_type_Lwl.a(paramLong, paramString);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "enterRoom: " + QLog.getStackTraceString(paramString));
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Lwl = null;
    paramContext.stopService(new Intent(paramContext, AVServiceForQQ.class));
  }
  
  public void a(atci paramatci)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (this.jdField_a_of_type_Lwl == null)
    {
      localIntent = new Intent(localBaseApplicationImpl, AVServiceForQQ.class);
      this.jdField_a_of_type_Atcj = new atcj(this, paramatci);
      localBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_Atcj, 1);
    }
    while (paramatci == null)
    {
      Intent localIntent;
      return;
    }
    paramatci.bt();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_Int = i;
      if ((!paramBoolean) || (!a(this.jdField_b_of_type_Int))) {
        break;
      }
      return;
    }
    b(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lwl != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lwl == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lwl.a();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "startSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Lwl == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lwl.b();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "stopSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Atck.a();
  }
  
  public void e()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atch
 * JD-Core Version:    0.7.0.1
 */
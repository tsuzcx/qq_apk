import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class axrb
{
  private static axrb jdField_a_of_type_Axrb;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private axrd jdField_a_of_type_Axrd;
  private axre jdField_a_of_type_Axre = new axre();
  private lws jdField_a_of_type_Lws;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public static axrb a()
  {
    if (jdField_a_of_type_Axrb == null) {}
    try
    {
      if (jdField_a_of_type_Axrb == null) {
        jdField_a_of_type_Axrb = new axrb();
      }
      return jdField_a_of_type_Axrb;
    }
    finally {}
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lws == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.a(paramBoolean);
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
    return this.jdField_a_of_type_Axre.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axrd != null)
    {
      BaseApplicationImpl.getApplication().unbindService(this.jdField_a_of_type_Axrd);
      this.jdField_a_of_type_Axrd = null;
    }
    this.jdField_a_of_type_Lws = null;
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
      this.jdField_a_of_type_Axre.a(paramInt1, paramString1, paramInt2, paramLong, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    if ((!this.c) && (!this.d)) {
      this.jdField_a_of_type_Axre.a(paramInt, paramString1, 10, paramLong, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lws == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Lws.a(paramLong);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Axre.a();
      this.jdField_a_of_type_Lws = null;
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
    if (this.jdField_a_of_type_Lws == null) {}
    do
    {
      return;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).getAVNotifyCenter().b())) {
          this.jdField_a_of_type_Lws.c();
        }
        this.jdField_a_of_type_Lws.a(paramLong, paramString);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "enterRoom: " + QLog.getStackTraceString(paramString));
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Lws = null;
    paramContext.stopService(new Intent(paramContext, AVServiceForQQ.class));
  }
  
  public void a(axrc paramaxrc)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (this.jdField_a_of_type_Lws == null)
    {
      localIntent = new Intent(localBaseApplicationImpl, AVServiceForQQ.class);
      this.jdField_a_of_type_Axrd = new axrd(this, paramaxrc);
      localBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_Axrd, 1);
    }
    while (paramaxrc == null)
    {
      Intent localIntent;
      return;
    }
    paramaxrc.g();
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
    return this.jdField_a_of_type_Lws != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lws == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.a();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "startSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Lws == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lws.b();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "stopSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Axre.a();
  }
  
  public void e()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrb
 * JD-Core Version:    0.7.0.1
 */
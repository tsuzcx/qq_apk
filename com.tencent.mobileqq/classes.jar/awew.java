import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController;", "Lcom/tencent/mobileqq/listentogether/ListenTogetherObserver;", "Landroid/os/Handler$Callback;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "errCount", "", "getErrCount", "()I", "setErrCount", "(I)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "interval", "getInterval", "setInterval", "joinedData", "Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "getJoinedData", "()Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "destroy", "", "doHeartBeat", "handleMessage", "msg", "Landroid/os/Message;", "keepHeartBeat", "onHeartBeat", "suc", "type", "uin", "", "reqTs", "", "errCode", "errWording", "onUIModuleNeedRefresh", "session", "Lcom/tencent/mobileqq/listentogether/ListenTogetherSession;", "start", "Companion", "Data", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class awew
  extends awfk
  implements Handler.Callback
{
  public static final awex a;
  private volatile int jdField_a_of_type_Int;
  @NotNull
  private final Handler jdField_a_of_type_AndroidOsHandler;
  @NotNull
  private final awey jdField_a_of_type_Awey;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int b;
  
  static
  {
    jdField_a_of_type_Awex = new awex(null);
  }
  
  public awew(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 60000;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), (Handler.Callback)this);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Awey = new awey(0, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this, true);
  }
  
  private final void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Int);
  }
  
  private final void f()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        BusinessHandler localBusinessHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (localBusinessHandler == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.listentogether.ListenTogetherHandler");
        }
      }
      finally {}
      ((awev)localObject).a(this.jdField_a_of_type_Awey.a(), this.jdField_a_of_type_Awey.a());
      e();
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogetherHeartBeatController", 2, "doHeartBeat uin=" + this.jdField_a_of_type_Awey.a());
      }
    }
  }
  
  public final void a()
  {
    QLog.d("ListenTogetherHeartBeatController", 1, "stop heartBeat");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  protected void a(@NotNull ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramListenTogetherSession, "session");
        Object localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mgr");
        boolean bool2 = ((ListenTogetherManager)localObject).a();
        boolean bool3 = ((ListenTogetherManager)localObject).b(paramListenTogetherSession.f, paramListenTogetherSession.e);
        if (bool3)
        {
          localObject = this.jdField_a_of_type_Awey;
          i = paramListenTogetherSession.f;
          String str = paramListenTogetherSession.e;
          Intrinsics.checkExpressionValueIsNotNull(str, "session.uin");
          if ((Intrinsics.areEqual(localObject, new awey(i, str)) ^ true))
          {
            this.jdField_a_of_type_Awey.a(paramListenTogetherSession.f);
            this.jdField_a_of_type_Awey.a(paramListenTogetherSession.e);
            i = 1;
            if (this.jdField_a_of_type_Awey.a() != 2) {
              break label283;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ListenTogetherHeartBeatController", 2, "onUIModuleNeedRefresh joinState=" + paramListenTogetherSession.i + " isJoin=" + bool2 + " isJoinThisSession=" + bool3 + " isJoinedSessionC2c=" + bool1);
            }
            if (!bool2) {
              continue;
            }
            if ((i != 0) && (!this.jdField_a_of_type_Boolean)) {
              a();
            }
            if (this.jdField_a_of_type_Boolean) {
              b();
            }
            return;
          }
        }
        if (!bool2)
        {
          this.jdField_a_of_type_Awey.a(0);
          this.jdField_a_of_type_Awey.a("");
          break label278;
          if ((this.jdField_a_of_type_Boolean) || (bool2)) {
            continue;
          }
          a();
          continue;
        }
        int i = 0;
      }
      finally {}
      label278:
      continue;
      label283:
      bool1 = false;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, @NotNull String paramString1, long paramLong, int paramInt2, int paramInt3, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errWording");
    if (this.jdField_a_of_type_Boolean) {}
    label38:
    do
    {
      return;
      boolean bool;
      if (SystemClock.elapsedRealtime() - paramLong > 30000)
      {
        bool = true;
        if ((paramBoolean) && (!bool)) {
          break label148;
        }
      }
      for (this.b += 1;; this.b = 0)
      {
        if (this.b > 15)
        {
          QLog.d("ListenTogetherHeartBeatController", 1, "onHeartBeat isTimeout=" + bool + " errCount=" + this.b + " stop");
          a();
        }
        if (paramBoolean != true) {
          break label156;
        }
        if ((paramInt2 <= 0) || (paramInt2 == this.jdField_a_of_type_Int)) {
          break;
        }
        this.jdField_a_of_type_Int = paramInt2;
        return;
        bool = false;
        break label38;
      }
    } while (paramBoolean);
    label148:
    label156:
    QLog.d("ListenTogetherHeartBeatController", 1, "onHeartBeat failed errCode=" + paramInt3 + " errWordig=" + paramString2);
  }
  
  public final void b()
  {
    QLog.d("ListenTogetherHeartBeatController", 1, "start heartBeat");
    this.jdField_a_of_type_Boolean = false;
    this.b = 0;
    f();
  }
  
  public final void c()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this);
  }
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awew
 * JD-Core Version:    0.7.0.1
 */
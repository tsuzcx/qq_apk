import android.app.Activity;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager.1;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager.2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class azfg
  implements Handler.Callback, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private azdj jdField_a_of_type_Azdj;
  private azes jdField_a_of_type_Azes;
  private azfh jdField_a_of_type_Azfh;
  private azfi jdField_a_of_type_Azfi;
  private azfx jdField_a_of_type_Azfx;
  private azgb jdField_a_of_type_Azgb;
  private azgc jdField_a_of_type_Azgc;
  private azgh jdField_a_of_type_Azgh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public azfg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!azhh.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "quitePanel not allow");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Azes != null) {
        this.jdField_a_of_type_Azes.a(paramBoolean1);
      }
      if (this.jdField_a_of_type_Azfi != null) {
        this.jdField_a_of_type_Azfi.b();
      }
      if (this.jdField_a_of_type_Azgh != null) {
        this.jdField_a_of_type_Azgh.c();
      }
      if (this.jdField_a_of_type_Azfx != null) {
        this.jdField_a_of_type_Azfx.b();
      }
      if (this.jdField_a_of_type_Azdj != null) {
        this.jdField_a_of_type_Azdj.a();
      }
    } while (!paramBoolean2);
    azhh.a().a("quiteVoicePanel");
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (this.jdField_a_of_type_Azfh == null))
    {
      this.jdField_a_of_type_Azfh = new azfh(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      BaseApplicationImpl.context.registerReceiver(this.jdField_a_of_type_Azfh, localIntentFilter);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1), 30000L);
    }
  }
  
  public int a()
  {
    int i = 2;
    if (!azhh.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "enterVoicePanel not allow");
      }
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if (this.jdField_a_of_type_Azfi != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VoiceAssistantManager", 2, "enterVoicePanel mVoicePresenter is null");
      return 2;
    } while (this.jdField_a_of_type_Azes == null);
    i = this.jdField_a_of_type_Azes.a(this.jdField_a_of_type_Azfi.a());
    if (i == 1)
    {
      FloatingScreenPermission.enterPermissionRequestDialogCustom(a(), 2131719574, 2131719573);
      return i;
    }
    if (this.jdField_a_of_type_Azdj != null) {
      this.jdField_a_of_type_Azdj.a(1);
    }
    if (i == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerSilent()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()))) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131694859, 1).a();
      }
      String str = azfu.a(1);
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
        str = BaseApplicationImpl.getApplication().getString(2131694861);
      }
      a(azgj.a(str, true));
      if (this.jdField_a_of_type_Azfx != null) {
        this.jdField_a_of_type_Azfx.a();
      }
    }
    return i;
  }
  
  public Activity a()
  {
    return BaseActivity.sTopActivity;
  }
  
  public azdj a()
  {
    return this.jdField_a_of_type_Azdj;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public List<azfv> a()
  {
    if (this.jdField_a_of_type_Azfi != null) {
      return this.jdField_a_of_type_Azfi.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azes = new azes();
    this.jdField_a_of_type_Azgh = new azgh();
    this.jdField_a_of_type_Azfi = new azfi(this);
    this.jdField_a_of_type_Azdj = new azdj();
    new azff();
    f();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoiceAssistantManager.1(this), 500L);
  }
  
  public void a(int paramInt, @Nullable Object paramObject)
  {
    if (this.jdField_a_of_type_Azgc != null) {}
    switch (paramInt)
    {
    default: 
      azeu.a("VoiceAssistantManager", "onVoiceMessageCallBack status error = " + paramInt);
      return;
    case 1: 
      bftt.b(2131230733, false);
      this.jdField_a_of_type_Azgc.c();
      return;
    case 2: 
      this.jdField_a_of_type_Azgc.d();
      bftt.b(2131230732, false);
      return;
    case 3: 
      this.jdField_a_of_type_Azgc.e();
      bftt.b(2131230732, false);
      return;
    }
    this.jdField_a_of_type_Azgc.a(paramObject);
    bftt.b(2131230732, false);
  }
  
  public void a(azfk paramazfk)
  {
    if (!azhh.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "executeCommand not allow");
      }
    }
    do
    {
      do
      {
        return;
        if ((b()) && (paramazfk != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VoiceAssistantManager", 2, "do not execute command");
      return;
      if ((!TextUtils.isEmpty(paramazfk.b)) && (paramazfk.b.equals("发消息")))
      {
        if (this.jdField_a_of_type_Azgb != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceAssistantManager", 2, "showChooseView");
          }
          this.jdField_a_of_type_Azgb.f();
          g();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAssistantManager", 2, "executeCommand mVoiceCommandListener is null");
        }
      }
    } while (this.jdField_a_of_type_Azfi == null);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      this.jdField_a_of_type_Azfi.n(paramazfk);
    }
    for (;;)
    {
      g();
      return;
      ThreadManager.getUIHandler().post(new VoiceAssistantManager.2(this, paramazfk));
    }
  }
  
  public void a(azfr paramazfr)
  {
    a(4, paramazfr);
    if (this.jdField_a_of_type_Azgb != null) {
      this.jdField_a_of_type_Azgb.e();
    }
  }
  
  public void a(azfx paramazfx)
  {
    this.jdField_a_of_type_Azfx = paramazfx;
  }
  
  public void a(azgb paramazgb)
  {
    this.jdField_a_of_type_Azgb = paramazgb;
  }
  
  public void a(azgd paramazgd)
  {
    if (this.jdField_a_of_type_Azdj != null)
    {
      if (paramazgd != null)
      {
        this.jdField_a_of_type_Azdj.a(paramazgd);
        this.jdField_a_of_type_Azgc = this.jdField_a_of_type_Azdj;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Azdj.a(null);
    this.jdField_a_of_type_Azgc = null;
  }
  
  public void a(azgg paramazgg)
  {
    if (this.jdField_a_of_type_Azgh != null) {
      this.jdField_a_of_type_Azgh.a(paramazgg);
    }
  }
  
  public void a(String paramString)
  {
    azgh localazgh;
    if (this.jdField_a_of_type_Azgh != null)
    {
      localazgh = this.jdField_a_of_type_Azgh;
      if (azdl.a <= 0) {
        break label29;
      }
    }
    label29:
    for (int i = azdl.a;; i = 0)
    {
      localazgh.a(paramString, i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(azgj.c());
      return;
    }
    b(paramBoolean1, true);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Azfi != null) && (this.jdField_a_of_type_Azfi.a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azes != null) {
      this.jdField_a_of_type_Azes.a();
    }
  }
  
  public void b(String paramString) {}
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Azes != null) && (this.jdField_a_of_type_Azes.a());
  }
  
  public void c()
  {
    a(2, null);
    if (this.jdField_a_of_type_Azgb != null) {
      this.jdField_a_of_type_Azgb.c();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantManager", 2, "resendVoice");
    }
    a(1, null);
    if (this.jdField_a_of_type_Azgb != null) {
      this.jdField_a_of_type_Azgb.d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Azgb != null) {
      this.jdField_a_of_type_Azgb.g();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(true, true);
      azgl.d(4);
    }
  }
  
  public void onDestroy()
  {
    azhh.a().b("VoiceAssistantManager onDestroy");
    if (this.jdField_a_of_type_Azdj != null) {
      this.jdField_a_of_type_Azdj.a();
    }
    azhh.a().c = false;
    if (this.jdField_a_of_type_Azes != null)
    {
      this.jdField_a_of_type_Azes.c();
      this.jdField_a_of_type_Azes = null;
    }
    this.jdField_a_of_type_Azfi = null;
    if (this.jdField_a_of_type_Azgh != null)
    {
      this.jdField_a_of_type_Azgh.c();
      this.jdField_a_of_type_Azgh = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      BaseApplicationImpl.context.unregisterReceiver(this.jdField_a_of_type_Azfh);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfg
 * JD-Core Version:    0.7.0.1
 */
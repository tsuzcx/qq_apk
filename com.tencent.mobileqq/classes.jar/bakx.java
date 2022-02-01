import android.app.Activity;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager.1;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bakx
  implements Handler.Callback, Manager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private baky jdField_a_of_type_Baky;
  private bakz jdField_a_of_type_Bakz;
  private bamm jdField_a_of_type_Bamm;
  private bamp jdField_a_of_type_Bamp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public bakx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!banp.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "quitePanel not allow");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bamm != null) {
        this.jdField_a_of_type_Bamm.a(4, Boolean.valueOf(paramBoolean));
      }
      if (this.jdField_a_of_type_Bakz != null) {
        this.jdField_a_of_type_Bakz.b();
      }
    } while (this.jdField_a_of_type_Bamp == null);
    this.jdField_a_of_type_Bamp.c();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (this.jdField_a_of_type_Baky == null))
    {
      this.jdField_a_of_type_Baky = new baky(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      BaseApplicationImpl.context.registerReceiver(this.jdField_a_of_type_Baky, localIntentFilter);
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
  
  public Activity a()
  {
    return BaseActivity.sTopActivity;
  }
  
  public bajj a()
  {
    if (this.jdField_a_of_type_Bamm != null) {
      return this.jdField_a_of_type_Bamm.a();
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public List<balm> a()
  {
    if (this.jdField_a_of_type_Bakz != null) {
      return this.jdField_a_of_type_Bakz.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bamp = new bamp();
    this.jdField_a_of_type_Bakz = new bakz(this);
    f();
    new bakw();
    this.jdField_a_of_type_Bamm = new bamm("VoiceAssistantManager", this.jdField_a_of_type_Bakz);
    this.jdField_a_of_type_Bamm.e();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoiceAssistantManager.1(this), 500L);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.b(paramInt);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.b(paramInt, paramObject);
    }
  }
  
  public void a(balb parambalb)
  {
    if (!banp.a().b()) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceAssistantManager", 2, "executeCommand not allow");
      }
    }
    do
    {
      do
      {
        return;
        if ((c()) && (parambalb != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VoiceAssistantManager", 2, "do not execute command");
      return;
      if ((!TextUtils.isEmpty(parambalb.b)) && (parambalb.b.equals("发消息")) && (this.jdField_a_of_type_Bamm != null) && (this.jdField_a_of_type_Bamm.a() != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceAssistantManager", 2, "showChooseView");
        }
        this.jdField_a_of_type_Bamm.a().f();
        g();
        return;
      }
    } while (this.jdField_a_of_type_Bakz == null);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      this.jdField_a_of_type_Bakz.p(parambalb);
    }
    for (;;)
    {
      g();
      return;
      ThreadManager.getUIHandler().post(new VoiceAssistantManager.2(this, parambalb));
    }
  }
  
  public void a(bali parambali)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.a(parambali);
    }
  }
  
  public void a(balo parambalo)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.a(parambalo);
    }
  }
  
  public void a(bals parambals)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.a(parambals);
    }
  }
  
  public void a(balu parambalu)
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.a(parambalu);
    }
  }
  
  public void a(bamo parambamo)
  {
    if (this.jdField_a_of_type_Bamp != null) {
      this.jdField_a_of_type_Bamp.a(parambamo);
    }
  }
  
  public void a(String paramString)
  {
    bamp localbamp;
    if (this.jdField_a_of_type_Bamp != null)
    {
      localbamp = this.jdField_a_of_type_Bamp;
      if (baja.a <= 0) {
        break label29;
      }
    }
    label29:
    for (int i = baja.a;; i = 0)
    {
      localbamp.a(paramString, i);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a(bamr.c());
      return;
    }
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bakz != null) && (this.jdField_a_of_type_Bakz.a());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.f();
    }
  }
  
  public void b(String paramString) {}
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null))
    {
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("audio");
      int i = localAudioManager.getStreamVolume(3);
      int j = localAudioManager.getStreamMaxVolume(3);
      return i / j < 0.18F;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.g();
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Bamm != null) && (this.jdField_a_of_type_Bamm.a());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceAssistantManager", 2, "resendVoice");
    }
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.h();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bamm != null) {
      this.jdField_a_of_type_Bamm.i();
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
      bamt.d(4);
    }
  }
  
  public void onDestroy()
  {
    banp.a().b("VoiceAssistantManager onDestroy");
    banp.a().c = false;
    this.jdField_a_of_type_Bakz = null;
    if (this.jdField_a_of_type_Bamp != null)
    {
      this.jdField_a_of_type_Bamp.c();
      this.jdField_a_of_type_Bamp = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
      BaseApplicationImpl.context.unregisterReceiver(this.jdField_a_of_type_Baky);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Bamm != null)
    {
      this.jdField_a_of_type_Bamm.j();
      this.jdField_a_of_type_Bamm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakx
 * JD-Core Version:    0.7.0.1
 */
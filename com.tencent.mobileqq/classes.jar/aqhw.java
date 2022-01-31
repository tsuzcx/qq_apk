import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class aqhw
  implements aqhu
{
  private static volatile aqhw jdField_a_of_type_Aqhw;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  protected aqhs a;
  private WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private WeakReference<ExtendFriendVoiceView> b;
  
  private aqhw(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public static final aqhw a(BaseActivity paramBaseActivity)
  {
    if (jdField_a_of_type_Aqhw == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aqhw == null) {
        jdField_a_of_type_Aqhw = new aqhw(paramBaseActivity);
      }
      return jdField_a_of_type_Aqhw;
    }
  }
  
  public static final void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      b();
      jdField_a_of_type_Aqhw = null;
      return;
    }
  }
  
  public static final void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aqhw != null)
      {
        if (jdField_a_of_type_Aqhw.a()) {
          jdField_a_of_type_Aqhw.c();
        }
        ExtendFriendVoiceView localExtendFriendVoiceView = jdField_a_of_type_Aqhw.a();
        if ((localExtendFriendVoiceView != null) && (localExtendFriendVoiceView.b())) {
          localExtendFriendVoiceView.d();
        }
      }
      return;
    }
  }
  
  public ExtendFriendVoiceView a()
  {
    if (this.b != null) {
      return (ExtendFriendVoiceView)this.b.get();
    }
    return null;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_Aqhs != null) {
      this.jdField_a_of_type_Aqhs.b();
    }
  }
  
  public void a(ExtendFriendVoiceView paramExtendFriendVoiceView)
  {
    if (paramExtendFriendVoiceView != null) {
      this.b = new WeakReference(paramExtendFriendVoiceView);
    }
  }
  
  public void a(File paramFile) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "playVoice " + paramString);
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localBaseActivity != null)
    {
      if (this.jdField_a_of_type_Aqhs == null) {
        this.jdField_a_of_type_Aqhs = new aqhs(this, localBaseActivity);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Aqhs.a(paramString);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MatchChatAioVoicePlayerManager", 2, "stopVoice");
    }
    if (this.jdField_a_of_type_Aqhs != null)
    {
      this.jdField_a_of_type_Aqhs.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void f(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhw
 * JD-Core Version:    0.7.0.1
 */
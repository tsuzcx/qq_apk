import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class aqdn
  implements aqdl
{
  private static volatile aqdn jdField_a_of_type_Aqdn;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  protected aqdj a;
  private WeakReference<BaseActivity> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private WeakReference<ExtendFriendVoiceView> b;
  
  private aqdn(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public static final aqdn a(BaseActivity paramBaseActivity)
  {
    if (jdField_a_of_type_Aqdn == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aqdn == null) {
        jdField_a_of_type_Aqdn = new aqdn(paramBaseActivity);
      }
      return jdField_a_of_type_Aqdn;
    }
  }
  
  public static final void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      b();
      jdField_a_of_type_Aqdn = null;
      return;
    }
  }
  
  public static final void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aqdn != null)
      {
        if (jdField_a_of_type_Aqdn.a()) {
          jdField_a_of_type_Aqdn.c();
        }
        ExtendFriendVoiceView localExtendFriendVoiceView = jdField_a_of_type_Aqdn.a();
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
    if (this.jdField_a_of_type_Aqdj != null) {
      this.jdField_a_of_type_Aqdj.b();
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
      if (this.jdField_a_of_type_Aqdj == null) {
        this.jdField_a_of_type_Aqdj = new aqdj(this, localBaseActivity);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_Aqdj.a(paramString);
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
    if (this.jdField_a_of_type_Aqdj != null)
    {
      this.jdField_a_of_type_Aqdj.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void f(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdn
 * JD-Core Version:    0.7.0.1
 */
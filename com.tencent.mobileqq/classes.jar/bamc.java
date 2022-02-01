import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.statemachine.ShowVoicePanelState.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bamc
  extends bamd
{
  private volatile int jdField_a_of_type_Int = 2;
  private bamm jdField_a_of_type_Bamm;
  
  public bamc(bamm parambamm)
  {
    this.jdField_a_of_type_Bamm = parambamm;
  }
  
  public int a()
  {
    int i = 2;
    if (!banp.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShowVoicePanelState", 2, "enterVoicePanel not allow");
      }
      i = 3;
    }
    bakx localbakx;
    do
    {
      do
      {
        return i;
        if ((this.jdField_a_of_type_Bamm != null) && (this.jdField_a_of_type_Bamm.a() != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShowVoicePanelState", 2, "enterVoicePanel mVoicePresenter is null");
      return 2;
      localbakx = bakl.a();
      if (localbakx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShowVoicePanelState", 2, "enterVoicePanel voiceAssistant is null");
    return 2;
    i = this.jdField_a_of_type_Bamm.a().a(this.jdField_a_of_type_Bamm.a().a());
    if (i == 1)
    {
      FloatingScreenPermission.enterPermissionRequestDialogCustom(localbakx.a(), 2131720027, 2131720026);
      return i;
    }
    if (i == 0)
    {
      if (localbakx.b()) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131695073, 1).a();
      }
      String str = ball.a(1);
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
        str = BaseApplicationImpl.getApplication().getString(2131695075);
      }
      localbakx.a(bamr.a(str, true));
      if ((this.jdField_a_of_type_Bamm != null) && (this.jdField_a_of_type_Bamm.a() != null)) {
        this.jdField_a_of_type_Bamm.a().a();
      }
    }
    return i;
  }
  
  public String a()
  {
    return bamc.class.getSimpleName();
  }
  
  public void a()
  {
    super.a();
    if (bakw.a())
    {
      bamt.e(1);
      return;
    }
    bamt.e(2);
  }
  
  public boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = super.a(paramMessage);
    }
    do
    {
      return bool;
      ThreadManager.getUIHandler().post(new ShowVoicePanelState.1(this));
      return true;
    } while (this.jdField_a_of_type_Bamm == null);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Bamm.c(4);
      return true;
    }
    this.jdField_a_of_type_Bamm.c(1);
    this.jdField_a_of_type_Bamm.a(1);
    return true;
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamc
 * JD-Core Version:    0.7.0.1
 */
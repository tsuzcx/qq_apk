import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public class aywk
  extends ayrr<View>
{
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aywl(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  
  public aywk(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131561306, (ViewGroup)this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_JavaLangObject).findViewById(2131370742);
    }
  }
  
  private void a(Message paramMessage)
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getWidth() <= 0) || (this.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
        break label254;
      }
      ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView, 2, ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard);
      bool1 = false;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        try
        {
          if (paramMessage.arg1 < 2)
          {
            Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
            localMessage.what = paramMessage.what;
            paramMessage.arg1 += 1;
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
            bool2 = bool1;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileMediaWallComponent", 2, String.format("checkMedalGuide needResendMsg=%s", new Object[] { Boolean.valueOf(bool2) }));
            if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard != null)
            {
              paramMessage = ((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard;
              QLog.d("ProfileMediaWallComponent", 2, String.format("checkMedalGuide medalSwitchDisable=%s iMedalCount=%s iNewCount=%s iUpgradeCount=%s", new Object[] { Boolean.valueOf(paramMessage.medalSwitchDisable), Integer.valueOf(paramMessage.iMedalCount), Integer.valueOf(paramMessage.iNewCount), Integer.valueOf(paramMessage.iUpgradeCount) }));
            }
          }
          return;
        }
        catch (Exception paramMessage)
        {
          boolean bool2;
          continue;
        }
        paramMessage = paramMessage;
        boolean bool1 = true;
        QLog.e("ProfileMediaWallComponent", 1, "checkMedalGuide fail.", paramMessage);
        bool2 = bool1;
        continue;
        label254:
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (bool1) {
      bool2 = bool1;
    }
  }
  
  public int a()
  {
    return 1025;
  }
  
  public String a()
  {
    return "ProfileMediaWallComponent";
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    a();
    if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 2000L);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
  }
  
  public void f()
  {
    MedalGuideView.a();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywk
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqcp
  implements adif, Handler.Callback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbgu jdField_a_of_type_Bbgu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public aqcp(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, " init ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface());
      }
    }
  }
  
  private bbgu a(String paramString)
  {
    return bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690575), new aqcq(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131699567)).show();
        }
      }
    }
    while (!this.d)
    {
      return;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true, "", true, true, null, "from_internal", null);
      return;
      if (this.c)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131699567)).show();
          return;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false, "", true, true, null, "from_internal", null);
        return;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
      return;
    }
    a();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbgu != null) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (!this.jdField_a_of_type_Bbgu.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_Bbgu.show();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bbgu.setMessage(2131695562);
      this.jdField_a_of_type_Bbgu.setTitle(2131720249);
      aqcr localaqcr = new aqcr(this);
      this.jdField_a_of_type_Bbgu.setNegativeButton(2131690596, localaqcr);
      this.jdField_a_of_type_Bbgu.setPositiveButton(2131695532, localaqcr);
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      return;
      b();
    } while (!QLog.isColorLevel());
    QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState DESTROY =");
  }
  
  public void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, "handleForwordIM");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      this.jdField_a_of_type_Boolean = paramIntent.getBoolean("thridparty_pull_aio", false);
    } while (!this.jdField_a_of_type_Boolean);
    this.d = paramBoolean;
    this.jdField_b_of_type_Boolean = paramIntent.getBoolean("pull_aio_audio", false);
    this.c = paramIntent.getBoolean("pull_aio_video", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getString("openid", "");
    this.jdField_b_of_type_JavaLangString = paramIntent.getString("appid", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e = paramIntent.getString("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent.getString("uinname", "");
    a(true);
  }
  
  public int[] a()
  {
    return new int[] { 5, 11 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcp
 * JD-Core Version:    0.7.0.1
 */
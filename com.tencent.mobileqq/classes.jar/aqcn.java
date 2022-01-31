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

public class aqcn
  implements adih, Handler.Callback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bbgg jdField_a_of_type_Bbgg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public aqcn(BaseChatPie paramBaseChatPie)
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
  
  private bbgg a(String paramString)
  {
    return bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690575), new aqco(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131699556)).show();
        }
      }
    }
    while (!this.d)
    {
      return;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true, "", true, true, null, "from_internal", null);
      return;
      if (this.c)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131699556)).show();
          return;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false, "", true, true, null, "from_internal", null);
        return;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
      return;
    }
    a();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbgg != null) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (!this.jdField_a_of_type_Bbgg.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_Bbgg.show();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_Bbgg.setMessage(2131695561);
      this.jdField_a_of_type_Bbgg.setTitle(2131720238);
      aqcp localaqcp = new aqcp(this);
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, localaqcp);
      this.jdField_a_of_type_Bbgg.setPositiveButton(2131695531, localaqcp);
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    this.jdField_a_of_type_Bbgg.show();
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
 * Qualified Name:     aqcn
 * JD-Core Version:    0.7.0.1
 */
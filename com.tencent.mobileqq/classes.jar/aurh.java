import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class aurh
  implements agin, Handler.Callback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public aurh(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, " init ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppInterface());
      }
    }
  }
  
  private QQCustomDialog a(String paramString)
  {
    return bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690679), new auri(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698953)).show();
        }
      }
    }
    while (!this.d)
    {
      return;
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.phoneNum, true, "", true, true, null, "from_internal", null);
      return;
      if (this.c)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))
        {
          a(this.jdField_a_of_type_AndroidAppActivity.getString(2131698953)).show();
          return;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.phoneNum, false, "", true, true, null, "from_internal", null);
        return;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
      return;
    }
    a();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131694975);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131719334);
      aurj localaurj = new aurj(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, localaurj);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694945, localaurj);
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = paramIntent.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = paramIntent.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.phoneNum = paramIntent.getString("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick = paramIntent.getString("uinname", "");
    a(true);
  }
  
  public int[] a()
  {
    return new int[] { 7, 14 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurh
 * JD-Core Version:    0.7.0.1
 */
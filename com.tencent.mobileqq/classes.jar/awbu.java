import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class awbu
  implements adif
{
  public static int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awbv(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewFlipper jdField_a_of_type_AndroidWidgetViewFlipper;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 259200;
  }
  
  public awbu(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private Friends a()
  {
    return ((ajxl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  private void a(RichStatus paramRichStatus)
  {
    String str;
    if (paramRichStatus != null)
    {
      str = paramRichStatus.getPlainText();
      long l1 = paramRichStatus.time;
      long l2 = NetConnInfoCenter.getServerTime();
      paramRichStatus = amvu.a();
      if (paramRichStatus != null)
      {
        jdField_a_of_type_Int = (int)(paramRichStatus.a * 60.0D * 60.0D);
        if (QLog.isColorLevel()) {
          QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> richTitleConfBean.c2c_time_interval = " + paramRichStatus.a);
        }
      }
      if (QLog.isColorLevel())
      {
        paramRichStatus = new StringBuilder().append("needShowRichSubTitle-> c = ").append(l2).append(" time = ").append(l1).append(" needShow =");
        if (l2 - l1 >= jdField_a_of_type_Int) {
          break label196;
        }
        bool = true;
        QLog.d("AioFriendTitleHelper", 2, bool);
      }
      if (l2 - l1 < jdField_a_of_type_Int) {
        if (TextUtils.isEmpty(str)) {
          break label202;
        }
      }
    }
    label196:
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A66A");
      return;
      bool = false;
      break;
    }
  }
  
  private void d()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) && (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())))
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 1 startFlipping all Visibility");
        }
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
      if (!this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.startFlipping();
      }
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText())) && (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView))
      {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        return;
      }
    } while ((!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) || (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_b_of_type_AndroidWidgetTextView));
    this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetViewFlipper != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      if (QLog.isColorLevel()) {
        QLog.d("AioFriendTitleHelper", 2, "needShowRichSubTitle-> destroy()");
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2: 
    case 4: 
    case 8: 
      do
      {
        return;
        a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetViewFlipper, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g);
        return;
        b("");
        return;
      } while ((this.jdField_a_of_type_AndroidWidgetViewFlipper == null) || (!this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()));
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
      return;
    }
    a();
  }
  
  public void a(ViewFlipper paramViewFlipper, TextView paramTextView1, TextView paramTextView2)
  {
    this.jdField_a_of_type_AndroidWidgetViewFlipper = paramViewFlipper;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    c();
    b();
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetViewFlipper == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new aykk(paramString, 3, 12));
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b("");
  }
  
  public boolean a()
  {
    Friends localFriends = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localFriends == null) {
      return false;
    }
    int i = bbcz.a(localFriends.detalStatusFlag, localFriends.iTermType);
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, isStatusOffline() -> status = " + i);
    }
    return i == 0;
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, onShowSubTitleText() isShowInputStatus =  " + paramBoolean + " statusText = " + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new AioFriendTitleHelper.2(this, paramBoolean, paramString));
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 8, 11 };
  }
  
  protected void b()
  {
    RichStatus localRichStatus = ((aweq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new AioFriendTitleHelper.1(this));
      return;
    }
    a(localRichStatus);
  }
  
  public void b(String paramString)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Q) && (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        if (!b()) {
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        }
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
        }
      } while (!QLog.isColorLevel());
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 2 subTitle = " + paramString);
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        }
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
        }
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 3");
        }
        aujc.a().a(a(), this.jdField_a_of_type_AndroidWidgetTextView, false);
        return;
      }
      if (a())
      {
        if ((this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        }
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
        }
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 4");
        }
        aujc.a().a(a(), this.jdField_a_of_type_AndroidWidgetTextView, false);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.Q)
      {
        if ((this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
        }
        if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
          this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
        }
        if (QLog.isColorLevel()) {
          QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 5");
        }
        aujc.a().a(a(), this.jdField_a_of_type_AndroidWidgetTextView, false);
        return;
      }
    } while ((b()) || (a()) || (this.jdField_b_of_type_Boolean));
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, updateSubTitleStatusAndText() -> type 1");
      }
      d();
    }
    aujc.a().a(a(), this.jdField_a_of_type_AndroidWidgetTextView, true);
  }
  
  public boolean b()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return false;
    }
    aruf localaruf = (aruf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(32);
    int i = j;
    if (localaruf != null)
    {
      i = j;
      if (localaruf.c()) {
        i = 1;
      }
    }
    if (i != 0) {
      return true;
    }
    return ((adji)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(43)).c();
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetViewFlipper == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbu
 * JD-Core Version:    0.7.0.1
 */
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.1;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.2;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper.4;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bbss
  implements agin, azfh
{
  public static int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bbst(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewFlipper jdField_a_of_type_AndroidWidgetViewFlipper;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = 259200;
  }
  
  public bbss(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private Friends a()
  {
    return ((anvk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
  }
  
  private void a(RichStatus paramRichStatus)
  {
    String str;
    if (paramRichStatus != null)
    {
      str = paramRichStatus.getPlainText();
      long l1 = paramRichStatus.time;
      long l2 = NetConnInfoCenter.getServerTime();
      paramRichStatus = arfq.a();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.reportClickEvent("CliOper", "0X800A66A");
      return;
      bool = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      if ((this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() == this.jdField_a_of_type_AndroidWidgetTextView) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
      }
      if (paramBoolean2) {
        azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, a(), this.jdField_a_of_type_AndroidWidgetTextView, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioFriendTitleHelper", 2, new Object[] { "resetSubTitleText, ", paramString });
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetViewFlipper.getCurrentView() != this.jdField_a_of_type_AndroidWidgetTextView) {
        this.jdField_a_of_type_AndroidWidgetViewFlipper.showNext();
      }
    }
  }
  
  private void e()
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
    b(null);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 4: 
    case 6: 
    case 10: 
      do
      {
        return;
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mViewFlipper, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mSubTilteText, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mSubTitleText2);
        return;
        b("");
        return;
      } while ((this.jdField_a_of_type_AndroidWidgetViewFlipper == null) || (!this.jdField_a_of_type_AndroidWidgetViewFlipper.isFlipping()));
      this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
      return;
    }
    b();
  }
  
  public void a(ViewFlipper paramViewFlipper, TextView paramTextView1, TextView paramTextView2)
  {
    this.jdField_a_of_type_AndroidWidgetViewFlipper = paramViewFlipper;
    this.jdField_a_of_type_AndroidWidgetViewFlipper.setOutAnimation(null);
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    d();
    c();
    if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)this.jdField_a_of_type_AndroidWidgetTextView).setLyricStateListener(this);
    }
  }
  
  protected void a(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetViewFlipper == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(paramString, 3, 12));
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b("");
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof OnlineStatusLyricView)) {
      return ((OnlineStatusLyricView)this.jdField_a_of_type_AndroidWidgetTextView).a();
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, onShowSubTitleText() isShowInputStatus =  " + paramBoolean + " statusText = " + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.runOnUiThread(new AioFriendTitleHelper.2(this, paramBoolean, paramString));
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 4, 6, 10, 14 };
  }
  
  public void b()
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
    if ((this.jdField_a_of_type_AndroidWidgetTextView instanceof OnlineStatusLyricView)) {
      ((OnlineStatusLyricView)this.jdField_a_of_type_AndroidWidgetTextView).d();
    }
  }
  
  public void b(String paramString)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setSubTitleVisiable) && (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (c())
    {
      a(false, false, "isListenTogetherTime");
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a(false, true, "isInputting");
      return;
    }
    if (b())
    {
      a(true, true, "isStatusOffline");
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setSubTitleVisiable)
    {
      a(true, true, "mChatPie.setSubTitleVisible");
      return;
    }
    if (a())
    {
      a(false, false, "isPlayLyric");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle");
      }
      e();
    }
    azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, a(), this.jdField_a_of_type_AndroidWidgetTextView, true);
  }
  
  public boolean b()
  {
    Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    if (localFriends == null)
    {
      ThreadManager.post(new AioFriendTitleHelper.4(this), 8, null, true);
      return false;
    }
    int i = ContactUtils.getFriendStatus(localFriends.detalStatusFlag, localFriends.iTermType);
    if (QLog.isColorLevel()) {
      QLog.i("AioFriendTitleHelper", 2, "needShowRichSubTitle, isStatusOffline() -> status = " + i);
    }
    return i == 0;
  }
  
  protected void c()
  {
    RichStatus localRichStatus = ((bbvn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.STATUS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new AioFriendTitleHelper.1(this));
      return;
    }
    a(localRichStatus);
  }
  
  public boolean c()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return false;
    }
    awim localawim = (awim)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(32);
    int i = j;
    if (localawim != null)
    {
      i = j;
      if (localawim.c()) {
        i = 1;
      }
    }
    if (i != 0) {
      return true;
    }
    return ((agkk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(43)).c();
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetViewFlipper == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetViewFlipper.stopFlipping();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbss
 * JD-Core Version:    0.7.0.1
 */
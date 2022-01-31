import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.QbossADImmersionBannerManager.1;
import mqq.os.MqqHandler;

public class bgqt
  extends ahag
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgmb jdField_a_of_type_Bgmb;
  private bgqq jdField_a_of_type_Bgqq;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  private int a(bgqq parambgqq)
  {
    if ((parambgqq == null) || (TextUtils.isEmpty(parambgqq.h))) {
      return 24;
    }
    try
    {
      int i = Integer.parseInt(parambgqq.h);
      return i;
    }
    catch (Exception parambgqq)
    {
      parambgqq.printStackTrace();
      QLog.i("QbossADBannerManager", 1, "getFrameRate exception");
    }
    return 24;
  }
  
  private void i()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    }
    for (;;)
    {
      localLayoutParams.width = b();
      localLayoutParams.height = c();
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = b();
      ((ViewGroup.LayoutParams)localObject).height = super.c();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(localLayoutParams.height * 2.050848F));
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams.height;
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1062;
      localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.c, this.jdField_a_of_type_AndroidWidgetImageView };
      localMqqHandler.sendMessage(localMessage);
      return;
    }
    QLog.i("QbossADBannerManager", 1, "handle is null.");
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null)) {
      return;
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(1063);
      return;
    }
    QLog.i("QbossADBannerManager", 1, "handle is null.");
  }
  
  protected int a()
  {
    return 2131495936;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131312424));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131312513));
    this.c = ((TextView)localView.findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299197));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302231));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131299191));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131303375));
    i();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected void a(ahac paramahac)
  {
    super.a(paramahac);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADImmersionBannerManager.1(this, paramahac));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Bgmb != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Bgmb.stop();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bgmb.start();
  }
  
  protected int c()
  {
    return super.c() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + bajq.b(50.0F);
  }
  
  public void c()
  {
    super.c();
    j();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bgmb != null)
    {
      this.jdField_a_of_type_Bgmb.stop();
      this.jdField_a_of_type_Bgmb.b();
    }
    k();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bgmb != null)
    {
      this.jdField_a_of_type_Bgmb.stop();
      this.jdField_a_of_type_Bgmb.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqt
 * JD-Core Version:    0.7.0.1
 */
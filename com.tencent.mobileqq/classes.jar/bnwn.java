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

public class bnwn
  extends almq
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnqp jdField_a_of_type_Bnqp;
  private bnwk jdField_a_of_type_Bnwk;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  private int a(bnwk parambnwk)
  {
    if ((parambnwk == null) || (TextUtils.isEmpty(parambnwk.j))) {
      return 24;
    }
    try
    {
      int i = Integer.parseInt(parambnwk.j);
      return i;
    }
    catch (Exception parambnwk)
    {
      parambnwk.printStackTrace();
      QLog.i("QbossADBannerManager", 1, "getFrameRate exception");
    }
    return 24;
  }
  
  private void i()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    }
    for (;;)
    {
      localLayoutParams.width = b();
      localLayoutParams.height = c();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
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
      localMessage.obj = new View[] { this.jdField_a_of_type_AndroidViewView, this.c, this.d, this.jdField_a_of_type_AndroidWidgetImageView };
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
    return 2131562015;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379939));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380071));
    this.c = ((TextView)localView.findViewById(2131379648));
    this.d = ((TextView)localView.findViewById(2131379656));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365120));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368395));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365112));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369774));
    i();
    return new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected void a(almm paramalmm)
  {
    super.a(paramalmm);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADImmersionBannerManager.1(this, paramalmm));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Bnqp != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Bnqp.stop();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bnqp.start();
  }
  
  protected int c()
  {
    return super.c() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + bhtq.b(50.0F);
  }
  
  public void c()
  {
    super.c();
    j();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bnqp != null)
    {
      this.jdField_a_of_type_Bnqp.stop();
      this.jdField_a_of_type_Bnqp.b();
    }
    k();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bnqp != null)
    {
      this.jdField_a_of_type_Bnqp.stop();
      this.jdField_a_of_type_Bnqp.b();
      this.jdField_a_of_type_Bnqp = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwn
 * JD-Core Version:    0.7.0.1
 */
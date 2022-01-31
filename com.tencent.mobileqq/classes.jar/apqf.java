import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.4;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.7;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;

public class apqf
  extends apou
{
  private volatile long jdField_a_of_type_Long;
  alku jdField_a_of_type_Alku = new apqi(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected QQAppInterface a;
  
  public apqf(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void b(int paramInt)
  {
    if (CameraEmoAllSend.a) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    aprl localaprl = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Aprl;
    QQViewPager localQQViewPager = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
    EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      CameraEmoAllSend.a = bool;
      if ((!CameraEmoAllSend.a) || (localaprl == null) || (localQQViewPager == null)) {
        break;
      }
      paramInt = localaprl.a(11);
      if ((BaseActivity.sTopActivity == null) || (localEmoticonMainPanel.getVisibility() != 0) || (localQQViewPager.getCurrentItem() != paramInt)) {
        break;
      }
      bdcd.a(BaseActivity.sTopActivity, localContext.getString(2131692044), 2131692045, 2131692051, new apqj(this, localContext), new apqk(this)).show();
      return;
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryShowCameraEmoGuide start.");
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) && (this.jdField_a_of_type_AndroidViewViewStub == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      i();
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363891);
      if (localImageView != null) {
        localImageView.setOnClickListener(new apqg(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165587));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().findViewById(2131380049));
  }
  
  public void a(apsm paramapsm)
  {
    if (paramapsm.a == 11)
    {
      l();
      paramapsm = (apjf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
      if (paramapsm.b()) {
        paramapsm.a(false);
      }
      if (((apjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a() == 0) {
        m();
      }
      return;
    }
    j();
  }
  
  public int[] a()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alku);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alku);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alku);
    }
  }
  
  void i()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363893);
    } while ((localImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null));
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() != 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      localLayoutParams.height = ((int)(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() * 0.6F));
      localLayoutParams.width = ((int)(localLayoutParams.height * 1.3F));
      localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() * 0.08F));
      localImageView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getViewTreeObserver().addOnGlobalLayoutListener(new apqh(this, localImageView));
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelCameraHelper.4(this), 200L);
  }
  
  void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "doSyncCameraEmotion");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    if (localQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new EmoticonPanelCameraHelper.7(this, localContext, localQQAppInterface), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqf
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.3;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.6;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class asnf
  extends asls
{
  private volatile long jdField_a_of_type_Long;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  anul jdField_a_of_type_Anul = new asnh(this);
  protected QQAppInterface a;
  
  public asnf(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void b(int paramInt)
  {
    if (CameraEmoAllSend.a) {
      return;
    }
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    asop localasop = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Asop;
    EmoticonPanelViewPager localEmoticonPanelViewPager = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager;
    EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      CameraEmoAllSend.a = bool;
      if ((!CameraEmoAllSend.a) || (localasop == null) || (localEmoticonPanelViewPager == null)) {
        break;
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(11);
      if ((BaseActivity.sTopActivity == null) || (localEmoticonMainPanel.getVisibility() != 0) || (localEmoticonPanelViewPager.getCurrentItem() != paramInt)) {
        break;
      }
      bhlq.a(BaseActivity.sTopActivity, localContext.getString(2131691703), 2131691704, 2131691710, new asni(this, localContext), new asnj(this)).show();
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
      a();
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364137);
      if (localImageView != null) {
        localImageView.setOnClickListener(new asng(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165623));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  protected int a()
  {
    int j = ((Integer)bhsi.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    int i = j;
    if (j == 0) {
      i = (int)(XPanelContainer.b() * this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
    }
    return i;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364139);
    } while ((localImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = a();
    localLayoutParams.height = ((int)(i * 0.5F));
    localLayoutParams.width = ((int)(localLayoutParams.height * 1.2F));
    localLayoutParams.topMargin = ((int)(i * 0.11F));
    localImageView.setLayoutParams(localLayoutParams);
  }
  
  public void a(aspt paramaspt)
  {
    if (paramaspt.a == 11)
    {
      l();
      paramaspt = (asfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
      if (paramaspt.b()) {
        paramaspt.a(false);
      }
      if (((asgf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a() == 0) {
        m();
      }
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelCameraHelper.3(this), 200L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().findViewById(2131381251));
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anul);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anul);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anul);
    }
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
    ThreadManager.excute(new EmoticonPanelCameraHelper.6(this, localContext, localQQAppInterface), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnf
 * JD-Core Version:    0.7.0.1
 */
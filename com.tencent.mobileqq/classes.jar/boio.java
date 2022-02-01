import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class boio
  extends boil
{
  protected ImageView a;
  protected LinearLayout a;
  protected QQCustomDialog a;
  
  public boio(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364291));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364290));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentMode", 2, new Object[] { "handleSelectMode", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131698036)).setPositiveButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131694399), new boiq(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131718450), new boip(this));
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SegmentMode", 2, "segment back dialog error:" + localThrowable);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Bmul instanceof bmuk)) {
        if (((bmuk)this.jdField_a_of_type_Bmul).a())
        {
          ((bmuk)this.jdField_a_of_type_Bmul).a();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
          continue;
          if ((this.jdField_a_of_type_Bmul instanceof bmuk)) {
            ((bmuk)this.jdField_a_of_type_Bmul).b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boio
 * JD-Core Version:    0.7.0.1
 */
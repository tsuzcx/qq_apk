import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class bhhx
  extends bhht
{
  protected ImageView a;
  protected LinearLayout a;
  protected bafb a;
  private boolean b;
  
  public bhhx(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bafb == null) {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131632606)).setPositiveButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131629116), new bhhz(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131653351), new bhhy(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bafb != null) && (!this.jdField_a_of_type_Bafb.isShowing())) {
        this.jdField_a_of_type_Bafb.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SegmentMode", 2, "segment back dialog error:" + localThrowable);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298334));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298333));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentMode", 2, new Object[] { "handleSelectMode", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bhia(this));
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      ((PressDarkImageButton)this.jdField_a_of_type_AndroidWidgetImageView).setEnableDark(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
      this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
      return;
    }
    ((PressDarkImageButton)this.jdField_a_of_type_AndroidWidgetImageView).setEnableDark(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(127);
    this.jdField_a_of_type_AndroidWidgetImageView.postInvalidate();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131298334: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bhdi.c())
        {
          this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bhdi.A();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bhdi.C();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhhx
 * JD-Core Version:    0.7.0.1
 */
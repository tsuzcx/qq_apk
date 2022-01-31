import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class blor
  extends blon
{
  protected ImageView a;
  protected LinearLayout a;
  protected bdfq a;
  private boolean b;
  
  public blor(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdfq == null) {
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131698642)).setPositiveButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131694951), new blot(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131719672), new blos(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bdfq != null) && (!this.jdField_a_of_type_Bdfq.isShowing())) {
        this.jdField_a_of_type_Bdfq.show();
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363947));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363946));
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
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new blou(this));
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
    case 2131363947: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bkil.c())
        {
          this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkil.y();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkil.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blor
 * JD-Core Version:    0.7.0.1
 */
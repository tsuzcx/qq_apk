import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class bltd
  extends blsz
{
  protected ImageView a;
  protected LinearLayout a;
  protected bdjz a;
  private boolean b;
  
  public bltd(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdjz == null) {
      this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(), 230).setMessage(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131698654)).setPositiveButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131694953), new bltf(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getString(2131719684), new blte(this));
    }
    try
    {
      if ((this.jdField_a_of_type_Bdjz != null) && (!this.jdField_a_of_type_Bdjz.isShowing())) {
        this.jdField_a_of_type_Bdjz.show();
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363949));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363948));
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
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bltg(this));
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
    case 2131363949: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bkms.c())
        {
          this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkms.y();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Bkms.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltd
 * JD-Core Version:    0.7.0.1
 */
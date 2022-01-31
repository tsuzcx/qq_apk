import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;

public class bkul
  extends blbl
{
  private static boolean jdField_a_of_type_Boolean;
  private WatermarkEditView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView;
  
  public bkul(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363906);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView = ((WatermarkEditView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363905));
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a();
    }
  }
  
  public Object a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  protected void a() {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      d();
      jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.setVisibility(8);
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkul
 * JD-Core Version:    0.7.0.1
 */
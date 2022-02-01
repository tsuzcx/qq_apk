import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;

public class blto
  extends bmar
{
  private static boolean jdField_a_of_type_Boolean;
  private WatermarkEditView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView;
  
  public blto(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)
    {
      ViewStub localViewStub = (ViewStub)this.mActivity.findViewById(2131364174);
      if (localViewStub != null)
      {
        localViewStub.inflate();
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView = ((WatermarkEditView)this.mActivity.findViewById(2131364173));
        this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a(this.mActivity);
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a();
    }
  }
  
  public Object get(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  protected void initView() {}
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      a();
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
 * Qualified Name:     blto
 * JD-Core Version:    0.7.0.1
 */
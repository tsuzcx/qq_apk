import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;

public class anpg
  implements DialogInterface.OnClickListener
{
  public anpg(MusicProviderView paramMusicProviderView, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    MusicProviderView.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.ay_();
    this.jdField_a_of_type_DovComQqImCaptureViewMusicProviderView.a(this.jdField_a_of_type_ComTencentWidgetAdapterView, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpg
 * JD-Core Version:    0.7.0.1
 */
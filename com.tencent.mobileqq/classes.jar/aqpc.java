import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import java.io.File;

class aqpc
  implements bfoq
{
  aqpc(aqox paramaqox, bfol parambfol, AIOPicData paramAIOPicData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_Bfol.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
    }
    if (this.jdField_a_of_type_Aqox.a(paramView, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, this.jdField_a_of_type_JavaIoFile)) {}
    this.jdField_a_of_type_Bfol.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpc
 * JD-Core Version:    0.7.0.1
 */
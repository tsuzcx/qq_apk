import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class bbrb
  implements audq
{
  bbrb(bbra parambbra, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void onNo()
  {
    this.jdField_a_of_type_Bbra.updateUI();
    this.jdField_a_of_type_Bbra.f(true);
  }
  
  public void onYes()
  {
    try
    {
      this.jdField_a_of_type_Bbra.updateUI();
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 20);
      if (this.jdField_a_of_type_Bbra.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView != null)
      {
        this.jdField_a_of_type_Bbra.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setDoubleTapEnable(true);
        this.jdField_a_of_type_Bbra.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setScaleEnable(true);
      }
      this.jdField_a_of_type_Bbra.e();
      this.jdField_a_of_type_Bbra.jdField_a_of_type_Bbqb.a().b();
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog exception = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrb
 * JD-Core Version:    0.7.0.1
 */
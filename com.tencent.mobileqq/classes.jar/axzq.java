import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.page.Gallery;

class axzq
  implements arrh
{
  axzq(axzp paramaxzp, AIOFilePictureData paramAIOFilePictureData) {}
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_Axzp.updateUI();
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 20);
      if (this.jdField_a_of_type_Axzp.a.getGallery() != null)
      {
        this.jdField_a_of_type_Axzp.a.getGallery().enableDoubleTap(true);
        this.jdField_a_of_type_Axzp.a.getGallery().enableScaleGesture(true);
      }
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog exception = " + localException.getMessage());
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axzp.updateUI();
    this.jdField_a_of_type_Axzp.e(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzq
 * JD-Core Version:    0.7.0.1
 */
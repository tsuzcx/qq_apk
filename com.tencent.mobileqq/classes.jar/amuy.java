import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class amuy
  implements DialogInterface.OnClickListener
{
  public amuy(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(), this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, QIMPtvTemplateAdapter.a(this.a));
    this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
    QIMCommonLoadingProgress.a(this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo).a();
    ShortVideoMtaReport.a("shortvideo_download_effects", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amuy
 * JD-Core Version:    0.7.0.1
 */
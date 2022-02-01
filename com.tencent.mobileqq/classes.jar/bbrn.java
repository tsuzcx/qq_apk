import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class bbrn
  implements DialogInterface.OnClickListener
{
  bbrn(bbrl parambbrl, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOPictureData));
    bbrl.a(this.jdField_a_of_type_Bbrl).a((AIOPictureData)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Bbrl.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrn
 * JD-Core Version:    0.7.0.1
 */
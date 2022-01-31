import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;

class apvv
  implements DialogInterface.OnClickListener
{
  apvv(apvq paramapvq, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      apsm.a().a().a("AIOGalleryVideoView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOShortVideoData));
    paramDialogInterface = (AIOShortVideoData)this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Apvq.a.a(paramDialogInterface);
    this.jdField_a_of_type_Apvq.a.a(paramDialogInterface.jdField_a_of_type_Long, paramDialogInterface.jdField_a_of_type_Int, 2);
    this.jdField_a_of_type_Apvq.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvv
 * JD-Core Version:    0.7.0.1
 */
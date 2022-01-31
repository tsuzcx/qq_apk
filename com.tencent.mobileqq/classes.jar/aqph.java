import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;

class aqph
  implements DialogInterface.OnClickListener
{
  aqph(aqox paramaqox, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      aqmb.a().a().a("AIOGalleryPicView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOPicData));
    this.jdField_a_of_type_Aqox.a.a((AIOPicData)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Aqox.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqph
 * JD-Core Version:    0.7.0.1
 */
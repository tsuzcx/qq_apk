import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class ayav
  implements DialogInterface.OnClickListener
{
  ayav(ayao paramayao, int paramInt, Object paramObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips type = " + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
    } while (!(this.jdField_a_of_type_JavaLangObject instanceof AIOVideoData));
    paramDialogInterface = (AIOVideoData)this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_Ayao.a.a(paramDialogInterface);
    this.jdField_a_of_type_Ayao.a.a(paramDialogInterface.jdField_a_of_type_Long, paramDialogInterface.jdField_a_of_type_Int, 2);
    this.jdField_a_of_type_Ayao.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayav
 * JD-Core Version:    0.7.0.1
 */
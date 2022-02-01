import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class bndt
  implements DialogInterface.OnDismissListener
{
  bndt(bndn parambndn) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
    this.a.jdField_a_of_type_Bnee.a(true, 0.0F, 0.0F, 0.0F, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndt
 * JD-Core Version:    0.7.0.1
 */
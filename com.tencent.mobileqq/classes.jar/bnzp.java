import android.arch.lifecycle.MutableLiveData;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import java.util.List;

class bnzp
  implements DialogInterface.OnClickListener
{
  bnzp(bnzo parambnzo, CutModelKt paramCutModelKt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnzo.a).size() <= 2) {
      AEEditorMultiCutEditFragment.b(this.jdField_a_of_type_Bnzo.a).setImageResource(2130837918);
    }
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnzo.a, 0L);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnzo.a).a.postValue(bnzu.a(this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getUuid(), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnzo.a), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bnzo.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzp
 * JD-Core Version:    0.7.0.1
 */
import android.arch.lifecycle.MutableLiveData;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment;
import java.util.List;

class bmjx
  implements DialogInterface.OnClickListener
{
  bmjx(bmjw parambmjw, CutModelKt paramCutModelKt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjw.a).size() <= 2) {
      AEEditorMultiCutEditFragment.b(this.jdField_a_of_type_Bmjw.a).setImageResource(2130837904);
    }
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjw.a, 0L);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjw.a).a.postValue(bmkc.a(this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getUuid(), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjw.a), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_Bmjw.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjx
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bnym
  implements DialogInterface.OnClickListener
{
  public bnym(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.getActivity().getIntent().putExtra("startTimeEdit", AEEditorVideoEditFragment.a(this.a, false));
    this.a.getActivity().getIntent().putExtra("endTimeEdit", AEEditorVideoEditFragment.b(this.a, false));
    this.a.getActivity().getIntent().putExtra("endSpeedEdit", AEEditorVideoEditFragment.a(this.a, false));
    bnqm.a().p();
    this.a.a().a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnym
 * JD-Core Version:    0.7.0.1
 */
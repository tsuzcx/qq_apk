import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment;

public class beqe
  implements DialogInterface.OnClickListener
{
  public beqe(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqe
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment;

public class bdkm
  implements DialogInterface.OnClickListener
{
  public bdkm(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().finish();
    WriteTogetherEditorFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkm
 * JD-Core Version:    0.7.0.1
 */
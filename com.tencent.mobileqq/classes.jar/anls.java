import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.interact.EditVideoInteract;

public class anls
  implements DialogInterface.OnClickListener
{
  public anls(EditVideoInteract paramEditVideoInteract) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anls
 * JD-Core Version:    0.7.0.1
 */
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag;

public class aody
  implements DialogInterface.OnClickListener
{
  public aody(EditVideoTag paramEditVideoTag) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVideoTag.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aody
 * JD-Core Version:    0.7.0.1
 */
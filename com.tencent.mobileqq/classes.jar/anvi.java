import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag;

public class anvi
  implements DialogInterface.OnClickListener
{
  public anvi(EditVideoTag paramEditVideoTag) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVideoTag.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvi
 * JD-Core Version:    0.7.0.1
 */
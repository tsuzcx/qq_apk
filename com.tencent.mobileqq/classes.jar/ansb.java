import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.biz.qqstory.takevideo.EditRecognitionPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoTag;

public class ansb
  implements DialogInterface.OnClickListener
{
  public ansb(EditRecognitionPart paramEditRecognitionPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    dov.com.qq.im.capture.view.MusicProviderView.a = false;
    this.a.a.a.a(this.a.a.a());
    EditRecognitionPart.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansb
 * JD-Core Version:    0.7.0.1
 */
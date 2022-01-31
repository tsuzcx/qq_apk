import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class antv
  implements DialogInterface.OnClickListener
{
  public antv(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShortVideoPreviewActivity.b(this.a);
    this.a.setResult(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     antv
 * JD-Core Version:    0.7.0.1
 */
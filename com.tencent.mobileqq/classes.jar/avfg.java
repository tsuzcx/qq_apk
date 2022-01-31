import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class avfg
  implements DialogInterface.OnClickListener
{
  public avfg(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avfg
 * JD-Core Version:    0.7.0.1
 */
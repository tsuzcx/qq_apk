import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class bbro
  implements DialogInterface.OnClickListener
{
  bbro(bbrl parambbrl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showSaveFileTips cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbro
 * JD-Core Version:    0.7.0.1
 */
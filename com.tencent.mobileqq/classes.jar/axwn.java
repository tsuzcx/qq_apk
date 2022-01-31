import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class axwn
  implements DialogInterface.OnClickListener
{
  axwn(axwf paramaxwf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwn
 * JD-Core Version:    0.7.0.1
 */
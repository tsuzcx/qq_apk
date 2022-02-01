import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

class bbsc
  implements DialogInterface.OnClickListener
{
  bbsc(bbrz parambbrz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showSaveFileTips cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsc
 * JD-Core Version:    0.7.0.1
 */
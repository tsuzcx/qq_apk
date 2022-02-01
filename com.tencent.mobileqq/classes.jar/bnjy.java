import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bnjy
  implements DialogInterface.OnClickListener
{
  bnjy(bnjw parambnjw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bnjw.a(this.a).smoothScrollToPosition(bnjw.a);
    bnjw.b = bnjw.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjy
 * JD-Core Version:    0.7.0.1
 */
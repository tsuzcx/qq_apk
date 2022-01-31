import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.widget.immersive.ImmersiveUtils;

class aqoh
  implements DialogInterface.OnDismissListener
{
  aqoh(aqog paramaqog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.a.a.aG_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqoh
 * JD-Core Version:    0.7.0.1
 */
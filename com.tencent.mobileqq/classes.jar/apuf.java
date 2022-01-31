import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.widget.immersive.ImmersiveUtils;

class apuf
  implements DialogInterface.OnDismissListener
{
  apuf(apue paramapue) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.a.a.aJ_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apuf
 * JD-Core Version:    0.7.0.1
 */
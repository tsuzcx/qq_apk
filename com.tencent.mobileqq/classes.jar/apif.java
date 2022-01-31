import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;

class apif
  implements View.OnClickListener
{
  apif(apie paramapie) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.a) != null) && (!this.a.a.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.a).dismiss();
      HotChatFlashPicActivity.a(this.a.a, null);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apif
 * JD-Core Version:    0.7.0.1
 */
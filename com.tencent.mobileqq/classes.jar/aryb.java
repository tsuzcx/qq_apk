import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aryb
  implements View.OnClickListener
{
  aryb(arya paramarya) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.a) != null) && (!this.a.a.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.a).dismiss();
      HotChatFlashPicActivity.a(this.a.a, null);
      this.a.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryb
 * JD-Core Version:    0.7.0.1
 */
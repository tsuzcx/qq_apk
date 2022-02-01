import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgPhotoView;

public class blwv
  implements View.OnClickListener
{
  public blwv(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    if (MsgPhotoView.a(this.a) != null)
    {
      if (paramView != MsgPhotoView.a(this.a)) {
        break label50;
      }
      MsgPhotoView.a(this.a).a(this.a.a, paramView, 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      if (paramView == MsgPhotoView.b(this.a)) {
        MsgPhotoView.a(this.a).a(this.a.a, paramView, 2);
      } else if (paramView == MsgPhotoView.c(this.a)) {
        MsgPhotoView.a(this.a).a(this.a.a, paramView, 3);
      } else if (paramView == MsgPhotoView.d(this.a)) {
        MsgPhotoView.a(this.a).a(this.a.a, paramView, 4);
      } else {
        MsgPhotoView.a(this.a).a(this.a.a, paramView, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwv
 * JD-Core Version:    0.7.0.1
 */
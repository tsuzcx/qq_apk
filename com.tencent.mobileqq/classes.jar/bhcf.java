import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.contentbox.MsgPhotoView;

public class bhcf
  implements View.OnClickListener
{
  public bhcf(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    if (MsgPhotoView.a(this.a) != null)
    {
      if (paramView == MsgPhotoView.a(this.a)) {
        MsgPhotoView.a(this.a).a(this.a.a, paramView, 1);
      }
    }
    else {
      return;
    }
    if (paramView == MsgPhotoView.b(this.a))
    {
      MsgPhotoView.a(this.a).a(this.a.a, paramView, 2);
      return;
    }
    if (paramView == MsgPhotoView.c(this.a))
    {
      MsgPhotoView.a(this.a).a(this.a.a, paramView, 3);
      return;
    }
    if (paramView == MsgPhotoView.d(this.a))
    {
      MsgPhotoView.a(this.a).a(this.a.a, paramView, 4);
      return;
    }
    MsgPhotoView.a(this.a).a(this.a.a, paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhcf
 * JD-Core Version:    0.7.0.1
 */
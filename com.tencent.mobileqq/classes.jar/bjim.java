import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.contentbox.MsgMoreView;

public class bjim
  implements View.OnClickListener
{
  public bjim(MsgMoreView paramMsgMoreView) {}
  
  public void onClick(View paramView)
  {
    if (MsgMoreView.a(this.a) != null) {
      MsgMoreView.a(this.a).a(MsgMoreView.a(this.a), paramView, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjim
 * JD-Core Version:    0.7.0.1
 */
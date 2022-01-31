import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;

public class axvo
  extends URLDrawableDownListener.Adapter
{
  public axvo(StructMsgForHypertext paramStructMsgForHypertext) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvo
 * JD-Core Version:    0.7.0.1
 */
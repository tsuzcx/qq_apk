import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardHeadLayout;
import com.tencent.qphone.base.util.QLog;

public class bbvu
  extends URLDrawableDownListener.Adapter
{
  public bbvu(CardHeadLayout paramCardHeadLayout) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHeadLayout", 2, "-->drawabel onLoadSuccessed, view: " + paramView);
    }
    CardHeadLayout.a(this.a);
    ((AnyScaleTypeImageView)paramView).setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbvu
 * JD-Core Version:    0.7.0.1
 */
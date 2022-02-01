import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amzo
  implements View.OnClickListener
{
  public amzo(WebGameFakeView paramWebGameFakeView, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    amyr.a().a(null);
    if (amyr.a().a() <= 1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzo
 * JD-Core Version:    0.7.0.1
 */
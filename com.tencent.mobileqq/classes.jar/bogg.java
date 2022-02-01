import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import java.util.List;

public class bogg
  implements View.OnClickListener
{
  public bogg(CaptureModeAdapter paramCaptureModeAdapter) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    if (localInteger.intValue() == CaptureModeAdapter.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((TextView)CaptureModeAdapter.a(this.a).get(CaptureModeAdapter.a(this.a))).setTextColor(CaptureModeAdapter.b(this.a));
      CaptureModeAdapter.a(this.a, localInteger.intValue());
      if (CaptureModeAdapter.a(this.a) != null) {
        CaptureModeAdapter.a(this.a).a(localInteger.intValue(), paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogg
 * JD-Core Version:    0.7.0.1
 */
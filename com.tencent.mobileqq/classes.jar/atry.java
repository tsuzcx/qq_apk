import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;

public class atry
  implements View.OnClickListener
{
  public atry(LocationPickFragment paramLocationPickFragment) {}
  
  public void onClick(View paramView)
  {
    if (LocationPickFragment.a(this.a).b())
    {
      LocationPickFragment.a(this.a).b();
      return;
    }
    LocationPickFragment.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atry
 * JD-Core Version:    0.7.0.1
 */
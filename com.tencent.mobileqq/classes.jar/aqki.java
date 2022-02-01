import android.view.View;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class aqki
  implements AdapterView.OnItemClickListener
{
  public aqki(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.isFinishing())
    {
      this.a.overridePendingTransition(0, 2130772355);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqki
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.widget.AdapterView;

public class bfgc
  implements bljn
{
  public bfgc(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.a != null)
    {
      paramAdapterView = this.a.a.a(paramInt);
      if ((paramAdapterView == null) || (paramAdapterView.a != 1)) {
        return false;
      }
    }
    MediaPreviewActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgc
 * JD-Core Version:    0.7.0.1
 */
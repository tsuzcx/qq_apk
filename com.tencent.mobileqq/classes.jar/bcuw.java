import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bcuw
  implements AdapterView.OnItemClickListener
{
  public bcuw(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof bbjh)) {
      return;
    }
    paramView = ((bbjh)paramView).a;
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).a(paramView, this.a);
    }
    ShareActionSheetV2 localShareActionSheetV2 = this.a;
    if (paramAdapterView == this.a.a) {
      paramInt = 0;
    }
    for (;;)
    {
      ShareActionSheetV2.a(localShareActionSheetV2, paramView, paramInt);
      return;
      if (paramAdapterView == this.a.b) {
        paramInt = 1;
      } else if (paramAdapterView == this.a.c) {
        paramInt = 2;
      } else {
        paramInt = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuw
 * JD-Core Version:    0.7.0.1
 */
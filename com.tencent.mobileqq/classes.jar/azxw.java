import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azxw
  implements AdapterView.OnItemClickListener
{
  azxw(azxu paramazxu) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (azxu.a(this.a).isShowing()) {
      azxu.a(this.a).dismiss();
    }
    int i = -1;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      if (azxu.a(this.a) != null) {
        azxu.a(this.a).a(i, azxu.a(this.a));
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      azxu.a(this.a);
      i = 0;
      continue;
      azxu.b(this.a);
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxw
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azfj
  implements AdapterView.OnItemClickListener
{
  azfj(azfh paramazfh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (azfh.a(this.a).isShowing()) {
      azfh.a(this.a).dismiss();
    }
    int i = -1;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      if (azfh.a(this.a) != null) {
        azfh.a(this.a).a(i, azfh.a(this.a));
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      azfh.a(this.a);
      i = 0;
      continue;
      azfh.b(this.a);
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfj
 * JD-Core Version:    0.7.0.1
 */
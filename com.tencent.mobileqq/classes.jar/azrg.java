import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azrg
  implements AdapterView.OnItemClickListener
{
  azrg(azre paramazre) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (azre.a(this.a).isShowing()) {
      azre.a(this.a).dismiss();
    }
    int i = -1;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      if (azre.a(this.a) != null) {
        azre.a(this.a).a(i, azre.a(this.a));
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      azre.a(this.a);
      i = 0;
      continue;
      azre.b(this.a);
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrg
 * JD-Core Version:    0.7.0.1
 */
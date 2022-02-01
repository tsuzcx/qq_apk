import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayml
  implements AdapterView.OnItemClickListener
{
  ayml(aymj paramaymj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (aymj.a(this.a).isShowing()) {
      aymj.a(this.a).dismiss();
    }
    int i = -1;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      if (aymj.a(this.a) != null) {
        aymj.a(this.a).a(i, aymj.a(this.a));
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      aymj.a(this.a);
      i = 0;
      continue;
      aymj.b(this.a);
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayml
 * JD-Core Version:    0.7.0.1
 */
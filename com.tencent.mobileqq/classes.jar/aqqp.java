import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqqp
  implements View.OnClickListener
{
  public aqqp(HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    HistoryFormItem localHistoryFormItem;
    if (aqnv.a())
    {
      i = 1;
      if ((i != 0) && (this.a.a()))
      {
        localHistoryFormItem = this.a;
        if (HistoryFormItem.a(this.a)) {
          break label119;
        }
      }
    }
    for (;;)
    {
      HistoryFormItem.a(localHistoryFormItem, bool);
      this.a.a(paramView, HistoryFormItem.a(this.a));
      if (HistoryFormItem.a(this.a) != null) {
        HistoryFormItem.a(this.a).a(paramView, HistoryFormItem.a(this.a), HistoryFormItem.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aqoq.a(paramView.getContext());
      i = 0;
      break;
      label119:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqp
 * JD-Core Version:    0.7.0.1
 */
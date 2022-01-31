import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;

public class amje
  implements View.OnClickListener
{
  public amje(HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    HistoryFormItem localHistoryFormItem;
    if (amgr.a())
    {
      i = 1;
      if ((i != 0) && (this.a.a()))
      {
        localHistoryFormItem = this.a;
        if (HistoryFormItem.a(this.a)) {
          break label112;
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
      return;
      amhh.a(paramView.getContext());
      i = 0;
      break;
      label112:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amje
 * JD-Core Version:    0.7.0.1
 */
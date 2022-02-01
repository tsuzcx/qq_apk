import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;

public class bidr
  extends RecyclerView.ViewHolder
{
  final SimpleMonthView a;
  
  public bidr(View paramView, bids parambids)
  {
    super(paramView);
    this.a = ((SimpleMonthView)paramView);
    this.a.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    this.a.setClickable(true);
    this.a.setOnDayClickListener(parambids);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidr
 * JD-Core Version:    0.7.0.1
 */
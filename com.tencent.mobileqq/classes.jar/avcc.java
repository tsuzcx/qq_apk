import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avcc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  avdg a;
  public ImageView d;
  
  public avcc(HotPicPageView paramHotPicPageView, View paramView, avdg paramavdg)
  {
    super(paramView);
    if (paramavdg != null)
    {
      this.a = paramavdg;
      this.d = ((ImageView)paramView.findViewById(2131368097));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramavdg);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(paramView, getPosition());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.a != null)
    {
      this.a.b(paramView, getPosition());
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcc
 * JD-Core Version:    0.7.0.1
 */
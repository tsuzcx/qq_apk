import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auhe
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  auii a;
  public ImageView d;
  
  public auhe(HotPicPageView paramHotPicPageView, View paramView, auii paramauii)
  {
    super(paramView);
    if (paramauii != null)
    {
      this.a = paramauii;
      this.d = ((ImageView)paramView.findViewById(2131368198));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramauii);
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
 * Qualified Name:     auhe
 * JD-Core Version:    0.7.0.1
 */
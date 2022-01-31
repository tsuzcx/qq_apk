import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;

public class aqfs
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  aqgw a;
  public ImageView d;
  
  public aqfs(HotPicPageView paramHotPicPageView, View paramView, aqgw paramaqgw)
  {
    super(paramView);
    if (paramaqgw != null)
    {
      this.a = paramaqgw;
      this.d = ((ImageView)paramView.findViewById(2131302026));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramaqgw);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(paramView, getPosition());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqfs
 * JD-Core Version:    0.7.0.1
 */
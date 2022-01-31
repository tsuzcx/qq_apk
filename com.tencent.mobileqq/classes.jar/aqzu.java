import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;

public class aqzu
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  aray a;
  public ImageView d;
  
  public aqzu(HotPicPageView paramHotPicPageView, View paramView, aray paramaray)
  {
    super(paramView);
    if (paramaray != null)
    {
      this.a = paramaray;
      this.d = ((ImageView)paramView.findViewById(2131367644));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramaray);
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
 * Qualified Name:     aqzu
 * JD-Core Version:    0.7.0.1
 */
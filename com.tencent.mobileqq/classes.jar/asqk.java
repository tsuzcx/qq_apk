import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;

public class asqk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  asro a;
  public ImageView d;
  
  public asqk(HotPicPageView paramHotPicPageView, View paramView, asro paramasro)
  {
    super(paramView);
    if (paramasro != null)
    {
      this.a = paramasro;
      this.d = ((ImageView)paramView.findViewById(2131367773));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramasro);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqk
 * JD-Core Version:    0.7.0.1
 */
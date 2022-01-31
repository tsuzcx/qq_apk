import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView;

public class asut
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  asvx a;
  public ImageView d;
  
  public asut(HotPicPageView paramHotPicPageView, View paramView, asvx paramasvx)
  {
    super(paramView);
    if (paramasvx != null)
    {
      this.a = paramasvx;
      this.d = ((ImageView)paramView.findViewById(2131367783));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramasvx);
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
 * Qualified Name:     asut
 * JD-Core Version:    0.7.0.1
 */
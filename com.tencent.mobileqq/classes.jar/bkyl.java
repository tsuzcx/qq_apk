import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bkyl
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public bkyl(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131373286));
  }
  
  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyl
 * JD-Core Version:    0.7.0.1
 */
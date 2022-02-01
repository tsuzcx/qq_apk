import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bnnd
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public bnnd(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131374152));
  }
  
  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnd
 * JD-Core Version:    0.7.0.1
 */
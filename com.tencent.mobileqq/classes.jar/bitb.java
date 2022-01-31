import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bitb
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public bitb(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131372846));
  }
  
  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitb
 * JD-Core Version:    0.7.0.1
 */
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bhsy
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public bhsy(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131307134));
  }
  
  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsy
 * JD-Core Version:    0.7.0.1
 */
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bnsa
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public bnsa(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131374038));
  }
  
  public void a(boolean paramBoolean)
  {
    this.itemView.setSelected(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsa
 * JD-Core Version:    0.7.0.1
 */
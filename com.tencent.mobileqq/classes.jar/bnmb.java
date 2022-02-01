import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bnmb
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public bnmb(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131362227));
  }
  
  public void a(@NonNull bnmc parambnmc)
  {
    this.a.setText(parambnmc.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmb
 * JD-Core Version:    0.7.0.1
 */
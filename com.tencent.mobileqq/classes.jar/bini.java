import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bini
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public bini(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131362150));
  }
  
  public void a(@NonNull binj parambinj)
  {
    this.a.setText(parambinj.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bini
 * JD-Core Version:    0.7.0.1
 */
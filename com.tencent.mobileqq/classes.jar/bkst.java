import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class bkst
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public bkst(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131362157));
  }
  
  public void a(@NonNull bksu parambksu)
  {
    this.a.setText(parambksu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkst
 * JD-Core Version:    0.7.0.1
 */
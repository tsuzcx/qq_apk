import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

class blrv
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public blrv(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131362236));
  }
  
  public void a(@NonNull blrw paramblrw)
  {
    this.a.setText(paramblrw.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrv
 * JD-Core Version:    0.7.0.1
 */
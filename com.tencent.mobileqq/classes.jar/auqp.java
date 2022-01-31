import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

class auqp
  implements View.OnClickListener
{
  auqp(auqn paramauqn) {}
  
  public void onClick(View paramView)
  {
    auqr localauqr = (auqr)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localauqr.a, localauqr.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqp
 * JD-Core Version:    0.7.0.1
 */
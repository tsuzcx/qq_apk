import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

class aszs
  implements View.OnClickListener
{
  aszs(aszq paramaszq) {}
  
  public void onClick(View paramView)
  {
    aszu localaszu = (aszu)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localaszu.a, localaszu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszs
 * JD-Core Version:    0.7.0.1
 */
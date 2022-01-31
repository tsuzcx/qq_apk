import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

class aszq
  implements View.OnClickListener
{
  aszq(aszo paramaszo) {}
  
  public void onClick(View paramView)
  {
    aszs localaszs = (aszs)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localaszs.a, localaszs.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszq
 * JD-Core Version:    0.7.0.1
 */
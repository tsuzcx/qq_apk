import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

class asdm
  implements View.OnClickListener
{
  asdm(asdk paramasdk) {}
  
  public void onClick(View paramView)
  {
    asdo localasdo = (asdo)paramView.getTag();
    if (this.a.a != null) {
      this.a.a.onItemClick(null, paramView, localasdo.a, localasdo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asdm
 * JD-Core Version:    0.7.0.1
 */
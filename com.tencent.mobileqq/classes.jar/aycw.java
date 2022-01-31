import android.view.View;
import android.view.View.OnClickListener;

class aycw
  implements View.OnClickListener
{
  aycw(aycv paramaycv) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    aycv.a(this.a).onItemClick(this.a.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycw
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;

class avhx
  implements View.OnClickListener
{
  avhx(avhw paramavhw) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    avhw.a(this.a).onItemClick(this.a.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhx
 * JD-Core Version:    0.7.0.1
 */
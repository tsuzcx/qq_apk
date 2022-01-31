import android.view.View;
import android.view.View.OnClickListener;

class avtw
  implements View.OnClickListener
{
  avtw(avtv paramavtv) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof avtx)) && (this.a.a != null))
    {
      avtx localavtx = (avtx)paramView.getTag();
      this.a.a.a(this.a, paramView, localavtx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtw
 * JD-Core Version:    0.7.0.1
 */
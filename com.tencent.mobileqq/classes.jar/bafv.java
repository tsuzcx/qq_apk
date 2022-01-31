import android.view.View;
import android.view.View.OnClickListener;

class bafv
  implements View.OnClickListener
{
  bafv(bafu parambafu) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof bafp))
    {
      bafp localbafp = (bafp)paramView.getTag();
      if ((this.a.a != null) && (localbafp.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafv
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;

class ayhz
  implements View.OnClickListener
{
  ayhz(ayhy paramayhy) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ayht))
    {
      ayht localayht = (ayht)paramView.getTag();
      if ((this.a.a != null) && (localayht.a.isClickable())) {
        this.a.a.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhz
 * JD-Core Version:    0.7.0.1
 */
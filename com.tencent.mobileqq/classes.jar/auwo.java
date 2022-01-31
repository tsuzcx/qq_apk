import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;

public class auwo
  implements View.OnClickListener
{
  public auwo(InterestTagItemView paramInterestTagItemView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).a(InterestTagItemView.a(this.a));
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwo
 * JD-Core Version:    0.7.0.1
 */
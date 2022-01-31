import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;

public class atfp
  implements View.OnClickListener
{
  public atfp(InterestTagItemView paramInterestTagItemView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).a(InterestTagItemView.a(this.a));
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfp
 * JD-Core Version:    0.7.0.1
 */
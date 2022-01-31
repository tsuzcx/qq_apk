import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.AuthorityAccountView;

public class bexk
  implements View.OnClickListener
{
  public bexk(AuthorityAccountView paramAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof String))) {
      this.a.b((String)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexk
 * JD-Core Version:    0.7.0.1
 */
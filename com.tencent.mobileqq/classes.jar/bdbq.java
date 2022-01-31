import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;

public class bdbq
  implements View.OnClickListener
{
  public bdbq(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof String))) {
      this.a.b((String)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbq
 * JD-Core Version:    0.7.0.1
 */
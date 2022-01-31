import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;

public class bdbo
  implements View.OnClickListener
{
  public bdbo(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (OpenAuthorityAccountView.a(this.a) != null) {
      OpenAuthorityAccountView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbo
 * JD-Core Version:    0.7.0.1
 */
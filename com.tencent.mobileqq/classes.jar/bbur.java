import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.widget.XListView;

public class bbur
  implements View.OnClickListener
{
  public bbur(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.a(this.a).c();
    AuthorityControlFragment.a(this.a, this.a.rightViewText, 2131624723);
    this.a.rightViewText.setTextColor(AuthorityControlFragment.a(this.a));
    this.a.rightViewText.setEnabled(true);
    this.a.setLeftButton("", null);
    this.a.leftView.setVisibility(0);
    AuthorityControlFragment.a(this.a).setText(2131624737);
    AuthorityControlFragment.a(this.a).setOverScrollHeader(AuthorityControlFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbur
 * JD-Core Version:    0.7.0.1
 */
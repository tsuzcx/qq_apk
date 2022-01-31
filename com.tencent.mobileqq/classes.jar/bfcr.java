import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.widget.XListView;

public class bfcr
  implements View.OnClickListener
{
  public bfcr(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.a(this.a).c();
    AuthorityControlFragment.a(this.a, this.a.rightViewText, 2131690335);
    this.a.rightViewText.setTextColor(AuthorityControlFragment.a(this.a));
    this.a.rightViewText.setEnabled(true);
    this.a.setLeftButton("", null);
    this.a.leftView.setVisibility(0);
    AuthorityControlFragment.a(this.a).setText(2131690349);
    AuthorityControlFragment.a(this.a).setOverScrollHeader(AuthorityControlFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcr
 * JD-Core Version:    0.7.0.1
 */
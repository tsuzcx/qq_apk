import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.widget.XListView;

public class bcyr
  implements View.OnClickListener
{
  public bcyr(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.a(this.a).c();
    AuthorityControlFragment.a(this.a, this.a.rightViewText, 2131690284);
    this.a.rightViewText.setTextColor(AuthorityControlFragment.a(this.a));
    this.a.rightViewText.setEnabled(true);
    this.a.setLeftButton("", null);
    this.a.leftView.setVisibility(0);
    AuthorityControlFragment.a(this.a).setText(2131690298);
    AuthorityControlFragment.a(this.a).setOverScrollHeader(AuthorityControlFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcyr
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class bjku
  implements View.OnClickListener
{
  public bjku(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.a(this.a).c();
    AuthorityControlFragment.a(this.a, this.a.rightViewText, 2131690177);
    this.a.rightViewText.setTextColor(AuthorityControlFragment.a(this.a));
    this.a.rightViewText.setEnabled(true);
    this.a.setLeftButton("", null);
    this.a.leftView.setVisibility(0);
    AuthorityControlFragment.a(this.a).setText(2131690188);
    AuthorityControlFragment.a(this.a).setOverScrollHeader(AuthorityControlFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjku
 * JD-Core Version:    0.7.0.1
 */
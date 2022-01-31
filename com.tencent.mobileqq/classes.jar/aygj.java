import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;

public class aygj
  implements View.OnClickListener
{
  public aygj(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.g = 1;
    if (UniteSearchActivity.a(GroupSearchFragment.b(this.a), GroupSearchFragment.a(this.a))) {
      this.a.g = 1;
    }
    this.a.h();
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygj
 * JD-Core Version:    0.7.0.1
 */
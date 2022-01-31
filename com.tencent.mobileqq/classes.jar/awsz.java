import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;

class awsz
  implements View.OnClickListener
{
  awsz(awsy paramawsy) {}
  
  public void onClick(View paramView)
  {
    paramView = null;
    if (awsy.a(this.a) != null) {
      paramView = awsy.a(this.a).mViewImpl.getViewModel();
    }
    if (paramView == null) {
      return;
    }
    paramView.reinitArkContainer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsz
 * JD-Core Version:    0.7.0.1
 */
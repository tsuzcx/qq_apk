import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;

class ayoc
  implements View.OnClickListener
{
  ayoc(ayob paramayob) {}
  
  public void onClick(View paramView)
  {
    paramView = null;
    if (ayob.a(this.a) != null) {
      paramView = ayob.a(this.a).mViewImpl.getViewModel();
    }
    if (paramView == null) {
      return;
    }
    paramView.reinitArkContainer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoc
 * JD-Core Version:    0.7.0.1
 */
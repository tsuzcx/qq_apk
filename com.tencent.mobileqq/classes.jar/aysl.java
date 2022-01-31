import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;

class aysl
  implements View.OnClickListener
{
  aysl(aysk paramaysk) {}
  
  public void onClick(View paramView)
  {
    paramView = null;
    if (aysk.a(this.a) != null) {
      paramView = aysk.a(this.a).mViewImpl.getViewModel();
    }
    if (paramView == null) {
      return;
    }
    paramView.reinitArkContainer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysl
 * JD-Core Version:    0.7.0.1
 */
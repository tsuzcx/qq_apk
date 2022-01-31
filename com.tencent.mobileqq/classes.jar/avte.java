import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;

class avte
  implements View.OnClickListener
{
  avte(avtd paramavtd) {}
  
  public void onClick(View paramView)
  {
    paramView = null;
    if (avtd.a(this.a) != null) {
      paramView = avtd.a(this.a).mViewImpl.getViewModel();
    }
    if (paramView == null) {
      return;
    }
    paramView.reinitArkContainer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avte
 * JD-Core Version:    0.7.0.1
 */
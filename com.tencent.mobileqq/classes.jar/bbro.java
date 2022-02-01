import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbro
  implements View.OnClickListener
{
  bbro(bbrn parambbrn) {}
  
  public void onClick(View paramView)
  {
    ArkViewModel localArkViewModel = null;
    if (bbrn.a(this.a) != null) {
      localArkViewModel = bbrn.a(this.a).mViewImpl.getViewModel();
    }
    if (localArkViewModel == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArkViewModel.reinitArkContainer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbro
 * JD-Core Version:    0.7.0.1
 */
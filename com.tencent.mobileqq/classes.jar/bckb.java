import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bckb
  implements View.OnClickListener
{
  bckb(bcka parambcka) {}
  
  public void onClick(View paramView)
  {
    ArkViewModel localArkViewModel = null;
    if (bcka.a(this.a) != null) {
      localArkViewModel = bcka.a(this.a).mViewImpl.getViewModel();
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
 * Qualified Name:     bckb
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayhl
  implements View.OnClickListener
{
  ayhl(ayhj paramayhj) {}
  
  public void onClick(View paramView)
  {
    this.a.f(paramView);
    new ayek().h("video").i("playpage_fw_click").a().a(this.a.a);
    ThreadManagerV2.excute(new PlayOperationViewModel.10.1(this, (axup)this.a.a.getManager(106)), 16, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhl
 * JD-Core Version:    0.7.0.1
 */
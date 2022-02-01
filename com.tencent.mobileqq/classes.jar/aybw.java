import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.9.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aybw
  implements View.OnClickListener
{
  aybw(ayat paramayat) {}
  
  public void onClick(View paramView)
  {
    this.a.c(paramView);
    new axxu().h("video").i("playpage_like_click").b().a(this.a.a);
    ThreadManagerV2.excute(new PlayOperationViewModel.9.1(this, (axny)this.a.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybw
 * JD-Core Version:    0.7.0.1
 */
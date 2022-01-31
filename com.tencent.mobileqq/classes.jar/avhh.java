import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10.1;

public class avhh
  implements View.OnClickListener
{
  avhh(avhf paramavhf) {}
  
  public void onClick(View paramView)
  {
    this.a.f(paramView);
    new aveg().h("video").i("playpage_fw_click").a().a(this.a.a);
    ThreadManagerV2.excute(new PlayOperationViewModel.10.1(this, (auul)this.a.a.getManager(106)), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhh
 * JD-Core Version:    0.7.0.1
 */
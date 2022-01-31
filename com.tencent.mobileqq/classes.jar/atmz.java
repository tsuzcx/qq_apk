import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.9.1;

public class atmz
  implements View.OnClickListener
{
  atmz(atlw paramatlw) {}
  
  public void onClick(View paramView)
  {
    this.a.c(paramView);
    new atix().h("video").i("playpage_like_click").b().a(this.a.a);
    ThreadManagerV2.excute(new PlayOperationViewModel.9.1(this, (aszf)this.a.a.getManager(106)), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmz
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class askm
  implements best
{
  public askm(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", "2747277822");
      this.a.startActivity(paramView);
    }
    while (paramInt != 1) {
      return;
    }
    QQGameFeedWebFragment.a(this.a, this.a.a);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askm
 * JD-Core Version:    0.7.0.1
 */
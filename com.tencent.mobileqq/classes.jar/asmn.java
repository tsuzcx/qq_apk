import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;

public class asmn
  implements bexc
{
  public asmn(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
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
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmn
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tribe.async.reactive.SimpleObserver;

public class ayvo
  extends SimpleObserver<ayvh>
{
  public ayvo(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(ayvh paramayvh)
  {
    super.onNext(paramayvh);
    urk.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    vkw.a(paramayvh.a);
    vkw.a(paramayvh.b);
    CheckArithHWResultFragment.a(this.a, paramayvh.a, paramayvh.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    bbmy.a(this.a.getActivity(), 1, ajjy.a(2131635970), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayvo
 * JD-Core Version:    0.7.0.1
 */
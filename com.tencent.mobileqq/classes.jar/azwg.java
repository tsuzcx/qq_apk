import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tribe.async.reactive.SimpleObserver;

public class azwg
  extends SimpleObserver<azvz>
{
  public azwg(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(azvz paramazvz)
  {
    super.onNext(paramazvz);
    ved.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    vxp.a(paramazvz.a);
    vxp.a(paramazvz.b);
    CheckArithHWResultFragment.a(this.a, paramazvz.a, paramazvz.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    bcql.a(this.a.getActivity(), 1, ajya.a(2131701765), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwg
 * JD-Core Version:    0.7.0.1
 */
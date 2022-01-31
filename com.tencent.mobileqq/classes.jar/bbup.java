import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class bbup
  extends SimpleObserver<bbui>
{
  public bbup(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(bbui parambbui)
  {
    super.onNext(parambbui);
    wsv.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    xmh.a(parambbui.a);
    xmh.a(parambbui.b);
    CheckArithHWResultFragment.a(this.a, parambbui.a, parambbui.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    QQToast.a(this.a.getActivity(), 1, alpo.a(2131702137), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbup
 * JD-Core Version:    0.7.0.1
 */
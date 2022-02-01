import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class bfzd
  extends SimpleObserver<bfyw>
{
  public bfzd(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(bfyw parambfyw)
  {
    super.onNext(parambfyw);
    yuk.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    znw.a(parambfyw.a);
    znw.a(parambfyw.b);
    CheckArithHWResultFragment.a(this.a, parambfyw.a, parambfyw.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    QQToast.a(this.a.getActivity(), 1, anzj.a(2131700676), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzd
 * JD-Core Version:    0.7.0.1
 */
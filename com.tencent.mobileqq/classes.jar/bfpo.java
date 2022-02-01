import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class bfpo
  extends SimpleObserver<bfph>
{
  public bfpo(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(bfph parambfph)
  {
    super.onNext(parambfph);
    ykq.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    zdl.a(parambfph.a);
    zdl.a(parambfph.b);
    CheckArithHWResultFragment.a(this.a, parambfph.a, parambfph.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    QQToast.a(this.a.getActivity(), 1, anvx.a(2131701262), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpo
 * JD-Core Version:    0.7.0.1
 */
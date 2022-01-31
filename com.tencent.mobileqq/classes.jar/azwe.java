import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tribe.async.reactive.SimpleObserver;

public class azwe
  extends SimpleObserver<azvx>
{
  public azwe(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(azvx paramazvx)
  {
    super.onNext(paramazvx);
    veg.d("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    vxs.a(paramazvx.a);
    vxs.a(paramazvx.b);
    CheckArithHWResultFragment.a(this.a, paramazvx.a, paramazvx.b);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    bcpw.a(this.a.getActivity(), 1, ajyc.a(2131701754), 0).a();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwe
 * JD-Core Version:    0.7.0.1
 */
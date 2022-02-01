import android.arch.lifecycle.ViewModel;
import android.support.annotation.CallSuper;

public class bpxy
  extends ViewModel
{
  @CallSuper
  public void onCleared()
  {
    super.onCleared();
    bpxz.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxy
 * JD-Core Version:    0.7.0.1
 */
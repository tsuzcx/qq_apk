import android.view.View;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.lang.ref.WeakReference;

public class avwo
  implements EnterCallback
{
  private final WeakReference<ODLoadingActivity> a;
  
  public avwo(ODLoadingActivity paramODLoadingActivity)
  {
    this.a = new WeakReference(paramODLoadingActivity);
  }
  
  public void onCloseLoadingView()
  {
    ODLoadingActivity localODLoadingActivity = (ODLoadingActivity)this.a.get();
    if (localODLoadingActivity == null) {
      return;
    }
    localODLoadingActivity.a();
  }
  
  public void onEnterComplete()
  {
    ODLoadingActivity localODLoadingActivity = (ODLoadingActivity)this.a.get();
    if (localODLoadingActivity == null) {
      return;
    }
    localODLoadingActivity.b();
  }
  
  public void onShowLoadingView(View paramView)
  {
    ODLoadingActivity localODLoadingActivity = (ODLoadingActivity)this.a.get();
    if (localODLoadingActivity == null) {
      return;
    }
    localODLoadingActivity.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwo
 * JD-Core Version:    0.7.0.1
 */
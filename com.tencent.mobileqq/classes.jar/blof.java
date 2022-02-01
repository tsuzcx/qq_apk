import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;

class blof
  implements ViewStub.OnInflateListener
{
  blof(bloe parambloe) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (bloe.a(this.a) == null) {
      return;
    }
    paramViewStub = (RelativeLayout.LayoutParams)bloe.a(this.a).getLayoutParams();
    paramViewStub.addRule(3, paramView.getId());
    bloe.a(this.a).setLayoutParams(paramViewStub);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blof
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;

class bojz
  implements ViewStub.OnInflateListener
{
  bojz(bojy parambojy) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (bojy.a(this.a) == null) {
      return;
    }
    paramViewStub = (RelativeLayout.LayoutParams)bojy.a(this.a).getLayoutParams();
    paramViewStub.addRule(3, paramView.getId());
    bojy.a(this.a).setLayoutParams(paramViewStub);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojz
 * JD-Core Version:    0.7.0.1
 */
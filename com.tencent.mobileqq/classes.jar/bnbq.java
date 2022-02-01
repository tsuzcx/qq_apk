import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;

class bnbq
  implements ViewStub.OnInflateListener
{
  bnbq(bnbp parambnbp) {}
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (bnbp.a(this.a) == null) {
      return;
    }
    paramViewStub = (RelativeLayout.LayoutParams)bnbp.a(this.a).getLayoutParams();
    paramViewStub.addRule(3, paramView.getId());
    bnbp.a(this.a).setLayoutParams(paramViewStub);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbq
 * JD-Core Version:    0.7.0.1
 */
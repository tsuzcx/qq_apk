import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qqmini.sdk.runtime.core.page.swipe.SwipeBackLayout;

public class bdvl
  extends bdvp
{
  public bdvl(SwipeBackLayout paramSwipeBackLayout) {}
  
  public int a(View paramView)
  {
    return SwipeBackLayout.b(this.a);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return 0;
    }
    return Math.min(paramInt1, SwipeBackLayout.b(this.a));
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (SwipeBackLayout.a(this.a) >= SwipeBackLayout.b(this.a) / 10)
    {
      SwipeBackLayout.a(this.a, true);
      SwipeBackLayout.a(this.a).a(SwipeBackLayout.b(this.a), paramView.getTop());
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      SwipeBackLayout.a(this.a).a(0, paramView.getTop());
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SwipeBackLayout.a(this.a, Math.abs(paramInt1 / (this.a.a.getWidth() + SwipeBackLayout.a(this.a).getIntrinsicWidth())));
    SwipeBackLayout.a(this.a, paramInt1);
    if ((SwipeBackLayout.a(this.a)) && (SwipeBackLayout.a(this.a) == SwipeBackLayout.b(this.a)) && (SwipeBackLayout.a(this.a) != null)) {
      SwipeBackLayout.a(this.a).a();
    }
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return paramView == this.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvl
 * JD-Core Version:    0.7.0.1
 */
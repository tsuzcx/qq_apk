import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class bcfl
  implements TouchWebView.OnScrollChangedListener
{
  bcfl(bcfj parambcfj) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (System.currentTimeMillis() - this.a.a > 1000L)
    {
      paramInt1 = paramInt2 - paramInt4;
      if (paramInt1 <= 0) {
        break label55;
      }
      if (Math.abs(paramInt1) > 50)
      {
        this.a.b(false);
        this.a.a = System.currentTimeMillis();
      }
    }
    label55:
    while (Math.abs(paramInt1) <= 50) {
      return;
    }
    this.a.b(true);
    this.a.a = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfl
 * JD-Core Version:    0.7.0.1
 */
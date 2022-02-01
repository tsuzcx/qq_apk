import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.startup.step.SetSplash;

class bmoh
  implements View.OnLayoutChangeListener
{
  bmoh(bmog parambmog) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView.getHeight() > 0)
    {
      bmog.a(this.a).removeOnLayoutChangeListener(this);
      SetSplash.a(bmog.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoh
 * JD-Core Version:    0.7.0.1
 */
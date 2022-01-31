import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;

public class aqsc
  implements View.OnLayoutChangeListener
{
  public aqsc(QQGamePadFaceFragment paramQQGamePadFaceFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((!QQGamePadFaceFragment.a(this.a)) && (paramInt3 - paramInt1 > 0) && (paramInt4 - paramInt2 > 0))
    {
      QQGamePadFaceFragment.a(this.a, true);
      QQGamePadFaceFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsc
 * JD-Core Version:    0.7.0.1
 */
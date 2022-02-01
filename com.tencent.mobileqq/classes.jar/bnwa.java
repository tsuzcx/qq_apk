import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class bnwa
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bnwa(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AETemplateInfoFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      if (AETemplateInfoFragment.a(this.a) != null) {
        break label50;
      }
    }
    label50:
    float f1;
    float f2;
    do
    {
      do
      {
        return;
        AETemplateInfoFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
      } while ((AETemplateInfoFragment.a(this.a).getVideoHeight() == 0) || (AETemplateInfoFragment.a(this.a).getVideoWidth() == 0));
      f1 = AETemplateInfoFragment.a(this.a).getVideoWidth() / AETemplateInfoFragment.a(this.a).getVideoHeight();
      i = AETemplateInfoFragment.a(this.a).getWidth();
      int j = AETemplateInfoFragment.a(this.a).getHeight();
      f2 = i / j;
      if (QLog.isDebugVersion()) {
        QLog.d("AETemplateInfoFragment", 2, new Object[] { "adjust player size---origin w:h=", Integer.valueOf(i), ":", Integer.valueOf(j), " availableRatio(w/h)=", Float.valueOf(f2), " video aspectRation(w/h)=" + f1 });
      }
      if (f1 < f2)
      {
        double d = AETemplateInfoFragment.a(this.a).getHeight();
        i = (int)(f1 * d);
        localObject = AETemplateInfoFragment.a(this.a).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = i;
        AETemplateInfoFragment.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
    } while (f1 <= f2);
    int i = (int)(AETemplateInfoFragment.a(this.a).getWidth() / f1);
    Object localObject = (ViewGroup.MarginLayoutParams)AETemplateInfoFragment.a(this.a).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).height = i;
    AETemplateInfoFragment.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwa
 * JD-Core Version:    0.7.0.1
 */
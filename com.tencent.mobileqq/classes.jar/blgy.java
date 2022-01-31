import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class blgy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public blgy(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void onGlobalLayout()
  {
    double d;
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      AEVideoShelfEditFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      d = 0.0D;
      if ((AEVideoShelfEditFragment.a(this.a) == null) || (AEVideoShelfEditFragment.a(this.a).getVideoHeight() == 0)) {
        break label345;
      }
      d = AEVideoShelfEditFragment.a(this.a).getVideoWidth() / AEVideoShelfEditFragment.a(this.a).getVideoHeight();
      if (d < 1.0D) {
        break label253;
      }
      i = 1;
    }
    for (;;)
    {
      label79:
      Object localObject;
      if (i != 0) {
        if (d < 3.0D)
        {
          i = (int)(AEVideoShelfEditFragment.a(this.a).getWidth() / d);
          localObject = (ViewGroup.MarginLayoutParams)AEVideoShelfEditFragment.a(this.a).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject).height = i;
          AEVideoShelfEditFragment.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.a(this.a, AEVideoShelfEditFragment.a(this.a).getWidth());
          AEVideoShelfEditFragment.b(this.a, ((ViewGroup.MarginLayoutParams)localObject).height);
        }
      }
      for (;;)
      {
        if (QLog.isDebugVersion()) {
          QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "centerView onGlobalLayout: ratio=", Double.valueOf(d), ", wxh=", Integer.valueOf(AEVideoShelfEditFragment.a(this.a)), "x", Integer.valueOf(AEVideoShelfEditFragment.b(this.a)) });
        }
        return;
        AEVideoShelfEditFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        break;
        label253:
        i = 0;
        break label79;
        if (d > 0.3333333333333333D)
        {
          i = (int)(AEVideoShelfEditFragment.a(this.a).getHeight() * d);
          localObject = AEVideoShelfEditFragment.a(this.a).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).width = i;
          AEVideoShelfEditFragment.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
          AEVideoShelfEditFragment.a(this.a, ((ViewGroup.LayoutParams)localObject).width);
          AEVideoShelfEditFragment.b(this.a, AEVideoShelfEditFragment.a(this.a).getHeight());
        }
      }
      label345:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgy
 * JD-Core Version:    0.7.0.1
 */
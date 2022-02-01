import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.qassistant.view.AssistantBackView;

public class azgn
  implements OnCompositionLoadedListener
{
  public azgn(AssistantBackView paramAssistantBackView) {}
  
  public void onCompositionLoaded(LottieComposition arg1)
  {
    if ((??? == null) || (AssistantBackView.a(this.a)))
    {
      azeu.a("AssistantBackView", "onCompositionLoaded lottieComposition is null or mIsDestroyed:" + AssistantBackView.a(this.a));
      return;
    }
    int i = AIOUtils.dp2px(70.0F, this.a.getResources());
    int j = AIOUtils.dp2px(70.0F, this.a.getResources());
    Object localObject1 = ???.getBounds();
    float f1 = i / ((Rect)localObject1).width();
    float f2 = j / ((Rect)localObject1).height();
    azeu.a("AssistantBackView", "onCompositionLoaded iw:" + i + ", ih:" + j + ": : rw:" + ((Rect)localObject1).width() + ", rh:" + ((Rect)localObject1).height());
    localObject1 = new LottieDrawable();
    ((LottieDrawable)localObject1).setImageAssetDelegate(new akpd(this.a.getContext().getApplicationContext()));
    ((LottieDrawable)localObject1).setComposition(???);
    ((LottieDrawable)localObject1).setScale(f1, f2);
    ((LottieDrawable)localObject1).loop(true);
    ??? = ((LottieDrawable)localObject1).getBounds();
    azeu.a("AssistantBackView", "onCompositionLoaded rw:" + ???.width() + ", rh:" + ???.height() + " mIsDestroyed:" + AssistantBackView.a(this.a));
    AssistantBackView.a(this.a, (LottieDrawable)localObject1);
    if (AssistantBackView.a(this.a))
    {
      ((LottieDrawable)localObject1).cancelAnimation();
      ((LottieDrawable)localObject1).recycleBitmaps();
      ((LottieDrawable)localObject1).clearComposition();
      ((LottieDrawable)localObject1).setImageAssetDelegate(null);
      AssistantBackView.a(this.a, null);
    }
    for (;;)
    {
      synchronized (AssistantBackView.a(this.a))
      {
        AssistantBackView.a(this.a, null);
        AssistantBackView.a(this.a, null);
        return;
      }
      if (this.a.isEnabled())
      {
        this.a.removeCallbacks(AssistantBackView.a(this.a));
        this.a.post(AssistantBackView.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgn
 * JD-Core Version:    0.7.0.1
 */
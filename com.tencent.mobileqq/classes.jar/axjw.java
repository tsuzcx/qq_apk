import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class axjw
  extends Handler
{
  public axjw(axjs paramaxjs, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
        if (BaseActivity.sTopActivity != null)
        {
          axjs.a(this.a, new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290)));
          paramMessage = (FrameLayout)axjs.a(this.a).get();
          if (paramMessage != null) {
            break label162;
          }
          QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
          return;
        }
        break;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleMessage exception = " + paramMessage.getMessage());
      return;
    }
    QLog.e("QzoneGiftManager", 1, "activity = null");
    return;
    label162:
    axjs.a(this.a, new FrameLayout(BaseApplicationImpl.getContext()));
    axjs.a(this.a).setOnTouchListener(this.a);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    paramMessage.addView(axjs.a(this.a), (ViewGroup.LayoutParams)localObject);
    if (axjs.a(this.a))
    {
      sendEmptyMessage(7);
      return;
    }
    axjs.a(this.a, 2);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (axjs.a(this.a) == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    axjs.a(this.a, new ImageView(BaseApplicationImpl.getContext()));
    axjs.a(this.a).setImageDrawable(axjs.a(this.a));
    axjs.b(this.a, new ImageView(BaseApplicationImpl.getContext()));
    axjs.b(this.a).setImageDrawable(axjs.b(this.a));
    paramMessage = new FrameLayout.LayoutParams(bdoo.b(200.0F), bdoo.b(200.0F));
    paramMessage.gravity = 17;
    axjs.a(this.a).addView(axjs.b(this.a), paramMessage);
    axjs.a(this.a).addView(axjs.a(this.a), paramMessage);
    axjs.a(this.a, new ParticleExplodeView(BaseApplicationImpl.getContext()));
    axjs.a(this.a, new ParticleDropView(BaseApplicationImpl.getContext()));
    axjs.a(this.a).setBitmap(axjs.a(this.a));
    paramMessage = new FrameLayout.LayoutParams(-1, -1);
    axjs.a(this.a).addView(axjs.a(this.a), paramMessage);
    axjs.a(this.a).addView(axjs.a(this.a), paramMessage);
    axjs.a(this.a, 3);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (axjs.a(this.a) != null)
    {
      axjs.a(this.a).start();
      axjs.a(this.a, 5, axjs.a(this.a).a() - 330);
      axjs.a(this.a, 4, axjs.a(this.a).a() - 300);
    }
    if (axjs.a(this.a) == null)
    {
      axjs.a(this.a, 4, 0);
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
      if (axjs.b(this.a) != null) {
        axjs.b(this.a).start();
      }
      if (axjs.a(this.a) != null) {
        axjs.a(this.a).b();
      }
      if (axjs.b(this.a) != null)
      {
        axjs.a(this.a, 6, axjs.b(this.a).a() + 2000);
        return;
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
        if (axjs.a(this.a) != null)
        {
          axjs.a(this.a).b();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
          paramMessage = ObjectAnimator.ofFloat(axjs.a(this.a), "alpha", new float[] { 1.0F, 0.0F });
          paramMessage.setDuration(500L);
          paramMessage.addListener(new axjx(this));
          paramMessage.start();
          paramMessage = new AnimatorSet();
          localObject = ObjectAnimator.ofFloat(axjs.b(this.a), "scaleX", new float[] { 1.0F, 0.5F });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(axjs.b(this.a), "scaleY", new float[] { 1.0F, 0.5F });
          paramMessage.setDuration(500L);
          paramMessage.play((Animator)localObject).with(localObjectAnimator);
          paramMessage.start();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
          if ((axjs.a(this.a) != null) && (axjs.a(this.a) != null))
          {
            paramMessage = new FrameLayout.LayoutParams(-1, -1);
            axjs.a(this.a).addView(axjs.a(this.a), paramMessage);
            return;
            QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
            if (axjs.a(this.a) != null) {
              axjs.a(this.a).b();
            }
            if (axjs.b(this.a) != null) {
              axjs.b(this.a).b();
            }
            if (axjs.a(this.a) != null) {
              axjs.a(this.a).c();
            }
            if (axjs.a(this.a) != null) {
              axjs.a(this.a).removeAllAnimatorListener();
            }
            if (axjs.a(this.a) != null)
            {
              paramMessage = (FrameLayout)axjs.a(this.a).get();
              if ((paramMessage != null) && (axjs.a(this.a) != null))
              {
                paramMessage.removeView(axjs.a(this.a));
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjw
 * JD-Core Version:    0.7.0.1
 */
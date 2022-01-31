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

class axfn
  extends Handler
{
  public axfn(axfj paramaxfj, Looper paramLooper)
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
          axfj.a(this.a, new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290)));
          paramMessage = (FrameLayout)axfj.a(this.a).get();
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
    axfj.a(this.a, new FrameLayout(BaseApplicationImpl.getContext()));
    axfj.a(this.a).setOnTouchListener(this.a);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    paramMessage.addView(axfj.a(this.a), (ViewGroup.LayoutParams)localObject);
    if (axfj.a(this.a))
    {
      sendEmptyMessage(7);
      return;
    }
    axfj.a(this.a, 2);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (axfj.a(this.a) == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    axfj.a(this.a, new ImageView(BaseApplicationImpl.getContext()));
    axfj.a(this.a).setImageDrawable(axfj.a(this.a));
    axfj.b(this.a, new ImageView(BaseApplicationImpl.getContext()));
    axfj.b(this.a).setImageDrawable(axfj.b(this.a));
    paramMessage = new FrameLayout.LayoutParams(bdkf.b(200.0F), bdkf.b(200.0F));
    paramMessage.gravity = 17;
    axfj.a(this.a).addView(axfj.b(this.a), paramMessage);
    axfj.a(this.a).addView(axfj.a(this.a), paramMessage);
    axfj.a(this.a, new ParticleExplodeView(BaseApplicationImpl.getContext()));
    axfj.a(this.a, new ParticleDropView(BaseApplicationImpl.getContext()));
    axfj.a(this.a).setBitmap(axfj.a(this.a));
    paramMessage = new FrameLayout.LayoutParams(-1, -1);
    axfj.a(this.a).addView(axfj.a(this.a), paramMessage);
    axfj.a(this.a).addView(axfj.a(this.a), paramMessage);
    axfj.a(this.a, 3);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (axfj.a(this.a) != null)
    {
      axfj.a(this.a).start();
      axfj.a(this.a, 5, axfj.a(this.a).a() - 330);
      axfj.a(this.a, 4, axfj.a(this.a).a() - 300);
    }
    if (axfj.a(this.a) == null)
    {
      axfj.a(this.a, 4, 0);
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
      if (axfj.b(this.a) != null) {
        axfj.b(this.a).start();
      }
      if (axfj.a(this.a) != null) {
        axfj.a(this.a).b();
      }
      if (axfj.b(this.a) != null)
      {
        axfj.a(this.a, 6, axfj.b(this.a).a() + 2000);
        return;
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
        if (axfj.a(this.a) != null)
        {
          axfj.a(this.a).b();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
          paramMessage = ObjectAnimator.ofFloat(axfj.a(this.a), "alpha", new float[] { 1.0F, 0.0F });
          paramMessage.setDuration(500L);
          paramMessage.addListener(new axfo(this));
          paramMessage.start();
          paramMessage = new AnimatorSet();
          localObject = ObjectAnimator.ofFloat(axfj.b(this.a), "scaleX", new float[] { 1.0F, 0.5F });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(axfj.b(this.a), "scaleY", new float[] { 1.0F, 0.5F });
          paramMessage.setDuration(500L);
          paramMessage.play((Animator)localObject).with(localObjectAnimator);
          paramMessage.start();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
          if ((axfj.a(this.a) != null) && (axfj.a(this.a) != null))
          {
            paramMessage = new FrameLayout.LayoutParams(-1, -1);
            axfj.a(this.a).addView(axfj.a(this.a), paramMessage);
            return;
            QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
            if (axfj.a(this.a) != null) {
              axfj.a(this.a).b();
            }
            if (axfj.b(this.a) != null) {
              axfj.b(this.a).b();
            }
            if (axfj.a(this.a) != null) {
              axfj.a(this.a).c();
            }
            if (axfj.a(this.a) != null) {
              axfj.a(this.a).removeAllAnimatorListener();
            }
            if (axfj.a(this.a) != null)
            {
              paramMessage = (FrameLayout)axfj.a(this.a).get();
              if ((paramMessage != null) && (axfj.a(this.a) != null))
              {
                paramMessage.removeView(axfj.a(this.a));
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
 * Qualified Name:     axfn
 * JD-Core Version:    0.7.0.1
 */
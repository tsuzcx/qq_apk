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

class avnq
  extends Handler
{
  public avnq(avnm paramavnm, Looper paramLooper)
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
          avnm.a(this.a, new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290)));
          paramMessage = (FrameLayout)avnm.a(this.a).get();
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
    avnm.a(this.a, new FrameLayout(BaseApplicationImpl.getContext()));
    avnm.a(this.a).setOnTouchListener(this.a);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    paramMessage.addView(avnm.a(this.a), (ViewGroup.LayoutParams)localObject);
    if (avnm.a(this.a))
    {
      sendEmptyMessage(7);
      return;
    }
    avnm.a(this.a, 2);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (avnm.a(this.a) == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    avnm.a(this.a, new ImageView(BaseApplicationImpl.getContext()));
    avnm.a(this.a).setImageDrawable(avnm.a(this.a));
    avnm.b(this.a, new ImageView(BaseApplicationImpl.getContext()));
    avnm.b(this.a).setImageDrawable(avnm.b(this.a));
    paramMessage = new FrameLayout.LayoutParams(bbkx.b(200.0F), bbkx.b(200.0F));
    paramMessage.gravity = 17;
    avnm.a(this.a).addView(avnm.b(this.a), paramMessage);
    avnm.a(this.a).addView(avnm.a(this.a), paramMessage);
    avnm.a(this.a, new ParticleExplodeView(BaseApplicationImpl.getContext()));
    avnm.a(this.a, new ParticleDropView(BaseApplicationImpl.getContext()));
    avnm.a(this.a).setBitmap(avnm.a(this.a));
    paramMessage = new FrameLayout.LayoutParams(-1, -1);
    avnm.a(this.a).addView(avnm.a(this.a), paramMessage);
    avnm.a(this.a).addView(avnm.a(this.a), paramMessage);
    avnm.a(this.a, 3);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (avnm.a(this.a) != null)
    {
      avnm.a(this.a).start();
      avnm.a(this.a, 5, avnm.a(this.a).a() - 330);
      avnm.a(this.a, 4, avnm.a(this.a).a() - 300);
    }
    if (avnm.a(this.a) == null)
    {
      avnm.a(this.a, 4, 0);
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
      if (avnm.b(this.a) != null) {
        avnm.b(this.a).start();
      }
      if (avnm.a(this.a) != null) {
        avnm.a(this.a).b();
      }
      if (avnm.b(this.a) != null)
      {
        avnm.a(this.a, 6, avnm.b(this.a).a() + 2000);
        return;
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
        if (avnm.a(this.a) != null)
        {
          avnm.a(this.a).b();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
          paramMessage = ObjectAnimator.ofFloat(avnm.a(this.a), "alpha", new float[] { 1.0F, 0.0F });
          paramMessage.setDuration(500L);
          paramMessage.addListener(new avnr(this));
          paramMessage.start();
          paramMessage = new AnimatorSet();
          localObject = ObjectAnimator.ofFloat(avnm.b(this.a), "scaleX", new float[] { 1.0F, 0.5F });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(avnm.b(this.a), "scaleY", new float[] { 1.0F, 0.5F });
          paramMessage.setDuration(500L);
          paramMessage.play((Animator)localObject).with(localObjectAnimator);
          paramMessage.start();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
          if ((avnm.a(this.a) != null) && (avnm.a(this.a) != null))
          {
            paramMessage = new FrameLayout.LayoutParams(-1, -1);
            avnm.a(this.a).addView(avnm.a(this.a), paramMessage);
            return;
            QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
            if (avnm.a(this.a) != null) {
              avnm.a(this.a).b();
            }
            if (avnm.b(this.a) != null) {
              avnm.b(this.a).b();
            }
            if (avnm.a(this.a) != null) {
              avnm.a(this.a).c();
            }
            if (avnm.a(this.a) != null) {
              avnm.a(this.a).removeAllAnimatorListener();
            }
            if (avnm.a(this.a) != null)
            {
              paramMessage = (FrameLayout)avnm.a(this.a).get();
              if ((paramMessage != null) && (avnm.a(this.a) != null))
              {
                paramMessage.removeView(avnm.a(this.a));
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnq
 * JD-Core Version:    0.7.0.1
 */
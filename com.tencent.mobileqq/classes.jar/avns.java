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

class avns
  extends Handler
{
  public avns(avno paramavno, Looper paramLooper)
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
          avno.a(this.a, new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290)));
          paramMessage = (FrameLayout)avno.a(this.a).get();
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
    avno.a(this.a, new FrameLayout(BaseApplicationImpl.getContext()));
    avno.a(this.a).setOnTouchListener(this.a);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    paramMessage.addView(avno.a(this.a), (ViewGroup.LayoutParams)localObject);
    if (avno.a(this.a))
    {
      sendEmptyMessage(7);
      return;
    }
    avno.a(this.a, 2);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (avno.a(this.a) == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    avno.a(this.a, new ImageView(BaseApplicationImpl.getContext()));
    avno.a(this.a).setImageDrawable(avno.a(this.a));
    avno.b(this.a, new ImageView(BaseApplicationImpl.getContext()));
    avno.b(this.a).setImageDrawable(avno.b(this.a));
    paramMessage = new FrameLayout.LayoutParams(bbll.b(200.0F), bbll.b(200.0F));
    paramMessage.gravity = 17;
    avno.a(this.a).addView(avno.b(this.a), paramMessage);
    avno.a(this.a).addView(avno.a(this.a), paramMessage);
    avno.a(this.a, new ParticleExplodeView(BaseApplicationImpl.getContext()));
    avno.a(this.a, new ParticleDropView(BaseApplicationImpl.getContext()));
    avno.a(this.a).setBitmap(avno.a(this.a));
    paramMessage = new FrameLayout.LayoutParams(-1, -1);
    avno.a(this.a).addView(avno.a(this.a), paramMessage);
    avno.a(this.a).addView(avno.a(this.a), paramMessage);
    avno.a(this.a, 3);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (avno.a(this.a) != null)
    {
      avno.a(this.a).start();
      avno.a(this.a, 5, avno.a(this.a).a() - 330);
      avno.a(this.a, 4, avno.a(this.a).a() - 300);
    }
    if (avno.a(this.a) == null)
    {
      avno.a(this.a, 4, 0);
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
      if (avno.b(this.a) != null) {
        avno.b(this.a).start();
      }
      if (avno.a(this.a) != null) {
        avno.a(this.a).b();
      }
      if (avno.b(this.a) != null)
      {
        avno.a(this.a, 6, avno.b(this.a).a() + 2000);
        return;
        QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
        if (avno.a(this.a) != null)
        {
          avno.a(this.a).b();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
          paramMessage = ObjectAnimator.ofFloat(avno.a(this.a), "alpha", new float[] { 1.0F, 0.0F });
          paramMessage.setDuration(500L);
          paramMessage.addListener(new avnt(this));
          paramMessage.start();
          paramMessage = new AnimatorSet();
          localObject = ObjectAnimator.ofFloat(avno.b(this.a), "scaleX", new float[] { 1.0F, 0.5F });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(avno.b(this.a), "scaleY", new float[] { 1.0F, 0.5F });
          paramMessage.setDuration(500L);
          paramMessage.play((Animator)localObject).with(localObjectAnimator);
          paramMessage.start();
          return;
          QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
          if ((avno.a(this.a) != null) && (avno.a(this.a) != null))
          {
            paramMessage = new FrameLayout.LayoutParams(-1, -1);
            avno.a(this.a).addView(avno.a(this.a), paramMessage);
            return;
            QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
            if (avno.a(this.a) != null) {
              avno.a(this.a).b();
            }
            if (avno.b(this.a) != null) {
              avno.b(this.a).b();
            }
            if (avno.a(this.a) != null) {
              avno.a(this.a).c();
            }
            if (avno.a(this.a) != null) {
              avno.a(this.a).removeAllAnimatorListener();
            }
            if (avno.a(this.a) != null)
            {
              paramMessage = (FrameLayout)avno.a(this.a).get();
              if ((paramMessage != null) && (avno.a(this.a) != null))
              {
                paramMessage.removeView(avno.a(this.a));
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
 * Qualified Name:     avns
 * JD-Core Version:    0.7.0.1
 */
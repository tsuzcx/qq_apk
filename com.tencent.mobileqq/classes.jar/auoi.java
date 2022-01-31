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

class auoi
  extends Handler
{
  public auoi(auoe paramauoe, Looper paramLooper)
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
          auoe.a(this.a, new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290)));
          paramMessage = (FrameLayout)auoe.a(this.a).get();
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
    auoe.a(this.a, new FrameLayout(BaseApplicationImpl.getContext()));
    auoe.a(this.a).setOnTouchListener(this.a);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    paramMessage.addView(auoe.a(this.a), (ViewGroup.LayoutParams)localObject);
    if (auoe.a(this.a))
    {
      sendEmptyMessage(7);
      return;
    }
    auoe.a(this.a, 2);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (auoe.a(this.a) == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    auoe.a(this.a, new ImageView(BaseApplicationImpl.getContext()));
    auoe.a(this.a).setImageDrawable(auoe.a(this.a));
    auoe.b(this.a, new ImageView(BaseApplicationImpl.getContext()));
    auoe.b(this.a).setImageDrawable(auoe.b(this.a));
    paramMessage = new FrameLayout.LayoutParams(bajq.b(200.0F), bajq.b(200.0F));
    paramMessage.gravity = 17;
    auoe.a(this.a).addView(auoe.b(this.a), paramMessage);
    auoe.a(this.a).addView(auoe.a(this.a), paramMessage);
    auoe.a(this.a, new ParticleExplodeView(BaseApplicationImpl.getContext()));
    auoe.a(this.a, new ParticleDropView(BaseApplicationImpl.getContext()));
    auoe.a(this.a).setBitmap(auoe.a(this.a));
    paramMessage = new FrameLayout.LayoutParams(-1, -1);
    auoe.a(this.a).addView(auoe.a(this.a), paramMessage);
    auoe.a(this.a).addView(auoe.a(this.a), paramMessage);
    auoe.a(this.a, 3);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (auoe.a(this.a) != null) {
      auoe.a(this.a).start();
    }
    auoe.a(this.a, 5, auoe.a(this.a).a() - 330);
    auoe.a(this.a, 4, auoe.a(this.a).a() - 300);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    if (auoe.b(this.a) != null) {
      auoe.b(this.a).start();
    }
    if (auoe.a(this.a) != null) {
      auoe.a(this.a).b();
    }
    auoe.a(this.a, 6, auoe.b(this.a).a() + 2000);
    return;
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    if (auoe.a(this.a) != null)
    {
      auoe.a(this.a).b();
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
      paramMessage = ObjectAnimator.ofFloat(auoe.a(this.a), "alpha", new float[] { 1.0F, 0.0F });
      paramMessage.setDuration(500L);
      paramMessage.addListener(new auoj(this));
      paramMessage.start();
      paramMessage = new AnimatorSet();
      localObject = ObjectAnimator.ofFloat(auoe.b(this.a), "scaleX", new float[] { 1.0F, 0.5F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(auoe.b(this.a), "scaleY", new float[] { 1.0F, 0.5F });
      paramMessage.setDuration(500L);
      paramMessage.play((Animator)localObject).with(localObjectAnimator);
      paramMessage.start();
      return;
      QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
      if ((auoe.a(this.a) != null) && (auoe.a(this.a) != null))
      {
        paramMessage = new FrameLayout.LayoutParams(-1, -1);
        auoe.a(this.a).addView(auoe.a(this.a), paramMessage);
        return;
        QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
        if (auoe.a(this.a) != null) {
          auoe.a(this.a).b();
        }
        if (auoe.b(this.a) != null) {
          auoe.b(this.a).b();
        }
        if (auoe.a(this.a) != null) {
          auoe.a(this.a).c();
        }
        if (auoe.a(this.a) != null) {
          auoe.a(this.a).removeAllAnimatorListener();
        }
        if (auoe.a(this.a) != null)
        {
          paramMessage = (FrameLayout)auoe.a(this.a).get();
          if ((paramMessage != null) && (auoe.a(this.a) != null))
          {
            paramMessage.removeView(auoe.a(this.a));
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auoi
 * JD-Core Version:    0.7.0.1
 */
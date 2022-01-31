package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VasFaceManager$Replayer
  implements ApngDrawable.OnPlayRepeatListener, Runnable
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  public WeakReference b;
  
  public VasFaceManager$Replayer(DynamicAvatarView paramDynamicAvatarView, ApngDrawable paramApngDrawable, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDynamicAvatarView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramApngDrawable.getImage());
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    paramApngDrawable.setOnPlayRepeatListener(this);
    if ((paramDynamicAvatarView != null) && (paramDynamicAvatarView.a != null)) {
      this.jdField_a_of_type_JavaLangString = paramDynamicAvatarView.a.jdField_a_of_type_JavaLangString;
    }
  }
  
  private String a()
  {
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = (l1 - this.jdField_a_of_type_Long + l2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_b_of_type_Long >= 5000L) {
        this.jdField_a_of_type_AndroidOsHandler.post(this);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L - this.jdField_b_of_type_Long);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(this);
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqhead.VasFaceManager", 1, "onPlayRepeat: " + this.jdField_a_of_type_JavaLangString + " image: " + this.jdField_b_of_type_JavaLangRefWeakReference.get());
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L);
  }
  
  public void run()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this);
    ApngImage localApngImage = (ApngImage)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localApngImage != null)
    {
      localApngImage.replay();
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.VasFaceManager", 2, a() + " isReplay " + localApngImage + " in " + this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager.Replayer
 * JD-Core Version:    0.7.0.1
 */
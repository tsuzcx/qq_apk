package com.tencent.mobileqq.apollo;

import amln;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloBrickPlayer$BrickCMSPlayerListener$1
  implements Runnable
{
  public ApolloBrickPlayer$BrickCMSPlayerListener$1(amln paramamln, int paramInt, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == amln.a(this.this$0)) {
      if ((amln.a(this.this$0) != null) && (amln.a(this.this$0).get() != null))
      {
        localObject = (ImageView)amln.a(this.this$0).get();
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        if ((amln.b(this.this$0) == null) || (amln.b(this.this$0).get() == null)) {
          break label161;
        }
        localObject = (ImageView)amln.b(this.this$0).get();
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        if ((amln.c(this.this$0) == null) || (amln.c(this.this$0).get() == null)) {
          break label166;
        }
        localObject = (RelativeLayout)amln.c(this.this$0).get();
        if (localObject != null) {
          ((RelativeLayout)localObject).invalidate();
        }
      }
    }
    label161:
    label166:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        Object localObject = null;
        continue;
        localObject = null;
        continue;
        localObject = null;
      }
    }
    QLog.w("ApolloBrickPlayer", 2, "onRecordDone mActionId not same! current " + amln.a(this.this$0) + " onRecordDone id " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloBrickPlayer.BrickCMSPlayerListener.1
 * JD-Core Version:    0.7.0.1
 */
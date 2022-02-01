package com.tencent.mobileqq.activity.aio;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class AIOUtils$3
  implements Runnable
{
  AIOUtils$3(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.val$touchView.setEnabled(true);
    this.val$touchView.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.val$top;
    ((Rect)localObject).bottom += this.val$bottom;
    ((Rect)localObject).left -= this.val$left;
    ((Rect)localObject).right += this.val$right;
    if (QLog.isColorLevel()) {
      QLog.d("TouchDelegate", 2, " bounds.top=" + ((Rect)localObject).top + "bounds.bottom=" + ((Rect)localObject).bottom);
    }
    localObject = new TouchDelegate((Rect)localObject, this.val$touchView);
    if (View.class.isInstance(this.val$touchView.getParent())) {
      ((View)this.val$touchView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils.3
 * JD-Core Version:    0.7.0.1
 */
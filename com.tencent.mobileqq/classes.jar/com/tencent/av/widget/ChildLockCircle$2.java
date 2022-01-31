package com.tencent.av.widget;

import android.view.ViewGroup;

class ChildLockCircle$2
  implements Runnable
{
  ChildLockCircle$2(ChildLockCircle paramChildLockCircle) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.this$0.getParent();
    if ((localViewGroup != null) && (localViewGroup.findViewById(2131372609) != null)) {
      localViewGroup.removeView(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.widget.ChildLockCircle.2
 * JD-Core Version:    0.7.0.1
 */
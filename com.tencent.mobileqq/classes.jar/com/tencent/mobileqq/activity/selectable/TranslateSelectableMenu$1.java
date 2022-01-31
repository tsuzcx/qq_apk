package com.tencent.mobileqq.activity.selectable;

import aepi;
import ajyl;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;

public class TranslateSelectableMenu$1
  implements Runnable
{
  public TranslateSelectableMenu$1(ajyl paramajyl, ContainerView paramContainerView) {}
  
  public void run()
  {
    this.a.a.setLineSpacing(aepi.a(6.0F, this.a.getResources()), 1.0F);
    this.a.a.setTextSize(1, 24.0F);
    this.a.a.setGravity(8388611);
    int i = aepi.a(16.0F, this.a.getResources());
    int j = aepi.a(12.0F, this.a.getResources());
    this.a.a.setPadding(j, i, j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1
 * JD-Core Version:    0.7.0.1
 */
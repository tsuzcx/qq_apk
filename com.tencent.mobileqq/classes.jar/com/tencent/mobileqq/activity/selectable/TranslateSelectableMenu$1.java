package com.tencent.mobileqq.activity.selectable;

import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;

class TranslateSelectableMenu$1
  implements Runnable
{
  TranslateSelectableMenu$1(TranslateSelectableMenu paramTranslateSelectableMenu, ContainerView paramContainerView) {}
  
  public void run()
  {
    this.a.a.setLineSpacing(AIOUtils.a(6.0F, this.a.getResources()), 1.0F);
    this.a.a.setTextSize(1, 24.0F);
    this.a.a.setGravity(8388611);
    int i = AIOUtils.a(16.0F, this.a.getResources());
    int j = AIOUtils.a(12.0F, this.a.getResources());
    this.a.a.setPadding(j, i, j, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu.1
 * JD-Core Version:    0.7.0.1
 */
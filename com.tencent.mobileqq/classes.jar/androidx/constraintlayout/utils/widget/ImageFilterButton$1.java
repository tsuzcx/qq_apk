package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class ImageFilterButton$1
  extends ViewOutlineProvider
{
  ImageFilterButton$1(ImageFilterButton paramImageFilterButton) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    int i = this.this$0.getWidth();
    int j = this.this$0.getHeight();
    paramOutline.setRoundRect(0, 0, i, j, Math.min(i, j) * ImageFilterButton.access$000(this.this$0) / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterButton.1
 * JD-Core Version:    0.7.0.1
 */
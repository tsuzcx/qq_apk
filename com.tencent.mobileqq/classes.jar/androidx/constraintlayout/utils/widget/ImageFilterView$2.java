package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class ImageFilterView$2
  extends ViewOutlineProvider
{
  ImageFilterView$2(ImageFilterView paramImageFilterView) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterView.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.utils.widget.ImageFilterView.2
 * JD-Core Version:    0.7.0.1
 */
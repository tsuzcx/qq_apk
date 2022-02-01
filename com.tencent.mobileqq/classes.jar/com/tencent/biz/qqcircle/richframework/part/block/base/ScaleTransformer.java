package com.tencent.biz.qqcircle.richframework.part.block.base;

import android.view.View;
import com.tencent.biz.richframework.part.block.base.GalleryLayoutManager;
import com.tencent.biz.richframework.part.block.base.GalleryLayoutManager.ItemTransformer;

public class ScaleTransformer
  implements GalleryLayoutManager.ItemTransformer
{
  public void a(GalleryLayoutManager paramGalleryLayoutManager, View paramView, float paramFloat)
  {
    paramView.setPivotX(paramView.getWidth() / 2.0F);
    paramView.setPivotY(paramView.getHeight() / 2.0F);
    paramFloat = 1.0F - Math.abs(paramFloat) * 0.05F;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.block.base.ScaleTransformer
 * JD-Core Version:    0.7.0.1
 */
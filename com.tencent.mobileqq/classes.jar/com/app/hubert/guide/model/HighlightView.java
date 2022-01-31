package com.app.hubert.guide.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.app.hubert.guide.util.LogUtil;
import com.app.hubert.guide.util.ViewUtils;

public class HighlightView
  implements HighLight
{
  private View mHole;
  private HighlightOptions options;
  private int padding;
  private RectF rectF;
  private int round;
  private HighLight.Shape shape;
  
  public HighlightView(View paramView, HighLight.Shape paramShape, int paramInt1, int paramInt2)
  {
    this.mHole = paramView;
    this.shape = paramShape;
    this.round = paramInt1;
    this.padding = paramInt2;
  }
  
  private RectF fetchLocation(View paramView)
  {
    RectF localRectF = new RectF();
    paramView = ViewUtils.getLocationInView(paramView, this.mHole);
    localRectF.left = (paramView.left - this.padding);
    localRectF.top = (paramView.top - this.padding);
    localRectF.right = (paramView.right + this.padding);
    localRectF.bottom = (paramView.bottom + this.padding);
    return localRectF;
  }
  
  public HighlightOptions getOptions()
  {
    return this.options;
  }
  
  public float getRadius()
  {
    if (this.mHole == null) {
      throw new IllegalArgumentException("the highlight view is null!");
    }
    return Math.max(this.mHole.getWidth() / 2, this.mHole.getHeight() / 2) + this.padding;
  }
  
  public RectF getRectF(View paramView)
  {
    if (this.mHole == null) {
      throw new IllegalArgumentException("the highlight view is null!");
    }
    if (this.rectF == null) {}
    for (this.rectF = fetchLocation(paramView);; this.rectF = fetchLocation(paramView)) {
      do
      {
        LogUtil.i(this.mHole.getClass().getSimpleName() + "'s location:" + this.rectF);
        return this.rectF;
      } while ((this.options == null) || (!this.options.fetchLocationEveryTime));
    }
  }
  
  public int getRound()
  {
    return this.round;
  }
  
  public HighLight.Shape getShape()
  {
    return this.shape;
  }
  
  public void setOptions(HighlightOptions paramHighlightOptions)
  {
    this.options = paramHighlightOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.app.hubert.guide.model.HighlightView
 * JD-Core Version:    0.7.0.1
 */
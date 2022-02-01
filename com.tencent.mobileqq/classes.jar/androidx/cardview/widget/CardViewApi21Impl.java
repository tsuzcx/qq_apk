package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class CardViewApi21Impl
  implements CardViewImpl
{
  private RoundRectDrawable getCardBackground(CardViewDelegate paramCardViewDelegate)
  {
    return (RoundRectDrawable)paramCardViewDelegate.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackground(paramCardViewDelegate).getColor();
  }
  
  public float getElevation(CardViewDelegate paramCardViewDelegate)
  {
    return paramCardViewDelegate.getCardView().getElevation();
  }
  
  public float getMaxElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackground(paramCardViewDelegate).getPadding();
  }
  
  public float getMinHeight(CardViewDelegate paramCardViewDelegate)
  {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getMinWidth(CardViewDelegate paramCardViewDelegate)
  {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getCardBackground(paramCardViewDelegate).getRadius();
  }
  
  public void initStatic() {}
  
  public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCardViewDelegate.setCardBackground(new RoundRectDrawable(paramColorStateList, paramFloat1));
    paramContext = paramCardViewDelegate.getCardView();
    paramContext.setClipToOutline(true);
    paramContext.setElevation(paramFloat2);
    setMaxElevation(paramCardViewDelegate, paramFloat3);
  }
  
  public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
  {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, @Nullable ColorStateList paramColorStateList)
  {
    getCardBackground(paramCardViewDelegate).setColor(paramColorStateList);
  }
  
  public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    paramCardViewDelegate.getCardView().setElevation(paramFloat);
  }
  
  public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getCardBackground(paramCardViewDelegate).setPadding(paramFloat, paramCardViewDelegate.getUseCompatPadding(), paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getCardBackground(paramCardViewDelegate).setRadius(paramFloat);
  }
  
  public void updatePadding(CardViewDelegate paramCardViewDelegate)
  {
    if (!paramCardViewDelegate.getUseCompatPadding())
    {
      paramCardViewDelegate.setShadowPadding(0, 0, 0, 0);
      return;
    }
    float f1 = getMaxElevation(paramCardViewDelegate);
    float f2 = getRadius(paramCardViewDelegate);
    int i = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    int j = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    paramCardViewDelegate.setShadowPadding(i, j, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.cardview.widget.CardViewApi21Impl
 * JD-Core Version:    0.7.0.1
 */
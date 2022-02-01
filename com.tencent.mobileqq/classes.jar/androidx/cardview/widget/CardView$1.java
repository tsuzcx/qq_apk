package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

class CardView$1
  implements CardViewDelegate
{
  private Drawable mCardBackground;
  
  CardView$1(CardView paramCardView) {}
  
  public Drawable getCardBackground()
  {
    return this.mCardBackground;
  }
  
  public View getCardView()
  {
    return this.this$0;
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this.this$0.getPreventCornerOverlap();
  }
  
  public boolean getUseCompatPadding()
  {
    return this.this$0.getUseCompatPadding();
  }
  
  public void setCardBackground(Drawable paramDrawable)
  {
    this.mCardBackground = paramDrawable;
    this.this$0.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMinWidthHeightInternal(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.this$0.mUserSetMinWidth) {
      CardView.access$101(this.this$0, paramInt1);
    }
    if (paramInt2 > this.this$0.mUserSetMinHeight) {
      CardView.access$201(this.this$0, paramInt2);
    }
  }
  
  public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.this$0.mShadowBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView localCardView = this.this$0;
    CardView.access$001(localCardView, paramInt1 + localCardView.mContentPadding.left, paramInt2 + this.this$0.mContentPadding.top, paramInt3 + this.this$0.mContentPadding.right, paramInt4 + this.this$0.mContentPadding.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.cardview.widget.CardView.1
 * JD-Core Version:    0.7.0.1
 */
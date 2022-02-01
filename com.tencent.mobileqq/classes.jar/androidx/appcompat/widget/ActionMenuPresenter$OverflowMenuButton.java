package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

class ActionMenuPresenter$OverflowMenuButton
  extends AppCompatImageView
  implements ActionMenuView.ActionMenuChildView
{
  private final float[] mTempPts = new float[2];
  
  public ActionMenuPresenter$OverflowMenuButton(ActionMenuPresenter paramActionMenuPresenter, Context paramContext)
  {
    super(paramContext, null, 2131034146);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    TooltipCompat.setTooltipText(this, getContentDescription());
    setOnTouchListener(new ActionMenuPresenter.OverflowMenuButton.1(this, this, paramActionMenuPresenter));
  }
  
  public boolean needsDividerAfter()
  {
    return false;
  }
  
  public boolean needsDividerBefore()
  {
    return false;
  }
  
  public boolean performClick()
  {
    if (super.performClick()) {
      return true;
    }
    playSoundEffect(0);
    this.this$0.showOverflowMenu();
    return true;
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable1 = getDrawable();
    Drawable localDrawable2 = getBackground();
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      int i = getWidth();
      paramInt2 = getHeight();
      paramInt1 = Math.max(i, paramInt2) / 2;
      int j = getPaddingLeft();
      int k = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      i = (i + (j - k)) / 2;
      paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
      DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton
 * JD-Core Version:    0.7.0.1
 */
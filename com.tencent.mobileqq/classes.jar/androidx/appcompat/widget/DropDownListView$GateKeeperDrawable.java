package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

class DropDownListView$GateKeeperDrawable
  extends DrawableWrapper
{
  private boolean mEnabled = true;
  
  DropDownListView$GateKeeperDrawable(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mEnabled) {
      super.draw(paramCanvas);
    }
  }
  
  void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.mEnabled) {
      super.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mEnabled) {
      super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.mEnabled) {
      return super.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mEnabled) {
      return super.setVisible(paramBoolean1, paramBoolean2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.DropDownListView.GateKeeperDrawable
 * JD-Core Version:    0.7.0.1
 */
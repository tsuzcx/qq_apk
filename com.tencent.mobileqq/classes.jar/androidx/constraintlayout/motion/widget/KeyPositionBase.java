package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class KeyPositionBase
  extends Key
{
  protected static final float SELECTION_SLOPE = 20.0F;
  int mCurveFit = UNSET;
  
  abstract void calcPosition(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  void getAttributeNames(HashSet<String> paramHashSet) {}
  
  abstract float getPositionX();
  
  abstract float getPositionY();
  
  public abstract boolean intersects(int paramInt1, int paramInt2, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2);
  
  abstract void positionAttributes(View paramView, RectF paramRectF1, RectF paramRectF2, float paramFloat1, float paramFloat2, String[] paramArrayOfString, float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyPositionBase
 * JD-Core Version:    0.7.0.1
 */
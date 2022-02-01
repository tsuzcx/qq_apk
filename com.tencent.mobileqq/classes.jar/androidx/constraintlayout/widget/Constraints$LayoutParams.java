package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class Constraints$LayoutParams
  extends ConstraintLayout.LayoutParams
{
  public float alpha = 1.0F;
  public boolean applyElevation;
  public float elevation;
  public float rotation;
  public float rotationX;
  public float rotationY;
  public float scaleX;
  public float scaleY;
  public float transformPivotX;
  public float transformPivotY;
  public float translationX;
  public float translationY;
  public float translationZ;
  
  public Constraints$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.applyElevation = false;
    this.elevation = 0.0F;
    this.rotation = 0.0F;
    this.rotationX = 0.0F;
    this.rotationY = 0.0F;
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.transformPivotX = 0.0F;
    this.transformPivotY = 0.0F;
    this.translationX = 0.0F;
    this.translationY = 0.0F;
    this.translationZ = 0.0F;
  }
  
  public Constraints$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    this.applyElevation = false;
    this.elevation = 0.0F;
    this.rotation = 0.0F;
    this.rotationX = 0.0F;
    this.rotationY = 0.0F;
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.transformPivotX = 0.0F;
    this.transformPivotY = 0.0F;
    this.translationX = 0.0F;
    this.translationY = 0.0F;
    this.translationZ = 0.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    int j = paramContext.getIndexCount();
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.ConstraintSet_android_alpha) {
        this.alpha = paramContext.getFloat(k, this.alpha);
      } else if (k == R.styleable.ConstraintSet_android_elevation)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.elevation = paramContext.getFloat(k, this.elevation);
          this.applyElevation = true;
        }
      }
      else if (k == R.styleable.ConstraintSet_android_rotationX) {
        this.rotationX = paramContext.getFloat(k, this.rotationX);
      } else if (k == R.styleable.ConstraintSet_android_rotationY) {
        this.rotationY = paramContext.getFloat(k, this.rotationY);
      } else if (k == R.styleable.ConstraintSet_android_rotation) {
        this.rotation = paramContext.getFloat(k, this.rotation);
      } else if (k == R.styleable.ConstraintSet_android_scaleX) {
        this.scaleX = paramContext.getFloat(k, this.scaleX);
      } else if (k == R.styleable.ConstraintSet_android_scaleY) {
        this.scaleY = paramContext.getFloat(k, this.scaleY);
      } else if (k == R.styleable.ConstraintSet_android_transformPivotX) {
        this.transformPivotX = paramContext.getFloat(k, this.transformPivotX);
      } else if (k == R.styleable.ConstraintSet_android_transformPivotY) {
        this.transformPivotY = paramContext.getFloat(k, this.transformPivotY);
      } else if (k == R.styleable.ConstraintSet_android_translationX) {
        this.translationX = paramContext.getFloat(k, this.translationX);
      } else if (k == R.styleable.ConstraintSet_android_translationY) {
        this.translationY = paramContext.getFloat(k, this.translationY);
      } else if ((k == R.styleable.ConstraintSet_android_translationZ) && (Build.VERSION.SDK_INT >= 21)) {
        this.translationZ = paramContext.getFloat(k, this.translationZ);
      }
      i += 1;
    }
    paramContext.recycle();
  }
  
  public Constraints$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.applyElevation = false;
    this.elevation = 0.0F;
    this.rotation = 0.0F;
    this.rotationX = 0.0F;
    this.rotationY = 0.0F;
    this.scaleX = 1.0F;
    this.scaleY = 1.0F;
    this.transformPivotX = 0.0F;
    this.transformPivotY = 0.0F;
    this.translationX = 0.0F;
    this.translationY = 0.0F;
    this.translationZ = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.Constraints.LayoutParams
 * JD-Core Version:    0.7.0.1
 */
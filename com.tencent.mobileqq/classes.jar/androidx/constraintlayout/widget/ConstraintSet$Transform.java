package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public class ConstraintSet$Transform
{
  private static final int ELEVATION = 11;
  private static final int ROTATION = 1;
  private static final int ROTATION_X = 2;
  private static final int ROTATION_Y = 3;
  private static final int SCALE_X = 4;
  private static final int SCALE_Y = 5;
  private static final int TRANSFORM_PIVOT_X = 6;
  private static final int TRANSFORM_PIVOT_Y = 7;
  private static final int TRANSLATION_X = 8;
  private static final int TRANSLATION_Y = 9;
  private static final int TRANSLATION_Z = 10;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  public boolean applyElevation = false;
  public float elevation = 0.0F;
  public boolean mApply = false;
  public float rotation = 0.0F;
  public float rotationX = 0.0F;
  public float rotationY = 0.0F;
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
  public float transformPivotX = (0.0F / 0.0F);
  public float transformPivotY = (0.0F / 0.0F);
  public float translationX = 0.0F;
  public float translationY = 0.0F;
  public float translationZ = 0.0F;
  
  static
  {
    mapToConstant.append(R.styleable.Transform_android_rotation, 1);
    mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
    mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
    mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
    mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
    mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
    mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
    mapToConstant.append(R.styleable.Transform_android_translationX, 8);
    mapToConstant.append(R.styleable.Transform_android_translationY, 9);
    mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
    mapToConstant.append(R.styleable.Transform_android_elevation, 11);
  }
  
  public void copyFrom(Transform paramTransform)
  {
    this.mApply = paramTransform.mApply;
    this.rotation = paramTransform.rotation;
    this.rotationX = paramTransform.rotationX;
    this.rotationY = paramTransform.rotationY;
    this.scaleX = paramTransform.scaleX;
    this.scaleY = paramTransform.scaleY;
    this.transformPivotX = paramTransform.transformPivotX;
    this.transformPivotY = paramTransform.transformPivotY;
    this.translationX = paramTransform.translationX;
    this.translationY = paramTransform.translationY;
    this.translationZ = paramTransform.translationZ;
    this.applyElevation = paramTransform.applyElevation;
    this.elevation = paramTransform.elevation;
  }
  
  void fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Transform);
    this.mApply = true;
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      switch (mapToConstant.get(k))
      {
      default: 
        break;
      case 11: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.applyElevation = true;
          this.elevation = paramContext.getDimension(k, this.elevation);
        }
        break;
      case 10: 
        if (Build.VERSION.SDK_INT >= 21) {
          this.translationZ = paramContext.getDimension(k, this.translationZ);
        }
        break;
      case 9: 
        this.translationY = paramContext.getDimension(k, this.translationY);
        break;
      case 8: 
        this.translationX = paramContext.getDimension(k, this.translationX);
        break;
      case 7: 
        this.transformPivotY = paramContext.getDimension(k, this.transformPivotY);
        break;
      case 6: 
        this.transformPivotX = paramContext.getDimension(k, this.transformPivotX);
        break;
      case 5: 
        this.scaleY = paramContext.getFloat(k, this.scaleY);
        break;
      case 4: 
        this.scaleX = paramContext.getFloat(k, this.scaleX);
        break;
      case 3: 
        this.rotationY = paramContext.getFloat(k, this.rotationY);
        break;
      case 2: 
        this.rotationX = paramContext.getFloat(k, this.rotationX);
        break;
      case 1: 
        this.rotation = paramContext.getFloat(k, this.rotation);
      }
      i += 1;
    }
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintSet.Transform
 * JD-Core Version:    0.7.0.1
 */
package androidx.transition;

import android.view.View;
import androidx.core.view.ViewCompat;

class ChangeTransform$Transforms
{
  final float mRotationX;
  final float mRotationY;
  final float mRotationZ;
  final float mScaleX;
  final float mScaleY;
  final float mTranslationX;
  final float mTranslationY;
  final float mTranslationZ;
  
  ChangeTransform$Transforms(View paramView)
  {
    this.mTranslationX = paramView.getTranslationX();
    this.mTranslationY = paramView.getTranslationY();
    this.mTranslationZ = ViewCompat.getTranslationZ(paramView);
    this.mScaleX = paramView.getScaleX();
    this.mScaleY = paramView.getScaleY();
    this.mRotationX = paramView.getRotationX();
    this.mRotationY = paramView.getRotationY();
    this.mRotationZ = paramView.getRotation();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Transforms;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Transforms)paramObject;
    bool1 = bool2;
    if (paramObject.mTranslationX == this.mTranslationX)
    {
      bool1 = bool2;
      if (paramObject.mTranslationY == this.mTranslationY)
      {
        bool1 = bool2;
        if (paramObject.mTranslationZ == this.mTranslationZ)
        {
          bool1 = bool2;
          if (paramObject.mScaleX == this.mScaleX)
          {
            bool1 = bool2;
            if (paramObject.mScaleY == this.mScaleY)
            {
              bool1 = bool2;
              if (paramObject.mRotationX == this.mRotationX)
              {
                bool1 = bool2;
                if (paramObject.mRotationY == this.mRotationY)
                {
                  bool1 = bool2;
                  if (paramObject.mRotationZ == this.mRotationZ) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    float f = this.mTranslationX;
    int i3 = 0;
    int i;
    if (f != 0.0F) {
      i = Float.floatToIntBits(f);
    } else {
      i = 0;
    }
    f = this.mTranslationY;
    int j;
    if (f != 0.0F) {
      j = Float.floatToIntBits(f);
    } else {
      j = 0;
    }
    f = this.mTranslationZ;
    int k;
    if (f != 0.0F) {
      k = Float.floatToIntBits(f);
    } else {
      k = 0;
    }
    f = this.mScaleX;
    int m;
    if (f != 0.0F) {
      m = Float.floatToIntBits(f);
    } else {
      m = 0;
    }
    f = this.mScaleY;
    int n;
    if (f != 0.0F) {
      n = Float.floatToIntBits(f);
    } else {
      n = 0;
    }
    f = this.mRotationX;
    int i1;
    if (f != 0.0F) {
      i1 = Float.floatToIntBits(f);
    } else {
      i1 = 0;
    }
    f = this.mRotationY;
    int i2;
    if (f != 0.0F) {
      i2 = Float.floatToIntBits(f);
    } else {
      i2 = 0;
    }
    f = this.mRotationZ;
    if (f != 0.0F) {
      i3 = Float.floatToIntBits(f);
    }
    return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
  
  public void restore(View paramView)
  {
    ChangeTransform.setTransforms(paramView, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeTransform.Transforms
 * JD-Core Version:    0.7.0.1
 */
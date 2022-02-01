package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;

class KeyAttributes$Loader
{
  private static final int ANDROID_ALPHA = 1;
  private static final int ANDROID_ELEVATION = 2;
  private static final int ANDROID_PIVOT_X = 19;
  private static final int ANDROID_PIVOT_Y = 20;
  private static final int ANDROID_ROTATION = 4;
  private static final int ANDROID_ROTATION_X = 5;
  private static final int ANDROID_ROTATION_Y = 6;
  private static final int ANDROID_SCALE_X = 7;
  private static final int ANDROID_SCALE_Y = 14;
  private static final int ANDROID_TRANSLATION_X = 15;
  private static final int ANDROID_TRANSLATION_Y = 16;
  private static final int ANDROID_TRANSLATION_Z = 17;
  private static final int CURVE_FIT = 13;
  private static final int FRAME_POSITION = 12;
  private static final int PROGRESS = 18;
  private static final int TARGET_ID = 10;
  private static final int TRANSITION_EASING = 9;
  private static final int TRANSITION_PATH_ROTATE = 8;
  private static SparseIntArray mAttrMap = new SparseIntArray();
  
  static
  {
    mAttrMap.append(R.styleable.KeyAttribute_android_alpha, 1);
    mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
    mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
    mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
    mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
    mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
    mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
    mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
    mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
    mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
    mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
    mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
    mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
    mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
    mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
    mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
    mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
    mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
  }
  
  public static void read(KeyAttributes paramKeyAttributes, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (mAttrMap.get(k))
      {
      case 3: 
      case 11: 
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unused attribute 0x");
        localStringBuilder.append(Integer.toHexString(k));
        localStringBuilder.append("   ");
        localStringBuilder.append(mAttrMap.get(k));
        Log.e("KeyAttribute", localStringBuilder.toString());
        break;
      case 20: 
        KeyAttributes.access$802(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$800(paramKeyAttributes)));
        break;
      case 19: 
        KeyAttributes.access$702(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$700(paramKeyAttributes)));
        break;
      case 18: 
        KeyAttributes.access$1502(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$1500(paramKeyAttributes)));
        break;
      case 17: 
        if (Build.VERSION.SDK_INT >= 21) {
          KeyAttributes.access$1402(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$1400(paramKeyAttributes)));
        }
        break;
      case 16: 
        KeyAttributes.access$1302(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$1300(paramKeyAttributes)));
        break;
      case 15: 
        KeyAttributes.access$1202(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$1200(paramKeyAttributes)));
        break;
      case 14: 
        KeyAttributes.access$1002(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$1000(paramKeyAttributes)));
        break;
      case 13: 
        KeyAttributes.access$302(paramKeyAttributes, paramTypedArray.getInteger(k, KeyAttributes.access$300(paramKeyAttributes)));
        break;
      case 12: 
        paramKeyAttributes.mFramePosition = paramTypedArray.getInt(k, paramKeyAttributes.mFramePosition);
        break;
      case 10: 
        if (MotionLayout.IS_IN_EDIT_MODE)
        {
          paramKeyAttributes.mTargetId = paramTypedArray.getResourceId(k, paramKeyAttributes.mTargetId);
          if (paramKeyAttributes.mTargetId == -1) {
            paramKeyAttributes.mTargetString = paramTypedArray.getString(k);
          }
        }
        else if (paramTypedArray.peekValue(k).type == 3)
        {
          paramKeyAttributes.mTargetString = paramTypedArray.getString(k);
        }
        else
        {
          paramKeyAttributes.mTargetId = paramTypedArray.getResourceId(k, paramKeyAttributes.mTargetId);
        }
        break;
      case 9: 
        KeyAttributes.access$902(paramKeyAttributes, paramTypedArray.getString(k));
        break;
      case 8: 
        KeyAttributes.access$1102(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$1100(paramKeyAttributes)));
        break;
      case 7: 
        KeyAttributes.access$402(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$400(paramKeyAttributes)));
        break;
      case 6: 
        KeyAttributes.access$602(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$600(paramKeyAttributes)));
        break;
      case 5: 
        KeyAttributes.access$502(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$500(paramKeyAttributes)));
        break;
      case 4: 
        KeyAttributes.access$202(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$200(paramKeyAttributes)));
        break;
      case 2: 
        KeyAttributes.access$102(paramKeyAttributes, paramTypedArray.getDimension(k, KeyAttributes.access$100(paramKeyAttributes)));
        break;
      case 1: 
        KeyAttributes.access$002(paramKeyAttributes, paramTypedArray.getFloat(k, KeyAttributes.access$000(paramKeyAttributes)));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyAttributes.Loader
 * JD-Core Version:    0.7.0.1
 */
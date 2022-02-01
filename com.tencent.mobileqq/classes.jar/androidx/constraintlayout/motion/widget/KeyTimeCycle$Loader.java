package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;

class KeyTimeCycle$Loader
{
  private static final int ANDROID_ALPHA = 1;
  private static final int ANDROID_ELEVATION = 2;
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
  private static final int WAVE_OFFSET = 21;
  private static final int WAVE_PERIOD = 20;
  private static final int WAVE_SHAPE = 19;
  private static SparseIntArray mAttrMap = new SparseIntArray();
  
  static
  {
    mAttrMap.append(R.styleable.KeyTimeCycle_android_alpha, 1);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
    mAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
    mAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
    mAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
    mAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
    mAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
    mAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
    mAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
    mAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
    mAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
    mAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
  }
  
  public static void read(KeyTimeCycle paramKeyTimeCycle, TypedArray paramTypedArray)
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
        Log.e("KeyTimeCycle", localStringBuilder.toString());
        break;
      case 21: 
        if (paramTypedArray.peekValue(k).type == 5) {
          KeyTimeCycle.access$602(paramKeyTimeCycle, paramTypedArray.getDimension(k, KeyTimeCycle.access$600(paramKeyTimeCycle)));
        } else {
          KeyTimeCycle.access$602(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$600(paramKeyTimeCycle)));
        }
        break;
      case 20: 
        KeyTimeCycle.access$502(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$500(paramKeyTimeCycle)));
        break;
      case 19: 
        KeyTimeCycle.access$402(paramKeyTimeCycle, paramTypedArray.getInt(k, KeyTimeCycle.access$400(paramKeyTimeCycle)));
        break;
      case 18: 
        KeyTimeCycle.access$1602(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$1600(paramKeyTimeCycle)));
        break;
      case 17: 
        if (Build.VERSION.SDK_INT >= 21) {
          KeyTimeCycle.access$1502(paramKeyTimeCycle, paramTypedArray.getDimension(k, KeyTimeCycle.access$1500(paramKeyTimeCycle)));
        }
        break;
      case 16: 
        KeyTimeCycle.access$1402(paramKeyTimeCycle, paramTypedArray.getDimension(k, KeyTimeCycle.access$1400(paramKeyTimeCycle)));
        break;
      case 15: 
        KeyTimeCycle.access$1302(paramKeyTimeCycle, paramTypedArray.getDimension(k, KeyTimeCycle.access$1300(paramKeyTimeCycle)));
        break;
      case 14: 
        KeyTimeCycle.access$1102(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$1100(paramKeyTimeCycle)));
        break;
      case 13: 
        KeyTimeCycle.access$302(paramKeyTimeCycle, paramTypedArray.getInteger(k, KeyTimeCycle.access$300(paramKeyTimeCycle)));
        break;
      case 12: 
        paramKeyTimeCycle.mFramePosition = paramTypedArray.getInt(k, paramKeyTimeCycle.mFramePosition);
        break;
      case 10: 
        if (MotionLayout.IS_IN_EDIT_MODE)
        {
          paramKeyTimeCycle.mTargetId = paramTypedArray.getResourceId(k, paramKeyTimeCycle.mTargetId);
          if (paramKeyTimeCycle.mTargetId == -1) {
            paramKeyTimeCycle.mTargetString = paramTypedArray.getString(k);
          }
        }
        else if (paramTypedArray.peekValue(k).type == 3)
        {
          paramKeyTimeCycle.mTargetString = paramTypedArray.getString(k);
        }
        else
        {
          paramKeyTimeCycle.mTargetId = paramTypedArray.getResourceId(k, paramKeyTimeCycle.mTargetId);
        }
        break;
      case 9: 
        KeyTimeCycle.access$1002(paramKeyTimeCycle, paramTypedArray.getString(k));
        break;
      case 8: 
        KeyTimeCycle.access$1202(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$1200(paramKeyTimeCycle)));
        break;
      case 7: 
        KeyTimeCycle.access$702(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$700(paramKeyTimeCycle)));
        break;
      case 6: 
        KeyTimeCycle.access$902(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$900(paramKeyTimeCycle)));
        break;
      case 5: 
        KeyTimeCycle.access$802(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$800(paramKeyTimeCycle)));
        break;
      case 4: 
        KeyTimeCycle.access$202(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$200(paramKeyTimeCycle)));
        break;
      case 2: 
        KeyTimeCycle.access$102(paramKeyTimeCycle, paramTypedArray.getDimension(k, KeyTimeCycle.access$100(paramKeyTimeCycle)));
        break;
      case 1: 
        KeyTimeCycle.access$002(paramKeyTimeCycle, paramTypedArray.getFloat(k, KeyTimeCycle.access$000(paramKeyTimeCycle)));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyTimeCycle.Loader
 * JD-Core Version:    0.7.0.1
 */
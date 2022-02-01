package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;

class KeyCycle$Loader
{
  private static final int ANDROID_ALPHA = 9;
  private static final int ANDROID_ELEVATION = 10;
  private static final int ANDROID_ROTATION = 11;
  private static final int ANDROID_ROTATION_X = 12;
  private static final int ANDROID_ROTATION_Y = 13;
  private static final int ANDROID_SCALE_X = 15;
  private static final int ANDROID_SCALE_Y = 16;
  private static final int ANDROID_TRANSLATION_X = 17;
  private static final int ANDROID_TRANSLATION_Y = 18;
  private static final int ANDROID_TRANSLATION_Z = 19;
  private static final int CURVE_FIT = 4;
  private static final int FRAME_POSITION = 2;
  private static final int PROGRESS = 20;
  private static final int TARGET_ID = 1;
  private static final int TRANSITION_EASING = 3;
  private static final int TRANSITION_PATH_ROTATE = 14;
  private static final int WAVE_OFFSET = 7;
  private static final int WAVE_PERIOD = 6;
  private static final int WAVE_SHAPE = 5;
  private static final int WAVE_VARIES_BY = 8;
  private static SparseIntArray mAttrMap = new SparseIntArray();
  
  static
  {
    mAttrMap.append(R.styleable.KeyCycle_motionTarget, 1);
    mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
    mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
    mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
    mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
    mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
    mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
    mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
    mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
    mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
    mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
    mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
    mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
    mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
    mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
    mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
    mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
    mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
    mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
    mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
  }
  
  private static void read(KeyCycle paramKeyCycle, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (mAttrMap.get(k))
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unused attribute 0x");
        localStringBuilder.append(Integer.toHexString(k));
        localStringBuilder.append("   ");
        localStringBuilder.append(mAttrMap.get(k));
        Log.e("KeyCycle", localStringBuilder.toString());
        break;
      case 20: 
        KeyCycle.access$1802(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1800(paramKeyCycle)));
        break;
      case 19: 
        if (Build.VERSION.SDK_INT >= 21) {
          KeyCycle.access$1702(paramKeyCycle, paramTypedArray.getDimension(k, KeyCycle.access$1700(paramKeyCycle)));
        }
        break;
      case 18: 
        KeyCycle.access$1602(paramKeyCycle, paramTypedArray.getDimension(k, KeyCycle.access$1600(paramKeyCycle)));
        break;
      case 17: 
        KeyCycle.access$1502(paramKeyCycle, paramTypedArray.getDimension(k, KeyCycle.access$1500(paramKeyCycle)));
        break;
      case 16: 
        KeyCycle.access$1402(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1400(paramKeyCycle)));
        break;
      case 15: 
        KeyCycle.access$1302(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1300(paramKeyCycle)));
        break;
      case 14: 
        KeyCycle.access$1202(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1200(paramKeyCycle)));
        break;
      case 13: 
        KeyCycle.access$1102(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1100(paramKeyCycle)));
        break;
      case 12: 
        KeyCycle.access$1002(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$1000(paramKeyCycle)));
        break;
      case 11: 
        KeyCycle.access$902(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$900(paramKeyCycle)));
        break;
      case 10: 
        KeyCycle.access$802(paramKeyCycle, paramTypedArray.getDimension(k, KeyCycle.access$800(paramKeyCycle)));
        break;
      case 9: 
        KeyCycle.access$702(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$700(paramKeyCycle)));
        break;
      case 8: 
        KeyCycle.access$602(paramKeyCycle, paramTypedArray.getInt(k, KeyCycle.access$600(paramKeyCycle)));
        break;
      case 7: 
        if (paramTypedArray.peekValue(k).type == 5) {
          KeyCycle.access$502(paramKeyCycle, paramTypedArray.getDimension(k, KeyCycle.access$500(paramKeyCycle)));
        } else {
          KeyCycle.access$502(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$500(paramKeyCycle)));
        }
        break;
      case 6: 
        KeyCycle.access$402(paramKeyCycle, paramTypedArray.getFloat(k, KeyCycle.access$400(paramKeyCycle)));
        break;
      case 5: 
        KeyCycle.access$302(paramKeyCycle, paramTypedArray.getInt(k, KeyCycle.access$300(paramKeyCycle)));
        break;
      case 4: 
        KeyCycle.access$202(paramKeyCycle, paramTypedArray.getInteger(k, KeyCycle.access$200(paramKeyCycle)));
        break;
      case 3: 
        KeyCycle.access$102(paramKeyCycle, paramTypedArray.getString(k));
        break;
      case 2: 
        paramKeyCycle.mFramePosition = paramTypedArray.getInt(k, paramKeyCycle.mFramePosition);
        break;
      case 1: 
        if (MotionLayout.IS_IN_EDIT_MODE)
        {
          paramKeyCycle.mTargetId = paramTypedArray.getResourceId(k, paramKeyCycle.mTargetId);
          if (paramKeyCycle.mTargetId == -1) {
            paramKeyCycle.mTargetString = paramTypedArray.getString(k);
          }
        }
        else if (paramTypedArray.peekValue(k).type == 3)
        {
          paramKeyCycle.mTargetString = paramTypedArray.getString(k);
        }
        else
        {
          paramKeyCycle.mTargetId = paramTypedArray.getResourceId(k, paramKeyCycle.mTargetId);
        }
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyCycle.Loader
 * JD-Core Version:    0.7.0.1
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;

class KeyPosition$Loader
{
  private static final int CURVE_FIT = 4;
  private static final int DRAW_PATH = 5;
  private static final int FRAME_POSITION = 2;
  private static final int PATH_MOTION_ARC = 10;
  private static final int PERCENT_HEIGHT = 12;
  private static final int PERCENT_WIDTH = 11;
  private static final int PERCENT_X = 6;
  private static final int PERCENT_Y = 7;
  private static final int SIZE_PERCENT = 8;
  private static final int TARGET_ID = 1;
  private static final int TRANSITION_EASING = 3;
  private static final int TYPE = 9;
  private static SparseIntArray mAttrMap = new SparseIntArray();
  
  static
  {
    mAttrMap.append(R.styleable.KeyPosition_motionTarget, 1);
    mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
    mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
    mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
    mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
    mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
    mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
    mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
    mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
    mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
    mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
    mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
  }
  
  private static void read(KeyPosition paramKeyPosition, TypedArray paramTypedArray)
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
        Log.e("KeyPosition", localStringBuilder.toString());
        break;
      case 12: 
        paramKeyPosition.mPercentHeight = paramTypedArray.getFloat(k, paramKeyPosition.mPercentHeight);
        break;
      case 11: 
        paramKeyPosition.mPercentWidth = paramTypedArray.getFloat(k, paramKeyPosition.mPercentWidth);
        break;
      case 10: 
        paramKeyPosition.mPathMotionArc = paramTypedArray.getInt(k, paramKeyPosition.mPathMotionArc);
        break;
      case 9: 
        paramKeyPosition.mPositionType = paramTypedArray.getInt(k, paramKeyPosition.mPositionType);
        break;
      case 8: 
        float f = paramTypedArray.getFloat(k, paramKeyPosition.mPercentHeight);
        paramKeyPosition.mPercentWidth = f;
        paramKeyPosition.mPercentHeight = f;
        break;
      case 7: 
        paramKeyPosition.mPercentY = paramTypedArray.getFloat(k, paramKeyPosition.mPercentY);
        break;
      case 6: 
        paramKeyPosition.mPercentX = paramTypedArray.getFloat(k, paramKeyPosition.mPercentX);
        break;
      case 5: 
        paramKeyPosition.mDrawPath = paramTypedArray.getInt(k, paramKeyPosition.mDrawPath);
        break;
      case 4: 
        paramKeyPosition.mCurveFit = paramTypedArray.getInteger(k, paramKeyPosition.mCurveFit);
        break;
      case 3: 
        if (paramTypedArray.peekValue(k).type == 3) {
          paramKeyPosition.mTransitionEasing = paramTypedArray.getString(k);
        } else {
          paramKeyPosition.mTransitionEasing = androidx.constraintlayout.motion.utils.Easing.NAMED_EASING[paramTypedArray.getInteger(k, 0)];
        }
        break;
      case 2: 
        paramKeyPosition.mFramePosition = paramTypedArray.getInt(k, paramKeyPosition.mFramePosition);
        break;
      case 1: 
        if (MotionLayout.IS_IN_EDIT_MODE)
        {
          paramKeyPosition.mTargetId = paramTypedArray.getResourceId(k, paramKeyPosition.mTargetId);
          if (paramKeyPosition.mTargetId == -1) {
            paramKeyPosition.mTargetString = paramTypedArray.getString(k);
          }
        }
        else if (paramTypedArray.peekValue(k).type == 3)
        {
          paramKeyPosition.mTargetString = paramTypedArray.getString(k);
        }
        else
        {
          paramKeyPosition.mTargetId = paramTypedArray.getResourceId(k, paramKeyPosition.mTargetId);
        }
        break;
      }
      i += 1;
    }
    if (paramKeyPosition.mFramePosition == -1) {
      Log.e("KeyPosition", "no frame position");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyPosition.Loader
 * JD-Core Version:    0.7.0.1
 */
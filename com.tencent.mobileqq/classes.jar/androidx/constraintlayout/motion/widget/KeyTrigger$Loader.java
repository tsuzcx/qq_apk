package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.widget.R.styleable;

class KeyTrigger$Loader
{
  private static final int COLLISION = 9;
  private static final int CROSS = 4;
  private static final int FRAME_POS = 8;
  private static final int NEGATIVE_CROSS = 1;
  private static final int POSITIVE_CROSS = 2;
  private static final int POST_LAYOUT = 10;
  private static final int TARGET_ID = 7;
  private static final int TRIGGER_ID = 6;
  private static final int TRIGGER_RECEIVER = 11;
  private static final int TRIGGER_SLACK = 5;
  private static SparseIntArray mAttrMap = new SparseIntArray();
  
  static
  {
    mAttrMap.append(R.styleable.KeyTrigger_framePosition, 8);
    mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
    mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
    mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
    mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
    mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
    mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
    mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
    mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
    mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
  }
  
  public static void read(KeyTrigger paramKeyTrigger, TypedArray paramTypedArray, Context paramContext)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      switch (mAttrMap.get(k))
      {
      case 3: 
      default: 
        break;
      case 11: 
        KeyTrigger.access$702(paramKeyTrigger, paramTypedArray.getResourceId(k, KeyTrigger.access$700(paramKeyTrigger)));
        break;
      case 10: 
        KeyTrigger.access$602(paramKeyTrigger, paramTypedArray.getBoolean(k, KeyTrigger.access$600(paramKeyTrigger)));
        break;
      case 9: 
        KeyTrigger.access$502(paramKeyTrigger, paramTypedArray.getResourceId(k, KeyTrigger.access$500(paramKeyTrigger)));
        break;
      case 8: 
        paramKeyTrigger.mFramePosition = paramTypedArray.getInteger(k, paramKeyTrigger.mFramePosition);
        KeyTrigger.access$002(paramKeyTrigger, (paramKeyTrigger.mFramePosition + 0.5F) / 100.0F);
        break;
      case 7: 
        if (MotionLayout.IS_IN_EDIT_MODE)
        {
          paramKeyTrigger.mTargetId = paramTypedArray.getResourceId(k, paramKeyTrigger.mTargetId);
          if (paramKeyTrigger.mTargetId == -1) {
            paramKeyTrigger.mTargetString = paramTypedArray.getString(k);
          }
        }
        else if (paramTypedArray.peekValue(k).type == 3)
        {
          paramKeyTrigger.mTargetString = paramTypedArray.getString(k);
        }
        else
        {
          paramKeyTrigger.mTargetId = paramTypedArray.getResourceId(k, paramKeyTrigger.mTargetId);
        }
        break;
      case 6: 
        KeyTrigger.access$402(paramKeyTrigger, paramTypedArray.getResourceId(k, KeyTrigger.access$400(paramKeyTrigger)));
        break;
      case 5: 
        paramKeyTrigger.mTriggerSlack = paramTypedArray.getFloat(k, paramKeyTrigger.mTriggerSlack);
        break;
      case 4: 
        KeyTrigger.access$302(paramKeyTrigger, paramTypedArray.getString(k));
        break;
      case 2: 
        KeyTrigger.access$202(paramKeyTrigger, paramTypedArray.getString(k));
        break;
      case 1: 
        KeyTrigger.access$102(paramKeyTrigger, paramTypedArray.getString(k));
        break;
      }
      paramContext = new StringBuilder();
      paramContext.append("unused attribute 0x");
      paramContext.append(Integer.toHexString(k));
      paramContext.append("   ");
      paramContext.append(mAttrMap.get(k));
      Log.e("KeyTrigger", paramContext.toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.KeyTrigger.Loader
 * JD-Core Version:    0.7.0.1
 */
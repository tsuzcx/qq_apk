package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R.styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class TouchResponse
{
  private static final boolean DEBUG = false;
  static final int FLAG_DISABLE_POST_SCROLL = 1;
  static final int FLAG_DISABLE_SCROLL = 2;
  private static final int SIDE_BOTTOM = 3;
  private static final int SIDE_END = 6;
  private static final int SIDE_LEFT = 1;
  private static final int SIDE_MIDDLE = 4;
  private static final int SIDE_RIGHT = 2;
  private static final int SIDE_START = 5;
  private static final int SIDE_TOP = 0;
  private static final String TAG = "TouchResponse";
  private static final float[][] TOUCH_DIRECTION;
  private static final int TOUCH_DOWN = 1;
  private static final int TOUCH_END = 5;
  private static final int TOUCH_LEFT = 2;
  private static final int TOUCH_RIGHT = 3;
  private static final float[][] TOUCH_SIDES = { { 0.5F, 0.0F }, { 0.0F, 0.5F }, { 1.0F, 0.5F }, { 0.5F, 1.0F }, { 0.5F, 0.5F }, { 0.0F, 0.5F }, { 1.0F, 0.5F } };
  private static final int TOUCH_START = 4;
  private static final int TOUCH_UP = 0;
  private float[] mAnchorDpDt = new float[2];
  private float mDragScale = 1.0F;
  private boolean mDragStarted = false;
  private float mDragThreshold = 10.0F;
  private int mFlags = 0;
  private float mLastTouchX;
  private float mLastTouchY;
  private int mLimitBoundsTo = -1;
  private float mMaxAcceleration = 1.2F;
  private float mMaxVelocity = 4.0F;
  private final MotionLayout mMotionLayout;
  private boolean mMoveWhenScrollAtTop = true;
  private int mOnTouchUp = 0;
  private int mTouchAnchorId = -1;
  private int mTouchAnchorSide = 0;
  private float mTouchAnchorX = 0.5F;
  private float mTouchAnchorY = 0.5F;
  private float mTouchDirectionX = 0.0F;
  private float mTouchDirectionY = 1.0F;
  private int mTouchRegionId = -1;
  private int mTouchSide = 0;
  
  static
  {
    float[] arrayOfFloat1 = { 0.0F, -1.0F };
    float[] arrayOfFloat2 = { -1.0F, 0.0F };
    float[] arrayOfFloat3 = { 1.0F, 0.0F };
    float[] arrayOfFloat4 = { -1.0F, 0.0F };
    float[] arrayOfFloat5 = { 1.0F, 0.0F };
    TOUCH_DIRECTION = new float[][] { arrayOfFloat1, { 0.0F, 1.0F }, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4, arrayOfFloat5 };
  }
  
  TouchResponse(Context paramContext, MotionLayout paramMotionLayout, XmlPullParser paramXmlPullParser)
  {
    this.mMotionLayout = paramMotionLayout;
    fillFromAttributeList(paramContext, Xml.asAttributeSet(paramXmlPullParser));
  }
  
  private void fill(TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      if (k == R.styleable.OnSwipe_touchAnchorId)
      {
        this.mTouchAnchorId = paramTypedArray.getResourceId(k, this.mTouchAnchorId);
      }
      else
      {
        float[][] arrayOfFloat;
        if (k == R.styleable.OnSwipe_touchAnchorSide)
        {
          this.mTouchAnchorSide = paramTypedArray.getInt(k, this.mTouchAnchorSide);
          arrayOfFloat = TOUCH_SIDES;
          k = this.mTouchAnchorSide;
          this.mTouchAnchorX = arrayOfFloat[k][0];
          this.mTouchAnchorY = arrayOfFloat[k][1];
        }
        else if (k == R.styleable.OnSwipe_dragDirection)
        {
          this.mTouchSide = paramTypedArray.getInt(k, this.mTouchSide);
          arrayOfFloat = TOUCH_DIRECTION;
          k = this.mTouchSide;
          this.mTouchDirectionX = arrayOfFloat[k][0];
          this.mTouchDirectionY = arrayOfFloat[k][1];
        }
        else if (k == R.styleable.OnSwipe_maxVelocity)
        {
          this.mMaxVelocity = paramTypedArray.getFloat(k, this.mMaxVelocity);
        }
        else if (k == R.styleable.OnSwipe_maxAcceleration)
        {
          this.mMaxAcceleration = paramTypedArray.getFloat(k, this.mMaxAcceleration);
        }
        else if (k == R.styleable.OnSwipe_moveWhenScrollAtTop)
        {
          this.mMoveWhenScrollAtTop = paramTypedArray.getBoolean(k, this.mMoveWhenScrollAtTop);
        }
        else if (k == R.styleable.OnSwipe_dragScale)
        {
          this.mDragScale = paramTypedArray.getFloat(k, this.mDragScale);
        }
        else if (k == R.styleable.OnSwipe_dragThreshold)
        {
          this.mDragThreshold = paramTypedArray.getFloat(k, this.mDragThreshold);
        }
        else if (k == R.styleable.OnSwipe_touchRegionId)
        {
          this.mTouchRegionId = paramTypedArray.getResourceId(k, this.mTouchRegionId);
        }
        else if (k == R.styleable.OnSwipe_onTouchUp)
        {
          this.mOnTouchUp = paramTypedArray.getInt(k, this.mOnTouchUp);
        }
        else if (k == R.styleable.OnSwipe_nestedScrollFlags)
        {
          this.mFlags = paramTypedArray.getInteger(k, 0);
        }
        else if (k == R.styleable.OnSwipe_limitBoundsTo)
        {
          this.mLimitBoundsTo = paramTypedArray.getResourceId(k, 0);
        }
      }
      i += 1;
    }
  }
  
  private void fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.OnSwipe);
    fill(paramContext);
    paramContext.recycle();
  }
  
  float dot(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * this.mTouchDirectionX + paramFloat2 * this.mTouchDirectionY;
  }
  
  public int getAnchorId()
  {
    return this.mTouchAnchorId;
  }
  
  public int getFlags()
  {
    return this.mFlags;
  }
  
  RectF getLimitBoundsTo(ViewGroup paramViewGroup, RectF paramRectF)
  {
    int i = this.mLimitBoundsTo;
    if (i == -1) {
      return null;
    }
    paramViewGroup = paramViewGroup.findViewById(i);
    if (paramViewGroup == null) {
      return null;
    }
    paramRectF.set(paramViewGroup.getLeft(), paramViewGroup.getTop(), paramViewGroup.getRight(), paramViewGroup.getBottom());
    return paramRectF;
  }
  
  int getLimitBoundsToId()
  {
    return this.mLimitBoundsTo;
  }
  
  float getMaxAcceleration()
  {
    return this.mMaxAcceleration;
  }
  
  public float getMaxVelocity()
  {
    return this.mMaxVelocity;
  }
  
  boolean getMoveWhenScrollAtTop()
  {
    return this.mMoveWhenScrollAtTop;
  }
  
  float getProgressDirection(float paramFloat1, float paramFloat2)
  {
    float f = this.mMotionLayout.getProgress();
    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    if (this.mTouchDirectionX != 0.0F)
    {
      arrayOfFloat = this.mAnchorDpDt;
      if (arrayOfFloat[0] == 0.0F) {
        arrayOfFloat[0] = 1.0E-007F;
      }
      return paramFloat1 * this.mTouchDirectionX / this.mAnchorDpDt[0];
    }
    float[] arrayOfFloat = this.mAnchorDpDt;
    if (arrayOfFloat[1] == 0.0F) {
      arrayOfFloat[1] = 1.0E-007F;
    }
    return paramFloat2 * this.mTouchDirectionY / this.mAnchorDpDt[1];
  }
  
  RectF getTouchRegion(ViewGroup paramViewGroup, RectF paramRectF)
  {
    int i = this.mTouchRegionId;
    if (i == -1) {
      return null;
    }
    paramViewGroup = paramViewGroup.findViewById(i);
    if (paramViewGroup == null) {
      return null;
    }
    paramRectF.set(paramViewGroup.getLeft(), paramViewGroup.getTop(), paramViewGroup.getRight(), paramViewGroup.getBottom());
    return paramRectF;
  }
  
  int getTouchRegionId()
  {
    return this.mTouchRegionId;
  }
  
  void processTouchEvent(MotionEvent paramMotionEvent, MotionLayout.MotionTracker paramMotionTracker, int paramInt, MotionScene paramMotionScene)
  {
    paramMotionTracker.addMovement(paramMotionEvent);
    paramInt = paramMotionEvent.getAction();
    if (paramInt != 0)
    {
      float f1;
      float f3;
      float f2;
      float f4;
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        f1 = paramMotionEvent.getRawY() - this.mLastTouchY;
        f3 = paramMotionEvent.getRawX() - this.mLastTouchX;
        if ((Math.abs(this.mTouchDirectionX * f3 + this.mTouchDirectionY * f1) > this.mDragThreshold) || (this.mDragStarted))
        {
          f2 = this.mMotionLayout.getProgress();
          if (!this.mDragStarted)
          {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(f2);
          }
          paramInt = this.mTouchAnchorId;
          if (paramInt != -1)
          {
            this.mMotionLayout.getAnchorDpDt(paramInt, f2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
          }
          else
          {
            f4 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
            paramMotionScene = this.mAnchorDpDt;
            paramMotionScene[1] = (this.mTouchDirectionY * f4);
            paramMotionScene[0] = (f4 * this.mTouchDirectionX);
          }
          f4 = this.mTouchDirectionX;
          paramMotionScene = this.mAnchorDpDt;
          if (Math.abs((f4 * paramMotionScene[0] + this.mTouchDirectionY * paramMotionScene[1]) * this.mDragScale) < 0.01D)
          {
            paramMotionScene = this.mAnchorDpDt;
            paramMotionScene[0] = 0.01F;
            paramMotionScene[1] = 0.01F;
          }
          if (this.mTouchDirectionX != 0.0F) {
            f1 = f3 / this.mAnchorDpDt[0];
          } else {
            f1 /= this.mAnchorDpDt[1];
          }
          f1 = Math.max(Math.min(f2 + f1, 1.0F), 0.0F);
          if (f1 != this.mMotionLayout.getProgress())
          {
            this.mMotionLayout.setProgress(f1);
            paramMotionTracker.computeCurrentVelocity(1000);
            f1 = paramMotionTracker.getXVelocity();
            f2 = paramMotionTracker.getYVelocity();
            if (this.mTouchDirectionX != 0.0F) {
              f1 /= this.mAnchorDpDt[0];
            } else {
              f1 = f2 / this.mAnchorDpDt[1];
            }
            this.mMotionLayout.mLastVelocity = f1;
          }
          else
          {
            this.mMotionLayout.mLastVelocity = 0.0F;
          }
          this.mLastTouchX = paramMotionEvent.getRawX();
          this.mLastTouchY = paramMotionEvent.getRawY();
        }
      }
      else
      {
        this.mDragStarted = false;
        paramMotionTracker.computeCurrentVelocity(1000);
        f1 = paramMotionTracker.getXVelocity();
        f2 = paramMotionTracker.getYVelocity();
        f3 = this.mMotionLayout.getProgress();
        paramInt = this.mTouchAnchorId;
        if (paramInt != -1)
        {
          this.mMotionLayout.getAnchorDpDt(paramInt, f3, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        }
        else
        {
          f4 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
          paramMotionEvent = this.mAnchorDpDt;
          paramMotionEvent[1] = (this.mTouchDirectionY * f4);
          paramMotionEvent[0] = (f4 * this.mTouchDirectionX);
        }
        f4 = this.mTouchDirectionX;
        paramMotionEvent = this.mAnchorDpDt;
        float f5 = paramMotionEvent[0];
        f5 = this.mTouchDirectionY;
        f5 = paramMotionEvent[1];
        if (f4 != 0.0F) {
          f1 /= paramMotionEvent[0];
        } else {
          f1 = f2 / paramMotionEvent[1];
        }
        if (!Float.isNaN(f1)) {
          f2 = f1 / 3.0F + f3;
        } else {
          f2 = f3;
        }
        if ((f2 != 0.0F) && (f2 != 1.0F))
        {
          paramInt = this.mOnTouchUp;
          if (paramInt != 3)
          {
            paramMotionEvent = this.mMotionLayout;
            if (f2 < 0.5D) {
              f2 = 0.0F;
            } else {
              f2 = 1.0F;
            }
            paramMotionEvent.touchAnimateTo(paramInt, f2, f1);
            if ((0.0F < f3) && (1.0F > f3)) {
              return;
            }
            this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
            return;
          }
        }
        if ((0.0F >= f2) || (1.0F <= f2)) {
          this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        }
      }
    }
    else
    {
      this.mLastTouchX = paramMotionEvent.getRawX();
      this.mLastTouchY = paramMotionEvent.getRawY();
      this.mDragStarted = false;
    }
  }
  
  void scrollMove(float paramFloat1, float paramFloat2)
  {
    float f1 = this.mTouchDirectionX;
    f1 = this.mTouchDirectionY;
    f1 = this.mMotionLayout.getProgress();
    if (!this.mDragStarted)
    {
      this.mDragStarted = true;
      this.mMotionLayout.setProgress(f1);
    }
    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f1, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    float f2 = this.mTouchDirectionX;
    float[] arrayOfFloat = this.mAnchorDpDt;
    if (Math.abs(f2 * arrayOfFloat[0] + this.mTouchDirectionY * arrayOfFloat[1]) < 0.01D)
    {
      arrayOfFloat = this.mAnchorDpDt;
      arrayOfFloat[0] = 0.01F;
      arrayOfFloat[1] = 0.01F;
    }
    f2 = this.mTouchDirectionX;
    if (f2 != 0.0F) {
      paramFloat1 = paramFloat1 * f2 / this.mAnchorDpDt[0];
    } else {
      paramFloat1 = paramFloat2 * this.mTouchDirectionY / this.mAnchorDpDt[1];
    }
    paramFloat1 = Math.max(Math.min(f1 + paramFloat1, 1.0F), 0.0F);
    if (paramFloat1 != this.mMotionLayout.getProgress()) {
      this.mMotionLayout.setProgress(paramFloat1);
    }
  }
  
  void scrollUp(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    this.mDragStarted = false;
    float f1 = this.mMotionLayout.getProgress();
    this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, f1, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
    float f2 = this.mTouchDirectionX;
    Object localObject = this.mAnchorDpDt;
    float f3 = localObject[0];
    f3 = this.mTouchDirectionY;
    float f4 = localObject[1];
    if (f2 != 0.0F) {
      paramFloat1 = paramFloat1 * f2 / localObject[0];
    } else {
      paramFloat1 = paramFloat2 * f3 / localObject[1];
    }
    paramFloat2 = f1;
    if (!Float.isNaN(paramFloat1)) {
      paramFloat2 = f1 + paramFloat1 / 3.0F;
    }
    if (paramFloat2 != 0.0F)
    {
      f1 = 1.0F;
      int i;
      if (paramFloat2 != 1.0F) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.mOnTouchUp != 3) {
        j = 1;
      }
      if ((j & i) != 0)
      {
        localObject = this.mMotionLayout;
        i = this.mOnTouchUp;
        if (paramFloat2 < 0.5D) {
          f1 = 0.0F;
        }
        ((MotionLayout)localObject).touchAnimateTo(i, f1, paramFloat1);
      }
    }
  }
  
  public void setAnchorId(int paramInt)
  {
    this.mTouchAnchorId = paramInt;
  }
  
  void setDown(float paramFloat1, float paramFloat2)
  {
    this.mLastTouchX = paramFloat1;
    this.mLastTouchY = paramFloat2;
  }
  
  public void setMaxAcceleration(float paramFloat)
  {
    this.mMaxAcceleration = paramFloat;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.mMaxVelocity = paramFloat;
  }
  
  public void setRTL(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      arrayOfFloat = TOUCH_DIRECTION;
      arrayOfFloat[4] = arrayOfFloat[3];
      arrayOfFloat[5] = arrayOfFloat[2];
      arrayOfFloat = TOUCH_SIDES;
      arrayOfFloat[5] = arrayOfFloat[2];
      arrayOfFloat[6] = arrayOfFloat[1];
    }
    else
    {
      arrayOfFloat = TOUCH_DIRECTION;
      arrayOfFloat[4] = arrayOfFloat[2];
      arrayOfFloat[5] = arrayOfFloat[3];
      arrayOfFloat = TOUCH_SIDES;
      arrayOfFloat[5] = arrayOfFloat[1];
      arrayOfFloat[6] = arrayOfFloat[2];
    }
    float[][] arrayOfFloat = TOUCH_SIDES;
    int i = this.mTouchAnchorSide;
    this.mTouchAnchorX = arrayOfFloat[i][0];
    this.mTouchAnchorY = arrayOfFloat[i][1];
    arrayOfFloat = TOUCH_DIRECTION;
    i = this.mTouchSide;
    this.mTouchDirectionX = arrayOfFloat[i][0];
    this.mTouchDirectionY = arrayOfFloat[i][1];
  }
  
  public void setTouchAnchorLocation(float paramFloat1, float paramFloat2)
  {
    this.mTouchAnchorX = paramFloat1;
    this.mTouchAnchorY = paramFloat2;
  }
  
  void setUpTouchEvent(float paramFloat1, float paramFloat2)
  {
    this.mLastTouchX = paramFloat1;
    this.mLastTouchY = paramFloat2;
    this.mDragStarted = false;
  }
  
  void setupTouch()
  {
    int i = this.mTouchAnchorId;
    Object localObject;
    if (i != -1)
    {
      View localView = this.mMotionLayout.findViewById(i);
      localObject = localView;
      if (localView == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cannot find TouchAnchorId @id/");
        ((StringBuilder)localObject).append(Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
        Log.e("TouchResponse", ((StringBuilder)localObject).toString());
        localObject = localView;
      }
    }
    else
    {
      localObject = null;
    }
    if ((localObject instanceof NestedScrollView))
    {
      localObject = (NestedScrollView)localObject;
      ((NestedScrollView)localObject).setOnTouchListener(new TouchResponse.1(this));
      ((NestedScrollView)localObject).setOnScrollChangeListener(new TouchResponse.2(this));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mTouchDirectionX);
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.mTouchDirectionY);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TouchResponse
 * JD-Core Version:    0.7.0.1
 */
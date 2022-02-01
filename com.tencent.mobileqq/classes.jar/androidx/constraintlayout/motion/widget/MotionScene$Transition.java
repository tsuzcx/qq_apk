package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R.styleable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class MotionScene$Transition
{
  public static final int AUTO_ANIMATE_TO_END = 4;
  public static final int AUTO_ANIMATE_TO_START = 3;
  public static final int AUTO_JUMP_TO_END = 2;
  public static final int AUTO_JUMP_TO_START = 1;
  public static final int AUTO_NONE = 0;
  static final int TRANSITION_FLAG_FIRST_DRAW = 1;
  private int mAutoTransition = 0;
  private int mConstraintSetEnd = -1;
  private int mConstraintSetStart = -1;
  private int mDefaultInterpolator = 0;
  private int mDefaultInterpolatorID = -1;
  private String mDefaultInterpolatorString = null;
  private boolean mDisable = false;
  private int mDuration = 400;
  private int mId = -1;
  private boolean mIsAbstract = false;
  private ArrayList<KeyFrames> mKeyFramesList = new ArrayList();
  private int mLayoutDuringTransition = 0;
  private final MotionScene mMotionScene;
  private ArrayList<MotionScene.Transition.TransitionOnClick> mOnClicks = new ArrayList();
  private int mPathMotionArc = -1;
  private float mStagger = 0.0F;
  private TouchResponse mTouchResponse = null;
  private int mTransitionFlags = 0;
  
  public MotionScene$Transition(int paramInt1, MotionScene paramMotionScene, int paramInt2, int paramInt3)
  {
    this.mId = paramInt1;
    this.mMotionScene = paramMotionScene;
    this.mConstraintSetStart = paramInt2;
    this.mConstraintSetEnd = paramInt3;
    this.mDuration = MotionScene.access$900(paramMotionScene);
    this.mLayoutDuringTransition = MotionScene.access$1000(paramMotionScene);
  }
  
  MotionScene$Transition(MotionScene paramMotionScene, Context paramContext, XmlPullParser paramXmlPullParser)
  {
    this.mDuration = MotionScene.access$900(paramMotionScene);
    this.mLayoutDuringTransition = MotionScene.access$1000(paramMotionScene);
    this.mMotionScene = paramMotionScene;
    fillFromAttributeList(paramMotionScene, paramContext, Xml.asAttributeSet(paramXmlPullParser));
  }
  
  MotionScene$Transition(MotionScene paramMotionScene, Transition paramTransition)
  {
    this.mMotionScene = paramMotionScene;
    if (paramTransition != null)
    {
      this.mPathMotionArc = paramTransition.mPathMotionArc;
      this.mDefaultInterpolator = paramTransition.mDefaultInterpolator;
      this.mDefaultInterpolatorString = paramTransition.mDefaultInterpolatorString;
      this.mDefaultInterpolatorID = paramTransition.mDefaultInterpolatorID;
      this.mDuration = paramTransition.mDuration;
      this.mKeyFramesList = paramTransition.mKeyFramesList;
      this.mStagger = paramTransition.mStagger;
      this.mLayoutDuringTransition = paramTransition.mLayoutDuringTransition;
    }
  }
  
  private void fill(MotionScene paramMotionScene, Context paramContext, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      Object localObject;
      if (k == R.styleable.Transition_constraintSetEnd)
      {
        this.mConstraintSetEnd = paramTypedArray.getResourceId(k, this.mConstraintSetEnd);
        if ("layout".equals(paramContext.getResources().getResourceTypeName(this.mConstraintSetEnd)))
        {
          localObject = new ConstraintSet();
          ((ConstraintSet)localObject).load(paramContext, this.mConstraintSetEnd);
          MotionScene.access$1100(paramMotionScene).append(this.mConstraintSetEnd, localObject);
        }
      }
      else if (k == R.styleable.Transition_constraintSetStart)
      {
        this.mConstraintSetStart = paramTypedArray.getResourceId(k, this.mConstraintSetStart);
        if ("layout".equals(paramContext.getResources().getResourceTypeName(this.mConstraintSetStart)))
        {
          localObject = new ConstraintSet();
          ((ConstraintSet)localObject).load(paramContext, this.mConstraintSetStart);
          MotionScene.access$1100(paramMotionScene).append(this.mConstraintSetStart, localObject);
        }
      }
      else if (k == R.styleable.Transition_motionInterpolator)
      {
        localObject = paramTypedArray.peekValue(k);
        if (((TypedValue)localObject).type == 1)
        {
          this.mDefaultInterpolatorID = paramTypedArray.getResourceId(k, -1);
          if (this.mDefaultInterpolatorID != -1) {
            this.mDefaultInterpolator = -2;
          }
        }
        else if (((TypedValue)localObject).type == 3)
        {
          this.mDefaultInterpolatorString = paramTypedArray.getString(k);
          if (this.mDefaultInterpolatorString.indexOf("/") > 0)
          {
            this.mDefaultInterpolatorID = paramTypedArray.getResourceId(k, -1);
            this.mDefaultInterpolator = -2;
          }
          else
          {
            this.mDefaultInterpolator = -1;
          }
        }
        else
        {
          this.mDefaultInterpolator = paramTypedArray.getInteger(k, this.mDefaultInterpolator);
        }
      }
      else if (k == R.styleable.Transition_duration)
      {
        this.mDuration = paramTypedArray.getInt(k, this.mDuration);
      }
      else if (k == R.styleable.Transition_staggered)
      {
        this.mStagger = paramTypedArray.getFloat(k, this.mStagger);
      }
      else if (k == R.styleable.Transition_autoTransition)
      {
        this.mAutoTransition = paramTypedArray.getInteger(k, this.mAutoTransition);
      }
      else if (k == R.styleable.Transition_android_id)
      {
        this.mId = paramTypedArray.getResourceId(k, this.mId);
      }
      else if (k == R.styleable.Transition_transitionDisable)
      {
        this.mDisable = paramTypedArray.getBoolean(k, this.mDisable);
      }
      else if (k == R.styleable.Transition_pathMotionArc)
      {
        this.mPathMotionArc = paramTypedArray.getInteger(k, -1);
      }
      else if (k == R.styleable.Transition_layoutDuringTransition)
      {
        this.mLayoutDuringTransition = paramTypedArray.getInteger(k, 0);
      }
      else if (k == R.styleable.Transition_transitionFlags)
      {
        this.mTransitionFlags = paramTypedArray.getInteger(k, 0);
      }
      i += 1;
    }
    if (this.mConstraintSetStart == -1) {
      this.mIsAbstract = true;
    }
  }
  
  private void fillFromAttributeList(MotionScene paramMotionScene, Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Transition);
    fill(paramMotionScene, paramContext, paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  public void addOnClick(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    this.mOnClicks.add(new MotionScene.Transition.TransitionOnClick(paramContext, this, paramXmlPullParser));
  }
  
  public String debugString(Context paramContext)
  {
    String str;
    if (this.mConstraintSetStart == -1) {
      str = "null";
    } else {
      str = paramContext.getResources().getResourceEntryName(this.mConstraintSetStart);
    }
    if (this.mConstraintSetEnd == -1)
    {
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append(" -> null");
      return paramContext.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(paramContext.getResources().getResourceEntryName(this.mConstraintSetEnd));
    return localStringBuilder.toString();
  }
  
  public int getAutoTransition()
  {
    return this.mAutoTransition;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getEndConstraintSetId()
  {
    return this.mConstraintSetEnd;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public List<KeyFrames> getKeyFrameList()
  {
    return this.mKeyFramesList;
  }
  
  public int getLayoutDuringTransition()
  {
    return this.mLayoutDuringTransition;
  }
  
  public List<MotionScene.Transition.TransitionOnClick> getOnClickList()
  {
    return this.mOnClicks;
  }
  
  public int getPathMotionArc()
  {
    return this.mPathMotionArc;
  }
  
  public float getStagger()
  {
    return this.mStagger;
  }
  
  public int getStartConstraintSetId()
  {
    return this.mConstraintSetStart;
  }
  
  public TouchResponse getTouchResponse()
  {
    return this.mTouchResponse;
  }
  
  public boolean isEnabled()
  {
    return this.mDisable ^ true;
  }
  
  public boolean isTransitionFlag(int paramInt)
  {
    return (paramInt & this.mTransitionFlags) != 0;
  }
  
  public void setAutoTransition(int paramInt)
  {
    this.mAutoTransition = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mDisable = (paramBoolean ^ true);
  }
  
  public void setPathMotionArc(int paramInt)
  {
    this.mPathMotionArc = paramInt;
  }
  
  public void setStagger(float paramFloat)
  {
    this.mStagger = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionScene.Transition
 * JD-Core Version:    0.7.0.1
 */
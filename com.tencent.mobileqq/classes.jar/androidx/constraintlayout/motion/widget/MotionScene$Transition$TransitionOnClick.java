package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.constraintlayout.widget.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.xmlpull.v1.XmlPullParser;

class MotionScene$Transition$TransitionOnClick
  implements View.OnClickListener
{
  public static final int ANIM_TOGGLE = 17;
  public static final int ANIM_TO_END = 1;
  public static final int ANIM_TO_START = 16;
  public static final int JUMP_TO_END = 256;
  public static final int JUMP_TO_START = 4096;
  int mMode = 17;
  int mTargetId = -1;
  private final MotionScene.Transition mTransition;
  
  public MotionScene$Transition$TransitionOnClick(Context paramContext, MotionScene.Transition paramTransition, XmlPullParser paramXmlPullParser)
  {
    this.mTransition = paramTransition;
    paramContext = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.OnClick);
    int j = paramContext.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.OnClick_targetId) {
        this.mTargetId = paramContext.getResourceId(k, this.mTargetId);
      } else if (k == R.styleable.OnClick_clickAction) {
        this.mMode = paramContext.getInt(k, this.mMode);
      }
      i += 1;
    }
    paramContext.recycle();
  }
  
  public void addOnClickListeners(MotionLayout paramMotionLayout, int paramInt, MotionScene.Transition paramTransition)
  {
    int i = this.mTargetId;
    if (i != -1) {
      paramMotionLayout = paramMotionLayout.findViewById(i);
    }
    if (paramMotionLayout == null)
    {
      paramMotionLayout = new StringBuilder();
      paramMotionLayout.append("OnClick could not find id ");
      paramMotionLayout.append(this.mTargetId);
      Log.e("MotionScene", paramMotionLayout.toString());
      return;
    }
    int k = MotionScene.Transition.access$100(paramTransition);
    int i1 = MotionScene.Transition.access$000(paramTransition);
    if (k == -1)
    {
      paramMotionLayout.setOnClickListener(this);
      return;
    }
    i = this.mMode;
    int n = 1;
    if (((i & 0x1) != 0) && (paramInt == k)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((this.mMode & 0x100) != 0) && (paramInt == k)) {
      j = 1;
    } else {
      j = 0;
    }
    if (((this.mMode & 0x1) != 0) && (paramInt == k)) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (((this.mMode & 0x10) != 0) && (paramInt == i1)) {
      m = 1;
    } else {
      m = 0;
    }
    if (((this.mMode & 0x1000) != 0) && (paramInt == i1)) {
      paramInt = n;
    } else {
      paramInt = 0;
    }
    if ((k | i | j | m | paramInt) != 0) {
      paramMotionLayout.setOnClickListener(this);
    }
  }
  
  boolean isTransitionViable(MotionScene.Transition paramTransition, MotionLayout paramMotionLayout)
  {
    MotionScene.Transition localTransition = this.mTransition;
    boolean bool = true;
    if (localTransition == paramTransition) {
      return true;
    }
    int i = MotionScene.Transition.access$000(localTransition);
    int j = MotionScene.Transition.access$100(this.mTransition);
    if (j == -1) {
      return paramMotionLayout.mCurrentState != i;
    }
    if (paramMotionLayout.mCurrentState != j)
    {
      if (paramMotionLayout.mCurrentState == i) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    MotionLayout localMotionLayout = MotionScene.access$800(MotionScene.Transition.access$700(this.mTransition));
    if (localMotionLayout.isInteractionEnabled())
    {
      int i;
      MotionScene.Transition localTransition1;
      if (MotionScene.Transition.access$100(this.mTransition) == -1)
      {
        i = localMotionLayout.getCurrentState();
        if (i == -1)
        {
          localMotionLayout.transitionToState(MotionScene.Transition.access$000(this.mTransition));
        }
        else
        {
          localTransition1 = new MotionScene.Transition(MotionScene.Transition.access$700(this.mTransition), this.mTransition);
          MotionScene.Transition.access$102(localTransition1, i);
          MotionScene.Transition.access$002(localTransition1, MotionScene.Transition.access$000(this.mTransition));
          localMotionLayout.setTransition(localTransition1);
          localMotionLayout.transitionToEnd();
        }
      }
      else
      {
        localTransition1 = MotionScene.Transition.access$700(this.mTransition).mCurrentTransition;
        i = this.mMode;
        if (((i & 0x1) == 0) && ((i & 0x100) == 0)) {
          i = 0;
        } else {
          i = 1;
        }
        int j = this.mMode;
        if (((j & 0x10) == 0) && ((j & 0x1000) == 0)) {
          j = 0;
        } else {
          j = 1;
        }
        int n;
        if ((i != 0) && (j != 0)) {
          n = 1;
        } else {
          n = 0;
        }
        int k = i;
        int m = j;
        if (n != 0)
        {
          MotionScene.Transition localTransition2 = MotionScene.Transition.access$700(this.mTransition).mCurrentTransition;
          MotionScene.Transition localTransition3 = this.mTransition;
          if (localTransition2 != localTransition3) {
            localMotionLayout.setTransition(localTransition3);
          }
          if ((localMotionLayout.getCurrentState() != localMotionLayout.getEndState()) && (localMotionLayout.getProgress() <= 0.5F))
          {
            m = 0;
            k = i;
          }
          else
          {
            k = 0;
            m = j;
          }
        }
        if (isTransitionViable(localTransition1, localMotionLayout)) {
          if ((k != 0) && ((this.mMode & 0x1) != 0))
          {
            localMotionLayout.setTransition(this.mTransition);
            localMotionLayout.transitionToEnd();
          }
          else if ((m != 0) && ((this.mMode & 0x10) != 0))
          {
            localMotionLayout.setTransition(this.mTransition);
            localMotionLayout.transitionToStart();
          }
          else if ((k != 0) && ((this.mMode & 0x100) != 0))
          {
            localMotionLayout.setTransition(this.mTransition);
            localMotionLayout.setProgress(1.0F);
          }
          else if ((m != 0) && ((this.mMode & 0x1000) != 0))
          {
            localMotionLayout.setTransition(this.mTransition);
            localMotionLayout.setProgress(0.0F);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void removeOnClickListeners(MotionLayout paramMotionLayout)
  {
    int i = this.mTargetId;
    if (i == -1) {
      return;
    }
    paramMotionLayout = paramMotionLayout.findViewById(i);
    if (paramMotionLayout == null)
    {
      paramMotionLayout = new StringBuilder();
      paramMotionLayout.append(" (*)  could not find id ");
      paramMotionLayout.append(this.mTargetId);
      Log.e("MotionScene", paramMotionLayout.toString());
      return;
    }
    paramMotionLayout.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
 * JD-Core Version:    0.7.0.1
 */
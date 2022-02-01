package androidx.transition;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;

public abstract class Visibility
  extends Transition
{
  public static final int MODE_IN = 1;
  public static final int MODE_OUT = 2;
  private static final String PROPNAME_PARENT = "android:visibility:parent";
  private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
  static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
  private static final String[] sTransitionProperties = { "android:visibility:visibility", "android:visibility:parent" };
  private int mMode = 3;
  
  public Visibility() {}
  
  @SuppressLint({"RestrictedApi"})
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.VISIBILITY_TRANSITION);
    int i = TypedArrayUtils.getNamedInt(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      setMode(i);
    }
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    int i = paramTransitionValues.view.getVisibility();
    paramTransitionValues.values.put("android:visibility:visibility", Integer.valueOf(i));
    paramTransitionValues.values.put("android:visibility:parent", paramTransitionValues.view.getParent());
    int[] arrayOfInt = new int[2];
    paramTransitionValues.view.getLocationOnScreen(arrayOfInt);
    paramTransitionValues.values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  private Visibility.VisibilityInfo getVisibilityChangeInfo(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    Visibility.VisibilityInfo localVisibilityInfo = new Visibility.VisibilityInfo();
    localVisibilityInfo.mVisibilityChange = false;
    localVisibilityInfo.mFadeIn = false;
    if ((paramTransitionValues1 != null) && (paramTransitionValues1.values.containsKey("android:visibility:visibility")))
    {
      localVisibilityInfo.mStartVisibility = ((Integer)paramTransitionValues1.values.get("android:visibility:visibility")).intValue();
      localVisibilityInfo.mStartParent = ((ViewGroup)paramTransitionValues1.values.get("android:visibility:parent"));
    }
    else
    {
      localVisibilityInfo.mStartVisibility = -1;
      localVisibilityInfo.mStartParent = null;
    }
    if ((paramTransitionValues2 != null) && (paramTransitionValues2.values.containsKey("android:visibility:visibility")))
    {
      localVisibilityInfo.mEndVisibility = ((Integer)paramTransitionValues2.values.get("android:visibility:visibility")).intValue();
      localVisibilityInfo.mEndParent = ((ViewGroup)paramTransitionValues2.values.get("android:visibility:parent"));
    }
    else
    {
      localVisibilityInfo.mEndVisibility = -1;
      localVisibilityInfo.mEndParent = null;
    }
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null))
    {
      if ((localVisibilityInfo.mStartVisibility == localVisibilityInfo.mEndVisibility) && (localVisibilityInfo.mStartParent == localVisibilityInfo.mEndParent)) {
        return localVisibilityInfo;
      }
      if (localVisibilityInfo.mStartVisibility != localVisibilityInfo.mEndVisibility)
      {
        if (localVisibilityInfo.mStartVisibility == 0)
        {
          localVisibilityInfo.mFadeIn = false;
          localVisibilityInfo.mVisibilityChange = true;
          return localVisibilityInfo;
        }
        if (localVisibilityInfo.mEndVisibility == 0)
        {
          localVisibilityInfo.mFadeIn = true;
          localVisibilityInfo.mVisibilityChange = true;
          return localVisibilityInfo;
        }
      }
      else
      {
        if (localVisibilityInfo.mEndParent == null)
        {
          localVisibilityInfo.mFadeIn = false;
          localVisibilityInfo.mVisibilityChange = true;
          return localVisibilityInfo;
        }
        if (localVisibilityInfo.mStartParent == null)
        {
          localVisibilityInfo.mFadeIn = true;
          localVisibilityInfo.mVisibilityChange = true;
          return localVisibilityInfo;
        }
      }
    }
    else
    {
      if ((paramTransitionValues1 == null) && (localVisibilityInfo.mEndVisibility == 0))
      {
        localVisibilityInfo.mFadeIn = true;
        localVisibilityInfo.mVisibilityChange = true;
        return localVisibilityInfo;
      }
      if ((paramTransitionValues2 == null) && (localVisibilityInfo.mStartVisibility == 0))
      {
        localVisibilityInfo.mFadeIn = false;
        localVisibilityInfo.mVisibilityChange = true;
      }
    }
    return localVisibilityInfo;
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  @Nullable
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    Visibility.VisibilityInfo localVisibilityInfo = getVisibilityChangeInfo(paramTransitionValues1, paramTransitionValues2);
    if ((localVisibilityInfo.mVisibilityChange) && ((localVisibilityInfo.mStartParent != null) || (localVisibilityInfo.mEndParent != null)))
    {
      if (localVisibilityInfo.mFadeIn) {
        return onAppear(paramViewGroup, paramTransitionValues1, localVisibilityInfo.mStartVisibility, paramTransitionValues2, localVisibilityInfo.mEndVisibility);
      }
      return onDisappear(paramViewGroup, paramTransitionValues1, localVisibilityInfo.mStartVisibility, paramTransitionValues2, localVisibilityInfo.mEndVisibility);
    }
    return null;
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public boolean isTransitionRequired(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    boolean bool2 = false;
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null)) {
      return false;
    }
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null) && (paramTransitionValues2.values.containsKey("android:visibility:visibility") != paramTransitionValues1.values.containsKey("android:visibility:visibility"))) {
      return false;
    }
    paramTransitionValues1 = getVisibilityChangeInfo(paramTransitionValues1, paramTransitionValues2);
    boolean bool1 = bool2;
    if (paramTransitionValues1.mVisibilityChange) {
      if (paramTransitionValues1.mStartVisibility != 0)
      {
        bool1 = bool2;
        if (paramTransitionValues1.mEndVisibility != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isVisible(TransitionValues paramTransitionValues)
  {
    boolean bool2 = false;
    if (paramTransitionValues == null) {
      return false;
    }
    int i = ((Integer)paramTransitionValues.values.get("android:visibility:visibility")).intValue();
    paramTransitionValues = (View)paramTransitionValues.values.get("android:visibility:parent");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (paramTransitionValues != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    if ((this.mMode & 0x1) == 1)
    {
      if (paramTransitionValues2 == null) {
        return null;
      }
      if (paramTransitionValues1 == null)
      {
        View localView = (View)paramTransitionValues2.view.getParent();
        if (getVisibilityChangeInfo(getMatchedTransitionValues(localView, false), getTransitionValues(localView, false)).mVisibilityChange) {
          return null;
        }
      }
      return onAppear(paramViewGroup, paramTransitionValues2.view, paramTransitionValues1, paramTransitionValues2);
    }
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, int paramInt1, TransitionValues paramTransitionValues2, int paramInt2)
  {
    if ((this.mMode & 0x2) != 2) {
      return null;
    }
    if (paramTransitionValues1 == null) {
      return null;
    }
    View localView1 = paramTransitionValues1.view;
    Object localObject1;
    if (paramTransitionValues2 != null) {
      localObject1 = paramTransitionValues2.view;
    } else {
      localObject1 = null;
    }
    Object localObject2 = (View)localView1.getTag(R.id.save_overlay_view);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = null;
      paramInt1 = 1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    else
    {
      if ((localObject1 != null) && (((View)localObject1).getParent() != null))
      {
        if ((paramInt2 != 4) && (localView1 != localObject1)) {
          break label135;
        }
        localObject3 = null;
        localObject2 = localObject1;
      }
      else
      {
        if (localObject1 == null) {
          break label135;
        }
        localObject2 = null;
        localObject3 = localObject1;
      }
      paramInt1 = 0;
      break label144;
      label135:
      localObject3 = null;
      localObject2 = localObject3;
      paramInt1 = 1;
      label144:
      localObject1 = localObject3;
      if (paramInt1 != 0) {
        if (localView1.getParent() != null)
        {
          localObject1 = localObject3;
          if ((localView1.getParent() instanceof View))
          {
            View localView2 = (View)localView1.getParent();
            if (!getVisibilityChangeInfo(getTransitionValues(localView2, true), getMatchedTransitionValues(localView2, true)).mVisibilityChange)
            {
              localObject1 = TransitionUtils.copyViewImage(paramViewGroup, localView1, localView2);
            }
            else
            {
              paramInt1 = localView2.getId();
              localObject1 = localObject3;
              if (localView2.getParent() == null)
              {
                localObject1 = localObject3;
                if (paramInt1 != -1)
                {
                  localObject1 = localObject3;
                  if (paramViewGroup.findViewById(paramInt1) != null)
                  {
                    localObject1 = localObject3;
                    if (!this.mCanRemoveViews) {}
                  }
                }
              }
            }
          }
        }
        else
        {
          localObject1 = localView1;
        }
      }
      paramInt1 = 0;
    }
    if (localObject1 != null)
    {
      if (paramInt1 == 0)
      {
        localObject2 = (int[])paramTransitionValues1.values.get("android:visibility:screenLocation");
        paramInt2 = localObject2[0];
        int i = localObject2[1];
        localObject2 = new int[2];
        paramViewGroup.getLocationOnScreen((int[])localObject2);
        ((View)localObject1).offsetLeftAndRight(paramInt2 - localObject2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(i - localObject2[1] - ((View)localObject1).getTop());
        ViewGroupUtils.getOverlay(paramViewGroup).add((View)localObject1);
      }
      paramTransitionValues1 = onDisappear(paramViewGroup, (View)localObject1, paramTransitionValues1, paramTransitionValues2);
      if (paramInt1 == 0)
      {
        if (paramTransitionValues1 == null)
        {
          ViewGroupUtils.getOverlay(paramViewGroup).remove((View)localObject1);
          return paramTransitionValues1;
        }
        localView1.setTag(R.id.save_overlay_view, localObject1);
        addListener(new Visibility.1(this, paramViewGroup, (View)localObject1, localView1));
      }
      return paramTransitionValues1;
    }
    if (localObject2 != null)
    {
      paramInt1 = ((View)localObject2).getVisibility();
      ViewUtils.setTransitionVisibility((View)localObject2, 0);
      paramViewGroup = onDisappear(paramViewGroup, (View)localObject2, paramTransitionValues1, paramTransitionValues2);
      if (paramViewGroup != null)
      {
        paramTransitionValues1 = new Visibility.DisappearListener((View)localObject2, paramInt2, true);
        paramViewGroup.addListener(paramTransitionValues1);
        AnimatorUtils.addPauseListener(paramViewGroup, paramTransitionValues1);
        addListener(paramTransitionValues1);
        return paramViewGroup;
      }
      ViewUtils.setTransitionVisibility((View)localObject2, paramInt1);
      return paramViewGroup;
    }
    return null;
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) == 0)
    {
      this.mMode = paramInt;
      return;
    }
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */
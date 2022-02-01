package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeBounds
  extends Transition
{
  private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
  private static final Property<ChangeBounds.ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
  private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY;
  private static final Property<View, PointF> POSITION_PROPERTY = new ChangeBounds.6(PointF.class, "position");
  private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
  private static final String PROPNAME_CLIP = "android:changeBounds:clip";
  private static final String PROPNAME_PARENT = "android:changeBounds:parent";
  private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
  private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
  private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
  private static final Property<ChangeBounds.ViewBounds, PointF> TOP_LEFT_PROPERTY;
  private static RectEvaluator sRectEvaluator = new RectEvaluator();
  private static final String[] sTransitionProperties = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private boolean mReparent = false;
  private boolean mResizeClip = false;
  private int[] mTempLocation = new int[2];
  
  static
  {
    DRAWABLE_ORIGIN_PROPERTY = new ChangeBounds.1(PointF.class, "boundsOrigin");
    TOP_LEFT_PROPERTY = new ChangeBounds.2(PointF.class, "topLeft");
    BOTTOM_RIGHT_PROPERTY = new ChangeBounds.3(PointF.class, "bottomRight");
    BOTTOM_RIGHT_ONLY_PROPERTY = new ChangeBounds.4(PointF.class, "bottomRight");
    TOP_LEFT_ONLY_PROPERTY = new ChangeBounds.5(PointF.class, "topLeft");
  }
  
  public ChangeBounds() {}
  
  @SuppressLint({"RestrictedApi"})
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.CHANGE_BOUNDS);
    boolean bool = TypedArrayUtils.getNamedBoolean(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    setResizeClip(bool);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramTransitionValues.values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramTransitionValues.values.put("android:changeBounds:parent", paramTransitionValues.view.getParent());
      if (this.mReparent)
      {
        paramTransitionValues.view.getLocationInWindow(this.mTempLocation);
        paramTransitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.mTempLocation[0]));
        paramTransitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.mTempLocation[1]));
      }
      if (this.mResizeClip) {
        paramTransitionValues.values.put("android:changeBounds:clip", ViewCompat.getClipBounds(localView));
      }
    }
  }
  
  private boolean parentMatches(View paramView1, View paramView2)
  {
    if (this.mReparent)
    {
      TransitionValues localTransitionValues = getMatchedTransitionValues(paramView1, true);
      if (localTransitionValues == null) {
        if (paramView1 == paramView2) {
          return true;
        }
      }
      while (paramView2 != localTransitionValues.view) {
        return false;
      }
    }
    return true;
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
    if ((paramTransitionValues1 != null) && (paramTransitionValues2 != null))
    {
      Object localObject2 = paramTransitionValues1.values;
      Object localObject1 = paramTransitionValues2.values;
      localObject2 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      Object localObject3 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      if ((localObject2 != null) && (localObject3 != null))
      {
        localObject1 = paramTransitionValues2.view;
        int k;
        int m;
        int j;
        int i;
        if (parentMatches((View)localObject2, (View)localObject3))
        {
          paramViewGroup = (Rect)paramTransitionValues1.values.get("android:changeBounds:bounds");
          localObject2 = (Rect)paramTransitionValues2.values.get("android:changeBounds:bounds");
          k = paramViewGroup.left;
          m = ((Rect)localObject2).left;
          int n = paramViewGroup.top;
          int i1 = ((Rect)localObject2).top;
          int i2 = paramViewGroup.right;
          int i3 = ((Rect)localObject2).right;
          int i4 = paramViewGroup.bottom;
          int i5 = ((Rect)localObject2).bottom;
          int i6 = i2 - k;
          int i7 = i4 - n;
          int i8 = i3 - m;
          int i9 = i5 - i1;
          paramTransitionValues1 = (Rect)paramTransitionValues1.values.get("android:changeBounds:clip");
          localObject2 = (Rect)paramTransitionValues2.values.get("android:changeBounds:clip");
          if (((i6 != 0) && (i7 != 0)) || ((i8 != 0) && (i9 != 0)))
          {
            if ((k == m) && (n == i1)) {
              j = 0;
            } else {
              j = 1;
            }
            if (i2 == i3)
            {
              i = j;
              if (i4 == i5) {}
            }
            else
            {
              i = j + 1;
            }
          }
          else
          {
            i = 0;
          }
          if ((paramTransitionValues1 == null) || (paramTransitionValues1.equals(localObject2)))
          {
            j = i;
            if (paramTransitionValues1 == null)
            {
              j = i;
              if (localObject2 == null) {}
            }
          }
          else
          {
            j = i + 1;
          }
          if (j > 0)
          {
            if (!this.mResizeClip)
            {
              paramViewGroup = (ViewGroup)localObject1;
              ViewUtils.setLeftTopRightBottom(paramViewGroup, k, n, i2, i4);
              if (j == 2)
              {
                if ((i6 == i8) && (i7 == i9))
                {
                  paramTransitionValues1 = getPathMotion().getPath(k, n, m, i1);
                  paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, POSITION_PROPERTY, paramTransitionValues1);
                }
                else
                {
                  paramTransitionValues1 = new ChangeBounds.ViewBounds(paramViewGroup);
                  paramViewGroup = getPathMotion().getPath(k, n, m, i1);
                  paramTransitionValues2 = ObjectAnimatorUtils.ofPointF(paramTransitionValues1, TOP_LEFT_PROPERTY, paramViewGroup);
                  paramViewGroup = getPathMotion().getPath(i2, i4, i3, i5);
                  localObject2 = ObjectAnimatorUtils.ofPointF(paramTransitionValues1, BOTTOM_RIGHT_PROPERTY, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramTransitionValues2, localObject2 });
                  paramViewGroup.addListener(new ChangeBounds.7(this, paramTransitionValues1));
                }
              }
              else if ((k == m) && (n == i1))
              {
                paramTransitionValues1 = getPathMotion().getPath(i2, i4, i3, i5);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, BOTTOM_RIGHT_ONLY_PROPERTY, paramTransitionValues1);
              }
              else
              {
                paramTransitionValues1 = getPathMotion().getPath(k, n, m, i1);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(paramViewGroup, TOP_LEFT_ONLY_PROPERTY, paramTransitionValues1);
              }
            }
            else
            {
              localObject3 = localObject1;
              ViewUtils.setLeftTopRightBottom((View)localObject3, k, n, Math.max(i6, i8) + k, Math.max(i7, i9) + n);
              if ((k == m) && (n == i1))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = getPathMotion().getPath(k, n, m, i1);
                paramViewGroup = ObjectAnimatorUtils.ofPointF(localObject3, POSITION_PROPERTY, paramViewGroup);
              }
              if (paramTransitionValues1 == null) {
                paramTransitionValues1 = new Rect(0, 0, i6, i7);
              }
              if (localObject2 == null) {
                paramTransitionValues2 = new Rect(0, 0, i8, i9);
              } else {
                paramTransitionValues2 = (TransitionValues)localObject2;
              }
              if (!paramTransitionValues1.equals(paramTransitionValues2))
              {
                ViewCompat.setClipBounds((View)localObject3, paramTransitionValues1);
                paramTransitionValues1 = ObjectAnimator.ofObject(localObject3, "clipBounds", sRectEvaluator, new Object[] { paramTransitionValues1, paramTransitionValues2 });
                paramTransitionValues1.addListener(new ChangeBounds.8(this, (View)localObject3, (Rect)localObject2, m, i1, i3, i5));
              }
              else
              {
                paramTransitionValues1 = null;
              }
              paramViewGroup = TransitionUtils.mergeAnimators(paramViewGroup, paramTransitionValues1);
            }
            if ((((View)localObject1).getParent() instanceof ViewGroup))
            {
              paramTransitionValues1 = (ViewGroup)((View)localObject1).getParent();
              ViewGroupUtils.suppressLayout(paramTransitionValues1, true);
              addListener(new ChangeBounds.9(this, paramTransitionValues1));
            }
            return paramViewGroup;
          }
        }
        else
        {
          i = ((Integer)paramTransitionValues1.values.get("android:changeBounds:windowX")).intValue();
          j = ((Integer)paramTransitionValues1.values.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)paramTransitionValues2.values.get("android:changeBounds:windowX")).intValue();
          m = ((Integer)paramTransitionValues2.values.get("android:changeBounds:windowY")).intValue();
          if ((i != k) || (j != m)) {
            break label944;
          }
        }
        return null;
        label944:
        paramViewGroup.getLocationInWindow(this.mTempLocation);
        paramTransitionValues1 = Bitmap.createBitmap(((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject1).draw(new Canvas(paramTransitionValues1));
        paramTransitionValues1 = new BitmapDrawable(paramTransitionValues1);
        float f = ViewUtils.getTransitionAlpha((View)localObject1);
        ViewUtils.setTransitionAlpha((View)localObject1, 0.0F);
        ViewUtils.getOverlay(paramViewGroup).add(paramTransitionValues1);
        paramTransitionValues2 = getPathMotion();
        localObject2 = this.mTempLocation;
        paramTransitionValues2 = paramTransitionValues2.getPath(i - localObject2[0], j - localObject2[1], k - localObject2[0], m - localObject2[1]);
        paramTransitionValues2 = ObjectAnimator.ofPropertyValuesHolder(paramTransitionValues1, new PropertyValuesHolder[] { PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, paramTransitionValues2) });
        paramTransitionValues2.addListener(new ChangeBounds.10(this, paramViewGroup, paramTransitionValues1, (View)localObject1, f));
        return paramTransitionValues2;
      }
      return null;
    }
    return null;
  }
  
  public boolean getResizeClip()
  {
    return this.mResizeClip;
  }
  
  @Nullable
  public String[] getTransitionProperties()
  {
    return sTransitionProperties;
  }
  
  public void setResizeClip(boolean paramBoolean)
  {
    this.mResizeClip = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */
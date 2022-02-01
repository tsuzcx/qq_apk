package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R.styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class StateListDrawable
  extends DrawableContainer
{
  private static final boolean DEBUG = false;
  private static final String TAG = "StateListDrawable";
  private boolean mMutated;
  private StateListDrawable.StateListState mStateListState;
  
  StateListDrawable()
  {
    this(null, null);
  }
  
  StateListDrawable(@Nullable StateListDrawable.StateListState paramStateListState)
  {
    if (paramStateListState != null) {
      setConstantState(paramStateListState);
    }
  }
  
  StateListDrawable(StateListDrawable.StateListState paramStateListState, Resources paramResources)
  {
    setConstantState(new StateListDrawable.StateListState(paramStateListState, this, paramResources));
    onStateChange(getState());
  }
  
  private void inflateChildElements(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    StateListDrawable.StateListState localStateListState = this.mStateListState;
    int i = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        Object localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawableItem);
        Drawable localDrawable = null;
        j = ((TypedArray)localObject).getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (j > 0) {
          localDrawable = ResourceManagerInternal.get().getDrawable(paramContext, j);
        }
        ((TypedArray)localObject).recycle();
        int[] arrayOfInt = extractStateSet(paramAttributeSet);
        localObject = localDrawable;
        if (localDrawable == null)
        {
          do
          {
            j = paramXmlPullParser.next();
          } while (j == 4);
          if (j == 2)
          {
            if (Build.VERSION.SDK_INT >= 21) {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
        }
        localStateListState.addStateSet(arrayOfInt, (Drawable)localObject);
      }
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    StateListDrawable.StateListState localStateListState = this.mStateListState;
    if (Build.VERSION.SDK_INT >= 21) {
      localStateListState.mChangingConfigurations |= paramTypedArray.getChangingConfigurations();
    }
    localStateListState.mVariablePadding = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, localStateListState.mVariablePadding);
    localStateListState.mConstantSize = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, localStateListState.mConstantSize);
    localStateListState.mEnterFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, localStateListState.mEnterFadeDuration);
    localStateListState.mExitFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, localStateListState.mExitFadeDuration);
    localStateListState.mDither = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_dither, localStateListState.mDither);
  }
  
  public void addState(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.mStateListState.addStateSet(paramArrayOfInt, paramDrawable);
      onStateChange(getState());
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  void clearMutated()
  {
    super.clearMutated();
    this.mMutated = false;
  }
  
  StateListDrawable.StateListState cloneConstantState()
  {
    return new StateListDrawable.StateListState(this.mStateListState, this, null);
  }
  
  int[] extractStateSet(AttributeSet paramAttributeSet)
  {
    int n = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[n];
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      int m = paramAttributeSet.getAttributeNameResource(i);
      k = j;
      if (m != 0)
      {
        k = j;
        if (m != 16842960)
        {
          k = j;
          if (m != 16843161)
          {
            if (paramAttributeSet.getAttributeBooleanValue(i, false)) {
              k = m;
            } else {
              k = -m;
            }
            arrayOfInt[j] = k;
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return StateSet.trimStateSet(arrayOfInt, j);
  }
  
  int getStateCount()
  {
    return this.mStateListState.getChildCount();
  }
  
  Drawable getStateDrawable(int paramInt)
  {
    return this.mStateListState.getChild(paramInt);
  }
  
  int getStateDrawableIndex(int[] paramArrayOfInt)
  {
    return this.mStateListState.indexOfStateSet(paramArrayOfInt);
  }
  
  StateListDrawable.StateListState getStateListState()
  {
    return this.mStateListState;
  }
  
  int[] getStateSet(int paramInt)
  {
    return this.mStateListState.mStateSets[paramInt];
  }
  
  public void inflate(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawable);
    setVisible(localTypedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
    updateStateFromTypedArray(localTypedArray);
    updateDensity(paramResources);
    localTypedArray.recycle();
    inflateChildElements(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mStateListState.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = this.mStateListState.indexOfStateSet(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    }
    return (selectDrawable(i)) || (bool);
  }
  
  void setConstantState(@NonNull DrawableContainer.DrawableContainerState paramDrawableContainerState)
  {
    super.setConstantState(paramDrawableContainerState);
    if ((paramDrawableContainerState instanceof StateListDrawable.StateListState)) {
      this.mStateListState = ((StateListDrawable.StateListState)paramDrawableContainerState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.StateListDrawable
 * JD-Core Version:    0.7.0.1
 */
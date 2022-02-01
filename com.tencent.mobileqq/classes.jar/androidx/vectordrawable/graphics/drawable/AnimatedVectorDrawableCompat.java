package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat
  extends VectorDrawableCommon
  implements Animatable2Compat
{
  private static final String ANIMATED_VECTOR = "animated-vector";
  private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
  private static final String LOGTAG = "AnimatedVDCompat";
  private static final String TARGET = "target";
  private AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState mAnimatedVectorState;
  ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks = null;
  private Animator.AnimatorListener mAnimatorListener = null;
  private ArgbEvaluator mArgbEvaluator = null;
  AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
  final Drawable.Callback mCallback = new AnimatedVectorDrawableCompat.1(this);
  private Context mContext;
  
  AnimatedVectorDrawableCompat()
  {
    this(null, null, null);
  }
  
  private AnimatedVectorDrawableCompat(@Nullable Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  private AnimatedVectorDrawableCompat(@Nullable Context paramContext, @Nullable AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, @Nullable Resources paramResources)
  {
    this.mContext = paramContext;
    if (paramAnimatedVectorDrawableCompatState != null)
    {
      this.mAnimatedVectorState = paramAnimatedVectorDrawableCompatState;
      return;
    }
    this.mAnimatedVectorState = new AnimatedVectorDrawableCompat.AnimatedVectorDrawableCompatState(paramContext, paramAnimatedVectorDrawableCompatState, this.mCallback, paramResources);
  }
  
  public static void clearAnimationCallbacks(Drawable paramDrawable)
  {
    if (!(paramDrawable instanceof Animatable)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      ((AnimatedVectorDrawable)paramDrawable).clearAnimationCallbacks();
      return;
    }
    ((AnimatedVectorDrawableCompat)paramDrawable).clearAnimationCallbacks();
  }
  
  @Nullable
  public static AnimatedVectorDrawableCompat create(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new AnimatedVectorDrawableCompat(paramContext);
      ((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable = ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      ((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable.setCallback(((AnimatedVectorDrawableCompat)localObject).mCallback);
      ((AnimatedVectorDrawableCompat)localObject).mCachedConstantStateDelegate = new AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState(((AnimatedVectorDrawableCompat)localObject).mDelegateDrawable.getConstantState());
      return localObject;
    }
    Object localObject = paramContext.getResources();
    try
    {
      localObject = ((Resources)localObject).getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramContext, paramContext.getResources(), (XmlPullParser)localObject, localAttributeSet, paramContext.getTheme());
      }
      throw new XmlPullParserException("No start tag found");
    }
    catch (IOException paramContext)
    {
      Log.e("AnimatedVDCompat", "parser error", paramContext);
    }
    catch (XmlPullParserException paramContext)
    {
      Log.e("AnimatedVDCompat", "parser error", paramContext);
    }
    return null;
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramContext = new AnimatedVectorDrawableCompat(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  public static void registerAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (paramDrawable != null)
    {
      if (paramAnimationCallback == null) {
        return;
      }
      if (!(paramDrawable instanceof Animatable)) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        registerPlatformCallback((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback);
        return;
      }
      ((AnimatedVectorDrawableCompat)paramDrawable).registerAnimationCallback(paramAnimationCallback);
    }
  }
  
  @RequiresApi(23)
  private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable paramAnimatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    paramAnimatedVectorDrawable.registerAnimationCallback(paramAnimationCallback.getPlatformCallback());
  }
  
  private void removeAnimatorSetListener()
  {
    if (this.mAnimatorListener != null)
    {
      this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
      this.mAnimatorListener = null;
    }
  }
  
  private void setupAnimatorsForTarget(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(paramString));
    if (Build.VERSION.SDK_INT < 21) {
      setupColorAnimator(paramAnimator);
    }
    if (this.mAnimatedVectorState.mAnimators == null)
    {
      this.mAnimatedVectorState.mAnimators = new ArrayList();
      this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
    }
    this.mAnimatedVectorState.mAnimators.add(paramAnimator);
    this.mAnimatedVectorState.mTargetNameMap.put(paramAnimator, paramString);
  }
  
  private void setupColorAnimator(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          setupColorAnimator((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (this.mArgbEvaluator == null) {
          this.mArgbEvaluator = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(this.mArgbEvaluator);
      }
    }
  }
  
  public static boolean unregisterAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (paramDrawable != null)
    {
      if (paramAnimationCallback == null) {
        return false;
      }
      if (!(paramDrawable instanceof Animatable)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        return unregisterPlatformCallback((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback);
      }
      return ((AnimatedVectorDrawableCompat)paramDrawable).unregisterAnimationCallback(paramAnimationCallback);
    }
    return false;
  }
  
  @RequiresApi(23)
  private static boolean unregisterPlatformCallback(AnimatedVectorDrawable paramAnimatedVectorDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    return paramAnimatedVectorDrawable.unregisterAnimationCallback(paramAnimationCallback.getPlatformCallback());
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    if (this.mDelegateDrawable != null) {
      DrawableCompat.applyTheme(this.mDelegateDrawable, paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }
    return false;
  }
  
  public void clearAnimationCallbacks()
  {
    if (this.mDelegateDrawable != null)
    {
      ((AnimatedVectorDrawable)this.mDelegateDrawable).clearAnimationCallbacks();
      return;
    }
    removeAnimatorSetListener();
    ArrayList localArrayList = this.mAnimationCallbacks;
    if (localArrayList == null) {
      return;
    }
    localArrayList.clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.draw(paramCanvas);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
      invalidateSelf();
    }
  }
  
  public int getAlpha()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.getAlpha(this.mDelegateDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
  }
  
  public ColorFilter getColorFilter()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.getColorFilter(this.mDelegateDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.mDelegateDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new AnimatedVectorDrawableCompat.AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getIntrinsicHeight();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getIntrinsicWidth();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.getOpacity();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.inflate(this.mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        Object localObject2;
        if ("animated-vector".equals(localObject1))
        {
          localObject1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
          i = ((TypedArray)localObject1).getResourceId(0, 0);
          if (i != 0)
          {
            localObject2 = VectorDrawableCompat.create(paramResources, i, paramTheme);
            ((VectorDrawableCompat)localObject2).setAllowCaching(false);
            ((VectorDrawableCompat)localObject2).setCallback(this.mCallback);
            if (this.mAnimatedVectorState.mVectorDrawable != null) {
              this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
            }
            this.mAnimatedVectorState.mVectorDrawable = ((VectorDrawableCompat)localObject2);
          }
          ((TypedArray)localObject1).recycle();
        }
        else if ("target".equals(localObject1))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
          localObject2 = ((TypedArray)localObject1).getString(0);
          i = ((TypedArray)localObject1).getResourceId(1, 0);
          if (i != 0)
          {
            Context localContext = this.mContext;
            if (localContext != null)
            {
              setupAnimatorsForTarget((String)localObject2, AnimatorInflaterCompat.loadAnimator(localContext, i));
            }
            else
            {
              ((TypedArray)localObject1).recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            }
          }
          ((TypedArray)localObject1).recycle();
        }
      }
      i = paramXmlPullParser.next();
    }
    this.mAnimatedVectorState.setupAnimatorSet();
  }
  
  public boolean isAutoMirrored()
  {
    if (this.mDelegateDrawable != null) {
      return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    if (this.mDelegateDrawable != null) {
      return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
    }
    return this.mAnimatedVectorState.mAnimatorSet.isRunning();
  }
  
  public boolean isStateful()
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.isStateful();
    }
    return this.mAnimatedVectorState.mVectorDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    if (this.mDelegateDrawable != null) {
      this.mDelegateDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setBounds(paramRect);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.setLevel(paramInt);
    }
    return this.mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.setState(paramArrayOfInt);
    }
    return this.mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfInt);
  }
  
  public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (this.mDelegateDrawable != null)
    {
      registerPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, paramAnimationCallback);
      return;
    }
    if (paramAnimationCallback == null) {
      return;
    }
    if (this.mAnimationCallbacks == null) {
      this.mAnimationCallbacks = new ArrayList();
    }
    if (this.mAnimationCallbacks.contains(paramAnimationCallback)) {
      return;
    }
    this.mAnimationCallbacks.add(paramAnimationCallback);
    if (this.mAnimatorListener == null) {
      this.mAnimatorListener = new AnimatedVectorDrawableCompat.2(this);
    }
    this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setAlpha(paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setAutoMirrored(this.mDelegateDrawable, paramBoolean);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mDelegateDrawable != null)
    {
      this.mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTint(this.mDelegateDrawable, paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTintList(this.mDelegateDrawable, paramColorStateList);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mDelegateDrawable != null)
    {
      DrawableCompat.setTintMode(this.mDelegateDrawable, paramMode);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mDelegateDrawable != null) {
      return this.mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    this.mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    if (this.mDelegateDrawable != null)
    {
      ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
      return;
    }
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
      return;
    }
    this.mAnimatedVectorState.mAnimatorSet.start();
    invalidateSelf();
  }
  
  public void stop()
  {
    if (this.mDelegateDrawable != null)
    {
      ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
      return;
    }
    this.mAnimatedVectorState.mAnimatorSet.end();
  }
  
  public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (this.mDelegateDrawable != null) {
      unregisterPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, paramAnimationCallback);
    }
    ArrayList localArrayList = this.mAnimationCallbacks;
    if ((localArrayList != null) && (paramAnimationCallback != null))
    {
      boolean bool = localArrayList.remove(paramAnimationCallback);
      if (this.mAnimationCallbacks.size() == 0) {
        removeAnimatorSetListener();
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 * JD-Core Version:    0.7.0.1
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;

abstract class DrawableContainer$DrawableContainerState
  extends Drawable.ConstantState
{
  boolean mAutoMirrored;
  boolean mCanConstantState;
  int mChangingConfigurations;
  boolean mCheckedConstantSize;
  boolean mCheckedConstantState;
  boolean mCheckedOpacity;
  boolean mCheckedPadding;
  boolean mCheckedStateful;
  int mChildrenChangingConfigurations;
  ColorFilter mColorFilter;
  int mConstantHeight;
  int mConstantMinimumHeight;
  int mConstantMinimumWidth;
  Rect mConstantPadding;
  boolean mConstantSize;
  int mConstantWidth;
  int mDensity = 160;
  boolean mDither;
  SparseArray<Drawable.ConstantState> mDrawableFutures;
  Drawable[] mDrawables;
  int mEnterFadeDuration;
  int mExitFadeDuration;
  boolean mHasColorFilter;
  boolean mHasTintList;
  boolean mHasTintMode;
  int mLayoutDirection;
  boolean mMutated;
  int mNumChildren;
  int mOpacity;
  final DrawableContainer mOwner;
  Resources mSourceRes;
  boolean mStateful;
  ColorStateList mTintList;
  PorterDuff.Mode mTintMode;
  boolean mVariablePadding;
  
  DrawableContainer$DrawableContainerState(DrawableContainerState paramDrawableContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    int j = 0;
    this.mVariablePadding = false;
    this.mConstantSize = false;
    this.mDither = true;
    this.mEnterFadeDuration = 0;
    this.mExitFadeDuration = 0;
    this.mOwner = paramDrawableContainer;
    if (paramResources != null) {
      paramDrawableContainer = paramResources;
    } else if (paramDrawableContainerState != null) {
      paramDrawableContainer = paramDrawableContainerState.mSourceRes;
    } else {
      paramDrawableContainer = null;
    }
    this.mSourceRes = paramDrawableContainer;
    int i;
    if (paramDrawableContainerState != null) {
      i = paramDrawableContainerState.mDensity;
    } else {
      i = 0;
    }
    this.mDensity = DrawableContainer.resolveDensity(paramResources, i);
    if (paramDrawableContainerState != null)
    {
      this.mChangingConfigurations = paramDrawableContainerState.mChangingConfigurations;
      this.mChildrenChangingConfigurations = paramDrawableContainerState.mChildrenChangingConfigurations;
      this.mCheckedConstantState = true;
      this.mCanConstantState = true;
      this.mVariablePadding = paramDrawableContainerState.mVariablePadding;
      this.mConstantSize = paramDrawableContainerState.mConstantSize;
      this.mDither = paramDrawableContainerState.mDither;
      this.mMutated = paramDrawableContainerState.mMutated;
      this.mLayoutDirection = paramDrawableContainerState.mLayoutDirection;
      this.mEnterFadeDuration = paramDrawableContainerState.mEnterFadeDuration;
      this.mExitFadeDuration = paramDrawableContainerState.mExitFadeDuration;
      this.mAutoMirrored = paramDrawableContainerState.mAutoMirrored;
      this.mColorFilter = paramDrawableContainerState.mColorFilter;
      this.mHasColorFilter = paramDrawableContainerState.mHasColorFilter;
      this.mTintList = paramDrawableContainerState.mTintList;
      this.mTintMode = paramDrawableContainerState.mTintMode;
      this.mHasTintList = paramDrawableContainerState.mHasTintList;
      this.mHasTintMode = paramDrawableContainerState.mHasTintMode;
      if (paramDrawableContainerState.mDensity == this.mDensity)
      {
        if (paramDrawableContainerState.mCheckedPadding)
        {
          this.mConstantPadding = new Rect(paramDrawableContainerState.mConstantPadding);
          this.mCheckedPadding = true;
        }
        if (paramDrawableContainerState.mCheckedConstantSize)
        {
          this.mConstantWidth = paramDrawableContainerState.mConstantWidth;
          this.mConstantHeight = paramDrawableContainerState.mConstantHeight;
          this.mConstantMinimumWidth = paramDrawableContainerState.mConstantMinimumWidth;
          this.mConstantMinimumHeight = paramDrawableContainerState.mConstantMinimumHeight;
          this.mCheckedConstantSize = true;
        }
      }
      if (paramDrawableContainerState.mCheckedOpacity)
      {
        this.mOpacity = paramDrawableContainerState.mOpacity;
        this.mCheckedOpacity = true;
      }
      if (paramDrawableContainerState.mCheckedStateful)
      {
        this.mStateful = paramDrawableContainerState.mStateful;
        this.mCheckedStateful = true;
      }
      paramDrawableContainer = paramDrawableContainerState.mDrawables;
      this.mDrawables = new Drawable[paramDrawableContainer.length];
      this.mNumChildren = paramDrawableContainerState.mNumChildren;
      paramDrawableContainerState = paramDrawableContainerState.mDrawableFutures;
      if (paramDrawableContainerState != null) {
        this.mDrawableFutures = paramDrawableContainerState.clone();
      } else {
        this.mDrawableFutures = new SparseArray(this.mNumChildren);
      }
      int k = this.mNumChildren;
      i = j;
      while (i < k)
      {
        if (paramDrawableContainer[i] != null)
        {
          paramDrawableContainerState = paramDrawableContainer[i].getConstantState();
          if (paramDrawableContainerState != null) {
            this.mDrawableFutures.put(i, paramDrawableContainerState);
          } else {
            this.mDrawables[i] = paramDrawableContainer[i];
          }
        }
        i += 1;
      }
    }
    this.mDrawables = new Drawable[10];
    this.mNumChildren = 0;
  }
  
  private void createAllFutures()
  {
    Object localObject = this.mDrawableFutures;
    if (localObject != null)
    {
      int j = ((SparseArray)localObject).size();
      int i = 0;
      while (i < j)
      {
        int k = this.mDrawableFutures.keyAt(i);
        localObject = (Drawable.ConstantState)this.mDrawableFutures.valueAt(i);
        this.mDrawables[k] = prepareDrawable(((Drawable.ConstantState)localObject).newDrawable(this.mSourceRes));
        i += 1;
      }
      this.mDrawableFutures = null;
    }
  }
  
  private Drawable prepareDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramDrawable.setLayoutDirection(this.mLayoutDirection);
    }
    paramDrawable = paramDrawable.mutate();
    paramDrawable.setCallback(this.mOwner);
    return paramDrawable;
  }
  
  public final int addChild(Drawable paramDrawable)
  {
    int i = this.mNumChildren;
    if (i >= this.mDrawables.length) {
      growArray(i, i + 10);
    }
    paramDrawable.mutate();
    paramDrawable.setVisible(false, true);
    paramDrawable.setCallback(this.mOwner);
    this.mDrawables[i] = paramDrawable;
    this.mNumChildren += 1;
    int j = this.mChildrenChangingConfigurations;
    this.mChildrenChangingConfigurations = (paramDrawable.getChangingConfigurations() | j);
    invalidateCache();
    this.mConstantPadding = null;
    this.mCheckedPadding = false;
    this.mCheckedConstantSize = false;
    this.mCheckedConstantState = false;
    return i;
  }
  
  @RequiresApi(21)
  final void applyTheme(Resources.Theme paramTheme)
  {
    if (paramTheme != null)
    {
      createAllFutures();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        if ((arrayOfDrawable[i] != null) && (arrayOfDrawable[i].canApplyTheme()))
        {
          arrayOfDrawable[i].applyTheme(paramTheme);
          this.mChildrenChangingConfigurations |= arrayOfDrawable[i].getChangingConfigurations();
        }
        i += 1;
      }
      updateDensity(paramTheme.getResources());
    }
  }
  
  @RequiresApi(21)
  public boolean canApplyTheme()
  {
    int j = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfDrawable[i];
      if (localObject != null)
      {
        if (((Drawable)localObject).canApplyTheme()) {
          return true;
        }
      }
      else
      {
        localObject = (Drawable.ConstantState)this.mDrawableFutures.get(i);
        if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
  
  public boolean canConstantState()
  {
    try
    {
      if (this.mCheckedConstantState)
      {
        boolean bool = this.mCanConstantState;
        return bool;
      }
      createAllFutures();
      this.mCheckedConstantState = true;
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      int i = 0;
      while (i < j)
      {
        if (arrayOfDrawable[i].getConstantState() == null)
        {
          this.mCanConstantState = false;
          return false;
        }
        i += 1;
      }
      this.mCanConstantState = true;
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  final void clearMutated()
  {
    this.mMutated = false;
  }
  
  protected void computeConstantSize()
  {
    this.mCheckedConstantSize = true;
    createAllFutures();
    int j = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    this.mConstantHeight = -1;
    this.mConstantWidth = -1;
    int i = 0;
    this.mConstantMinimumHeight = 0;
    this.mConstantMinimumWidth = 0;
    while (i < j)
    {
      Drawable localDrawable = arrayOfDrawable[i];
      int k = localDrawable.getIntrinsicWidth();
      if (k > this.mConstantWidth) {
        this.mConstantWidth = k;
      }
      k = localDrawable.getIntrinsicHeight();
      if (k > this.mConstantHeight) {
        this.mConstantHeight = k;
      }
      k = localDrawable.getMinimumWidth();
      if (k > this.mConstantMinimumWidth) {
        this.mConstantMinimumWidth = k;
      }
      k = localDrawable.getMinimumHeight();
      if (k > this.mConstantMinimumHeight) {
        this.mConstantMinimumHeight = k;
      }
      i += 1;
    }
  }
  
  final int getCapacity()
  {
    return this.mDrawables.length;
  }
  
  public int getChangingConfigurations()
  {
    return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
  }
  
  public final Drawable getChild(int paramInt)
  {
    Object localObject = this.mDrawables[paramInt];
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mDrawableFutures;
    if (localObject != null)
    {
      int i = ((SparseArray)localObject).indexOfKey(paramInt);
      if (i >= 0)
      {
        localObject = prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(i)).newDrawable(this.mSourceRes));
        this.mDrawables[paramInt] = localObject;
        this.mDrawableFutures.removeAt(i);
        if (this.mDrawableFutures.size() == 0) {
          this.mDrawableFutures = null;
        }
        return localObject;
      }
    }
    return null;
  }
  
  public final int getChildCount()
  {
    return this.mNumChildren;
  }
  
  public final int getConstantHeight()
  {
    if (!this.mCheckedConstantSize) {
      computeConstantSize();
    }
    return this.mConstantHeight;
  }
  
  public final int getConstantMinimumHeight()
  {
    if (!this.mCheckedConstantSize) {
      computeConstantSize();
    }
    return this.mConstantMinimumHeight;
  }
  
  public final int getConstantMinimumWidth()
  {
    if (!this.mCheckedConstantSize) {
      computeConstantSize();
    }
    return this.mConstantMinimumWidth;
  }
  
  public final Rect getConstantPadding()
  {
    if (this.mVariablePadding) {
      return null;
    }
    if ((this.mConstantPadding == null) && (!this.mCheckedPadding))
    {
      createAllFutures();
      Rect localRect = new Rect();
      int j = this.mNumChildren;
      Drawable[] arrayOfDrawable = this.mDrawables;
      Object localObject1 = null;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject1;
        if (arrayOfDrawable[i].getPadding(localRect))
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Rect(0, 0, 0, 0);
          }
          if (localRect.left > ((Rect)localObject2).left) {
            ((Rect)localObject2).left = localRect.left;
          }
          if (localRect.top > ((Rect)localObject2).top) {
            ((Rect)localObject2).top = localRect.top;
          }
          if (localRect.right > ((Rect)localObject2).right) {
            ((Rect)localObject2).right = localRect.right;
          }
          localObject3 = localObject2;
          if (localRect.bottom > ((Rect)localObject2).bottom)
          {
            ((Rect)localObject2).bottom = localRect.bottom;
            localObject3 = localObject2;
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
      this.mCheckedPadding = true;
      this.mConstantPadding = localObject1;
      return localObject1;
    }
    return this.mConstantPadding;
  }
  
  public final int getConstantWidth()
  {
    if (!this.mCheckedConstantSize) {
      computeConstantSize();
    }
    return this.mConstantWidth;
  }
  
  public final int getEnterFadeDuration()
  {
    return this.mEnterFadeDuration;
  }
  
  public final int getExitFadeDuration()
  {
    return this.mExitFadeDuration;
  }
  
  public final int getOpacity()
  {
    if (this.mCheckedOpacity) {
      return this.mOpacity;
    }
    createAllFutures();
    int m = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    if (m > 0) {
      i = arrayOfDrawable[0].getOpacity();
    } else {
      i = -2;
    }
    int k = 1;
    int j = i;
    int i = k;
    while (i < m)
    {
      j = Drawable.resolveOpacity(j, arrayOfDrawable[i].getOpacity());
      i += 1;
    }
    this.mOpacity = j;
    this.mCheckedOpacity = true;
    return j;
  }
  
  public void growArray(int paramInt1, int paramInt2)
  {
    Drawable[] arrayOfDrawable = new Drawable[paramInt2];
    System.arraycopy(this.mDrawables, 0, arrayOfDrawable, 0, paramInt1);
    this.mDrawables = arrayOfDrawable;
  }
  
  void invalidateCache()
  {
    this.mCheckedOpacity = false;
    this.mCheckedStateful = false;
  }
  
  public final boolean isConstantSize()
  {
    return this.mConstantSize;
  }
  
  public final boolean isStateful()
  {
    if (this.mCheckedStateful) {
      return this.mStateful;
    }
    createAllFutures();
    int j = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (arrayOfDrawable[i].isStateful())
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    this.mStateful = bool1;
    this.mCheckedStateful = true;
    return bool1;
  }
  
  void mutate()
  {
    int j = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    int i = 0;
    while (i < j)
    {
      if (arrayOfDrawable[i] != null) {
        arrayOfDrawable[i].mutate();
      }
      i += 1;
    }
    this.mMutated = true;
  }
  
  public final void setConstantSize(boolean paramBoolean)
  {
    this.mConstantSize = paramBoolean;
  }
  
  public final void setEnterFadeDuration(int paramInt)
  {
    this.mEnterFadeDuration = paramInt;
  }
  
  public final void setExitFadeDuration(int paramInt)
  {
    this.mExitFadeDuration = paramInt;
  }
  
  final boolean setLayoutDirection(int paramInt1, int paramInt2)
  {
    int j = this.mNumChildren;
    Drawable[] arrayOfDrawable = this.mDrawables;
    int i = 0;
    boolean bool3;
    for (boolean bool2 = false; i < j; bool2 = bool3)
    {
      bool3 = bool2;
      if (arrayOfDrawable[i] != null)
      {
        boolean bool1;
        if (Build.VERSION.SDK_INT >= 23) {
          bool1 = arrayOfDrawable[i].setLayoutDirection(paramInt1);
        } else {
          bool1 = false;
        }
        bool3 = bool2;
        if (i == paramInt2) {
          bool3 = bool1;
        }
      }
      i += 1;
    }
    this.mLayoutDirection = paramInt1;
    return bool2;
  }
  
  public final void setVariablePadding(boolean paramBoolean)
  {
    this.mVariablePadding = paramBoolean;
  }
  
  final void updateDensity(Resources paramResources)
  {
    if (paramResources != null)
    {
      this.mSourceRes = paramResources;
      int i = DrawableContainer.resolveDensity(paramResources, this.mDensity);
      int j = this.mDensity;
      this.mDensity = i;
      if (j != i)
      {
        this.mCheckedConstantSize = false;
        this.mCheckedPadding = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
 * JD-Core Version:    0.7.0.1
 */
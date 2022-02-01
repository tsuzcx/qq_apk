package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;

class AnimatedStateListDrawableCompat$AnimatedStateListState
  extends StateListDrawable.StateListState
{
  private static final long REVERSED_BIT = 4294967296L;
  private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
  SparseArrayCompat<Integer> mStateIds;
  LongSparseArray<Long> mTransitions;
  
  AnimatedStateListDrawableCompat$AnimatedStateListState(@Nullable AnimatedStateListState paramAnimatedStateListState, @NonNull AnimatedStateListDrawableCompat paramAnimatedStateListDrawableCompat, @Nullable Resources paramResources)
  {
    super(paramAnimatedStateListState, paramAnimatedStateListDrawableCompat, paramResources);
    if (paramAnimatedStateListState != null)
    {
      this.mTransitions = paramAnimatedStateListState.mTransitions;
      this.mStateIds = paramAnimatedStateListState.mStateIds;
      return;
    }
    this.mTransitions = new LongSparseArray();
    this.mStateIds = new SparseArrayCompat();
  }
  
  private static long generateTransitionKey(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 | l << 32;
  }
  
  int addStateSet(@NonNull int[] paramArrayOfInt, @NonNull Drawable paramDrawable, int paramInt)
  {
    int i = super.addStateSet(paramArrayOfInt, paramDrawable);
    this.mStateIds.put(i, Integer.valueOf(paramInt));
    return i;
  }
  
  int addTransition(int paramInt1, int paramInt2, @NonNull Drawable paramDrawable, boolean paramBoolean)
  {
    int i = super.addChild(paramDrawable);
    long l2 = generateTransitionKey(paramInt1, paramInt2);
    long l1;
    if (paramBoolean) {
      l1 = 8589934592L;
    } else {
      l1 = 0L;
    }
    paramDrawable = this.mTransitions;
    long l3 = i;
    paramDrawable.append(l2, Long.valueOf(l3 | l1));
    if (paramBoolean)
    {
      l2 = generateTransitionKey(paramInt2, paramInt1);
      this.mTransitions.append(l2, Long.valueOf(0x0 | l3 | l1));
    }
    return i;
  }
  
  int getKeyframeIdAt(int paramInt)
  {
    if (paramInt < 0) {
      return 0;
    }
    return ((Integer)this.mStateIds.get(paramInt, Integer.valueOf(0))).intValue();
  }
  
  int indexOfKeyframe(@NonNull int[] paramArrayOfInt)
  {
    int i = super.indexOfStateSet(paramArrayOfInt);
    if (i >= 0) {
      return i;
    }
    return super.indexOfStateSet(StateSet.WILD_CARD);
  }
  
  int indexOfTransition(int paramInt1, int paramInt2)
  {
    long l = generateTransitionKey(paramInt1, paramInt2);
    return (int)((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue();
  }
  
  boolean isTransitionReversed(int paramInt1, int paramInt2)
  {
    long l = generateTransitionKey(paramInt1, paramInt2);
    return (((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L;
  }
  
  void mutate()
  {
    this.mTransitions = this.mTransitions.clone();
    this.mStateIds = this.mStateIds.clone();
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new AnimatedStateListDrawableCompat(this, null);
  }
  
  @NonNull
  public Drawable newDrawable(Resources paramResources)
  {
    return new AnimatedStateListDrawableCompat(this, paramResources);
  }
  
  boolean transitionHasReversibleFlag(int paramInt1, int paramInt2)
  {
    long l = generateTransitionKey(paramInt1, paramInt2);
    return (((Long)this.mTransitions.get(l, Long.valueOf(-1L))).longValue() & 0x0) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.AnimatedStateListState
 * JD-Core Version:    0.7.0.1
 */
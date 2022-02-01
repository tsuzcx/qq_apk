package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.annotation.NonNull;

class StateListDrawable$StateListState
  extends DrawableContainer.DrawableContainerState
{
  int[][] mStateSets;
  
  StateListDrawable$StateListState(StateListState paramStateListState, StateListDrawable paramStateListDrawable, Resources paramResources)
  {
    super(paramStateListState, paramStateListDrawable, paramResources);
    if (paramStateListState != null)
    {
      this.mStateSets = paramStateListState.mStateSets;
      return;
    }
    this.mStateSets = new int[getCapacity()][];
  }
  
  int addStateSet(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    int i = addChild(paramDrawable);
    this.mStateSets[i] = paramArrayOfInt;
    return i;
  }
  
  public void growArray(int paramInt1, int paramInt2)
  {
    super.growArray(paramInt1, paramInt2);
    int[][] arrayOfInt = new int[paramInt2][];
    System.arraycopy(this.mStateSets, 0, arrayOfInt, 0, paramInt1);
    this.mStateSets = arrayOfInt;
  }
  
  int indexOfStateSet(int[] paramArrayOfInt)
  {
    int[][] arrayOfInt = this.mStateSets;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  void mutate()
  {
    Object localObject = this.mStateSets;
    int[][] arrayOfInt = new int[localObject.length][];
    int i = localObject.length - 1;
    while (i >= 0)
    {
      localObject = this.mStateSets;
      if (localObject[i] != null) {
        localObject = (int[])localObject[i].clone();
      } else {
        localObject = null;
      }
      arrayOfInt[i] = localObject;
      i -= 1;
    }
    this.mStateSets = arrayOfInt;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new StateListDrawable(this, null);
  }
  
  @NonNull
  public Drawable newDrawable(Resources paramResources)
  {
    return new StateListDrawable(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.StateListDrawable.StateListState
 * JD-Core Version:    0.7.0.1
 */
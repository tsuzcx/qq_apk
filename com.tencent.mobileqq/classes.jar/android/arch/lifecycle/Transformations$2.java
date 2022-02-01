package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.Nullable;

final class Transformations$2
  implements Observer<X>
{
  LiveData<Y> mSource;
  
  Transformations$2(Function paramFunction, MediatorLiveData paramMediatorLiveData) {}
  
  public void onChanged(@Nullable X paramX)
  {
    paramX = (LiveData)this.val$func.apply(paramX);
    LiveData localLiveData = this.mSource;
    if (localLiveData == paramX) {
      return;
    }
    if (localLiveData != null) {
      this.val$result.removeSource(localLiveData);
    }
    this.mSource = paramX;
    paramX = this.mSource;
    if (paramX != null) {
      this.val$result.addSource(paramX, new Transformations.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.Transformations.2
 * JD-Core Version:    0.7.0.1
 */
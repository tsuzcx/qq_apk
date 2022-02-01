package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

final class Transformations$2
  implements Observer<X>
{
  LiveData<Y> mSource;
  
  Transformations$2(Function paramFunction, MediatorLiveData paramMediatorLiveData) {}
  
  public void onChanged(@Nullable X paramX)
  {
    paramX = (LiveData)this.val$switchMapFunction.apply(paramX);
    if (this.mSource == paramX) {}
    do
    {
      return;
      if (this.mSource != null) {
        this.val$result.removeSource(this.mSource);
      }
      this.mSource = paramX;
    } while (this.mSource == null);
    this.val$result.addSource(this.mSource, new Transformations.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.Transformations.2
 * JD-Core Version:    0.7.0.1
 */
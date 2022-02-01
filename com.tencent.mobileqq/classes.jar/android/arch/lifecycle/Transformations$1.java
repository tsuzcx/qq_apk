package android.arch.lifecycle;

import android.arch.core.util.Function;
import android.support.annotation.Nullable;

final class Transformations$1
  implements Observer<X>
{
  Transformations$1(MediatorLiveData paramMediatorLiveData, Function paramFunction) {}
  
  public void onChanged(@Nullable X paramX)
  {
    this.val$result.setValue(this.val$func.apply(paramX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.Transformations.1
 * JD-Core Version:    0.7.0.1
 */
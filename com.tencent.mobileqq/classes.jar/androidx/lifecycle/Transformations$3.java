package androidx.lifecycle;

final class Transformations$3
  implements Observer<X>
{
  boolean mFirstTime = true;
  
  Transformations$3(MediatorLiveData paramMediatorLiveData) {}
  
  public void onChanged(X paramX)
  {
    Object localObject = this.val$outputLiveData.getValue();
    if ((this.mFirstTime) || ((localObject == null) && (paramX != null)) || ((localObject != null) && (!localObject.equals(paramX))))
    {
      this.mFirstTime = false;
      this.val$outputLiveData.setValue(paramX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.Transformations.3
 * JD-Core Version:    0.7.0.1
 */
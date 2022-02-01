package androidx.lifecycle;

public class MutableLiveData<T>
  extends LiveData<T>
{
  public MutableLiveData() {}
  
  public MutableLiveData(T paramT)
  {
    super(paramT);
  }
  
  public void postValue(T paramT)
  {
    super.postValue(paramT);
  }
  
  public void setValue(T paramT)
  {
    super.setValue(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.MutableLiveData
 * JD-Core Version:    0.7.0.1
 */
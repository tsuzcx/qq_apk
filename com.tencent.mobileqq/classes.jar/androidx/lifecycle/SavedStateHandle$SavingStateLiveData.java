package androidx.lifecycle;

import java.util.Map;

class SavedStateHandle$SavingStateLiveData<T>
  extends MutableLiveData<T>
{
  private SavedStateHandle mHandle;
  private String mKey;
  
  SavedStateHandle$SavingStateLiveData(SavedStateHandle paramSavedStateHandle, String paramString)
  {
    this.mKey = paramString;
    this.mHandle = paramSavedStateHandle;
  }
  
  SavedStateHandle$SavingStateLiveData(SavedStateHandle paramSavedStateHandle, String paramString, T paramT)
  {
    super(paramT);
    this.mKey = paramString;
    this.mHandle = paramSavedStateHandle;
  }
  
  void detach()
  {
    this.mHandle = null;
  }
  
  public void setValue(T paramT)
  {
    SavedStateHandle localSavedStateHandle = this.mHandle;
    if (localSavedStateHandle != null) {
      localSavedStateHandle.mRegular.put(this.mKey, paramT);
    }
    super.setValue(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandle.SavingStateLiveData
 * JD-Core Version:    0.7.0.1
 */
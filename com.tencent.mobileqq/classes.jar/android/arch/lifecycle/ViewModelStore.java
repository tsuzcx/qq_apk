package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ViewModelStore
{
  private final HashMap<String, ViewModel> mMap = new HashMap();
  
  public final void clear()
  {
    Iterator localIterator = this.mMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).onCleared();
    }
    this.mMap.clear();
  }
  
  final ViewModel get(String paramString)
  {
    return (ViewModel)this.mMap.get(paramString);
  }
  
  final void put(String paramString, ViewModel paramViewModel)
  {
    paramString = (ViewModel)this.mMap.put(paramString, paramViewModel);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelStore
 * JD-Core Version:    0.7.0.1
 */
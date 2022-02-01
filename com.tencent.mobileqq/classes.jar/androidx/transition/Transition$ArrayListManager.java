package androidx.transition;

import java.util.ArrayList;

class Transition$ArrayListManager
{
  static <T> ArrayList<T> add(ArrayList<T> paramArrayList, T paramT)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if (!((ArrayList)localObject).contains(paramT)) {
      ((ArrayList)localObject).add(paramT);
    }
    return localObject;
  }
  
  static <T> ArrayList<T> remove(ArrayList<T> paramArrayList, T paramT)
  {
    ArrayList<T> localArrayList = paramArrayList;
    if (paramArrayList != null)
    {
      paramArrayList.remove(paramT);
      localArrayList = paramArrayList;
      if (paramArrayList.isEmpty()) {
        localArrayList = null;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Transition.ArrayListManager
 * JD-Core Version:    0.7.0.1
 */
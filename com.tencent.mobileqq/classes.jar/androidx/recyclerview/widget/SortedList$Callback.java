package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import java.util.Comparator;

public abstract class SortedList$Callback<T2>
  implements ListUpdateCallback, Comparator<T2>
{
  public abstract boolean areContentsTheSame(T2 paramT21, T2 paramT22);
  
  public abstract boolean areItemsTheSame(T2 paramT21, T2 paramT22);
  
  public abstract int compare(T2 paramT21, T2 paramT22);
  
  @Nullable
  public Object getChangePayload(T2 paramT21, T2 paramT22)
  {
    return null;
  }
  
  public abstract void onChanged(int paramInt1, int paramInt2);
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    onChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.SortedList.Callback
 * JD-Core Version:    0.7.0.1
 */
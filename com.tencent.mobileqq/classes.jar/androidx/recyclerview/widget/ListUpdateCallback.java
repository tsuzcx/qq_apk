package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public abstract interface ListUpdateCallback
{
  public abstract void onChanged(int paramInt1, int paramInt2, @Nullable Object paramObject);
  
  public abstract void onInserted(int paramInt1, int paramInt2);
  
  public abstract void onMoved(int paramInt1, int paramInt2);
  
  public abstract void onRemoved(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.ListUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public abstract class DiffUtil$Callback
{
  public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
  
  public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
  
  @Nullable
  public Object getChangePayload(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public abstract int getNewListSize();
  
  public abstract int getOldListSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil.Callback
 * JD-Core Version:    0.7.0.1
 */
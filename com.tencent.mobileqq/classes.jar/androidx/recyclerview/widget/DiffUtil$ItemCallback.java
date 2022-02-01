package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class DiffUtil$ItemCallback<T>
{
  public abstract boolean areContentsTheSame(@NonNull T paramT1, @NonNull T paramT2);
  
  public abstract boolean areItemsTheSame(@NonNull T paramT1, @NonNull T paramT2);
  
  @Nullable
  public Object getChangePayload(@NonNull T paramT1, @NonNull T paramT2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil.ItemCallback
 * JD-Core Version:    0.7.0.1
 */
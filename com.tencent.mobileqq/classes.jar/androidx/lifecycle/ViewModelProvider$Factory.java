package androidx.lifecycle;

import androidx.annotation.NonNull;

public abstract interface ViewModelProvider$Factory
{
  @NonNull
  public abstract <T extends ViewModel> T create(@NonNull Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.Factory
 * JD-Core Version:    0.7.0.1
 */
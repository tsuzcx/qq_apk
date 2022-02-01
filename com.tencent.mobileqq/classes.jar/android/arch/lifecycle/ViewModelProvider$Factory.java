package android.arch.lifecycle;

import android.support.annotation.NonNull;

public abstract interface ViewModelProvider$Factory
{
  @NonNull
  public abstract <T extends ViewModel> T create(@NonNull Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider.Factory
 * JD-Core Version:    0.7.0.1
 */
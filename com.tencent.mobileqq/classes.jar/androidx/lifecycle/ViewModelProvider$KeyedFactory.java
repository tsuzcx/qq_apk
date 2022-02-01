package androidx.lifecycle;

import androidx.annotation.NonNull;

abstract class ViewModelProvider$KeyedFactory
  extends ViewModelProvider.OnRequeryFactory
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
  }
  
  @NonNull
  public abstract <T extends ViewModel> T create(@NonNull String paramString, @NonNull Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ViewModelProvider.KeyedFactory
 * JD-Core Version:    0.7.0.1
 */
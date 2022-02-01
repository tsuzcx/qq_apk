package androidx.core.view;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;

public final class WindowInsetsCompat$Builder
{
  private final WindowInsetsCompat.BuilderImpl mImpl;
  
  public WindowInsetsCompat$Builder()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mImpl = new WindowInsetsCompat.BuilderImpl29();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.mImpl = new WindowInsetsCompat.BuilderImpl20();
      return;
    }
    this.mImpl = new WindowInsetsCompat.BuilderImpl();
  }
  
  public WindowInsetsCompat$Builder(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mImpl = new WindowInsetsCompat.BuilderImpl29(paramWindowInsetsCompat);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.mImpl = new WindowInsetsCompat.BuilderImpl20(paramWindowInsetsCompat);
      return;
    }
    this.mImpl = new WindowInsetsCompat.BuilderImpl(paramWindowInsetsCompat);
  }
  
  @NonNull
  public WindowInsetsCompat build()
  {
    return this.mImpl.build();
  }
  
  @NonNull
  public Builder setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat)
  {
    this.mImpl.setDisplayCutout(paramDisplayCutoutCompat);
    return this;
  }
  
  @NonNull
  public Builder setMandatorySystemGestureInsets(@NonNull Insets paramInsets)
  {
    this.mImpl.setMandatorySystemGestureInsets(paramInsets);
    return this;
  }
  
  @NonNull
  public Builder setStableInsets(@NonNull Insets paramInsets)
  {
    this.mImpl.setStableInsets(paramInsets);
    return this;
  }
  
  @NonNull
  public Builder setSystemGestureInsets(@NonNull Insets paramInsets)
  {
    this.mImpl.setSystemGestureInsets(paramInsets);
    return this;
  }
  
  @NonNull
  public Builder setSystemWindowInsets(@NonNull Insets paramInsets)
  {
    this.mImpl.setSystemWindowInsets(paramInsets);
    return this;
  }
  
  @NonNull
  public Builder setTappableElementInsets(@NonNull Insets paramInsets)
  {
    this.mImpl.setTappableElementInsets(paramInsets);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.WindowInsetsCompat.Builder
 * JD-Core Version:    0.7.0.1
 */
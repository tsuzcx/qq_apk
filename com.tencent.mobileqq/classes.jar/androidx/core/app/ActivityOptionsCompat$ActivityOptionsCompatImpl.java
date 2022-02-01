package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
class ActivityOptionsCompat$ActivityOptionsCompatImpl
  extends ActivityOptionsCompat
{
  private final ActivityOptions mActivityOptions;
  
  ActivityOptionsCompat$ActivityOptionsCompatImpl(ActivityOptions paramActivityOptions)
  {
    this.mActivityOptions = paramActivityOptions;
  }
  
  public Rect getLaunchBounds()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return null;
    }
    return this.mActivityOptions.getLaunchBounds();
  }
  
  public void requestUsageTimeReport(@NonNull PendingIntent paramPendingIntent)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.mActivityOptions.requestUsageTimeReport(paramPendingIntent);
    }
  }
  
  @NonNull
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return this;
    }
    return new ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(paramRect));
  }
  
  public Bundle toBundle()
  {
    return this.mActivityOptions.toBundle();
  }
  
  public void update(@NonNull ActivityOptionsCompat paramActivityOptionsCompat)
  {
    if ((paramActivityOptionsCompat instanceof ActivityOptionsCompatImpl))
    {
      paramActivityOptionsCompat = (ActivityOptionsCompatImpl)paramActivityOptionsCompat;
      this.mActivityOptions.update(paramActivityOptionsCompat.mActivityOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl
 * JD-Core Version:    0.7.0.1
 */
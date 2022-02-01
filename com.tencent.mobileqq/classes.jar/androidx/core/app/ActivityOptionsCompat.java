package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ActivityOptionsCompat
{
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  @NonNull
  public static ActivityOptionsCompat makeBasic()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, @NonNull View paramView, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity paramActivity, androidx.core.util.Pair<View, String>... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = null;
      if (paramVarArgs != null)
      {
        android.util.Pair[] arrayOfPair = new android.util.Pair[paramVarArgs.length];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfPair;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfPair[i] = android.util.Pair.create(paramVarArgs[i].first, paramVarArgs[i].second);
          i += 1;
        }
      }
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeTaskLaunchBehind()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }
    return new ActivityOptionsCompat();
  }
  
  @NonNull
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View paramView, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  @Nullable
  public Rect getLaunchBounds()
  {
    return null;
  }
  
  public void requestUsageTimeReport(@NonNull PendingIntent paramPendingIntent) {}
  
  @NonNull
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
  {
    return this;
  }
  
  @Nullable
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(@NonNull ActivityOptionsCompat paramActivityOptionsCompat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ActivityOptionsCompat
 * JD-Core Version:    0.7.0.1
 */
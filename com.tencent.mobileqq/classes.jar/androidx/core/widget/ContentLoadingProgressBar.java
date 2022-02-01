package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  private static final int MIN_DELAY = 500;
  private static final int MIN_SHOW_TIME = 500;
  private final Runnable mDelayedHide = new ContentLoadingProgressBar.1(this);
  private final Runnable mDelayedShow = new ContentLoadingProgressBar.2(this);
  boolean mDismissed = false;
  boolean mPostedHide = false;
  boolean mPostedShow = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void removeCallbacks()
  {
    removeCallbacks(this.mDelayedHide);
    removeCallbacks(this.mDelayedShow);
  }
  
  public void hide()
  {
    try
    {
      this.mDismissed = true;
      removeCallbacks(this.mDelayedShow);
      this.mPostedShow = false;
      long l = System.currentTimeMillis() - this.mStartTime;
      if ((l < 500L) && (this.mStartTime != -1L))
      {
        if (!this.mPostedHide)
        {
          postDelayed(this.mDelayedHide, 500L - l);
          this.mPostedHide = true;
        }
      }
      else {
        setVisibility(8);
      }
      return;
    }
    finally {}
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }
  
  public void show()
  {
    try
    {
      this.mStartTime = -1L;
      this.mDismissed = false;
      removeCallbacks(this.mDelayedHide);
      this.mPostedHide = false;
      if (!this.mPostedShow)
      {
        postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */
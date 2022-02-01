package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.mobileqq.util.OrientationUtil;
import java.lang.ref.WeakReference;

public class FlingTrackerHandler
  extends FlingHandler
  implements TopLayout.OnDraggingListener
{
  private ImageView mBackImageView;
  private ContentWrapView mContentWrapView;
  private int mCount;
  private Handler mHandler = new Handler();
  private View mInnerView;
  private TopLayout mTopView;
  private Runnable mWrapContentTaskRunnable = new FlingTrackerHandler.1(this);
  
  public FlingTrackerHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private int calculateInSamplePowerSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int m = 1;
    int i = 1;
    if ((paramInt1 & paramInt2) != 0)
    {
      if ((paramInt1 | paramInt2) == -1) {
        return 1;
      }
      int j = paramOptions.outHeight;
      int k = paramOptions.outWidth;
      for (;;)
      {
        if (j <= paramInt2)
        {
          m = i;
          if (k <= paramInt1) {
            break;
          }
        }
        int n = Math.round(j / paramInt2);
        m = Math.round(k / paramInt1);
        if (n <= m) {
          n = m;
        }
        m = i;
        if (n < 2) {
          break;
        }
        k /= 2;
        j /= 2;
        i *= 2;
      }
    }
    return m;
  }
  
  private String getSnapFilePath()
  {
    Activity localActivity = (Activity)this.mWrappedActivity.get();
    if (localActivity != null) {
      return ScreenCapture.getSnapPath(localActivity, getFlingCode());
    }
    return null;
  }
  
  /* Error */
  private void loadBackViewSnap()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 120	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:getSnapFilePath	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 70	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:mBackImageView	Landroid/widget/ImageView;
    //   14: invokevirtual 125	android/widget/ImageView:getMeasuredWidth	()I
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 70	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:mBackImageView	Landroid/widget/ImageView;
    //   22: invokevirtual 128	android/widget/ImageView:getMeasuredHeight	()I
    //   25: istore_2
    //   26: aload_0
    //   27: aload_3
    //   28: iload_1
    //   29: iload_2
    //   30: invokevirtual 132	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:decodeSampledBitmapFromFile	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +15 -> 50
    //   38: aload_0
    //   39: getfield 70	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:mBackImageView	Landroid/widget/ImageView;
    //   42: aload_3
    //   43: invokevirtual 136	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   46: return
    //   47: astore_3
    //   48: aload_3
    //   49: athrow
    //   50: return
    //   51: astore_3
    //   52: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	FlingTrackerHandler
    //   17	12	1	i	int
    //   25	5	2	j	int
    //   4	39	3	localObject1	Object
    //   47	2	3	localObject2	Object
    //   51	1	3	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   26	34	47	finally
    //   26	34	51	java/lang/OutOfMemoryError
  }
  
  public void cancelDrag()
  {
    OrientationUtil.b((Activity)this.mWrappedActivity.get());
  }
  
  public Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSamplePowerSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      label50:
      break label50;
    }
    return null;
  }
  
  public void endDrag()
  {
    Activity localActivity = (Activity)this.mWrappedActivity.get();
    if (localActivity != null)
    {
      OrientationUtil.b(localActivity);
      localActivity.onBackPressed();
      localActivity.overridePendingTransition(2130772101, 2130772101);
    }
  }
  
  protected boolean isWrapped()
  {
    TopLayout localTopLayout = this.mTopView;
    return (localTopLayout != null) && (localTopLayout.getParent() != null);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (isWrapped()) {
      this.mTopView.onConfigChanged(paramConfiguration);
    }
  }
  
  public void startDrag()
  {
    OrientationUtil.a((Activity)this.mWrappedActivity.get());
  }
  
  protected void unwrap()
  {
    Object localObject = (Activity)this.mWrappedActivity.get();
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
    if ((isWrapped()) && (this.mTopView.getParent().equals(localObject)))
    {
      ((ViewGroup)localObject).removeView(this.mTopView);
      if ((this.mContentWrapView != null) && (this.mInnerView.getParent().equals(this.mContentWrapView)))
      {
        this.mContentWrapView.removeView(this.mInnerView);
        ((ViewGroup)localObject).addView(this.mInnerView);
      }
      localObject = this.mBackImageView;
      if ((localObject != null) && (((ImageView)localObject).getDrawable() != null))
      {
        localObject = this.mBackImageView.getDrawable();
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            ((Bitmap)localObject).recycle();
          }
        }
        this.mBackImageView.setImageDrawable(null);
      }
    }
    localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.mWrapContentTaskRunnable);
    }
  }
  
  protected void wrap()
  {
    if (canWrapContent())
    {
      Handler localHandler = this.mHandler;
      if (localHandler != null) {
        localHandler.postDelayed(this.mWrapContentTaskRunnable, 100L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler
 * JD-Core Version:    0.7.0.1
 */
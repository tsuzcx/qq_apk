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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContentWrapView jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView;
  private TopLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable = new FlingTrackerHandler.1(this);
  
  public FlingTrackerHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
  
  private String a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      return ScreenCapture.getSnapPath(localActivity, a());
    }
    return null;
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 98	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:a	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   14: invokevirtual 103	android/widget/ImageView:getMeasuredWidth	()I
    //   17: istore_1
    //   18: aload_0
    //   19: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   22: invokevirtual 106	android/widget/ImageView:getMeasuredHeight	()I
    //   25: istore_2
    //   26: aload_0
    //   27: aload_3
    //   28: iload_1
    //   29: iload_2
    //   30: invokevirtual 110	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:decodeSampledBitmapFromFile	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +15 -> 50
    //   38: aload_0
    //   39: getfield 60	com/tencent/mobileqq/activity/fling/FlingTrackerHandler:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   42: aload_3
    //   43: invokevirtual 114	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
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
  
  protected void a()
  {
    if (a())
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
    }
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.getParent().equals(localObject)))
    {
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView != null) && (this.jdField_a_of_type_AndroidViewView.getParent().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingContentWrapView.removeView(this.jdField_a_of_type_AndroidViewView);
        ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localObject != null) && (((ImageView)localObject).getDrawable() != null))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
        if ((localObject instanceof BitmapDrawable))
        {
          localObject = ((BitmapDrawable)localObject).getBitmap();
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            ((Bitmap)localObject).recycle();
          }
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  protected boolean b()
  {
    TopLayout localTopLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout;
    return (localTopLayout != null) && (localTopLayout.getParent() != null);
  }
  
  public void cancelDrag()
  {
    OrientationUtil.b((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
  
  public Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
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
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      OrientationUtil.b(localActivity);
      localActivity.onBackPressed();
      localActivity.overridePendingTransition(2130772071, 2130772071);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopLayout.onConfigChanged(paramConfiguration);
    }
  }
  
  public void startDrag()
  {
    OrientationUtil.a((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

class FlingTrackerHandler$1
  implements Runnable
{
  FlingTrackerHandler$1(FlingTrackerHandler paramFlingTrackerHandler) {}
  
  public void run()
  {
    Object localObject1 = (Activity)this.this$0.a.get();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      if (!ScreenCapture.hasSnapFile((Context)localObject1))
      {
        if (FlingTrackerHandler.a(this.this$0) > 5) {
          FlingTrackerHandler.a(this.this$0, 0);
        }
      }
      else
      {
        localObject2 = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
        if (FlingTrackerHandler.a(this.this$0) != null) {
          break label303;
        }
        FlingTrackerHandler.a(this.this$0, ((ViewGroup)localObject2).getChildAt(0));
        View localView = FlingTrackerHandler.a(this.this$0);
        FlingTrackerHandler.a(this.this$0, new TopLayout((Context)localObject1));
        FlingTrackerHandler.a(this.this$0).setBackgroundColor(-16777216);
        TopLayout localTopLayout = FlingTrackerHandler.a(this.this$0);
        localTopLayout.setOnDraggingListener(this.this$0);
        ((ViewGroup)localObject2).addView(localTopLayout);
        ((ViewGroup)localObject2).removeView(localView);
        FlingTrackerHandler.a(this.this$0, new ContentWrapView((Context)localObject1));
        localObject2 = FlingTrackerHandler.a(this.this$0);
        ((ContentWrapView)localObject2).addView(localView);
        localTopLayout.setContent((ContentWrapView)localObject2);
        FlingTrackerHandler.a(this.this$0, new ImageView((Context)localObject1));
        FlingTrackerHandler.a(this.this$0).setScaleType(ImageView.ScaleType.FIT_START);
        localObject1 = FlingTrackerHandler.a(this.this$0);
        ((ImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        localTopLayout.setBehind((View)localObject1);
      }
      while ((this.this$0.b()) && (FlingTrackerHandler.a(this.this$0) != null) && (FlingTrackerHandler.a(this.this$0).getDrawable() == null))
      {
        FlingTrackerHandler.a(this.this$0);
        return;
        FlingTrackerHandler.b(this.this$0);
        FlingTrackerHandler.a(this.this$0).postDelayed(this, 100L);
        return;
        label303:
        if (!this.this$0.b())
        {
          ((ViewGroup)localObject2).addView(FlingTrackerHandler.a(this.this$0));
          ((ViewGroup)localObject2).removeView(FlingTrackerHandler.a(this.this$0));
          FlingTrackerHandler.a(this.this$0).addView(FlingTrackerHandler.a(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler.1
 * JD-Core Version:    0.7.0.1
 */
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
    Object localObject1 = (Activity)this.this$0.mWrappedActivity.get();
    if (localObject1 == null) {
      return;
    }
    if (!ScreenCapture.hasSnapFile((Context)localObject1)) {
      if (FlingTrackerHandler.access$000(this.this$0) > 5)
      {
        FlingTrackerHandler.access$002(this.this$0, 0);
      }
      else
      {
        FlingTrackerHandler.access$008(this.this$0);
        FlingTrackerHandler.access$100(this.this$0).postDelayed(this, 100L);
        return;
      }
    }
    Object localObject2 = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
    if (FlingTrackerHandler.access$200(this.this$0) == null)
    {
      FlingTrackerHandler.access$302(this.this$0, ((ViewGroup)localObject2).getChildAt(0));
      View localView = FlingTrackerHandler.access$300(this.this$0);
      FlingTrackerHandler.access$202(this.this$0, new TopLayout((Context)localObject1));
      FlingTrackerHandler.access$200(this.this$0).setBackgroundColor(-16777216);
      TopLayout localTopLayout = FlingTrackerHandler.access$200(this.this$0);
      localTopLayout.setOnDraggingListener(this.this$0);
      ((ViewGroup)localObject2).addView(localTopLayout);
      ((ViewGroup)localObject2).removeView(localView);
      FlingTrackerHandler.access$402(this.this$0, new ContentWrapView((Context)localObject1));
      localObject2 = FlingTrackerHandler.access$400(this.this$0);
      ((ContentWrapView)localObject2).addView(localView);
      localTopLayout.setContent((ContentWrapView)localObject2);
      FlingTrackerHandler.access$502(this.this$0, new ImageView((Context)localObject1));
      FlingTrackerHandler.access$500(this.this$0).setScaleType(ImageView.ScaleType.FIT_START);
      localObject1 = FlingTrackerHandler.access$500(this.this$0);
      ((ImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localTopLayout.setBehind((View)localObject1);
    }
    else if (!this.this$0.isWrapped())
    {
      ((ViewGroup)localObject2).addView(FlingTrackerHandler.access$200(this.this$0));
      ((ViewGroup)localObject2).removeView(FlingTrackerHandler.access$300(this.this$0));
      FlingTrackerHandler.access$400(this.this$0).addView(FlingTrackerHandler.access$300(this.this$0));
    }
    if ((this.this$0.isWrapped()) && (FlingTrackerHandler.access$500(this.this$0) != null) && (FlingTrackerHandler.access$500(this.this$0).getDrawable() == null)) {
      FlingTrackerHandler.access$600(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingTrackerHandler.1
 * JD-Core Version:    0.7.0.1
 */
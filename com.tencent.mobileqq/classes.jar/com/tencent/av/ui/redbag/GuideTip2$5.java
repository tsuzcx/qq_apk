package com.tencent.av.ui.redbag;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import mqg;

public class GuideTip2$5
  implements Runnable
{
  public GuideTip2$5(mqg parammqg, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if (localObject != null)
    {
      localObject = (RelativeLayout)((Activity)localObject).findViewById(2131367754);
      if (Build.VERSION.SDK_INT < 16) {
        break label118;
      }
      ((RelativeLayout)localObject).findViewById(2131367755).setBackground(null);
      ((RelativeLayout)localObject).findViewById(2131367756).setBackground(null);
    }
    for (;;)
    {
      this.a.removeView(this.b);
      if (this.this$0.a != null)
      {
        this.this$0.a.recycle();
        this.this$0.a = null;
      }
      if (this.this$0.b != null)
      {
        this.this$0.b.recycle();
        this.this$0.b = null;
      }
      return;
      label118:
      ((RelativeLayout)localObject).findViewById(2131367755).setBackgroundDrawable(null);
      ((RelativeLayout)localObject).findViewById(2131367756).setBackgroundDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2.5
 * JD-Core Version:    0.7.0.1
 */
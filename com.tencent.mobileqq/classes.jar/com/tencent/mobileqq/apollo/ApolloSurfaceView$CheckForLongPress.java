package com.tencent.mobileqq.apollo;

import aiil;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloSurfaceView$CheckForLongPress
  implements Runnable
{
  private int a;
  
  ApolloSurfaceView$CheckForLongPress(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void a()
  {
    this.a = ApolloSurfaceView.access$601(this.this$0);
  }
  
  public void run()
  {
    if (ApolloSurfaceView.access$100(this.this$0) == null) {}
    aiil localaiil;
    do
    {
      do
      {
        do
        {
          return;
          localaiil = (aiil)ApolloSurfaceView.access$100(this.this$0).get();
        } while (localaiil == null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSurfaceView", 2, "CheckForLongPress onLongClick");
        }
      } while (this.a != ApolloSurfaceView.access$201(this.this$0));
      ApolloSurfaceView.access$302(this.this$0, true);
      ApolloSurfaceView.access$401(this.this$0, 2);
    } while ((TextUtils.isEmpty(this.this$0.mApolloId)) || (ApolloSurfaceView.access$500(this.this$0) < 0) || (localaiil == null));
    localaiil.onNotifyLongTouch(this.this$0.mApolloId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.ARPromotion;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionUIContainer
{
  private Context a;
  private FrameLayout b;
  private TextView c;
  private volatile boolean d = false;
  
  public ARTransferPromotionUIContainer(Context paramContext)
  {
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    this.b = ((FrameLayout)LayoutInflater.from(this.a).inflate(2131627300, null));
    this.c = ((TextView)this.b.findViewById(2131450245));
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "attachToRootViewGroup");
    if (this.d) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.b(57.0F, this.a.getResources());
    paramRelativeLayout.addView(this.b, localLayoutParams);
    this.d = true;
  }
  
  public void a(String paramString)
  {
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public void b(RelativeLayout paramRelativeLayout)
  {
    QLog.d("ARTransferPromotionUIContainer", 2, "disattachFromRootViewGroup");
    if (!this.d) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRelativeLayout.removeView(this.b);
      this.d = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferPromotionUIContainer
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountDownView
  extends RelativeLayout
{
  private static final String a = "CountDownView";
  private TextView b;
  private Animation c;
  private PlayerUtil.Player d;
  private PlayerUtil.Player e;
  private int f = 0;
  private boolean g;
  private AtomicBoolean h = new AtomicBoolean(true);
  private CountDownView.OnCountDownListener i;
  private Handler j = new CountDownView.MainHandler(this);
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = AnimationUtils.loadAnimation(paramContext, 2063663106);
  }
  
  private void a(int paramInt)
  {
    this.f = paramInt;
    Object localObject;
    if (paramInt == 0)
    {
      setVisibility(4);
      localObject = this.i;
      if (localObject != null) {
        ((CountDownView.OnCountDownListener)localObject).b();
      }
    }
    else
    {
      localObject = String.format(getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(paramInt) });
      this.b.setText((CharSequence)localObject);
      this.c.reset();
      this.b.clearAnimation();
      this.b.startAnimation(this.c);
      if (this.g)
      {
        if (this.h.get())
        {
          this.h.set(false);
          try
          {
            Thread.sleep(150L);
          }
          catch (InterruptedException localInterruptedException)
          {
            LogUtils.e(localInterruptedException);
          }
        }
        if (paramInt == 1) {
          PlayerUtil.startPlayer(this.d, true);
        } else if (paramInt <= 3) {
          PlayerUtil.startPlayer(this.e, true);
        }
      }
      this.j.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a()
  {
    if (this.f > 0)
    {
      this.f = 0;
      this.j.removeMessages(1);
      setVisibility(4);
      CountDownView.OnCountDownListener localOnCountDownListener = this.i;
      if (localOnCountDownListener != null) {
        localOnCountDownListener.a();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid input for countdown timer: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" seconds");
      LogUtils.w(str, localStringBuilder.toString());
      return;
    }
    setVisibility(0);
    this.g = paramBoolean;
    a(paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((TextView)findViewById(2063991361));
  }
  
  public void setCountDownListener(CountDownView.OnCountDownListener paramOnCountDownListener)
  {
    this.i = paramOnCountDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.CountDownView
 * JD-Core Version:    0.7.0.1
 */
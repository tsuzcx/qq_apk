package com.tencent.av.ui.beauty;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVPanelBase;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;

public abstract class BeautyBaseView
  extends RelativeLayout
  implements View.OnClickListener, AVPanelBase, BeautySeekView.ActionListener
{
  VideoAppInterface a;
  long b = 0L;
  
  public BeautyBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautyBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l - this.b) > 200L))
    {
      this.b = l;
      BaseToolbar.keepInToolbar(this.a, -1043L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    if (this.a != paramVideoAppInterface) {
      this.a = paramVideoAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautyBaseView
 * JD-Core Version:    0.7.0.1
 */
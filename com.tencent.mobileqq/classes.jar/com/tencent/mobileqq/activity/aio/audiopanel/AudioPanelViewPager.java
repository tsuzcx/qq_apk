package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelViewPager
  extends ViewPager
{
  public boolean a;
  private AudioPanel b;
  
  public AudioPanelViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public AudioPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(AudioPanel paramAudioPanel)
  {
    this.b = paramAudioPanel;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b.getStatus() == 1) {
      try
      {
        boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onInterceptTouchEvent: ");
          localStringBuilder.append(paramMotionEvent);
          QLog.d("AudioPanelViewPager", 4, localStringBuilder.toString());
          return false;
        }
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        StringBuilder localStringBuilder;
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onInterceptTouchEvent: ");
          localStringBuilder.append(paramMotionEvent);
          QLog.d("AudioPanelViewPager", 4, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelViewPager
 * JD-Core Version:    0.7.0.1
 */
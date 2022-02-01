package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class AudioPanelViewPager
  extends ViewPager
{
  private AudioPanel a;
  public boolean a;
  
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b() == 1) {}
    try
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + paramMotionEvent);
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.d("AudioPanelViewPager", 4, "onInterceptTouchEvent: " + paramMotionEvent);
    }
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelViewPager
 * JD-Core Version:    0.7.0.1
 */
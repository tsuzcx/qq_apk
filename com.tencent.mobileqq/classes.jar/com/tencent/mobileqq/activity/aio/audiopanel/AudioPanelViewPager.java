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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b() == 1) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelViewPager
 * JD-Core Version:    0.7.0.1
 */
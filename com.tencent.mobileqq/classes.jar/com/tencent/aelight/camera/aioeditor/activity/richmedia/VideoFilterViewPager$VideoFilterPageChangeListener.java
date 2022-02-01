package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.qphone.base.util.QLog;

class VideoFilterViewPager$VideoFilterPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  public int a;
  public View a;
  
  VideoFilterViewPager$VideoFilterPageChangeListener(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChanged state: ");
      localStringBuilder.append(paramInt);
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled position: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", positionOffset: ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", positionOffsetPixels: ");
      localStringBuilder.append(paramInt2);
      QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    boolean bool;
    if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.a < 400L) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onPageSelected l ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(",n ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" scroll ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.d = false;
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPageSelected 2 ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(",n");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" scroll ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager) != null) {
      VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a(VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a(paramInt), VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a(paramInt));
    }
    FlowCameraMqqAction.a("", "0X8007804", "", "", "", "");
    if (bool) {}
    try
    {
      localObject1 = VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a(paramInt);
      if (localObject1 != null)
      {
        int i;
        if ((paramInt > this.jdField_a_of_type_Int) && (VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a() != 0) && (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a() != 0))
        {
          if ((paramInt != 0) && (((QIMFilterCategoryItem)localObject1).b()))
          {
            i = paramInt + 1;
            if (i < VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).getCount()) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.setCurrentItem(i, false);
            }
          }
        }
        else if ((((QIMFilterCategoryItem)localObject1).b()) && (VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a() != 0) && (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a() != 0))
        {
          i = paramInt - 1;
          if (i > 0)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.setCurrentItem(i, false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label401:
      Object localObject2;
      break label401;
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1 = VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager).a(paramInt);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPageSelected 3 ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",n");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" pageItem ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 != null)
      {
        localObject2 = (Runnable)((View)localObject2).getTag();
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidViewView.removeCallbacks((Runnable)localObject2);
        }
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      localObject2 = (Runnable)((View)localObject1).getTag();
      if (localObject2 != null)
      {
        ((View)localObject1).removeCallbacks((Runnable)localObject2);
        ((View)localObject1).setTag(null);
      }
      VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager, (View)localObject1, paramInt, bool);
    }
    else if (!VideoFilterViewPager.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager))
    {
      VideoFilterViewPager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager, true);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
    ((VideoFilterViewPager)localObject1).d = false;
    ((VideoFilterViewPager)localObject1).e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.VideoFilterPageChangeListener
 * JD-Core Version:    0.7.0.1
 */
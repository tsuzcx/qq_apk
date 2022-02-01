package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.view.View;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.qphone.base.util.QLog;

class VideoFilterViewPager$VideoFilterPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  public View a;
  public int b;
  
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
    if (System.currentTimeMillis() - this.c.g < 400L) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.b == paramInt)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onPageSelected l ");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(",n ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" scroll ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
      }
      this.c.d = false;
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onPageSelected 2 ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(",n");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" scroll ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject1).toString());
    }
    if (VideoFilterViewPager.j(this.c) != null) {
      VideoFilterViewPager.j(this.c).a(VideoFilterViewPager.k(this.c).b(paramInt), VideoFilterViewPager.k(this.c).a(paramInt));
    }
    FlowCameraMqqAction.a("", "0X8007804", "", "", "", "");
    if (bool) {}
    try
    {
      localObject1 = VideoFilterViewPager.k(this.c).a(paramInt);
      if (localObject1 != null)
      {
        int i;
        if ((paramInt > this.b) && (VideoFilterViewPager.k(this.c).a() != 0) && (paramInt % VideoFilterViewPager.k(this.c).a() != 0))
        {
          if ((paramInt != 0) && (((QIMFilterCategoryItem)localObject1).c()))
          {
            i = paramInt + 1;
            if (i < VideoFilterViewPager.k(this.c).getCount()) {
              this.c.setCurrentItem(i, false);
            }
          }
        }
        else if ((((QIMFilterCategoryItem)localObject1).c()) && (VideoFilterViewPager.k(this.c).a() != 0) && (paramInt % VideoFilterViewPager.k(this.c).a() != 0))
        {
          i = paramInt - 1;
          if (i > 0)
          {
            this.c.setCurrentItem(i, false);
            return;
          }
        }
      }
      if (localObject1 != null) {
        AEBaseDataReporter.a().e(((QIMFilterCategoryItem)localObject1).a, AEProviderViewModel.a(localObject1));
      }
    }
    catch (Exception localException)
    {
      label425:
      Object localObject2;
      break label425;
    }
    this.b = paramInt;
    Object localObject1 = VideoFilterViewPager.k(this.c).c(paramInt);
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
      localObject2 = this.a;
      if (localObject2 != null)
      {
        localObject2 = (Runnable)((View)localObject2).getTag();
        if (localObject2 != null) {
          this.a.removeCallbacks((Runnable)localObject2);
        }
        this.a.clearAnimation();
      }
      localObject2 = (Runnable)((View)localObject1).getTag();
      if (localObject2 != null)
      {
        ((View)localObject1).removeCallbacks((Runnable)localObject2);
        ((View)localObject1).setTag(null);
      }
      VideoFilterViewPager.a(this.c, (View)localObject1, paramInt, bool);
    }
    else if (!VideoFilterViewPager.l(this.c))
    {
      VideoFilterViewPager.a(this.c, true);
    }
    this.a = ((View)localObject1);
    localObject1 = this.c;
    ((VideoFilterViewPager)localObject1).d = false;
    ((VideoFilterViewPager)localObject1).e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.VideoFilterPageChangeListener
 * JD-Core Version:    0.7.0.1
 */
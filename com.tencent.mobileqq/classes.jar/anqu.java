import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.ScrollCallBack;

public class anqu
  implements ViewPager.OnPageChangeListener
{
  public int a;
  public View a;
  
  public anqu(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrollStateChanged state: " + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageScrolled position: " + paramInt1 + ", positionOffset: " + paramFloat + ", positionOffsetPixels: " + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (MediaCodecDPC.l()) {
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.b < 400L) {}
    for (boolean bool = true; this.jdField_a_of_type_Int == paramInt; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.jdField_a_of_type_Int + ",n " + paramInt + " scroll " + bool);
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.c = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelected 2 " + this.jdField_a_of_type_Int + ",n" + paramInt + " scroll " + bool);
    }
    if ((bool) && (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager) != null)) {
      VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).B();
    }
    FlowCameraMqqAction.a("", "0X8007804", "", "", "", "");
    View localView;
    if (bool)
    {
      try
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(paramInt);
        if (localQIMFilterCategoryItem != null)
        {
          if ((paramInt <= this.jdField_a_of_type_Int) || (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0)) {
            break label402;
          }
          if ((paramInt != 0) && (localQIMFilterCategoryItem.b()) && (paramInt + 1 < VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).getCount()))
          {
            this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt + 1, false);
            return;
          }
        }
      }
      catch (Exception localException) {}
    }
    else
    {
      this.jdField_a_of_type_Int = paramInt;
      localView = VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(paramInt);
      if (localView == null) {
        break label455;
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localRunnable = (Runnable)this.jdField_a_of_type_AndroidViewView.getTag();
        if (localRunnable != null) {
          this.jdField_a_of_type_AndroidViewView.removeCallbacks(localRunnable);
        }
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      Runnable localRunnable = (Runnable)localView.getTag();
      if (localRunnable != null)
      {
        localView.removeCallbacks(localRunnable);
        localView.setTag(null);
      }
      VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager, localView, paramInt, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.c = false;
      return;
      label402:
      if ((!localView.b()) || (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt - 1 <= 0)) {
        break;
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt - 1, false);
      return;
      label455:
      if (!VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager)) {
        VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqu
 * JD-Core Version:    0.7.0.1
 */
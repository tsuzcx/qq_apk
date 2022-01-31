import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class bjaj
  implements ViewPager.OnPageChangeListener
{
  public int a;
  public View a;
  
  public bjaj(VideoFilterViewPager paramVideoFilterViewPager) {}
  
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
    if (awll.l()) {
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a < 400L) {}
    for (boolean bool = true; this.jdField_a_of_type_Int == paramInt; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected l " + this.jdField_a_of_type_Int + ",n " + paramInt + " scroll " + bool);
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.e = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onPageSelected 2 " + this.jdField_a_of_type_Int + ",n" + paramInt + " scroll " + bool);
    }
    if ((bool) && (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager) != null)) {
      VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).t();
    }
    if (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager) != null) {
      VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(paramInt), VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(paramInt));
    }
    biyj.a("", "0X8007804", "", "", "", "");
    View localView;
    if (bool)
    {
      try
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a(paramInt);
        if (localQIMFilterCategoryItem != null)
        {
          if ((paramInt <= this.jdField_a_of_type_Int) || (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0)) {
            break label503;
          }
          if ((paramInt != 0) && (localQIMFilterCategoryItem.c()) && (paramInt + 1 < VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).getCount()))
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
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onPageSelected 3 " + paramInt + ",n" + paramInt + " pageItem " + localView);
      }
      if (localView == null) {
        break label556;
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
      VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager, localView, paramInt, bool);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.e = false;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.f = false;
      return;
      label503:
      if ((!localView.c()) || (VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt % VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager).a() == 0) || (paramInt - 1 <= 0)) {
        break;
      }
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt - 1, false);
      return;
      label556:
      if (!VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager)) {
        VideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjaj
 * JD-Core Version:    0.7.0.1
 */
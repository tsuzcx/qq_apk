package com.tencent.aelight.camera.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.SelectCallBack;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;

public class FilterPagerViewStubHolder
  extends BaseViewStubHolder
{
  private VideoFilterViewPager a;
  
  public FilterPagerViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public CameraViewPagerGesture a()
  {
    CameraViewPagerGesture localCameraViewPagerGesture = new CameraViewPagerGesture(null);
    a(new FilterPagerViewStubHolder.2(this, localCameraViewPagerGesture));
    return localCameraViewPagerGesture;
  }
  
  public void a(int paramInt)
  {
    a(new FilterPagerViewStubHolder.5(this, paramInt));
  }
  
  protected void a(View paramView)
  {
    this.a = ((VideoFilterViewPager)paramView.findViewById(2064122221));
  }
  
  public void a(VideoFilterViewPager.SelectCallBack paramSelectCallBack)
  {
    a(new FilterPagerViewStubHolder.4(this, paramSelectCallBack));
  }
  
  public void a(boolean paramBoolean)
  {
    a();
    a(new FilterPagerViewStubHolder.1(this, paramBoolean));
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    this.a.e();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!a())) {
      return;
    }
    a();
    VideoFilterViewPager localVideoFilterViewPager = this.a;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localVideoFilterViewPager.setVisibility(i);
    this.a.setEnabled(paramBoolean);
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    a();
    VideoFilterViewPager localVideoFilterViewPager = this.a;
    if (localVideoFilterViewPager != null)
    {
      localVideoFilterViewPager.setDisableScroll(paramBoolean ^ true);
      this.a.a(paramBoolean ^ true);
    }
    localVideoFilterViewPager = this.a;
    if (localVideoFilterViewPager != null)
    {
      localVideoFilterViewPager.setIsNormalMode(paramBoolean);
      if (!paramBoolean)
      {
        this.a.a(0);
        return;
      }
      this.a.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    a();
    this.a.post(new FilterPagerViewStubHolder.3(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder
 * JD-Core Version:    0.7.0.1
 */
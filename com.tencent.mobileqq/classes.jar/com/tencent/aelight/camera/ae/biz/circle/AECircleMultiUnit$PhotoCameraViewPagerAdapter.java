package com.tencent.aelight.camera.ae.biz.circle;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import mqq.util.WeakReference;

final class AECircleMultiUnit$PhotoCameraViewPagerAdapter
  extends PagerAdapter
{
  private List<AECircleMultiUnit.PageData> a;
  
  public void a(List<AECircleMultiUnit.PageData> paramList)
  {
    this.a = ((List)new WeakReference(paramList).get());
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.a.get(paramInt));
    if ((AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.a.get(paramInt)) instanceof AECirclePhotoUnit)) {
      ((AECirclePhotoUnit)AECircleMultiUnit.PageData.a((AECircleMultiUnit.PageData)this.a.get(paramInt))).a();
    }
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit.PhotoCameraViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */
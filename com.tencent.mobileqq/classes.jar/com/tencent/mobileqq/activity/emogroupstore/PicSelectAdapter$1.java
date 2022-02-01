package com.tencent.mobileqq.activity.emogroupstore;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;

class PicSelectAdapter$1
  implements ViewPager.OnPageChangeListener
{
  PicSelectAdapter$1(PicSelectAdapter paramPicSelectAdapter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = PicSelectAdapter.a(this.a).a(paramInt);
    if (localEmoticonFromGroupEntity != null)
    {
      PicSelectAdapter.a(this.a, localEmoticonFromGroupEntity);
      PicSelectAdapter.b(this.a, localEmoticonFromGroupEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.PicSelectAdapter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.addContactTroopView;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;

class TroopCardBanner$1
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((this.a.e != null) && (this.a.e.rpt_banner_items.size() > 1))
    {
      if (this.a.h != null) {
        this.a.h.setImageResource(2130837997);
      }
      paramInt %= this.a.e.rpt_banner_items.size();
      ((ImageView)this.a.g.get(paramInt)).setImageResource(2130837996);
      TroopCardBanner localTroopCardBanner = this.a;
      localTroopCardBanner.h = ((ImageView)localTroopCardBanner.g.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner.1
 * JD-Core Version:    0.7.0.1
 */
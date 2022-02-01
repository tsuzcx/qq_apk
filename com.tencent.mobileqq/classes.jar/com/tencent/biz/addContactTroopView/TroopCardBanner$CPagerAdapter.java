package com.tencent.biz.addContactTroopView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;

public class TroopCardBanner$CPagerAdapter
  extends PagerAdapter
{
  protected TroopCardBanner$CPagerAdapter(TroopCardBanner paramTroopCardBanner) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewGroup)paramView).removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get().size() > 0))
    {
      if (1 == this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get().size()) {
        return 1;
      }
      return 2147483647;
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramInt %= this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size();
    ImageView localImageView = new ImageView(this.a.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageDrawable(URLDrawable.getDrawable(((popclassifc.BannerItem)this.a.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(paramInt)).str_pic_url.get(), null));
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewGroup.addView(localImageView, -1, -1);
    localImageView.setTag(Integer.valueOf(paramInt));
    localImageView.setContentDescription("banner图片");
    localImageView.setOnClickListener(this.a);
    return localImageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner.CPagerAdapter
 * JD-Core Version:    0.7.0.1
 */
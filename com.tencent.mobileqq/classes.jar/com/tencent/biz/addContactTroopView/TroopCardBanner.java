package com.tencent.biz.addContactTroopView;

import affk;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import axqw;
import bawz;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import myc;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class TroopCardBanner
  extends BaseTroopCardView
  implements View.OnClickListener
{
  protected ViewPager a;
  protected ImageView a;
  protected LinearLayout a;
  protected ArrayList<ImageView> a;
  protected popclassifc.BannerCard a;
  
  private String a()
  {
    try
    {
      Object localObject = (myc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
      if ((localObject != null) && (((myc)localObject).a() != null) && (((myc)localObject).a().popRsb != null))
      {
        int i = ((myc)localObject).a().popRsb.uint32_longitude.get();
        int j = ((myc)localObject).a().popRsb.uint32_latitude.get();
        localObject = ((myc)localObject).a().popRsb.str_city_id.get();
        localObject = "lon=" + String.valueOf(i) + "&lat=" + String.valueOf(j) + "&city=" + (String)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    if (paramBoolean)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size())
      {
        ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        int j = bawz.a(this.jdField_a_of_type_Affk.a(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = bawz.a(this.jdField_a_of_type_Affk.a(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
          localImageView.setImageResource(2130837712);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localImageView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
          i += 1;
          break;
          localImageView.setImageResource(2130837713);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject;
    if (i >= 0)
    {
      paramView = (popclassifc.BannerItem)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(i);
      if (paramView != null)
      {
        localObject = paramView.str_transfer_url.get();
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramView = a();
          if (!((String)localObject).contains("?")) {
            break label149;
          }
        }
      }
    }
    label149:
    for (paramView = (String)localObject + "&" + paramView;; paramView = (String)localObject + "?" + paramView)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
      return;
    }
  }
  
  public void setData(popclassifc.BannerCard paramBannerCard)
  {
    boolean bool = true;
    this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard = paramBannerCard;
    if ((this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 0)) {
      if (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() <= 1) {
        break label70;
      }
    }
    for (;;)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new TroopCardBanner.CPagerAdapter(this));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      return;
      label70:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */
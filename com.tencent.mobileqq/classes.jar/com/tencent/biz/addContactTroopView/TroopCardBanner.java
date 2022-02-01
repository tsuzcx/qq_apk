package com.tencent.biz.addContactTroopView;

import aitf;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bdla;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import ntw;
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
      Object localObject = (ntw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
      if ((localObject != null) && (((ntw)localObject).a() != null) && (((ntw)localObject).a().popRsb != null))
      {
        int i = ((ntw)localObject).a().popRsb.uint32_longitude.get();
        int j = ((ntw)localObject).a().popRsb.uint32_latitude.get();
        localObject = ((ntw)localObject).a().popRsb.str_city_id.get();
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
        int j = DisplayUtil.dip2px(this.jdField_a_of_type_Aitf.a(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_Aitf.a(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
          localImageView.setImageResource(2130838051);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localImageView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
          i += 1;
          break;
          localImageView.setImageResource(2130838052);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (popclassifc.BannerItem)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(i);
      if (localObject1 != null)
      {
        localObject2 = ((popclassifc.BannerItem)localObject1).str_transfer_url.get();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = a();
          if (!((String)localObject2).contains("?")) {
            break label164;
          }
        }
      }
    }
    label164:
    for (Object localObject1 = (String)localObject2 + "&" + (String)localObject1;; localObject1 = (String)localObject2 + "?" + (String)localObject1)
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
      EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */
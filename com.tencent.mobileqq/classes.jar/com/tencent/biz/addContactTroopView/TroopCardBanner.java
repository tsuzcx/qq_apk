package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class TroopCardBanner
  extends BaseTroopCardView
  implements View.OnClickListener
{
  protected ImageView a;
  protected LinearLayout a;
  protected ViewPager a;
  protected ArrayList<ImageView> a;
  protected popclassifc.BannerCard a;
  
  private String a()
  {
    try
    {
      Object localObject = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
      if ((localObject != null) && (((AddContactTroopManage)localObject).a() != null) && (((AddContactTroopManage)localObject).a().popRsb != null))
      {
        int i = ((AddContactTroopManage)localObject).a().popRsb.uint32_longitude.get();
        int j = ((AddContactTroopManage)localObject).a().popRsb.uint32_latitude.get();
        localObject = ((AddContactTroopManage)localObject).a().popRsb.str_city_id.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("lon=");
        localStringBuilder.append(String.valueOf(i));
        localStringBuilder.append("&lat=");
        localStringBuilder.append(String.valueOf(j));
        localStringBuilder.append("&city=");
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
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
      while (i < this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size())
      {
        ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        int j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
          localImageView.setImageResource(2130837972);
        }
        else
        {
          localImageView.setImageResource(2130837973);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localImageView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i >= 0)
    {
      Object localObject1 = (popclassifc.BannerItem)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(i);
      if (localObject1 != null)
      {
        Object localObject2 = ((popclassifc.BannerItem)localObject1).str_transfer_url.get();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = a();
          StringBuilder localStringBuilder;
          if (((String)localObject2).contains("?"))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("&");
            localStringBuilder.append((String)localObject1);
            localObject1 = localStringBuilder.toString();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("?");
            localStringBuilder.append((String)localObject1);
            localObject1 = localStringBuilder.toString();
          }
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setData(popclassifc.BannerCard paramBannerCard)
  {
    this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard = paramBannerCard;
    paramBannerCard = this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard;
    if ((paramBannerCard != null) && (paramBannerCard.rpt_banner_items.size() > 0))
    {
      int i = this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size();
      boolean bool = true;
      if (i <= 1) {
        bool = false;
      }
      a(bool);
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(new TroopCardBanner.CPagerAdapter(this));
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */
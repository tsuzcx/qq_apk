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
  protected ViewPager d;
  protected popclassifc.BannerCard e;
  protected LinearLayout f;
  protected ArrayList<ImageView> g;
  protected ImageView h;
  
  private String a()
  {
    try
    {
      Object localObject = (AddContactTroopManage)this.c.getManager(QQManagerFactory.ADDCONTACT_TROOP_SEARCH_POP_MANAGE);
      if ((localObject != null) && (((AddContactTroopManage)localObject).b() != null) && (((AddContactTroopManage)localObject).b().popRsb != null))
      {
        int i = ((AddContactTroopManage)localObject).b().popRsb.uint32_longitude.get();
        int j = ((AddContactTroopManage)localObject).b().popRsb.uint32_latitude.get();
        localObject = ((AddContactTroopManage)localObject).b().popRsb.str_city_id.get();
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
    this.f.removeAllViews();
    this.g = new ArrayList();
    this.h = null;
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.e.rpt_banner_items.size())
      {
        ImageView localImageView = new ImageView(this.c.getApplication());
        int j = DisplayUtil.a(this.a.b(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = DisplayUtil.a(this.a.b(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.h = localImageView;
          localImageView.setImageResource(2130837996);
        }
        else
        {
          localImageView.setImageResource(2130837997);
        }
        this.g.add(localImageView);
        this.f.addView(localImageView);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i >= 0)
    {
      Object localObject1 = (popclassifc.BannerItem)this.e.rpt_banner_items.get(i);
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
        localObject2 = new Intent(this.b, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.b.startActivity((Intent)localObject2);
      }
      ReportController.b(this.c, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setData(popclassifc.BannerCard paramBannerCard)
  {
    this.e = paramBannerCard;
    paramBannerCard = this.e;
    if ((paramBannerCard != null) && (paramBannerCard.rpt_banner_items.size() > 0))
    {
      int i = this.e.rpt_banner_items.size();
      boolean bool = true;
      if (i <= 1) {
        bool = false;
      }
      a(bool);
      this.d.setAdapter(new TroopCardBanner.CPagerAdapter(this));
      this.d.setCurrentItem(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */
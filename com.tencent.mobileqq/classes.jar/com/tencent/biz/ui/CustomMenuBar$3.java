package com.tencent.biz.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomMenuBar$3
  implements View.OnClickListener
{
  CustomMenuBar$3(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, PopupMenu paramPopupMenu, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (this.g.e == null)
      {
        if (this.g.f) {
          break label590;
        }
        this.g.f = true;
        this.a.setImageResource(2130844347);
        if (CustomMenuBar.a()) {
          this.b.setTextColor(this.g.getResources().getColor(2131168200));
        } else {
          this.b.setTextColor(this.g.getResources().getColor(2131168018));
        }
        this.g.g = false;
        this.g.j.removeCallbacks(this.g.k);
        this.c.a(paramView);
        this.g.h.setVisibility(0);
        this.g.e = this.c;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.d, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.e), this.f, String.valueOf(0), false);
      }
      else if (this.g.e == this.c)
      {
        if (!this.g.g)
        {
          if (this.g.f) {
            break label590;
          }
          this.g.f = true;
          this.a.setImageResource(2130844347);
          if (CustomMenuBar.a()) {
            this.b.setTextColor(this.g.getResources().getColor(2131168200));
          } else {
            this.b.setTextColor(this.g.getResources().getColor(2131168018));
          }
          this.g.g = false;
          this.g.j.removeCallbacks(this.g.k);
          this.c.a(paramView);
          this.g.h.setVisibility(0);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.d, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.e), this.f, String.valueOf(0), false);
        }
        else
        {
          this.g.g = false;
        }
      }
      else
      {
        if (this.g.f) {
          break label590;
        }
        this.g.f = true;
        this.a.setImageResource(2130844347);
        if (CustomMenuBar.a()) {
          this.b.setTextColor(this.g.getResources().getColor(2131168200));
        } else {
          this.b.setTextColor(this.g.getResources().getColor(2131168018));
        }
        this.g.g = false;
        this.g.j.removeCallbacks(this.g.k);
        this.c.a(paramView);
        this.g.h.setVisibility(0);
        this.g.e = this.c;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.d, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.e), this.f, String.valueOf(0), false);
      }
      label590:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.3
 * JD-Core Version:    0.7.0.1
 */
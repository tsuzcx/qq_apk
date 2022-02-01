package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativePersonalDetailHeadItemView$FansGroupHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView b;
  private TextView c;
  private Button d;
  private CertifiedAccountMeta.StQQGroup e;
  
  public RelativePersonalDetailHeadItemView$FansGroupHolder(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, View paramView)
  {
    super(paramView);
    this.b = ((TextView)paramView.findViewById(2131448598));
    this.c = ((TextView)paramView.findViewById(2131448637));
    this.d = ((Button)paramView.findViewById(2131429948));
    this.d.setOnClickListener(this);
  }
  
  public void a(CertifiedAccountMeta.StQQGroup paramStQQGroup)
  {
    if (paramStQQGroup != null)
    {
      this.b.setText(paramStQQGroup.name.get());
      Object localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramStQQGroup.memberNum.get());
      localStringBuilder.append(HardCodeUtil.a(2131910850));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.e = paramStQQGroup;
      localObject = this.d;
      int i;
      if (paramStQQGroup.joinState.get() == 1) {
        i = 2131910846;
      } else {
        i = 2131910845;
      }
      ((Button)localObject).setText(HardCodeUtil.a(i));
      if (RelativePersonalDetailHeadItemView.a(this.a).user != null)
      {
        localObject = RelativePersonalDetailHeadItemView.a(this.a).user.id.get();
        if (paramStQQGroup.joinState.get() == 1) {
          paramStQQGroup = "open_butten";
        } else {
          paramStQQGroup = "enter_butten";
        }
        VSReporter.a((String)localObject, "auth_fan", paramStQQGroup, 0, 0, new String[0]);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.e != null) && (paramView != null) && (paramView.getContext() != null))
    {
      Object localObject;
      if (this.e.joinState.get() == 1)
      {
        localObject = AIOUtils.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("uin", String.valueOf(this.e.id.get()));
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", this.e.name.get());
        paramView.getContext().startActivity((Intent)localObject);
      }
      else
      {
        localObject = TroopInfoUIUtil.a(String.valueOf(this.e.id.get()), 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        TroopUtils.a(paramView.getContext(), (Bundle)localObject, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.FansGroupHolder
 * JD-Core Version:    0.7.0.1
 */
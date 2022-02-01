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
  private CertifiedAccountMeta.StQQGroup jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public RelativePersonalDetailHeadItemView$FansGroupHolder(RelativePersonalDetailHeadItemView paramRelativePersonalDetailHeadItemView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379778));
    this.b = ((TextView)paramView.findViewById(2131379806));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363991));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(CertifiedAccountMeta.StQQGroup paramStQQGroup)
  {
    if (paramStQQGroup != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStQQGroup.name.get());
      Object localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramStQQGroup.memberNum.get());
      localStringBuilder.append(HardCodeUtil.a(2131713297));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup = paramStQQGroup;
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      int i;
      if (paramStQQGroup.joinState.get() == 1) {
        i = 2131713293;
      } else {
        i = 2131713292;
      }
      ((Button)localObject).setText(HardCodeUtil.a(i));
      if (RelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView).user != null)
      {
        localObject = RelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView).user.id.get();
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
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup != null) && (paramView != null) && (paramView.getContext() != null))
    {
      Object localObject;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.joinState.get() == 1)
      {
        localObject = AIOUtils.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("uin", String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.id.get()));
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.name.get());
        paramView.getContext().startActivity((Intent)localObject);
      }
      else
      {
        localObject = TroopInfoUIUtil.a(String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StQQGroup.id.get()), 4);
        ((Bundle)localObject).putInt("t_s_f", 1001);
        TroopUtils.a(paramView.getContext(), (Bundle)localObject, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.FansGroupHolder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbilityImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor.NickNameLayoutData;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardProcessor;

public class VipExtendIconExtender
  extends NickNameLayoutExtender
{
  private ImageView a;
  
  public VipExtendIconExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new ImageView(this.mContext);
      this.a.setId(2131380943);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.b(1.0F, this.mContext.getResources());
      this.layoutParams = localLayoutParams;
      this.a.setOnClickListener(new VipExtendIconExtender.1(this));
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = VipUtils.VipIconUtils.a(IndividuationUrlHelper.a("extendnameplateiconurl", this.a), String.valueOf(paramInt));
      this.a.setVisibility(0);
      VipUtils.a(this.mContext.getResources(), this.a, (String)localObject, this.mContext.getResources().getDrawable(2130847296));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("extendnameplatejumpurl_");
      ((StringBuilder)localObject).append(paramInt);
      localObject = IndividuationUrlHelper.a(((StringBuilder)localObject).toString(), this.a);
      this.a.setTag(localObject);
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new BaseChatItemLayoutViewBasicAbilityImpl(this.a);
    }
    return this.ability;
  }
  
  public View getView()
  {
    a();
    return this.a;
  }
  
  public void updateView(NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    this.a.setVisibility(8);
    if ((QVipRedNameCardProcessor.c().a) && (!SimpleUIUtil.a()) && (paramNickNameLayoutData.c != 0) && (paramNickNameLayoutData.c != -100)) {
      a(paramNickNameLayoutData.f);
    }
    QQAppInterface localQQAppInterface;
    if (BaseActivity.sTopActivity != null) {
      localQQAppInterface = BaseActivity.sTopActivity.app;
    } else {
      localQQAppInterface = null;
    }
    if ((localQQAppInterface != null) && (((((IBizTroopInfoService)localQQAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).getmIsShowTroopBigClub()) && (paramNickNameLayoutData.g == 0)) || ((paramNickNameLayoutData.g == -100) && (paramNickNameLayoutData.c != 0) && (paramNickNameLayoutData.c != -100) && (!SimpleUIUtil.a())))) {
      a(paramNickNameLayoutData.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipExtendIconExtender
 * JD-Core Version:    0.7.0.1
 */
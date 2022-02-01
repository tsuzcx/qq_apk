package com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbilityImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor.NickNameLayoutData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipRedNameCardConfig;
import com.tencent.mobileqq.config.business.qvip.QVipRedNameCardProcessor;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;

public class VipIconExtender
  extends NickNameLayoutExtender
{
  private ImageView a;
  
  public VipIconExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new ImageView(this.mContext);
      this.a.setId(2131381702);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.a(5.0F, this.mContext.getResources());
      this.layoutParams = localLayoutParams;
      this.a.setOnClickListener(new VipIconExtender.1(this));
    }
  }
  
  public NickNameExtenderViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new NickNameExtenderViewBasicAbilityImpl(this.a);
    }
    return this.ability;
  }
  
  public View getView()
  {
    a();
    return this.a;
  }
  
  public void updateView(NickNameLayoutProcessor.NickNameLayoutData paramNickNameLayoutData)
  {
    this.a.setVisibility(8);
    int i;
    if ((QVipRedNameCardProcessor.c().a) && (!SimpleUIUtil.a()))
    {
      if ((paramNickNameLayoutData.c != 0) && (paramNickNameLayoutData.c != -100))
      {
        this.a.setVisibility(0);
        i = 3;
        if ((paramNickNameLayoutData.c & 0x2) != 0) {
          i = 259;
        }
        localObject = VipUtils.VipIconUtils.a(i, paramNickNameLayoutData.d, paramNickNameLayoutData.e);
        VipUtils.a(this.mContext.getResources(), this.a, (String)localObject, this.mContext.getResources().getDrawable(2130847431));
        NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramNickNameLayoutData.e);
        localObject = new NamePlateCfgInfo(i, paramNickNameLayoutData.e);
        this.a.setTag(localObject);
      }
    }
    else {
      if (BaseActivity.sTopActivity == null) {
        break label527;
      }
    }
    label527:
    for (Object localObject = BaseActivity.sTopActivity.app;; localObject = null)
    {
      if ((localObject != null) && (((((IBizTroopInfoService)((QQAppInterface)localObject).getRuntimeService(IBizTroopInfoService.class, "")).getmIsShowTroopBigClub()) && (paramNickNameLayoutData.g == 0)) || ((paramNickNameLayoutData.g == -100) && (paramNickNameLayoutData.c != 0) && (paramNickNameLayoutData.c != -100) && (!SimpleUIUtil.a()))))
      {
        this.a.setVisibility(0);
        i = 3;
        if ((paramNickNameLayoutData.c & 0x2) != 0) {
          i = 259;
        }
        NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramNickNameLayoutData.e);
        localObject = VipUtils.VipIconUtils.a(i, paramNickNameLayoutData.d, paramNickNameLayoutData.e);
        VipUtils.a(this.mContext.getResources(), this.a, (String)localObject, this.mContext.getResources().getDrawable(2130847431));
        paramNickNameLayoutData = new NamePlateCfgInfo(i, paramNickNameLayoutData.e);
        this.a.setTag(paramNickNameLayoutData);
      }
      return;
      localObject = new NamePlateCfgInfo();
      ((NamePlateCfgInfo)localObject).mNamePlateId = paramNickNameLayoutData.e;
      switch (VipUtils.a(paramNickNameLayoutData.a))
      {
      default: 
        this.a.setVisibility(8);
      }
      for (;;)
      {
        this.a.setTag(localObject);
        break;
        this.a.setVisibility(8);
        ((NamePlateCfgInfo)localObject).mVipType = 1;
        continue;
        this.a.setVisibility(0);
        String str = VipUtils.VipIconUtils.a(2, paramNickNameLayoutData.b, paramNickNameLayoutData.e);
        VipUtils.a(this.mContext.getResources(), this.a, str, this.mContext.getResources().getDrawable(2130847429));
        ((NamePlateCfgInfo)localObject).mVipType = 2;
        continue;
        this.a.setVisibility(0);
        str = VipUtils.VipIconUtils.a(258, paramNickNameLayoutData.b, paramNickNameLayoutData.e);
        VipUtils.a(this.mContext.getResources(), this.a, str, this.mContext.getResources().getDrawable(2130847431));
        ((NamePlateCfgInfo)localObject).mVipType = 258;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipIconExtender
 * JD-Core Version:    0.7.0.1
 */
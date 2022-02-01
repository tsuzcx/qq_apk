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
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardProcessor;

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
      this.a.setId(2131449926);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.b(5.0F, this.mContext.getResources());
      this.layoutParams = localLayoutParams;
      this.a.setOnClickListener(new VipIconExtender.1(this));
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
    boolean bool = QVipRedNameCardProcessor.e().a;
    int j = 259;
    int i;
    Object localObject;
    if ((bool) && (!SimpleUIUtil.e())) {
      if ((paramNickNameLayoutData.l != 0) && (paramNickNameLayoutData.l != -100))
      {
        this.a.setVisibility(0);
        if ((paramNickNameLayoutData.l & 0x2) != 0) {
          i = 259;
        } else {
          i = 3;
        }
        localObject = VipUtils.VipIconUtils.a(i, paramNickNameLayoutData.m, paramNickNameLayoutData.n);
        VipUtils.a(this.mContext.getResources(), this.a, (String)localObject, this.mContext.getResources().getDrawable(2130848951));
        NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramNickNameLayoutData.n);
        localObject = new NamePlateCfgInfo(i, paramNickNameLayoutData.n);
        this.a.setTag(localObject);
      }
      else
      {
        localObject = new NamePlateCfgInfo();
        ((NamePlateCfgInfo)localObject).mNamePlateId = paramNickNameLayoutData.n;
        i = VipUtils.b(paramNickNameLayoutData.j);
        if (i != 1)
        {
          String str;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                this.a.setVisibility(8);
                break label356;
              }
              this.a.setVisibility(0);
              str = VipUtils.VipIconUtils.a(258, paramNickNameLayoutData.k, paramNickNameLayoutData.n);
              VipUtils.a(this.mContext.getResources(), this.a, str, this.mContext.getResources().getDrawable(2130848951));
              ((NamePlateCfgInfo)localObject).mVipType = 258;
              break label356;
            }
          }
          else
          {
            this.a.setVisibility(0);
            str = VipUtils.VipIconUtils.a(2, paramNickNameLayoutData.k, paramNickNameLayoutData.n);
            VipUtils.a(this.mContext.getResources(), this.a, str, this.mContext.getResources().getDrawable(2130848949));
            ((NamePlateCfgInfo)localObject).mVipType = 2;
            break label356;
          }
        }
        this.a.setVisibility(8);
        ((NamePlateCfgInfo)localObject).mVipType = 1;
        label356:
        this.a.setTag(localObject);
      }
    }
    if (BaseActivity.sTopActivity != null) {
      localObject = BaseActivity.sTopActivity.app;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((((IBizTroopInfoService)((QQAppInterface)localObject).getRuntimeService(IBizTroopInfoService.class, "")).getmIsShowTroopBigClub()) && (paramNickNameLayoutData.p == 0)) || ((paramNickNameLayoutData.p == -100) && (paramNickNameLayoutData.l != 0) && (paramNickNameLayoutData.l != -100) && (!SimpleUIUtil.e()))))
    {
      this.a.setVisibility(0);
      if ((paramNickNameLayoutData.l & 0x2) != 0) {
        i = j;
      } else {
        i = 3;
      }
      NamePlateCfgInfo.vipNamePlateExposeReport(BaseActivity.sTopActivity.app, paramNickNameLayoutData.n);
      localObject = VipUtils.VipIconUtils.a(i, paramNickNameLayoutData.m, paramNickNameLayoutData.n);
      VipUtils.a(this.mContext.getResources(), this.a, (String)localObject, this.mContext.getResources().getDrawable(2130848951));
      paramNickNameLayoutData = new NamePlateCfgInfo(i, paramNickNameLayoutData.n);
      this.a.setTag(paramNickNameLayoutData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basechatitemlayout.VipIconExtender
 * JD-Core Version:    0.7.0.1
 */
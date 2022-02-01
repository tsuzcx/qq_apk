package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;

public class MiniPieForStranger
  extends MiniPie
{
  private QidianManager Y;
  
  public MiniPieForStranger(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    this.O = true;
  }
  
  protected void A()
  {
    this.a = "MiniPieForStranger";
  }
  
  public QidianManager C()
  {
    if (this.Y == null) {
      this.Y = ((QidianManager)this.d.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.Y;
  }
  
  protected void D()
  {
    if (!this.P) {
      return;
    }
    if (this.S != null)
    {
      this.S.setOnClickListener(null);
      if ((!ChatActivityUtils.b(this.d, this.c)) && (!CrmUtils.a(this.d, this.c.b, this.c.a)) && (this.c.a != 1))
      {
        if ((this.p.getText() != null) && (this.p.getText().length() < 6)) {
          this.S.setVisibility(4);
        } else {
          this.S.setVisibility(8);
        }
      }
      else if (AIOTopRightButtonConfig.a().b(this.d.getCurrentAccountUin()))
      {
        this.S.setVisibility(0);
        this.S.setContentDescription(this.b.getResources().getString(2131896548));
      }
      else
      {
        this.S.setVisibility(8);
      }
      if ((this.c.a != 0) && (this.c.a != 1025)) {
        this.S.setVisibility(8);
      }
    }
  }
  
  protected void h()
  {
    if (!this.P) {
      return;
    }
    if ((this.O) && ((this.c.a != 1025) || (!C().e(this.c.b))) && (this.c.a == 1006))
    {
      Object localObject = ((IPhoneContactService)this.d.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.c.b);
      if ((localObject != null) && (OnlineStatusUtils.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) != 0))
      {
        localObject = ContactUtils.a((PhoneContact)localObject);
        e(true);
        this.R.setText((CharSequence)localObject);
        if (AppSetting.e) {
          this.R.setContentDescription((CharSequence)localObject);
        }
      }
      else if (this.R.getVisibility() == 0)
      {
        e(false);
      }
    }
  }
  
  protected void i()
  {
    super.i();
    if (this.P)
    {
      h();
      D();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForStranger
 * JD-Core Version:    0.7.0.1
 */
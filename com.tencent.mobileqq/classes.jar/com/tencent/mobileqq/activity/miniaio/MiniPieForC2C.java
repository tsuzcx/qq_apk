package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.robotchat.RobotChatUtil;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;

public class MiniPieForC2C
  extends MiniPie
{
  private QidianManager Y;
  
  public MiniPieForC2C(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    if (paramQQAppInterface.isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.Y = ((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    this.O = true;
  }
  
  private void C()
  {
    if (this.p != null)
    {
      if (this.b == null) {
        return;
      }
      Object localObject = this.p.getParent();
      ViewGroup localViewGroup = null;
      if ((localObject instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject;
      }
      if (localViewGroup == null) {
        return;
      }
      if (RobotUtils.a(this.d, this.c.b))
      {
        int i = localViewGroup.indexOfChild(this.p);
        localObject = RobotChatUtil.b(this.b);
        if (localObject != null)
        {
          ((View)localObject).setId(2131445089);
          ((View)localObject).setPadding(AIOUtils.b(4.0F, this.p.getResources()), AIOUtils.b(6.0F, this.p.getResources()), 0, 0);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(1, 2131447463);
          localLayoutParams.addRule(6, 2131447463);
          ((View)localObject).setLayoutParams(localLayoutParams);
          localViewGroup.addView((View)localObject, i);
        }
      }
      else
      {
        localObject = localViewGroup.findViewById(2131445089);
        if (localObject != null) {
          localViewGroup.removeView((View)localObject);
        }
      }
    }
  }
  
  protected void A()
  {
    this.a = "MiniPieForC2C";
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void h()
  {
    if (!this.P) {
      return;
    }
    this.c.i = false;
    this.c.j = false;
    if (this.c.a == 0)
    {
      QIMUserManager.b().a(this.d, this.c);
      TIMUserManager.b().a(this.d, this.c);
    }
    Object localObject;
    if ((this.c.i) && (this.c.n))
    {
      this.R.setTextColor(-1);
      this.R.setAlpha(0.8F);
      localObject = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.c.b);
      if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
      {
        localObject = ContactUtils.b((Friends)localObject);
        this.R.setCompoundDrawablePadding(AIOUtils.b(2.0F, BaseApplicationImpl.getContext().getResources()));
        this.R.setCompoundDrawables(QIMUserManager.b().b(5), null, null, null);
        this.R.setOnClickListener(null);
        this.R.setText((CharSequence)localObject);
        e(true);
        return;
      }
      if (this.R.getVisibility() == 0) {
        e(false);
      }
      return;
    }
    if ((this.c.j) && (this.c.m))
    {
      this.R.setTextColor(-1);
      this.R.setAlpha(0.8F);
      localObject = ((FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.c.b);
      if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
      {
        localObject = ContactUtils.b((Friends)localObject);
        this.R.setCompoundDrawablePadding(AIOUtils.b(2.0F, BaseApplicationImpl.getContext().getResources()));
        this.R.setCompoundDrawables(TIMUserManager.b().b(5), null, null, null);
        this.R.setText((CharSequence)localObject);
        e(true);
        return;
      }
      if (this.R.getVisibility() == 0) {
        e(false);
      }
      return;
    }
    this.R.setTextColor(-1);
    this.R.setAlpha(0.8F);
    this.R.setCompoundDrawables(null, null, null, null);
    this.R.setOnClickListener(null);
    if (QQTheme.isNowSimpleUI())
    {
      this.R.setTextColor(this.b.getResources().getColor(2131167990));
      this.R.setAlpha(0.8F);
    }
    else
    {
      this.R.setTextColor(-1);
      this.R.setAlpha(0.8F);
    }
    System.currentTimeMillis();
    if (this.O)
    {
      localObject = this.Y;
      if ((localObject == null) || (!((QidianManager)localObject).e(this.c.b)))
      {
        localObject = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (this.c.a == 1008) {
          return;
        }
        localObject = ((FriendsManager)localObject).m(this.c.b);
        if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject).strTermDesc)) && (((Friends)localObject).strTermDesc.contains("TIM")))))
        {
          localObject = ContactUtils.b((Friends)localObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!Utils.c(this.c.b)))
          {
            this.R.setText((CharSequence)localObject);
            e(true);
            if (AppSetting.e) {
              this.R.setContentDescription((CharSequence)localObject);
            }
          }
          else
          {
            e(false);
          }
        }
        else if (this.R.getVisibility() == 0)
        {
          e(false);
        }
      }
    }
  }
  
  protected void i()
  {
    this.T = true;
    super.i();
    if (this.P)
    {
      h();
      if (!TextUtils.equals(this.c.b, this.d.getCurrentUin())) {
        ViewUtils.setVisible(this.S, 0);
      }
    }
    C();
  }
  
  protected void w()
  {
    super.w();
  }
  
  protected void x()
  {
    super.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForC2C
 * JD-Core Version:    0.7.0.1
 */
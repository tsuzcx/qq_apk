package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$13
  extends CardObserver
{
  PermisionPrivacyActivity$13(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      if (paramBoolean1)
      {
        paramString = this.a;
        PermisionPrivacyActivity.a(paramString, paramString.d.a(), paramBoolean2);
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("onGetAllowSeeLoginDays isSuccess ");
      paramString.append(paramBoolean1);
      paramString.append("isAllow:");
      paramString.append(paramBoolean2);
      paramString.append("uin empty!");
      QLog.e("Q.security", 2, paramString.toString());
    }
  }
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.isFinishing())
    {
      if (this.a.app == null) {
        return;
      }
      if (!paramBoolean1)
      {
        this.a.a(2131718834, 1);
        localObject = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.app.getCurrentAccountUin());
        PermisionPrivacyActivity localPermisionPrivacyActivity = this.a;
        PermisionPrivacyActivity.a(localPermisionPrivacyActivity, localPermisionPrivacyActivity.e.a(), ((Card)localObject).strangerInviteMeGroupOpen);
        return;
      }
      Object localObject = this.a;
      PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, ((PermisionPrivacyActivity)localObject).e.a(), paramBoolean2);
    }
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      if (!paramBoolean2) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699255));
      } else {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699256));
      }
      if (QLog.isColorLevel())
      {
        Card localCard = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.app.getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermisionPrivacyActivity onGetCalReactiveDays isAllow= ");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("card.allowCalInteractive=");
        localStringBuilder.append(localCard.allowCalInteractive);
        QLog.d("interactive", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    paramString = this.a;
    PermisionPrivacyActivity.a(paramString, paramString.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
    paramString = this.a;
    PermisionPrivacyActivity.a(paramString, PermisionPrivacyActivity.a(paramString), paramBoolean3);
  }
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.a, paramBoolean);
        this.a.j.setChecked(paramBoolean);
        paramObject = new StringBuilder();
        paramObject.append("onGetPrettyOwnerFlag ");
        paramObject.append(paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, paramObject.toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      paramObject = new StringBuilder();
      paramObject.append("onGetPrettyOwnerFlag ex:");
      paramObject.append(localObject);
      QLog.e("vip_pretty.Q.security", 1, paramObject.toString());
      return;
      paramBoolean = false;
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.app.getCurrentAccountUin());
    PermisionPrivacyActivity localPermisionPrivacyActivity = this.a;
    PermisionPrivacyActivity.a(localPermisionPrivacyActivity, localPermisionPrivacyActivity.d.a(), localCard.allowPeopleSee);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      Card localCard = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.app.getCurrentAccountUin());
      if (!localCard.allowCalInteractive) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699255));
      } else {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(HardCodeUtil.a(2131699256));
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PermisionPrivacyActivity onSetCalReactiveDays isAllow= ");
        localStringBuilder.append(localCard.allowCalInteractive ^ true);
        QLog.d("interactive", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131718834, 1);
    }
    if (paramBoolean2)
    {
      paramString = this.a;
      PermisionPrivacyActivity.a(paramString, paramString.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
      return;
    }
    paramString = this.a;
    PermisionPrivacyActivity.a(paramString, PermisionPrivacyActivity.a(paramString), paramBoolean3);
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.a, paramBoolean);
        paramObject = new StringBuilder();
        paramObject.append("onSetPrettyOwnerFlag ");
        paramObject.append(paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, paramObject.toString());
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
      }
      paramObject = new StringBuilder();
      paramObject.append("onSetPrettyOwnerFlag ex:");
      paramObject.append(localObject);
      QLog.e("vip_pretty.Q.security", 1, paramObject.toString());
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.13
 * JD-Core Version:    0.7.0.1
 */
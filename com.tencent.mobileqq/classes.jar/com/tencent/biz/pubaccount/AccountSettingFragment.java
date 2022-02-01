package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;

public class AccountSettingFragment
  extends IphoneTitleBarFragment
{
  private MqqHandler a;
  private QQAppInterface b;
  private String c;
  private String d;
  private Integer e;
  private PublicAccountDetailImpl f;
  private Switch g;
  private View.OnClickListener h = new AccountSettingFragment.1(this);
  
  private void a()
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      this.f = ((PublicAccountDetailImpl)localIPublicAccountDataManager.findAccountDetailInfoCache(this.c));
      b();
    }
    if (this.f == null) {
      PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(this.c)), null, new AccountSettingFragment.2(this));
    }
  }
  
  private void a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    EntityManager localEntityManager = this.b.getEntityManagerFactory().createEntityManager();
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.f;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, paramPublicAccountDetailImpl.name);
      }
      this.f.clone(paramPublicAccountDetailImpl);
      if (!localEntityManager.update(this.f)) {
        localEntityManager.drop(PublicAccountDetailImpl.class);
      }
    }
    else
    {
      this.f = paramPublicAccountDetailImpl;
      localEntityManager.persist(paramPublicAccountDetailImpl);
    }
    localEntityManager.close();
    paramPublicAccountDetailImpl = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (paramPublicAccountDetailImpl != null) {
      paramPublicAccountDetailImpl.saveAccountDetailInfoCache(this.f);
    }
  }
  
  private void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.a.post(new AccountSettingFragment.3(this));
      return;
    }
    c();
  }
  
  private void c()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    this.e = PublicAccountUtilImpl.getMessageSetting((PublicAccountDetailImpl)localObject);
    localObject = this.e;
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      this.g.setChecked(true);
      return;
    }
    this.g.setChecked(false);
  }
  
  private void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.b = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.a = new MqqHandler(Looper.getMainLooper());
    this.g = ((Switch)this.mContentView.findViewById(2131428665));
    this.g.setOnClickListener(this.h);
    paramLayoutInflater = getArguments();
    this.c = paramLayoutInflater.getString("uin");
    this.d = paramLayoutInflater.getString("name");
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625668;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131892983));
    if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      this.vg.changeBg(true);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountSettingFragment
 * JD-Core Version:    0.7.0.1
 */
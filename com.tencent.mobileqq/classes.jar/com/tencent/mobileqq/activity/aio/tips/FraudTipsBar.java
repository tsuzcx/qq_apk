package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.os.MqqHandler;

public class FraudTipsBar
  implements TipsBarTask
{
  private QQAppInterface a;
  private TipsManager b;
  private Context c;
  private BaseSessionInfo d;
  private MqqHandler e;
  private int f = 0;
  private boolean g = false;
  
  public FraudTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, BaseSessionInfo paramBaseSessionInfo, MqqHandler paramMqqHandler)
  {
    this.a = paramQQAppInterface;
    this.b = paramTipsManager;
    this.c = paramContext;
    this.d = paramBaseSessionInfo;
    this.e = paramMqqHandler;
  }
  
  public int a()
  {
    return 50;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.c).inflate(2131628276, null);
    TextView localTextView = (TextView)localView.findViewById(2131428122);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new FraudTipsBar.2(this, i));
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    d();
  }
  
  public int b()
  {
    return 0;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "check() : ");
    }
    if (this.d.a != 0) {
      return;
    }
    if (this.f != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FraudTipsBar", 2, "mAntiFraudTips is showing or has shown");
      }
      return;
    }
    long l;
    try
    {
      l = Long.parseLong(this.d.b);
    }
    catch (Throwable localThrowable1)
    {
      localThrowable1.printStackTrace();
      l = 0L;
    }
    if (l == 0L) {
      return;
    }
    if (!this.g)
    {
      this.g = true;
      if (UinFraudInfo.a().b(l))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FraudTipsBar", 2, "uin cache is out of date, update it! ");
        }
        ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).queryUinSafetyFlag("OidbSvc.0x476_146", (int)l, 146);
      }
    }
    int i = UinFraudInfo.a().a(l);
    if (i != 0)
    {
      AntiFraudConfigFileUtil.a().a(this.a, "SecWarningCfg");
      Object localObject1 = null;
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("BannerWording");
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      if (this.b.a(this, new Object[] { localObject1, Integer.valueOf(i) }))
      {
        this.f = 1;
        ReportController.b(null, "P_CliOper", "Safe_AntiFraud", this.d.b, "banner", "display", i, 0, "", "", "", "");
        localObject2 = new Timer();
        FraudTipsBar.1 local1 = new FraudTipsBar.1(this);
        localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerTTL", 146, i);
        if (localObject1 != null) {
          localObject1 = ((Bundle)localObject1).getString("BannerTTL");
        } else {
          localObject1 = "0";
        }
        l = 15L;
        try
        {
          i = Integer.parseInt((String)localObject1);
          l = i;
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        l *= 1000L;
        if (l > 0L) {
          ((Timer)localObject2).schedule(local1, l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FraudTipsBar
 * JD-Core Version:    0.7.0.1
 */
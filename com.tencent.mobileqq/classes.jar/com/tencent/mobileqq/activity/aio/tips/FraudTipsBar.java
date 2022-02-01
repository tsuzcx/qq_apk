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
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  
  public FraudTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, BaseSessionInfo paramBaseSessionInfo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public int a()
  {
    return 50;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561858, null);
    TextView localTextView = (TextView)localView.findViewById(2131362512);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new FraudTipsBar.2(this, i));
    return localView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "check() : ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FraudTipsBar", 2, "mAntiFraudTips is showing or has shown");
      }
      return;
    }
    long l;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
    catch (Throwable localThrowable1)
    {
      localThrowable1.printStackTrace();
      l = 0L;
    }
    if (l == 0L) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (UinFraudInfo.a().a(l))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FraudTipsBar", 2, "uin cache is out of date, update it! ");
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).queryUinSafetyFlag("OidbSvc.0x476_146", (int)l, 146);
      }
    }
    int i = UinFraudInfo.a().a(l);
    if (i != 0)
    {
      AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
      Object localObject1 = null;
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("BannerWording");
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { localObject1, Integer.valueOf(i) }))
      {
        this.jdField_a_of_type_Int = 1;
        ReportController.b(null, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i, 0, "", "", "", "");
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
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FraudTipsBar
 * JD-Core Version:    0.7.0.1
 */
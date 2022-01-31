package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.os.MqqHandler;
import vzl;
import vzn;

public class FraudTipsBar
  implements TipsBarTask
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  
  public FraudTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public int a()
  {
    return 50;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970877, null);
    TextView localTextView = (TextView)localView.findViewById(2131372062);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new vzn(this, i));
    return localView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FraudTipsBar", 2, "check() : ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int != 0)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FraudTipsBar", 2, "mAntiFraudTips is showing or has shown");
        return;
      }
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (l == 0L) {
          continue;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (UinFraudInfo.a().a(l))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FraudTipsBar", 2, "uin cache is out of date, update it! ");
            }
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a("OidbSvc.0x476_146", (int)l, 146);
          }
        }
        int i = UinFraudInfo.a().a(l);
        if (i == 0) {
          continue;
        }
        AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
        Object localObject = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("BannerWording");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { localObject, Integer.valueOf(i) })) {
            continue;
          }
          this.jdField_a_of_type_Int = 1;
          ReportController.b(null, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i, 0, "", "", "", "");
          Timer localTimer = new Timer();
          vzl localvzl = new vzl(this);
          localObject = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerTTL", 146, i);
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getString("BannerTTL");
            try
            {
              i = Integer.parseInt((String)localObject);
              l = i;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                localThrowable2.printStackTrace();
                l = 15L;
              }
            }
            l *= 1000L;
            if (l <= 0L) {
              continue;
            }
            localTimer.schedule(localvzl, l);
            return;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          long l = 0L;
          continue;
          String str = "0";
          continue;
          str = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FraudTipsBar
 * JD-Core Version:    0.7.0.1
 */
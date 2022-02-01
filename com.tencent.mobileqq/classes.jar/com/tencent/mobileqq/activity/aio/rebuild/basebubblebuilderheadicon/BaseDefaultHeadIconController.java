package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.avatardoubletap.TouchEventHandler;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseDefaultHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 3000)
      {
        bool1 = bool2;
        if (paramInt != 0)
        {
          bool1 = bool2;
          if (paramInt != 1005)
          {
            bool1 = bool2;
            if (paramInt != 1001)
            {
              bool1 = bool2;
              if (paramInt != 1006)
              {
                bool1 = bool2;
                if (paramInt != 1000)
                {
                  bool1 = bool2;
                  if (paramInt != 10004)
                  {
                    bool1 = bool2;
                    if (paramInt != 1004)
                    {
                      bool1 = bool2;
                      if (paramInt != 1008)
                      {
                        bool1 = bool2;
                        if (paramInt != 1009)
                        {
                          bool1 = bool2;
                          if (paramInt != 1010)
                          {
                            bool1 = bool2;
                            if (paramInt != 1011)
                            {
                              bool1 = bool2;
                              if (paramInt != 1020)
                              {
                                bool1 = bool2;
                                if (paramInt != 1021)
                                {
                                  bool1 = bool2;
                                  if (paramInt != 1023)
                                  {
                                    bool1 = bool2;
                                    if (paramInt != 1024)
                                    {
                                      bool1 = bool2;
                                      if (paramInt != 1036)
                                      {
                                        bool1 = bool2;
                                        if (paramInt != 1025)
                                        {
                                          bool1 = bool2;
                                          if (paramInt != 10002)
                                          {
                                            if (paramInt == 1022) {
                                              return true;
                                            }
                                            bool1 = false;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected void c()
  {
    a(this.h);
  }
  
  protected void d()
  {
    int i = this.a.istroop;
    if (((!this.a.isSendFromLocal()) && (a(i))) || (i == 10008))
    {
      if (!this.b.getCurrentAccountUin().equals(this.a.senderuin))
      {
        String str1 = this.a.frienduin;
        String str2 = this.a.senderuin;
        ThreadManager.executeOnSubThread(new BaseDefaultHeadIconController.ProcessMemberNickTask(this.b, this.c, this.e, str1, str2, i, this.g));
      }
    }
    else {
      a(null);
    }
  }
  
  protected void e()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AppSetting.enableTalkBack = ");
      ((StringBuilder)localObject).append(AppSetting.e);
      QLog.d("BaseBubbleBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (AppSetting.e)
    {
      if ((this.a.istroop != 1) && (this.a.istroop != 3000))
      {
        if (this.a.isSend())
        {
          localObject = HardCodeUtil.a(2131899182);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.d.e);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131899185));
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else {
        localObject = "";
      }
      if (this.a.msgtype == -3006) {
        localObject = String.format(this.c.getResources().getString(2131895452), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext()) });
      }
      a((CharSequence)localObject);
    }
  }
  
  protected void f()
  {
    new TouchEventHandler().a(this.e, this.c);
  }
  
  protected void g()
  {
    a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.BaseDefaultHeadIconController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class TroopAssistBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public TroopAssistBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131559049, null);
    View localView = paramBanner.findViewById(2131365372);
    paramBanner.setOnClickListener(new TroopAssistBannerProcessor.1(this));
    localView.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(19, 0);
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    if ((BannerManager.a().a(19)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    List localList;
    int i;
    label86:
    int j;
    label88:
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
      if ((localQQAppInterface != null) && ((TroopAssistantManager.a().c(localQQAppInterface, this.jdField_a_of_type_JavaLangString)) || (this.b)))
      {
        localList = localQQAppInterface.getProxyManager().a().a(false);
        if (localList != null) {
          break label141;
        }
        i = 0;
        j = 0;
        k = m;
        if (j >= i) {
          break label159;
        }
        if (((RecentUser)localList.get(j)).getType() != 5000) {
          break label152;
        }
        if (this.b) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
        }
      }
    }
    label141:
    label152:
    label159:
    do
    {
      return;
      localQQAppInterface = null;
      break;
      i = localList.size();
      break label86;
      j += 1;
      break label88;
      if (k < i)
      {
        RecentUser localRecentUser = (RecentUser)localList.get(k);
        if (localRecentUser.getType() != 1) {}
        do
        {
          do
          {
            k += 1;
            break;
          } while ((TextUtils.isEmpty(localRecentUser.uin)) || (TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin)) || (TroopAssistantManager.a().a(localQQAppInterface, localRecentUser.uin) != 1));
          if (localQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.b) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(localRecentUser.uin))) {
              break;
            }
            this.jdField_a_of_type_JavaLangString = localRecentUser.uin;
            return;
          }
        } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(localRecentUser.uin)));
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
        return;
      }
    } while ((!this.b) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.jdField_a_of_type_JavaLangString = "";
      BannerManager.a().a(19, 0, paramMessage);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 2000) {
        c();
      } else if (paramMessage.what == 2001) {
        a(paramMessage.getData().getString("troopUin"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor
 * JD-Core Version:    0.7.0.1
 */
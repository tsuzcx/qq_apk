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
import com.tencent.mobileqq.banner.BannerTypeCollections;
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
  public static final int a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.s;
  }
  
  public TroopAssistBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131558943, null);
    View localView = paramBanner.findViewById(2131365236);
    paramBanner.setOnClickListener(new TroopAssistBannerProcessor.1(this));
    localView.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    if ((BannerManager.a().a(jdField_a_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "checkIsShowTroopTip");
    }
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    } else {
      localQQAppInterface = null;
    }
    if ((localQQAppInterface != null) && ((TroopAssistantManager.a().c(localQQAppInterface, this.jdField_a_of_type_JavaLangString)) || (this.b)))
    {
      Object localObject = localQQAppInterface.getProxyManager().a();
      int m = 0;
      localObject = ((RecentUserProxy)localObject).a(false);
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      int j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= i) {
          break;
        }
        if (((RecentUser)((List)localObject).get(j)).getType() == 5000)
        {
          if (this.b) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
          }
          return;
        }
        j += 1;
      }
      while (k < i)
      {
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(k);
        if ((localRecentUser.getType() == 1) && (!TextUtils.isEmpty(localRecentUser.uin)) && (!TroopAssistantManager.a().b(localQQAppInterface, localRecentUser.uin)) && (TroopAssistantManager.a().a(localQQAppInterface, localRecentUser.uin) == 1))
        {
          if (localQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) > 99)
          {
            if ((this.b) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(localRecentUser.uin))) {
              return;
            }
            this.jdField_a_of_type_JavaLangString = localRecentUser.uin;
            return;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(localRecentUser.uin)))
          {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
            return;
          }
        }
        k += 1;
      }
      if ((this.b) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1000);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.jdField_a_of_type_JavaLangString = "";
      BannerManager.a().a(jdField_a_of_type_Int, 0, paramMessage);
    }
    else if (paramMessage.what == 2000)
    {
      c();
    }
    else if (paramMessage.what == 2001)
    {
      a(paramMessage.getData().getString("troopUin"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor
 * JD-Core Version:    0.7.0.1
 */
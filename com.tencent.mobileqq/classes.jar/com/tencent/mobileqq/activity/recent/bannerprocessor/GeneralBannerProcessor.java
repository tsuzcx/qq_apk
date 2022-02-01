package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerIconCollection;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerOnUpdateBannerState;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class GeneralBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle, IBannerOnUpdateBannerState
{
  public static final int a;
  public volatile BBannerHelper.MessageToShowBanner a;
  public volatile BBannerHelper.MessageToShowBanner b;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.L;
  }
  
  public GeneralBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    int i = BannerManager.jdField_a_of_type_Int;
    while (i < BannerManager.jdField_b_of_type_Int)
    {
      Banner localBanner = BannerManager.a().a(i);
      if ((localBanner != null) && (localBanner.jdField_b_of_type_Int == 2)) {
        if (i != paramInt)
        {
          b(i, paramInt);
          localBanner.jdField_b_of_type_Int = 0;
        }
        else if ((i == jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner != null) && (!this.b.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner)))
        {
          b(i, paramInt);
        }
      }
      i += 1;
    }
  }
  
  private void a(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideGeneralBanner: ");
      localStringBuilder.append(paramMessage);
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
    if (!(paramMessage.obj instanceof BBannerHelper.MessageToShowBanner)) {
      return;
    }
    int i = ((BBannerHelper.MessageToShowBanner)paramMessage.obj).jdField_a_of_type_Int;
    if (!paramMessage.obj.equals(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner)) {
      return;
    }
    BannerManager.a().a(jdField_a_of_type_Int, 0, paramMessage);
  }
  
  private void a(BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGeneralBannerInBInternal with: ");
      ((StringBuilder)localObject).append(paramMessageToShowBanner);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1000);
    ((Message)localObject).obj = paramMessageToShowBanner;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[notifyBannerIsOverride], type is ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$IBannerInteract.onOverride();
    }
  }
  
  private void b(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof BBannerHelper.MessageToShowBanner)) {
      return;
    }
    int i = ((BBannerHelper.MessageToShowBanner)paramMessage.obj).jdField_a_of_type_Int;
    this.b = ((BBannerHelper.MessageToShowBanner)paramMessage.obj);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner = this.b;
    BannerManager.a().a(jdField_a_of_type_Int, 2, paramMessage);
    b((BBannerHelper.MessageToShowBanner)paramMessage.obj);
  }
  
  private void b(BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    paramMessageToShowBanner = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1000, paramMessageToShowBanner);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessageToShowBanner, 900000L);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.b(true);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= BannerManager.jdField_a_of_type_Int) && (paramInt1 < BannerManager.jdField_b_of_type_Int) && (paramInt2 == 2)) {
      a(paramInt1);
    }
  }
  
  @SuppressLint({"ResourceType"})
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner = (TipsBar)paramBanner.a;
    if (paramMessage == null) {
      return;
    }
    paramMessage = (BBannerHelper.MessageToShowBanner)paramMessage.obj;
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(BannerIconCollection.a(paramMessage.jdField_b_of_type_Int)));
    paramBanner.setTipsText(paramMessage.jdField_b_of_type_JavaLangString);
    paramBanner.setOnClickListener(new BBannerHelper.OnEnterClickDelegate(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramBanner.setCloseListener(new BBannerHelper.OnCloseClickDelegate(paramMessage, this.jdField_a_of_type_MqqOsMqqHandler));
    paramBanner.setVisibility(0);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
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
  
  public void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("handleAccountChanged with: ");
      paramAppRuntime.append(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
      QLog.d("Q.recent.banner", 2, paramAppRuntime.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$IBannerInteract.isNeedAutoCloseWhenAccountChange())) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorBBannerHelper$MessageToShowBanner);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != 1000) && (paramMessage.what != 1134201))
    {
      if (paramMessage.what == 1134200) {
        b(paramMessage);
      }
    }
    else {
      a(paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor
 * JD-Core Version:    0.7.0.1
 */
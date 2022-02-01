package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewBinder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewModel;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.LayoutStatusLiveData;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class StickerRecHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private long jdField_a_of_type_Long;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IStickerRecViewBinder jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewBinder;
  private IStickerRecViewModel jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public StickerRecHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
    paramBaseChatPie.b().a().a(this);
    d();
  }
  
  private void d()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = LifeCycleFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel = ((IStickerRecMvvmCreator)QRoute.api(IStickerRecMvvmCreator.class)).createViewModel(localLifeCycleAndViewModelStoreOwner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewBinder = ((IStickerRecMvvmCreator)QRoute.api(IStickerRecMvvmCreator.class)).createViewBinder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewBinder.a(localLifeCycleAndViewModelStoreOwner);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(67);
    b();
    a(true);
    a(12);
  }
  
  void a(int paramInt)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(paramInt);
    }
  }
  
  public void a(Editable paramEditable)
  {
    String str = ((SpecWordEmotionThinkHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(41)).a();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(paramEditable, str);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long - 3000L;
    if (!bool)
    {
      if (l > 0L)
      {
        a();
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, -l);
    }
  }
  
  void a(boolean paramBoolean)
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.showApolloView(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData(2));
  }
  
  public void b(Editable paramEditable)
  {
    if (paramEditable.length() == 0) {
      a();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return;
    }
    b();
    a(true);
    a(12);
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    int i = paramMessage.what;
    if (i != 67)
    {
      if (i != 69)
      {
        if (i != 92) {
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData(2));
        if (localBaseChatPie != null) {
          localBaseChatPie.a().removeMessages(67);
        }
        a(true);
        a(12);
        return true;
      }
      String str = null;
      if ((paramMessage.obj instanceof String)) {
        str = (String)paramMessage.obj;
      }
      paramMessage = new LayoutStatusLiveData(1);
      paramMessage.a = str;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(paramMessage);
      if (localBaseChatPie != null)
      {
        a(false);
        paramMessage = (IDoutuService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IDoutuService.class, "");
        if (paramMessage != null) {
          paramMessage.hideDoutuEmotionLayout();
        }
        a(11);
        EmojiStickerManager.a().c(localBaseChatPie);
        localBaseChatPie.a().removeMessages(67);
        localBaseChatPie.a().sendEmptyMessageDelayed(67, 6000L);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(67);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData(3));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.b(true);
    a(true);
    a(12);
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9, 10, 7, 6 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 10)
          {
            if (paramInt != 15) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData(3));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(false);
            return;
          }
          BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if ((localBaseChatPie != null) && (localBaseChatPie.l())) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(true);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedMvvmIStickerRecViewModel.a(new LayoutStatusLiveData(4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StickerRecHelper
 * JD-Core Version:    0.7.0.1
 */
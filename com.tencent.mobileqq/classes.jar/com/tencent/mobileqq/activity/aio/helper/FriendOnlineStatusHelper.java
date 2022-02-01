package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class FriendOnlineStatusHelper
  extends OnlineStatusHelper
  implements OnFinishListener, OnActivityResultCallback
{
  private final View.OnClickListener a;
  private final View.OnClickListener b = new FriendOnlineStatusHelper.2(this);
  
  public FriendOnlineStatusHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new FriendOnlineStatusHelper.1(this);
    paramAIOContext = paramAIOContext.a();
    paramAIOContext.a(this);
    paramAIOContext.a(this);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.c) {
      a((Context)localObject, 2131167053);
    } else {
      a((Context)localObject, 2131167054);
    }
    localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
    {
      a(ContactUtils.b((Friends)localObject));
      a().setCompoundDrawablePadding(AIOUtils.b(2.0F, BaseApplicationImpl.getContext().getResources()));
      a().setCompoundDrawables(QIMUserManager.a().b(5), null, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
      a().setOnClickListener(this.b);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
      }
      a(true);
      return;
    }
    if (a().getVisibility() == 0)
    {
      a(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      if (((TipsManager)localObject).a() == 5)
      {
        FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        ((TipsManager)localObject).a();
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.c) {
      a((Context)localObject, 2131167053);
    } else {
      a((Context)localObject, 2131167054);
    }
    localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && ((OnlineStatusUtils.a(((Friends)localObject).detalStatusFlag, ((Friends)localObject).iTermType) != 0) || (!TextUtils.isEmpty(((Friends)localObject).strTermDesc))))
    {
      a(ContactUtils.b((Friends)localObject));
      a().setCompoundDrawablePadding(AIOUtils.b(2.0F, BaseApplicationImpl.getContext().getResources()));
      a().setCompoundDrawables(TIMUserManager.a().b(5), null, null, null);
      a(true);
      return;
    }
    if (a().getVisibility() == 0) {
      a(false);
    }
  }
  
  private void f()
  {
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject1 != null) && ((OnlineStatusUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) != 0) || ((!TextUtils.isEmpty(((Friends)localObject1).strTermDesc)) && (((Friends)localObject1).strTermDesc.contains("TIM")))))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject2 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(AppRuntime.Status.online, ((Friends)localObject1).uExtOnlineStatus, bool ^ true);
      if ((OnlineStatusUtils.a(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType) == 4) && (((OnlineStatusItem)localObject2).a > 0L) && (localObject2 != null)) {
        bool = true;
      } else {
        bool = false;
      }
      String str = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject1, a(), 1, (OnlineStatusItem)localObject2, Boolean.valueOf(bool));
      if ((!TextUtils.isEmpty(str)) && (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        a(true);
        a(str);
        ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).showOnlineStatusDrawable((Friends)localObject1, a(), false, (OnlineStatusItem)localObject2, 1);
        if (ChatActivityConstants.jdField_a_of_type_Boolean) {
          a().setContentDescription(str);
        }
      }
      else
      {
        a(false);
        ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).showOnlineStatusDrawable((Friends)localObject1, a(), true, (OnlineStatusItem)localObject2, 1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getResources().getDrawable(2130838630);
      int i = ViewUtils.a(9.0F);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      localObject2 = a().getCompoundDrawables();
      a().setCompoundDrawables(localObject2[0], localObject2[1], (Drawable)localObject1, localObject2[3]);
      return;
    }
    if (a().getVisibility() == 0)
    {
      a(false);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      if (((TipsManager)localObject1).a() == 5)
      {
        FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        ((TipsManager)localObject1).a();
      }
    }
  }
  
  public int a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    if (((C2CListenTogetherPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(32)).c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendOnlineStatusHelper", 2, "updateOnlineStatus, isListenTogetherTime");
      }
      return;
    }
    if (((TogetherControlHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(43)).c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendOnlineStatusHelper", 2, "updateOnlineStatus, isTogetherTime");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.f))
    {
      d();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e))
    {
      e();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), 2131167053);
    a().setCompoundDrawables(null, null, null, null);
    if ((!CustomOnlineStatusManager.a().a()) && (!((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).enableAIOSubTitleClicked(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      a().setOnClickListener(null);
      a().setOnClickListener(null);
      BaseListenTogetherPanel.a(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
    }
    else
    {
      a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      View localView = a();
      localView.setClickable(true);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      int i = (ViewUtils.b(200.0F) - localView.getWidth()) / 2;
      BaseListenTogetherPanel.a(localView, 0, ViewUtils.a(9.0F), i, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
    }
    if ((this.jdField_a_of_type_Boolean) && (!((QidianHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(61)).a(true)))
    {
      if (a()) {
        return;
      }
      f();
    }
  }
  
  protected void c()
  {
    b();
  }
  
  public void d(int paramInt) {}
  
  @NonNull
  public String getTag()
  {
    return "FriendOnlineStatusHelper";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ((IOnlineStatusService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class, "")).onAIODialogResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendOnlineStatusHelper
 * JD-Core Version:    0.7.0.1
 */
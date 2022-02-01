package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.MODE;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSRecordListener;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "timeoutRunnable", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Ljava/lang/Runnable;)V", "encodeEnd", "", "success", "", "path", "", "encodeStart", "getActionId", "", "getBusinessConfig", "Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "getCurrentRecordKey", "getRecordMode", "Lcom/tencent/mobileqq/apollo/player/action/MODE;", "getTaskId", "onRecordDone", "errorCode", "recordKey", "onRecordFrameEnd", "onRecordFrameStart", "onRecordSingleFrame", "index", "pixels", "", "width", "height", "frameTime", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayer$CMSRecordListener
  implements IApolloActionRecordListener
{
  private final ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  private final CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  
  public CMSBornPlayer$CMSRecordListener(@NotNull CMSAction paramCMSAction, @NotNull ICMSPlayerListener paramICMSPlayerListener, @NotNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().a;
  }
  
  @NotNull
  public MODE a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a();
  }
  
  @NotNull
  public BusinessConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a();
  }
  
  @NotNull
  public String a()
  {
    return CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null);
  }
  
  public void a()
  {
    TraceReportUtil.a(CMSHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a()), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 2);
  }
  
  public void a(int paramInt)
  {
    TraceReportUtil.a(CMSHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a()), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 2, paramInt, new Object[0]);
  }
  
  public void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localICMSPlayerListener.a(localCMSAction, bool, paramString1, paramString2);
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    int j = CMSHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a());
    String str = CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zipLevel:1, path:");
    localStringBuilder.append(paramString);
    TraceReportUtil.a(j, str, 3, i, new Object[] { localStringBuilder.toString() });
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.c();
  }
  
  public void b()
  {
    TraceReportUtil.a(CMSHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a()), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, null, null, 3, null), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSRecordListener
 * JD-Core Version:    0.7.0.1
 */
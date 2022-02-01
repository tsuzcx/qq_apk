package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.screenshot.IApolloActionRecordListener;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSRecordListener;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloActionRecordListener;", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "targetWidth", "", "targetHeight", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "timeoutRunnable", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;IILcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;Ljava/lang/Runnable;)V", "encodeEnd", "", "success", "", "path", "", "encodeStart", "getActionId", "getBusinessConfig", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "getCurrentRecordKey", "getRecordMode", "Lcom/tencent/mobileqq/apollo/api/player/action/MODE;", "getTargetHeight", "getTargetWidth", "getTaskId", "onRecordDone", "errorCode", "recordKey", "onRecordFrameEnd", "onRecordFrameStart", "onRecordSingleFrame", "index", "pixels", "", "width", "height", "frameTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayer$CMSRecordListener
  implements IApolloActionRecordListener
{
  private final int jdField_a_of_type_Int;
  private final CMSAction jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  private final ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private final int b;
  
  public CMSBornPlayer$CMSRecordListener(@NotNull CMSAction paramCMSAction, int paramInt1, int paramInt2, @NotNull ICMSPlayerListener paramICMSPlayerListener, @NotNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().jdField_a_of_type_Int;
  }
  
  @NotNull
  public MODE a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a();
  }
  
  @NotNull
  public BusinessConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a();
  }
  
  @NotNull
  public String a()
  {
    return CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, null, null, 3, null);
  }
  
  public void a()
  {
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, null, null, 3, null), 2);
  }
  
  public void a(int paramInt)
  {
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, null, null, 3, null), 2, paramInt, new Object[0]);
  }
  
  public void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
    CMSAction localCMSAction = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localICMSPlayerListener.a(localCMSAction, bool, paramString1, paramString2);
      return;
    }
  }
  
  public void a(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().toReportFeatureId();
    String str = CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, null, null, 3, null);
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      TraceReportUtil.a(j, str, 3, i, new Object[] { "zipLevel:9, path:" + paramString });
      return;
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.d();
  }
  
  public void b()
  {
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction.a().toReportFeatureId(), CMSAction.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, null, null, 3, null), 3);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSRecordListener
 * JD-Core Version:    0.7.0.1
 */
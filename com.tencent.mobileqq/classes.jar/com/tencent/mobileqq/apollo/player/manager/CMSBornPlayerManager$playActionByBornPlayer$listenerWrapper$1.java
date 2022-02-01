package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener.DefaultImpls;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$playActionByBornPlayer$listenerWrapper$1", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "hasCompleteOrInterrupt", "", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "status", "Lcom/tencent/mobileqq/apollo/player/CMSActionStatus;", "onFirstFrame", "onRecordDone", "success", "recordKey", "", "recordPath", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$playActionByBornPlayer$listenerWrapper$1
  implements ICMSPlayerListener
{
  private boolean jdField_a_of_type_Boolean;
  
  CMSBornPlayerManager$playActionByBornPlayer$listenerWrapper$1(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer) {}
  
  public void a(@NotNull CMSAction paramCMSAction)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a();
    if (localICMSPlayerListener != null) {
      localICMSPlayerListener.a(paramCMSAction);
    }
  }
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    ICMSPlayerListener.DefaultImpls.a(this, paramCMSAction, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramCMSActionStatus, "status");
    if ((paramCMSActionStatus == CMSActionStatus.COMPLETE) || (paramCMSActionStatus == CMSActionStatus.INTERRUPT)) {
      if (this.jdField_a_of_type_Boolean) {
        QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d() + " state change, but hasCompleteOrInterrupt skip!!");
      }
    }
    ICMSPlayerListener localICMSPlayerListener;
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().d() + " state change to " + paramCMSActionStatus);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().b()) {
        if (CMSBornPlayerManager.a(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem)) {
          CMSBornPlayerManager.a(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer);
        }
      }
      for (;;)
      {
        localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a();
        if (localICMSPlayerListener == null) {
          break;
        }
        localICMSPlayerListener.a(paramCMSAction, paramCMSActionStatus);
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a().a().c = false;
        CMSBornPlayerManager.a(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer);
        continue;
        CMSBornPlayerManager.a(CMSBornPlayerManager.a, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayer);
      }
      localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a();
    } while (localICMSPlayerListener == null);
    localICMSPlayerListener.a(paramCMSAction, paramCMSActionStatus);
  }
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramCMSAction, "action");
    Intrinsics.checkParameterIsNotNull(paramString1, "recordKey");
    ICMSPlayerListener localICMSPlayerListener = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerManagerCMSBornPlayerManager$ActionItem.a();
    if (localICMSPlayerListener != null) {
      localICMSPlayerListener.a(paramCMSAction, paramBoolean, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.playActionByBornPlayer.listenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */
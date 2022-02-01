package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ApolloPanel$FrameCallback
  implements GetFrameCallback
{
  private ApolloActionData jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData;
  private List<ApolloViewBinder> jdField_a_of_type_JavaUtilList;
  
  public ApolloPanel$FrameCallback(List<ApolloViewBinder> paramList, ApolloActionData paramApolloActionData)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData = paramApolloActionData;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    QLog.d("ApolloPanel", 1, "ApolloPanel handleCMSPlayerGetFrame success : " + paramBoolean + " actionId: " + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId);
    ThreadManager.getUIHandler().post(new ApolloPanel.FrameCallback.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
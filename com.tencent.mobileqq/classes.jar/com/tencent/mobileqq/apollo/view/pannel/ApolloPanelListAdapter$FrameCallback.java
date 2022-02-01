package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ApolloPanelListAdapter$FrameCallback
  implements GetFrameCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ApolloInfo jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo;
  private ApolloLinearLayout.ViewHolder jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$ViewHolder;
  
  public ApolloPanelListAdapter$FrameCallback(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$ViewHolder = paramViewHolder;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = paramApolloInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$ViewHolder != null) {
      ThreadManager.getUIHandler().post(new ApolloPanelListAdapter.FrameCallback.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
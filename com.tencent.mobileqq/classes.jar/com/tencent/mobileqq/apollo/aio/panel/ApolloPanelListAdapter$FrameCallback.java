package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class ApolloPanelListAdapter$FrameCallback
  implements GetFrameCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ApolloInfo jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo;
  private ApolloLinearLayout.ViewHolder jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder;
  
  public ApolloPanelListAdapter$FrameCallback(ApolloLinearLayout.ViewHolder paramViewHolder, ApolloInfo paramApolloInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder = paramViewHolder;
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = paramApolloInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder != null) {
      ThreadManager.getUIHandler().post(new ApolloPanelListAdapter.FrameCallback.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
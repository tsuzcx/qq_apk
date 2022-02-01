package com.tencent.mobileqq.apollo.api.impl;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class ApolloManagerServiceImpl$FrameCallback
  implements GetFrameCallback
{
  private ApolloActionData jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData;
  private GetFrameCallback jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback;
  
  public ApolloManagerServiceImpl$FrameCallback(ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData = paramApolloActionData;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback = paramGetFrameCallback;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCMSPlayerGetFrame onComplete success:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", action:");
    ((StringBuilder)localObject).append(paramCMSAction.d());
    ((StringBuilder)localObject).append(", path:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("[cmshow]ApolloManager", 1, ((StringBuilder)localObject).toString());
    ApolloManagerServiceImpl.access$1200().remove(paramCMSAction);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      if (FileUtils.copyFile(paramString, CMGetResPathUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 10)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback;
        if (localObject != null) {
          ((GetFrameCallback)localObject).a(true, paramString, paramCMSAction);
        }
        return;
      }
      QLog.d("[cmshow]ApolloManager", 1, "handleCMSPlayerGetFrame copyFile failed.");
    }
    else
    {
      QLog.w("[cmshow]ApolloManager", 1, "handleCMSPlayerGetFrame file not exists.");
    }
    ApolloManagerServiceImpl.access$1100().remove(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId));
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback;
    if (localObject != null) {
      ((GetFrameCallback)localObject).a(false, paramString, paramCMSAction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
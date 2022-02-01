package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import org.jetbrains.annotations.Nullable;

public class ApolloManagerServiceImpl$FrameCallback
  implements GetFrameCallback
{
  private ApolloActionData jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData;
  private GetFrameCallback jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback;
  
  public ApolloManagerServiceImpl$FrameCallback(ApolloActionData paramApolloActionData, GetFrameCallback paramGetFrameCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData = paramApolloActionData;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback = paramGetFrameCallback;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable CMSAction paramCMSAction)
  {
    QLog.d("ApolloManager", 1, "ApolloManager onComplete success:" + paramBoolean + ", path:" + paramString);
    ApolloManagerServiceImpl.access$2400().remove(paramCMSAction);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      if (FileUtils.d(paramString, ApolloUtilImpl.getApolloResPath(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, 10)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback.a(true, paramString, paramCMSAction);
        }
        return;
      }
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame copyFile failed.");
    }
    for (;;)
    {
      ApolloManagerServiceImpl.access$2300().remove(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.actionId));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloPlayerGetFrameCallback.a(false, paramString, paramCMSAction);
      return;
      QLog.d("ApolloManager", 1, "handleCMSPlayerGetFrame file not exists.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.FrameCallback
 * JD-Core Version:    0.7.0.1
 */
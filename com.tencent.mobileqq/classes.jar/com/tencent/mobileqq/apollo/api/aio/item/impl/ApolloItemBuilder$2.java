package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.player.action.CMSAIOAction;
import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloItemBuilder$2
  implements Runnable
{
  ApolloItemBuilder$2(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo) {}
  
  public void run()
  {
    File localFile;
    Object localObject2;
    try
    {
      Object localObject1 = new CMSAIOAction(this.a, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localFile = ApolloScreenshotController.a.a(((CMSAIOAction)localObject1).a(null, null));
      if (localFile == null)
      {
        ApolloItemBuilder.a(this.this$0, 2);
        return;
      }
      localObject2 = localFile.getName();
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(".0")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 2);
      }
      localObject1 = AppConstants.SDCARD_IMG_FAVORITE + (String)localObject1 + ".gif";
      localObject2 = new File((String)localObject1);
      if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
      {
        ApolloItemBuilder.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131689614), 1, this.this$0.jdField_a_of_type_AndroidContentContext);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloItemBuilder", 1, "addNewCmShowAnimToFav error", localException);
      return;
    }
    Object localObject3 = localException + ".temp";
    if (!new ApolloApngEncoder().a(localFile.getAbsolutePath(), (String)localObject3))
    {
      ApolloItemBuilder.a(this.this$0, 3);
      return;
    }
    localObject3 = new File((String)localObject3);
    if ((((File)localObject3).exists()) && (((File)localObject3).length() > 0L))
    {
      ((File)localObject3).renameTo((File)localObject2);
      QLog.i("ApolloItemBuilder", 1, "addNewCmShowAnimToFav " + localFile.getAbsolutePath() + " to " + localException);
    }
    switch (AIOGalleryUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, localException, null, null))
    {
    case 1: 
      ApolloItemBuilder.a(this.this$0, 5);
      return;
      ApolloItemBuilder.a(this.this$0, 4);
      return;
    case 2: 
      ApolloItemBuilder.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131689614), 1, this.this$0.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */
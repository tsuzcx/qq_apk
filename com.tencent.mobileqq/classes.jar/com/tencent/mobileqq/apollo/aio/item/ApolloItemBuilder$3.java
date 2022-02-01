package com.tencent.mobileqq.apollo.aio.item;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.player.action.CMSAIOAction;
import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloItemBuilder$3
  implements Runnable
{
  ApolloItemBuilder$3(ApolloItemBuilder paramApolloItemBuilder, MessageForApollo paramMessageForApollo) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new CMSAIOAction(this.a, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      File localFile = ApolloScreenshotController.a.a(((CMSAIOAction)localObject1).a(null, null));
      if (localFile == null)
      {
        ApolloItemBuilder.a(this.this$0, 2);
        return;
      }
      Object localObject2 = localFile.getName();
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(".0")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_IMG_FAVORITE);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".gif");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
      {
        ApolloItemBuilder.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131689646), 1, this.this$0.jdField_a_of_type_AndroidContentContext);
        return;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".temp");
      localObject3 = ((StringBuilder)localObject3).toString();
      if (!new ApolloApngEncoder().a(localFile.getAbsolutePath(), (String)localObject3))
      {
        ApolloItemBuilder.a(this.this$0, 3);
        return;
      }
      localObject3 = new File((String)localObject3);
      if ((((File)localObject3).exists()) && (((File)localObject3).length() > 0L))
      {
        ((File)localObject3).renameTo((File)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addNewCmShowAnimToFav ");
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(" to ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("[cmshow]ApolloItemBuilder", 1, ((StringBuilder)localObject2).toString());
        int i = AIOGalleryUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, (String)localObject1, null, null);
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              return;
            }
            ApolloItemBuilder.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131689646), 1, this.this$0.jdField_a_of_type_AndroidContentContext);
            return;
          }
          ApolloItemBuilder.a(this.this$0, 5);
        }
      }
      else
      {
        ApolloItemBuilder.a(this.this$0, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloItemBuilder", 1, "addNewCmShowAnimToFav error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */
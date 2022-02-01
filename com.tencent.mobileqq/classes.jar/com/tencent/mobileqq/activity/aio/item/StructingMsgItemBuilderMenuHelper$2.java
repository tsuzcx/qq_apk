package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;

class StructingMsgItemBuilderMenuHelper$2
  implements Runnable
{
  StructingMsgItemBuilderMenuHelper$2(StructingMsgItemBuilderMenuHelper paramStructingMsgItemBuilderMenuHelper, StructMsgItemImage paramStructMsgItemImage, int paramInt, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = URLDrawableHelper.getURL(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemImage.a, 1);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((URL)localObject).toString();
    }
    localObject = AbsDownloader.getFilePath((String)localObject);
    QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemImage.ae, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemImage.ad, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemImage.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemImage.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */
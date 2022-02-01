package com.tencent.mobileqq.activity.aio.item;

import agqa;
import android.app.Activity;
import bcjc;
import bkov;
import bkpf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;

public class StructingMsgItemBuilderMenuHelper$2
  implements Runnable
{
  public StructingMsgItemBuilderMenuHelper$2(agqa paramagqa, bcjc parambcjc, int paramInt, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = URLDrawableHelper.getURL(this.jdField_a_of_type_Bcjc.a, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = AbsDownloader.getFilePath((String)localObject);
      bkov.a(this.jdField_a_of_type_Bcjc.ae, this.jdField_a_of_type_Int, this.jdField_a_of_type_Bcjc.ad, this.jdField_a_of_type_Bcjc.c, (String)localObject, this.jdField_a_of_type_Bcjc.d).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 3);
      bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, 0, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.2
 * JD-Core Version:    0.7.0.1
 */
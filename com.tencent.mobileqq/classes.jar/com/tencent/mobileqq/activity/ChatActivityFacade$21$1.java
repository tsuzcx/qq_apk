package com.tencent.mobileqq.activity;

import adak;
import android.text.TextUtils;
import aqyt;
import axfj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import nlj;

class ChatActivityFacade$21$1
  implements Runnable
{
  ChatActivityFacade$21$1(ChatActivityFacade.21 param21, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1)
    {
      nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      if (adak.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) != 1032) {
        break label296;
      }
      aqyt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
      axfj localaxfj = (axfj)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localaxfj == null) {
        break label376;
      }
      Object localObject = localaxfj.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label376;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(str))
        {
          RecentEmotion localRecentEmotion = new RecentEmotion();
          localRecentEmotion.epId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          localRecentEmotion.eId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
          localRecentEmotion.keyword = str.toLowerCase();
          localRecentEmotion.exposeNum = 0;
          localaxfj.a(localRecentEmotion);
        }
      }
      if (!nlj.a().a) {
        break;
      }
      nlj.a().a = false;
      break;
      label296:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j) {
        aqyt.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k) {
        aqyt.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label376:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " ePackage.copywritingType = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType + " currentTime = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.21.1
 * JD-Core Version:    0.7.0.1
 */
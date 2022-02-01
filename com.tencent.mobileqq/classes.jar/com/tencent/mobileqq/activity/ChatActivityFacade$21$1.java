package com.tencent.mobileqq.activity;

import acnh;
import android.text.TextUtils;
import aqvh;
import awyr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import nty;

class ChatActivityFacade$21$1
  implements Runnable
{
  ChatActivityFacade$21$1(ChatActivityFacade.21 param21, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.entrance;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1)
    {
      nty.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      if (acnh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType) != 1032) {
        break label297;
      }
      aqvh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.topicId);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addAndSendMessage(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
      awyr localawyr = (awyr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      if (localawyr == null) {
        break label377;
      }
      Object localObject = localawyr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label377;
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
          localawyr.a(localRecentEmotion);
        }
      }
      if (!nty.a().a) {
        break;
      }
      nty.a().a = false;
      break;
      label297:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isFromFrdRecConfess) {
        aqvh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isFromGroupRecConfess) {
        aqvh.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
    }
    label377:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " ePackage.copywritingType = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType + " currentTime = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.21.1
 * JD-Core Version:    0.7.0.1
 */
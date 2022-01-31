package com.tencent.mobileqq.activity;

import acvh;
import akbm;
import alyc;
import android.text.TextUtils;
import arnz;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mnf;

class ChatActivityFacade$20$1
  implements Runnable
{
  ChatActivityFacade$20$1(ChatActivityFacade.20 param20, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1)
    {
      mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
      if (akbm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) != 1032) {
        break label317;
      }
      alyc.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    }
    for (;;)
    {
      acvh.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.uniseq, 0L, this.this$0.jdField_a_of_type_Int);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
      arnz localarnz = (arnz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localarnz == null) {
        break label397;
      }
      Object localObject = localarnz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label397;
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
          localarnz.a(localRecentEmotion);
        }
      }
      if (!mnf.a().a) {
        break;
      }
      mnf.a().a = false;
      break;
      label317:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.j) {
        alyc.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k) {
        alyc.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label397:
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "mainRunnable, epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + " ePackage.copywritingType = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType + " currentTime = " + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.20.1
 * JD-Core Version:    0.7.0.1
 */
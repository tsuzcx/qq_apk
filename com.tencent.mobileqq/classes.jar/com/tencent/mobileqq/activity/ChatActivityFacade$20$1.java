package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ChatActivityFacade$20$1
  implements Runnable
{
  ChatActivityFacade$20$1(ChatActivityFacade.20 param20, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.sendFaceName = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.msgVia = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.c;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.istroop == 1) {
      AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace);
    } else if (AnonymousChatHelper.a().a) {
      AnonymousChatHelper.a().a = false;
    }
    if (UinTypeUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int) == 1032) {
      ConfessMsgUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.e);
    } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.j) {
      ConfessMsgUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    } else if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.k) {
      ConfessMsgUtil.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
    ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.uniseq, 0L, this.this$0.jdField_a_of_type_Int);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace, null);
    Object localObject1 = (IEmoticonManagerService)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    if (localObject1 != null)
    {
      Object localObject2 = ((IEmoticonManagerService)localObject1).getKeywordsByEmoticon(this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(str))
          {
            RecentEmotion localRecentEmotion = new RecentEmotion();
            localRecentEmotion.epId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
            localRecentEmotion.eId = this.this$0.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
            localRecentEmotion.keyword = str.toLowerCase();
            localRecentEmotion.exposeNum = 0;
            ((IEmoticonManagerService)localObject1).addRecentEmotionToCache(localRecentEmotion);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mainRunnable, epId = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      ((StringBuilder)localObject1).append(" ePackage.copywritingType = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.copywritingType);
      ((StringBuilder)localObject1).append(" currentTime = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.20.1
 * JD-Core Version:    0.7.0.1
 */
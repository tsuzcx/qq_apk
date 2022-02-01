package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class ChatActivityFacade$19
  implements Runnable
{
  ChatActivityFacade$19(Emoticon paramEmoticon, IEmoticonManagerService paramIEmoticonManagerService, IEmojiManagerService paramIEmojiManagerService) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 0)
    {
      localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonManagerService.syncGetSubEmoticonsByPackageId(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.fetchEmoticonEncryptKeys(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, (ArrayList)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("func tryFetchEmosmKey, try fetch normal emotion keys. epId:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          ((StringBuilder)localObject).append(",cur emo id:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.fetchEmoticonEncryptKeys(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, (ArrayList)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func tryFetchEmosmKey, try fetch magic emotion key. epId:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        ((StringBuilder)localObject).append(",cur emo id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.19
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import java.util.List;

class TroopRelevantHandler$TmiCallBackForTroopHonor
  implements TroopManager.ITroopMemberInfoCallBack
{
  public BaseChatItemLayout a;
  public String a;
  
  private TroopRelevantHandler$TmiCallBackForTroopHonor(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = ((ITroopHonorService)TroopRelevantHandler.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler).getRuntimeService(ITroopHonorService.class, "")).convertToHonorList(paramTroopMemberInfo.honorList, Byte.valueOf(paramTroopMemberInfo.mHonorRichFlag));
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      if (localObject != null)
      {
        localObject = ((BaseChatItemLayout)localObject).a(NickNameChatItemLayoutProcessor.c);
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
        {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setData(new Object[] { paramTroopMemberInfo, Integer.valueOf(1) });
          if ((paramTroopMemberInfo != null) && (paramTroopMemberInfo.size() > 0))
          {
            ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(TroopRelevantHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler));
            return;
          }
          ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForTroopHonor
 * JD-Core Version:    0.7.0.1
 */
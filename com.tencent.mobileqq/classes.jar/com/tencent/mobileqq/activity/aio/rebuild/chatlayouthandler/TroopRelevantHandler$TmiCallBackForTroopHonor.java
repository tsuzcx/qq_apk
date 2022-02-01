package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
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
    NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility;
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = ((ITroopHonorService)TroopRelevantHandler.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler).getRuntimeService(ITroopHonorService.class, "")).convertToHonorList(paramTroopMemberInfo.honorList, Byte.valueOf(paramTroopMemberInfo.mHonorRichFlag));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null)
      {
        localNickNameExtenderViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutProcessor.c);
        if ((localNickNameExtenderViewBasicAbility != null) && (localNickNameExtenderViewBasicAbility.checkViewNonNull()))
        {
          localNickNameExtenderViewBasicAbility.setData(new Object[] { paramTroopMemberInfo, Integer.valueOf(1) });
          if ((paramTroopMemberInfo == null) || (paramTroopMemberInfo.size() <= 0)) {
            break label135;
          }
          localNickNameExtenderViewBasicAbility.setOnClickListener(TroopRelevantHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler));
        }
      }
    }
    return;
    label135:
    localNickNameExtenderViewBasicAbility.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForTroopHonor
 * JD-Core Version:    0.7.0.1
 */
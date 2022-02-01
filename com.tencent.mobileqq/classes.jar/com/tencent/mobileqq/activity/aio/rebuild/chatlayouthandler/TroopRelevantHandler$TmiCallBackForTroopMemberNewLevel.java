package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.qphone.base.util.QLog;

class TroopRelevantHandler$TmiCallBackForTroopMemberNewLevel
  implements TroopManager.ITroopMemberInfoCallBack
{
  public BaseChatItemLayout a;
  public TroopInfo a;
  public String a;
  
  private TroopRelevantHandler$TmiCallBackForTroopMemberNewLevel(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)) {}
    label21:
    int j;
    do
    {
      break label21;
      do
      {
        return;
      } while (!this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin));
      j = paramTroopMemberInfo.newRealLevel;
      i = j;
      if (j == 0) {
        i = TroopMemberLevelUtils.b(paramTroopMemberInfo.realLevel);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopRelevantHandler", 2, "TmiCallBackForTroopMemberNewLevel: realLevel = " + paramTroopMemberInfo.realLevel + ",newRealLevel = " + paramTroopMemberInfo.newRealLevel);
      }
      paramTroopMemberInfo = TroopMemberLevelUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopMemberInfo.memberuin, i, paramTroopMemberInfo.level, paramTroopMemberInfo.mUniqueTitle, paramTroopMemberInfo.mHonorRichFlag);
    } while (paramTroopMemberInfo == null);
    if ((TroopRelevantHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler).jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(TroopRelevantHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler).jdField_a_of_type_JavaLangString))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = AnonymousChatHelper.e;
        j = TroopRankConfig.a().jdField_a_of_type_Int;
        paramTroopMemberInfo.a = new int[] { j, j };
        paramTroopMemberInfo.b = new int[] { j, j };
        paramTroopMemberInfo.d = i;
        paramTroopMemberInfo.c = i;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) {
        break;
      }
      NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutProcessor.i);
      if ((localNickNameExtenderViewBasicAbility == null) || (!localNickNameExtenderViewBasicAbility.checkViewNonNull())) {
        break;
      }
      localNickNameExtenderViewBasicAbility.setData(new Object[] { paramTroopMemberInfo });
      localNickNameExtenderViewBasicAbility.setOnClickListener(TroopRelevantHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler));
      localNickNameExtenderViewBasicAbility.setTag(Integer.valueOf(2131364674));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel
 * JD-Core Version:    0.7.0.1
 */
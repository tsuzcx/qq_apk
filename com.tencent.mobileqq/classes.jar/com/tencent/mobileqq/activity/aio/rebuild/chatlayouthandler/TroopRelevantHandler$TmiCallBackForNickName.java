package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor.NickNameLayoutData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;

class TroopRelevantHandler$TmiCallBackForNickName
  implements TroopManager.ITroopMemberInfoCallBack
{
  public int a;
  public ColorStateList a;
  public BaseBubbleBuilder.ViewHolder a;
  public BaseChatItemLayout a;
  public ChatMessage a;
  public CharSequence a;
  public String a;
  public boolean a;
  public ColorStateList b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  private TroopRelevantHandler$TmiCallBackForNickName(TroopRelevantHandler paramTroopRelevantHandler)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localObject1 = (HotChatManager)TroopRelevantHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      localObject1 = new ColorNickText(ContactUtils.a(TroopRelevantHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler), paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, true), 13).a();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_type");
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_level");
      String str1 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("bigClub_type");
      String str2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("bigClub_level");
      String str3 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_card_id");
      String str4 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("vip_ext_card_id");
      int i = VipUtils.a((String)localObject2, 0);
      int j = VipUtils.a((String)localObject3, 0);
      int k = VipUtils.a(str1, 0);
      int m = VipUtils.a(str2, 0);
      int n = VipUtils.a(str3, 0);
      int i1 = VipUtils.a(str4, 0);
      localObject2 = this.jdField_a_of_type_AndroidContentResColorStateList;
      boolean bool;
      if (((!this.jdField_a_of_type_Boolean) || (!AnonymousChatHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (!TroopConfessUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
        bool = false;
      } else {
        bool = true;
      }
      localObject2 = new NickNameChatItemLayoutProcessor.NickNameLayoutData((CharSequence)localObject1, (ColorStateList)localObject2, bool, this.jdField_b_of_type_Boolean, this.d, this.c, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_JavaLangString, i, j, k, m, n, i1, paramTroopMemberInfo.mIsHideBigClub);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      if ((localObject1 == null) && (!this.jdField_a_of_type_Boolean)) {
        bool = false;
      } else {
        bool = true;
      }
      ((BaseChatItemLayout)localObject3).setNick(bool, (NickNameChatItemLayoutProcessor.NickNameLayoutData)localObject2);
      if (this.jdField_a_of_type_Int == 1) {
        TroopRelevantHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler, ((CharSequence)localObject1).toString(), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
      if (localObject2 != null) {
        ((BaseChatItemLayoutViewBasicAbility)localObject2).setData(new Object[] { TroopRelevantHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler), localObject1, Integer.valueOf(paramTroopMemberInfo.troopColorNickId), Boolean.valueOf(false) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForNickName
 * JD-Core Version:    0.7.0.1
 */
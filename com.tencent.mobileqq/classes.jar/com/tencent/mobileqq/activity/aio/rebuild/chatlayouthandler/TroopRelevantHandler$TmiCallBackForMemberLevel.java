package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;

class TroopRelevantHandler$TmiCallBackForMemberLevel
  implements TroopManager.ITroopMemberInfoCallBack
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private TroopRelevantHandler$TmiCallBackForMemberLevel(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramInt = TroopRankConfig.a().jdField_a_of_type_Int;
    }
    return paramInt;
  }
  
  private String a(TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    String str = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
      if (!paramBoolean2)
      {
        str = paramString;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupRankUserFlag) {}
      }
      else
      {
        str = paramString;
        if (!paramBoolean1)
        {
          paramBoolean1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            break label96;
          }
          str = "";
          if (!paramBoolean1) {
            break label102;
          }
          str = HardCodeUtil.a(2131720289);
        }
      }
    }
    label96:
    label102:
    while (i == 0)
    {
      return str;
      i = 0;
      break;
    }
    return HardCodeUtil.a(2131720286);
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler.jdField_a_of_type_Boolean = paramBoolean;
      NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameLayoutProcessor.j);
      if ((localNickNameExtenderViewBasicAbility != null) && (localNickNameExtenderViewBasicAbility.checkViewNonNull()))
      {
        localNickNameExtenderViewBasicAbility.setData(new Object[] { TroopRelevantHandler.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler), Boolean.valueOf(paramBoolean), paramString, Boolean.valueOf(false), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int) });
        localNickNameExtenderViewBasicAbility.setOnClickListener(TroopRelevantHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler));
        localNickNameExtenderViewBasicAbility.setTag(Integer.valueOf(2131364673));
      }
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    Object localObject1 = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    TroopRankConfig.TroopRankItem localTroopRankItem1;
    TroopRankConfig.TroopRankItem localTroopRankItem2;
    Object localObject2;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      localTroopRankItem1 = null;
      localTroopRankItem2 = null;
      localObject2 = null;
      localObject1 = null;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop();
      bool3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop();
      bool4 = SimpleUIUtil.a();
      if (!bool4) {
        break label210;
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label205;
      }
      i = 1;
      localTroopRankItem1 = TroopRankConfig.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      if ((localTroopRankItem1 == null) || ((i == 0) && (!bool1))) {
        break label419;
      }
      localObject1 = localTroopRankItem1.a;
    }
    label401:
    label410:
    label419:
    for (int i = localTroopRankItem1.b;; i = 0)
    {
      i = a(i);
      for (;;)
      {
        paramTroopMemberInfo = a(paramTroopMemberInfo, (String)localObject1, bool3, bool4);
        if (TroopMemberLevelUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))
        {
          bool1 = bool2;
          label197:
          a(paramTroopMemberInfo, i, bool1);
          return;
          label205:
          i = 0;
          break;
          label210:
          if (bool1)
          {
            boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
            for (bool1 = true;; bool1 = false)
            {
              localTroopRankItem2 = TroopRankConfig.a().a(bool5, bool1);
              if (localTroopRankItem2 == null) {
                break label410;
              }
              localObject1 = localTroopRankItem2.a;
              i = localTroopRankItem2.b;
              break;
            }
          }
          if (bool3)
          {
            localTroopRankItem1 = TroopRankConfig.a().a(paramTroopMemberInfo.level, false, false, false);
            if ((localTroopRankItem1 == null) || (!HWTroopUtils.a(paramTroopMemberInfo))) {
              break label401;
            }
            localObject1 = localTroopRankItem1.a;
            i = localTroopRankItem1.b;
          }
        }
        for (;;)
        {
          i = a(i);
          break;
          localTroopRankItem1 = TroopRankConfig.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (localTroopRankItem1 != null)
          {
            localObject1 = localTroopRankItem1.a;
            i = localTroopRankItem1.b;
          }
          for (;;)
          {
            i = a(i);
            break;
            bool1 = true;
            break label197;
            i = 0;
            localObject1 = localObject2;
          }
          i = 0;
          localObject1 = localTroopRankItem2;
        }
        i = 0;
        localObject1 = localTroopRankItem1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForMemberLevel
 * JD-Core Version:    0.7.0.1
 */
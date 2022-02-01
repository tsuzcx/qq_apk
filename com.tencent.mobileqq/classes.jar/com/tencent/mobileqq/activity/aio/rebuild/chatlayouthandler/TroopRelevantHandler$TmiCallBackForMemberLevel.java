package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
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
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    String str = paramString;
    if (localTroopInfo != null)
    {
      int i = 1;
      if (!paramBoolean2)
      {
        str = paramString;
        if (1 == localTroopInfo.cGroupRankUserFlag) {}
      }
      else
      {
        str = paramString;
        if (!paramBoolean1)
        {
          paramBoolean1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            i = 0;
          }
          if (paramBoolean1) {
            return HardCodeUtil.a(2131720028);
          }
          if (i != 0) {
            return HardCodeUtil.a(2131720025);
          }
          str = "";
        }
      }
    }
    return str;
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler.jdField_a_of_type_Boolean = paramBoolean;
      BaseChatItemLayoutViewBasicAbility localBaseChatItemLayoutViewBasicAbility = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.j);
      if ((localBaseChatItemLayoutViewBasicAbility != null) && (localBaseChatItemLayoutViewBasicAbility.checkViewNonNull()))
      {
        localBaseChatItemLayoutViewBasicAbility.setData(new Object[] { TroopRelevantHandler.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler), Boolean.valueOf(paramBoolean), paramString, Boolean.valueOf(false), Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int) });
        localBaseChatItemLayoutViewBasicAbility.setOnClickListener(TroopRelevantHandler.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildChatlayouthandlerTroopRelevantHandler));
        localBaseChatItemLayoutViewBasicAbility.setTag(Integer.valueOf(2131364560));
      }
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localTroopInfo != null)
      {
        TroopRankConfig.TroopRankItem localTroopRankItem2 = null;
        localObject1 = null;
        Object localObject2 = null;
        TroopRankConfig.TroopRankItem localTroopRankItem1 = null;
        boolean bool1 = localTroopInfo.isQidianPrivateTroop();
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop();
        boolean bool3 = SimpleUIUtil.a();
        int j = 0;
        int i = 0;
        int k = 0;
        if (bool3)
        {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            i = 1;
          } else {
            i = 0;
          }
          localTroopRankItem2 = TroopRankConfig.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          localObject1 = localTroopRankItem1;
          j = k;
          if (localTroopRankItem2 != null) {
            if (i == 0)
            {
              localObject1 = localTroopRankItem1;
              j = k;
              if (!bool1) {}
            }
            else
            {
              localObject1 = localTroopRankItem2.a;
              j = localTroopRankItem2.b;
            }
          }
          i = a(j);
        }
        else if (bool1)
        {
          boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localTroopRankItem1 = TroopRankConfig.a().a(bool4, bool1);
          if (localTroopRankItem1 != null)
          {
            localObject1 = localTroopRankItem1.a;
            i = localTroopRankItem1.b;
          }
          else
          {
            i = 0;
            localObject1 = localObject2;
          }
        }
        else if (bool2)
        {
          localTroopRankItem1 = TroopRankConfig.a().a(paramTroopMemberInfo.level, false, false, false);
          localObject1 = localTroopRankItem2;
          i = j;
          if (localTroopRankItem1 != null)
          {
            localObject1 = localTroopRankItem2;
            i = j;
            if (HWTroopUtils.a(paramTroopMemberInfo))
            {
              localObject1 = localTroopRankItem1.a;
              i = localTroopRankItem1.b;
            }
          }
          i = a(i);
        }
        else
        {
          localTroopRankItem1 = TroopRankConfig.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (localTroopRankItem1 != null)
          {
            localObject1 = localTroopRankItem1.a;
            i = localTroopRankItem1.b;
          }
          i = a(i);
        }
        a(a(paramTroopMemberInfo, (String)localObject1, bool2, bool3), i, ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin) ^ true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForMemberLevel
 * JD-Core Version:    0.7.0.1
 */
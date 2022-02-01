package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.qphone.base.util.QLog;

class TroopRelevantHandler$TmiCallBackForTroopMemberNewLevel
  implements TroopManager.ITroopMemberInfoCallBack
{
  public BaseChatItemLayout a;
  public String b;
  public TroopInfo c;
  
  private TroopRelevantHandler$TmiCallBackForTroopMemberNewLevel(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.b)))
    {
      if (this.c == null) {
        return;
      }
      if (!this.b.equals(paramTroopMemberInfo.memberuin)) {
        return;
      }
      int j = paramTroopMemberInfo.newRealLevel;
      int i = j;
      if (j == 0) {
        i = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramTroopMemberInfo.realLevel);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TmiCallBackForTroopMemberNewLevel: realLevel = ");
        ((StringBuilder)localObject).append(paramTroopMemberInfo.realLevel);
        ((StringBuilder)localObject).append(",newRealLevel = ");
        ((StringBuilder)localObject).append(paramTroopMemberInfo.newRealLevel);
        QLog.d("TroopRelevantHandler", 2, ((StringBuilder)localObject).toString());
      }
      paramTroopMemberInfo = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.c, paramTroopMemberInfo.memberuin, i, paramTroopMemberInfo.level, paramTroopMemberInfo.mUniqueTitle, paramTroopMemberInfo.mHonorRichFlag);
      if (paramTroopMemberInfo == null) {
        return;
      }
      if ((TroopRelevantHandler.f(this.d).a == 1) && (AnonymousChatHelper.a().a(TroopRelevantHandler.g(this.d).b))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        i = AnonymousChatHelper.e;
        j = TroopRankConfig.a().a;
        paramTroopMemberInfo.d = new int[] { j, j };
        paramTroopMemberInfo.e = new int[] { j, j };
        paramTroopMemberInfo.i = i;
        paramTroopMemberInfo.h = i;
      }
      Object localObject = this.a;
      if (localObject != null)
      {
        localObject = ((BaseChatItemLayout)localObject).a(NickNameChatItemLayoutProcessor.i);
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
        {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setData(new Object[] { paramTroopMemberInfo });
          ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(TroopRelevantHandler.h(this.d));
          ((BaseChatItemLayoutViewBasicAbility)localObject).setTag(Integer.valueOf(2131430620));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel
 * JD-Core Version:    0.7.0.1
 */
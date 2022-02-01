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
  public boolean a;
  public ColorStateList b;
  public boolean c;
  public boolean d;
  public CharSequence e;
  public ColorStateList f;
  public boolean g;
  public String h;
  public BaseChatItemLayout i;
  public ChatMessage j;
  public BaseBubbleBuilder.ViewHolder k;
  public int l = 1;
  
  private TroopRelevantHandler$TmiCallBackForNickName(TroopRelevantHandler paramTroopRelevantHandler) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (BaseBubbleBuilder.ViewHolder)this.i.getTag();
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject1).q.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localObject1 = (HotChatManager)TroopRelevantHandler.a(this.m).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      localObject1 = new ColorNickText(ContactUtils.a(TroopRelevantHandler.b(this.m), paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, true), 13).b();
      Object localObject2 = this.j.getExtInfoFromExtStr("vip_type");
      Object localObject3 = this.j.getExtInfoFromExtStr("vip_level");
      String str1 = this.j.getExtInfoFromExtStr("bigClub_type");
      String str2 = this.j.getExtInfoFromExtStr("bigClub_level");
      String str3 = this.j.getExtInfoFromExtStr("vip_card_id");
      String str4 = this.j.getExtInfoFromExtStr("vip_ext_card_id");
      int n = VipUtils.a((String)localObject2, 0);
      int i1 = VipUtils.a((String)localObject3, 0);
      int i2 = VipUtils.a(str1, 0);
      int i3 = VipUtils.a(str2, 0);
      int i4 = VipUtils.a(str3, 0);
      int i5 = VipUtils.a(str4, 0);
      localObject2 = this.b;
      boolean bool;
      if (((!this.a) || (!AnonymousChatHelper.f(this.j))) && (!TroopConfessUtil.c(this.j)) && (!this.j.isSend())) {
        bool = false;
      } else {
        bool = true;
      }
      localObject2 = new NickNameChatItemLayoutProcessor.NickNameLayoutData((CharSequence)localObject1, (ColorStateList)localObject2, bool, this.c, this.g, this.d, this.e, this.f, this.h, n, i1, i2, i3, i4, i5, paramTroopMemberInfo.mIsHideBigClub);
      localObject3 = this.i;
      if ((localObject1 == null) && (!this.a)) {
        bool = false;
      } else {
        bool = true;
      }
      ((BaseChatItemLayout)localObject3).setNick(bool, (NickNameChatItemLayoutProcessor.NickNameLayoutData)localObject2);
      if (this.l == 1) {
        TroopRelevantHandler.a(this.m, ((CharSequence)localObject1).toString(), this.j, this.i, this.k);
      }
      localObject2 = this.i.a(NickNameChatItemLayoutProcessor.h);
      if (localObject2 != null) {
        ((BaseChatItemLayoutViewBasicAbility)localObject2).setData(new Object[] { TroopRelevantHandler.c(this.m), localObject1, Integer.valueOf(paramTroopMemberInfo.troopColorNickId), Boolean.valueOf(false) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler.TmiCallBackForNickName
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.recent.msg.littleear.creator;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.ArkInfoMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentMsgProxy;
import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopConfessToMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopEffectPicMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHasGiftMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopHomeworkPraiseMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopKeyWordMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopPubAccountMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceiptMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopReplyMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopShopArkMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopStickerNotifyMsg;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.troop_homework.model.TroopHomeworkSpecialMsg;

public class RecentMsgProxyProviderListProvider
  implements Provider<SparseArray<Provider<RecentMsgProxy>>>
{
  private final SparseArray<AbstructRecentUserMsg> a = new SparseArray();
  
  public RecentMsgProxyProviderListProvider()
  {
    this.a.put(17, new TroopSpecialAttentionMsg(BaseApplication.getContext()));
    this.a.put(16, new TroopKeyWordMsg(BaseApplication.getContext()));
    this.a.put(10, new TroopConfessToMeMsg(BaseApplication.getContext()));
    this.a.put(24, new TroopAtMeMsg(BaseApplication.getContext()));
    this.a.put(13, new TroopAtAllMsg(BaseApplication.getContext()));
    this.a.put(5, new TroopHomeworkSpecialMsg(BaseApplication.getContext()));
    this.a.put(7, new TroopHasGiftMsg(BaseApplication.getContext()));
    this.a.put(22, new TroopReplyMsg(BaseApplication.getContext()));
    this.a.put(3, new TroopNewFileMsg(BaseApplication.getContext(), 1));
    this.a.put(2, new TroopNewFileMsg(BaseApplication.getContext(), 0));
    this.a.put(21, new TroopCalendarMsg(BaseApplication.getContext()));
    this.a.put(8, new TroopPubAccountMsg(BaseApplication.getContext()));
    this.a.put(4, new TroopHomeworkPraiseMsg(BaseApplication.getContext()));
    this.a.put(9, new TroopStickerNotifyMsg(BaseApplication.getContext()));
    this.a.put(12, new TroopReceiptMsg(BaseApplication.getContext()));
    this.a.put(6, new TroopEffectPicMsg(BaseApplication.getContext()));
    this.a.put(20, new ArkInfoMsg(BaseApplication.getContext(), ""));
    this.a.put(23, new TroopShopArkMsg(BaseApplication.getContext()));
    Object localObject = new TroopNotificationMsg(BaseApplication.getContext(), false);
    this.a.put(29, localObject);
    this.a.put(11, localObject);
    localObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
    this.a.put(27, localObject);
    this.a.put(14, localObject);
  }
  
  public SparseArray<Provider<RecentMsgProxy>> a()
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    while (i < this.a.size())
    {
      localSparseArray.put(this.a.keyAt(i), new RecentMsgProvider((AbstructRecentUserMsg)this.a.valueAt(i)));
      i += 1;
    }
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.littleear.creator.RecentMsgProxyProviderListProvider
 * JD-Core Version:    0.7.0.1
 */
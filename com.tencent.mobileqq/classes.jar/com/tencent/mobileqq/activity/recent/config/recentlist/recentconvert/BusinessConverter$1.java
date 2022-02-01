package com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemActivateFriendsData;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMsgBox;
import com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemQCallData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRIJPrivateItemData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentItemGameMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemFilterMsgBoxData;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentItemTempMsgBoxData;

final class BusinessConverter$1
  extends SparseArray<Class<? extends RecentBaseData>>
{
  BusinessConverter$1()
  {
    put(5000, RecentItemTroopAssistant.class);
    put(5001, RecentHotChatCenterItem.class);
    put(6000, RecentItemPcDataLine.class);
    put(6003, RecentItemPcDataLine.class);
    put(6002, RecentItemRouterDataLine.class);
    put(7000, RecentItemSubAccount.class);
    put(1009, RecentItemMsgBox.class);
    put(1001, RecentItemMsgBox.class);
    put(1010, RecentItemMsgBox.class);
    put(10002, RecentItemMsgBox.class);
    put(10005, RecentItemImaxADData.class);
    put(1, RecentItemTroopMsgData.class);
    put(6004, RecentItemTencentDocsAssistantData.class);
    put(3000, RecentItemDiscussionMsgData.class);
    put(9000, RecentItemTroopNotification.class);
    put(4001, RecentItemTroopNotification.class);
    put(9003, SendBlessRecentItemData.class);
    put(8112, RecentItemMayKnowFriendVerticalListData.class);
    put(8113, RecentItemRecommendTroopData.class);
    put(7230, RecentItemServiceAccountFolderData.class);
    put(7120, RecentItemEcShopAssitant.class);
    put(8, RecentItemQCallData.class);
    put(1031, RecentItemChatMsgData.class);
    put(1032, RecentItemConfessMsgBox.class);
    put(1033, RecentItemConfessMsgBox.class);
    put(1034, RecentItemConfessMsgBox.class);
    put(9002, RecentItemActivateFriendsData.class);
    put(1038, RecentItemAppletsFolderData.class);
    put(8114, RecentItemContactsGuideData.class);
    put(10011, RecentItemTempMsgBoxData.class);
    put(10012, RecentItemFilterMsgBoxData.class);
    put(10013, RecentItemRIJPrivateItemData.class);
    put(10015, RecentItemGameMsgBoxData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.BusinessConverter.1
 * JD-Core Version:    0.7.0.1
 */
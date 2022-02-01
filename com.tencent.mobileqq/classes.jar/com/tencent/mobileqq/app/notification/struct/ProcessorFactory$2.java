package com.tencent.mobileqq.app.notification.struct;

import com.tencent.mobileqq.app.notification.processor.basemessage.C2CFriendNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.basemessage.DiscussionNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.basemessage.TempSessionNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.basemessage.TroopNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.ActivateFriendsNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.ConfessNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.DatalinePcNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.DateNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.DeviceMsgNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.KandianLockscreenInteractPushNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.KandianMergeNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.MatchChatNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.PublicAccountNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.SubAccountAssistantNotificationProcessor;
import com.tencent.mobileqq.app.notification.processor.business.TempGameMsgNotificationProcessor;
import com.tencent.mobileqq.guild.temp.api.GuildManagerProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class ProcessorFactory$2
  extends HashMap<Integer, Class<? extends BaseUinTypeProcessor>>
{
  ProcessorFactory$2()
  {
    if (ProcessorFactory.a() != null) {
      ProcessorFactory.a().isEmpty();
    }
    Iterator localIterator = ProcessorFactory.a().iterator();
    while (localIterator.hasNext()) {
      put((Integer)localIterator.next(), TempSessionNotificationProcessor.class);
    }
    put(Integer.valueOf(3000), DiscussionNotificationProcessor.class);
    put(Integer.valueOf(1), TroopNotificationProcessor.class);
    put(Integer.valueOf(10014), GuildManagerProvider.j());
    put(Integer.valueOf(7000), SubAccountAssistantNotificationProcessor.class);
    put(Integer.valueOf(6000), DatalinePcNotificationProcessor.class);
    put(Integer.valueOf(1010), DateNotificationProcessor.class);
    put(Integer.valueOf(1001), DateNotificationProcessor.class);
    put(Integer.valueOf(10002), DateNotificationProcessor.class);
    put(Integer.valueOf(1032), ConfessNotificationProcessor.class);
    put(Integer.valueOf(1044), MatchChatNotificationProcessor.class);
    put(Integer.valueOf(1045), MatchChatNotificationProcessor.class);
    put(Integer.valueOf(1008), PublicAccountNotificationProcessor.class);
    put(Integer.valueOf(9002), ActivateFriendsNotificationProcessor.class);
    put(Integer.valueOf(9501), DeviceMsgNotificationProcessor.class);
    put(Integer.valueOf(10007), TempGameMsgNotificationProcessor.class);
    put(Integer.valueOf(7220), KandianMergeNotificationProcessor.class);
    put(Integer.valueOf(7225), KandianLockscreenInteractPushNotificationProcessor.class);
    put(Integer.valueOf(0), C2CFriendNotificationProcessor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.ProcessorFactory.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.imcore.message.facade;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.message.DiscMessageManager;
import com.tencent.mobileqq.app.message.HCTopicMessageManager;
import com.tencent.mobileqq.app.message.SubMessageManager;
import com.tencent.mobileqq.app.message.TinyIdMsgMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import java.util.HashMap;
import mqq.app.AppRuntime;

class MsgManagerProvider$1
  extends HashMap<Integer, BaseMessageManager>
{
  MsgManagerProvider$1(MsgManagerProvider paramMsgManagerProvider, AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    put(Integer.valueOf(1), new TroopMessageManager(this.val$app, this.val$msgPool));
    put(Integer.valueOf(3000), new DiscMessageManager(this.val$app, this.val$msgPool));
    put(Integer.valueOf(7000), new SubMessageManager(this.val$app, this.val$msgPool));
    put(Integer.valueOf(1026), new HCTopicMessageManager(this.val$app, this.val$msgPool));
    put(Integer.valueOf(10007), new TinyIdMsgMessageManager(this.val$app, this.val$msgPool));
    put(Integer.valueOf(10014), ((IGuildMessageManagerApi)QRoute.api(IGuildMessageManagerApi.class)).newGuildMessageManager(this.val$app, this.val$msgPool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.MsgManagerProvider.1
 * JD-Core Version:    0.7.0.1
 */
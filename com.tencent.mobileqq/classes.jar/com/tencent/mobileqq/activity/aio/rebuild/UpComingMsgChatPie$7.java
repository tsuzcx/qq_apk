package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class UpComingMsgChatPie$7
  extends FriendListObserver
{
  UpComingMsgChatPie$7(UpComingMsgChatPie paramUpComingMsgChatPie) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    UpComingMsgChatPie.c(this.a).removeMessages(24);
    Object localObject = this.a.ao;
    int i = 1;
    if ((localObject != null) && (this.a.ao.isShowing()))
    {
      if (MultiMsgManager.a().e != 2) {
        this.a.ao.dismiss();
      }
      MultiMsgManager.a().d.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().d.putAll((Map)paramObject);
      }
      if (MultiMsgManager.a().d.size() == 0) {
        QQToast.makeText(this.a.d.getApp(), 2131896472, 0).show(this.a.A());
      } else if (paramObject != null) {
        ((MultiForwardHelper)UpComingMsgChatPie.d(this.a).a(1)).a((Map)paramObject, MultiMsgManager.a().c, MultiMsgManager.a().e);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = this.a.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetFriendNickBatch = ");
        localStringBuilder.append(paramObject);
        QLog.d((String)localObject, 4, localStringBuilder.toString());
      }
      return;
    }
    localObject = new HashMap();
    if ((!paramBoolean) && ((paramObject instanceof Integer))) {
      i = ((Integer)paramObject).intValue();
    } else if (paramBoolean) {
      i = 0;
    }
    paramObject = new StringBuilder();
    paramObject.append(i);
    paramObject.append("");
    ((HashMap)localObject).put("result", paramObject.toString());
    paramObject = new StringBuilder();
    paramObject.append(NetworkUtil.getSystemNetwork(BaseApplication.getContext()));
    paramObject.append("");
    ((HashMap)localObject).put("netType", paramObject.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.d.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */
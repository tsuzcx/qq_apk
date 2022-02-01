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
    UpComingMsgChatPie.a(this.a).removeMessages(24);
    Object localObject = this.a.c;
    int i = 1;
    if ((localObject != null) && (this.a.c.isShowing()))
    {
      if (MultiMsgManager.a().jdField_a_of_type_Int != 2) {
        this.a.c.dismiss();
      }
      MultiMsgManager.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        MultiMsgManager.a().b.putAll((Map)paramObject);
      }
      if (MultiMsgManager.a().b.size() == 0) {
        QQToast.a(this.a.a.getApp(), 2131698526, 0).b(this.a.a());
      } else if (paramObject != null) {
        ((MultiForwardHelper)UpComingMsgChatPie.a(this.a).a(1)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = this.a.b;
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.a.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */
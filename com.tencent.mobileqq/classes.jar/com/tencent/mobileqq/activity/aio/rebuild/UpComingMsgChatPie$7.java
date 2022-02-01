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
  
  public void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    UpComingMsgChatPie.a(this.a).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.a.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label328;
        }
        i = 1;
        break;
        if (MultiMsgManager.a().jdField_a_of_type_Int != 2) {
          this.a.c.dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          MultiMsgManager.a().b.putAll((Map)paramObject);
        }
        if (MultiMsgManager.a().b.size() == 0) {
          QQToast.a(this.a.a.getApp(), 2131698460, 0).b(this.a.a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d(this.a.b, 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            ((MultiForwardHelper)UpComingMsgChatPie.a(this.a).a(1)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
          }
        }
      }
      label328:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.core;

import aezn;
import ahqh;
import ampv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class BaseChatPie$71
  extends ampv
{
  BaseChatPie$71(BaseChatPie paramBaseChatPie) {}
  
  public void onGetAppShareInfo(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if ((paramBoolean) && (this.this$0.listAdapter != null)) {
      this.this$0.listAdapter.notifyDataSetChanged();
    }
  }
  
  public void onShowVoipTips(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
  {
    if (this.this$0.isFullScreenMode()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "on showTips, chatactivity upadte ui");
          }
          if ((this.this$0.sessionInfo.curFriendUin.equals(paramString)) && (this.this$0.sessionInfo.curType == paramInt)) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("QQOperateVoIP", 4, "on showTips, uin dosenot equal");
        return;
        if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("QQOperateVoIP", 4, "on showTips,tasklist is null");
      return;
    } while (this.this$0.mOperateTips == null);
    this.this$0.mOperateTips.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.71
 * JD-Core Version:    0.7.0.1
 */
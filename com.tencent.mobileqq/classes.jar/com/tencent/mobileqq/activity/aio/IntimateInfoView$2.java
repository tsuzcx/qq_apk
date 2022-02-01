package com.tencent.mobileqq.activity.aio;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoView$2
  implements Runnable
{
  IntimateInfoView$2(IntimateInfoView paramIntimateInfoView) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!TextUtils.isEmpty(this.this$0.d)))
    {
      IntimateInfoManager localIntimateInfoManager = (IntimateInfoManager)this.this$0.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
      IntimateInfo localIntimateInfo = localIntimateInfoManager.a(this.this$0.d);
      if (localIntimateInfo != null)
      {
        IntimateInfoView.a(this.this$0, localIntimateInfo);
        Message localMessage = IntimateInfoView.a(this.this$0).obtainMessage();
        localMessage.what = 0;
        localMessage.obj = localIntimateInfo;
        IntimateInfoView.a(this.this$0).sendMessage(localMessage);
      }
      localIntimateInfoManager.a(FriendIntimateRelationshipConfProcessor.a().R, FriendIntimateRelationshipConfProcessor.a().S);
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, String.format("init cache friendUin: %s, intimateInfo: %s", new Object[] { this.this$0.d, localIntimateInfo }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.2
 * JD-Core Version:    0.7.0.1
 */
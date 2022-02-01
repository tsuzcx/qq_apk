package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;

class RecentPubAccHelper$3
  extends NewPublicAccountObserver.ResponseResultListener
{
  RecentPubAccHelper$3(RecentPubAccHelper paramRecentPubAccHelper, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow success");
    }
    RecentPubAccHelper.a(this.c, this.a, this.b);
    StructLongMessageDownloadProcessor.deleteTask(this.b, this.a.getRecentUserUin());
    ((TroopBindPublicAccountMgr)this.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.getRecentUserUin());
    RecentPubAccHelper.b(this.c, this.a, this.b);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    RecentPubAccHelper.a(this.c, 2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    RecentPubAccHelper.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.3
 * JD-Core Version:    0.7.0.1
 */
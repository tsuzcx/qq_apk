package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountDetailActivityImpl$5
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountDetailActivityImpl$5(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      paramObject = new JSONObject();
      if (this.a.uin != null) {
        try
        {
          paramObject.put("uin", this.a.uin);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add("find.mp.qq.com");
          localArrayList.add("post.mp.qq.com");
          localArrayList.add("article.mp.qq.com");
          EventApiPlugin.a("unFollow", paramObject, localArrayList, null);
        }
        catch (JSONException paramObject)
        {
          paramObject.printStackTrace();
        }
      }
      this.a.updateUnfollowInfo();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.deleteTask(this.a.app, this.a.uin);
      ((TroopBindPublicAccountMgr)this.a.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.accountDetail.uin);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.a.displayToast(2131695217);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.a;
    paramObject.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.5
 * JD-Core Version:    0.7.0.1
 */
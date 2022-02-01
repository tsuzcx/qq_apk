package com.tencent.biz.bmqq.app;

import android.os.Bundle;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class BmqqBusinessHandler
  extends BusinessHandler
{
  public BmqqBusinessHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null)
    {
      notifyUI(1001, false, null);
      return;
    }
    paramToServiceMsg = (Bundle)paramObject;
    int i = paramToServiceMsg.getInt("result");
    paramToServiceMsg = (BmqqUserSimpleInfo)paramToServiceMsg.getParcelable("info");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = true;
        ((QidianManager)this.appRuntime.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramToServiceMsg);
      }
    }
    notifyUI(1001, bool1, paramToServiceMsg);
  }
  
  public void a(String paramString)
  {
    if (!BmqqSegmentUtil.a(this.appRuntime.getApplication(), paramString)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("hrtxformqq.service", this.appRuntime.getAccount(), "hrtxformqq.getUsrSimpleInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", Long.valueOf(paramString));
    localToServiceMsg.setAttributes(localHashMap);
    send(localToServiceMsg);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BmqqBusinessObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.app.BmqqBusinessHandler
 * JD-Core Version:    0.7.0.1
 */
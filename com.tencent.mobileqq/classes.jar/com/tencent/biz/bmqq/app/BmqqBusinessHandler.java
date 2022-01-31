package com.tencent.biz.bmqq.app;

import android.os.Bundle;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null)
    {
      a(1001, false, null);
      return;
    }
    int i = ((Bundle)paramObject).getInt("result");
    paramToServiceMsg = (BmqqUserSimpleInfo)((Bundle)paramObject).getParcelable("info");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        ((QidianManager)this.a.getManager(164)).a(paramToServiceMsg);
        bool1 = true;
      }
    }
    a(1001, bool1, paramToServiceMsg);
  }
  
  protected Class a()
  {
    return BmqqBusinessObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!BmqqSegmentUtil.a(this.b.getApplication(), paramString)) {
      return;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("hrtxformqq.service", this.b.getCurrentAccountUin(), "hrtxformqq.getUsrSimpleInfo");
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", Long.valueOf(paramString));
    localToServiceMsg.setAttributes(localHashMap);
    a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.bmqq.app.BmqqBusinessHandler
 * JD-Core Version:    0.7.0.1
 */
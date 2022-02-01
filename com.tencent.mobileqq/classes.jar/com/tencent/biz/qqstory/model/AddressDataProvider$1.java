package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class AddressDataProvider$1
  implements LbsManager.LbsUpdateListener
{
  AddressDataProvider$1(AddressDataProvider paramAddressDataProvider) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AddressLbsListener: onLbsUpdate, isSuccess=");
    localStringBuilder.append(paramBoolean);
    SLog.b("AddressDataProvider", localStringBuilder.toString());
    if ((paramBoolean) && (paramBasicLocation != null))
    {
      SLog.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramBasicLocation.b), Integer.valueOf(paramBasicLocation.a));
      this.a.a(paramBasicLocation.b, paramBasicLocation.a);
      return;
    }
    SLog.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.AddressDataProvider.1
 * JD-Core Version:    0.7.0.1
 */
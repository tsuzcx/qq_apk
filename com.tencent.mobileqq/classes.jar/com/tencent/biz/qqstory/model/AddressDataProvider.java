package com.tencent.biz.qqstory.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;

@TargetApi(9)
public class AddressDataProvider
  extends DataProvider<AddressDataProvider.AddressInfo>
{
  protected boolean a;
  private SharedPreferences e;
  private LbsManager.LbsUpdateListener f = new AddressDataProvider.1(this);
  
  public AddressDataProvider()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().c();
    if (localBaseApplicationImpl != null)
    {
      this.e = localBaseApplicationImpl.getSharedPreferences("poi_filter_perferences", 0);
      return;
    }
    throw new IllegalArgumentException("Context should not be null");
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    GetLocationRequest localGetLocationRequest = new GetLocationRequest(1, paramInt1, paramInt2);
    CmdTaskManger.a().a(localGetLocationRequest, new AddressDataProvider.2(this));
  }
  
  protected void a(BasicLocation paramBasicLocation)
  {
    SLog.b("AddressDataProvider", "requestAddress.");
    if (this.a)
    {
      SLog.d("AddressDataProvider", "is request address ing....");
      return;
    }
    this.a = true;
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = localLbsManager.d();
    }
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.a);
      return;
    }
    localLbsManager.a(this.f);
    localLbsManager.e();
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.e.edit().putInt(paramString, paramInt).apply();
  }
  
  protected void a(String paramString, long paramLong)
  {
    this.e.edit().putLong(paramString, paramLong).apply();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.e.edit().putString(paramString1, paramString2).apply();
  }
  
  public boolean a(AddressDataProvider.AddressInfo paramAddressInfo)
  {
    return (paramAddressInfo != null) && (!TextUtils.isEmpty(paramAddressInfo.a)) && (!HardCodeUtil.a(2131898144).equals(paramAddressInfo.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.AddressDataProvider
 * JD-Core Version:    0.7.0.1
 */
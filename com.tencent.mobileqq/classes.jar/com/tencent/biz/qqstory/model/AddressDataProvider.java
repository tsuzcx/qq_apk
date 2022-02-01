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
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private LbsManager.LbsUpdateListener jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener = new AddressDataProvider.1(this);
  protected boolean a;
  
  public AddressDataProvider()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("poi_filter_perferences", 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("longitude", 0);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("time", 0L);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("country", "");
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    GetLocationRequest localGetLocationRequest = new GetLocationRequest(1, paramInt1, paramInt2);
    CmdTaskManger.a().a(localGetLocationRequest, new AddressDataProvider.2(this));
  }
  
  protected void a(BasicLocation paramBasicLocation)
  {
    SLog.b("AddressDataProvider", "requestAddress.");
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.d("AddressDataProvider", "is request address ing....");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = paramBasicLocation;
    if (paramBasicLocation == null) {
      localBasicLocation = localLbsManager.b();
    }
    if (localBasicLocation != null)
    {
      a(localBasicLocation.b, localBasicLocation.a);
      return;
    }
    localLbsManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$LbsUpdateListener);
    localLbsManager.c();
  }
  
  protected void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, paramInt).apply();
  }
  
  protected void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public boolean a(AddressDataProvider.AddressInfo paramAddressInfo)
  {
    return (paramAddressInfo != null) && (!TextUtils.isEmpty(paramAddressInfo.a)) && (!HardCodeUtil.a(2131699958).equals(paramAddressInfo.a));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("latitude", 0);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("province", "");
  }
  
  public String c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("city", "");
  }
  
  public String d()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("district", "");
  }
  
  public String e()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("street", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.AddressDataProvider
 * JD-Core Version:    0.7.0.1
 */
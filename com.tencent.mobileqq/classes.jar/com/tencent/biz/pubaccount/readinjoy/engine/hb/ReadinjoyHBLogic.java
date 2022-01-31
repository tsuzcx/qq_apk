package com.tencent.biz.pubaccount.readinjoy.engine.hb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianHBManager.HBInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class ReadinjoyHBLogic
{
  private static volatile ReadinjoyHBLogic jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineHbReadinjoyHBLogic;
  private ReadInJoyListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup;
  
  public static ReadinjoyHBLogic a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineHbReadinjoyHBLogic == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineHbReadinjoyHBLogic == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineHbReadinjoyHBLogic = new ReadinjoyHBLogic();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineHbReadinjoyHBLogic;
    }
    finally {}
  }
  
  static boolean c()
  {
    return ReadInJoyArkViewController.a().a("0");
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
    if (localSharedPreferences == null) {
      return 0;
    }
    return localSharedPreferences.getInt("readinjoy_hb_turntable_show_count", 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup != null) {
      b();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("readinjoy_hb_turntable_show_count", paramInt);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  public void a(KandianHBManager.HBInfo paramHBInfo)
  {
    int i = paramHBInfo.accumlatedDay;
    int j = paramHBInfo.totalDay;
    ReadInJoyArkViewController.a().a(i, j, "notify_day");
  }
  
  public void a(KandianHBManager.HBInfo paramHBInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramHBInfo == null) {
      QLog.e("kandianhb.ReadinjoyHBLogic", 1, "onReciveNewHBState hbInfo null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("kandianhb.ReadinjoyHBLogic", 2, "onReciveNewHBState " + paramHBInfo.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramHBInfo = new StringBuilder().append("onReciveNewHBState mHBListView==null:");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup == null) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        QLog.d("kandianhb.ReadinjoyHBLogic", 2, paramBoolean);
        return;
      }
      if (paramHBInfo.accumlatedDay != paramHBInfo.totalDay) {
        a(0);
      }
      if (a() < 2) {
        a(paramHBInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("kandianhb.ReadinjoyHBLogic", 2, "onReciveNewHBState isFirst0_1Showed:" + b() + " showLuckyTest:" + paramBoolean);
      }
    } while ((!paramBoolean) || (paramHBInfo.accumlatedDay != 1) || (b()));
    new Bundle();
    paramHBInfo = paramHBInfo.popIntroUrl;
    if (!TextUtils.isEmpty(paramHBInfo))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup.getContext(), ApolloFloatActivity.class);
      localIntent.putExtra("extra_key_click_time", System.currentTimeMillis());
      localIntent.putExtra("extra_key_weburl", paramHBInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup.getContext().startActivity(localIntent);
      QLog.d("kandianhb.ReadinjoyHBLogic", 1, "start to open introduction url");
      a(true);
      return;
    }
    QLog.e("kandianhb.ReadinjoyHBLogic", 1, "onReciveNewHBState introductionUrl empty");
  }
  
  public void a(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("kandianhb.ReadinjoyHBLogic", 2, "detachReadinjoyListView" + paramReadInJoyListViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup == paramReadInJoyListViewGroup) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("readinjoy_hb_first_0_1", paramBoolean);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  public boolean a()
  {
    return c();
  }
  
  public void b()
  {
    ReadInJoyArkViewController.a().a(0, 0, "notify_animation");
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("readinjoy_hb_first_0_1", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.hb.ReadinjoyHBLogic
 * JD-Core Version:    0.7.0.1
 */
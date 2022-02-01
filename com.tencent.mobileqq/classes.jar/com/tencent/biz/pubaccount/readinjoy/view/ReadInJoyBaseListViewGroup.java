package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService.ICallBack;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  protected int a;
  protected ReadInJoyBaseViewController a;
  protected ReadInJoyPageItemCache a;
  KandianVideoUploadService.ICallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$ICallBack = new ReadInJoyBaseListViewGroup.1(this);
  KandianProgressView.ClickCallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianProgressView$ClickCallBack = new ReadInJoyBaseListViewGroup.2(this);
  protected ReadInJoyXListView a;
  List<KandianProgressView> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected boolean a;
  
  public ReadInJoyBaseListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController.a());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = paramReadInJoyBaseViewController;
    if (paramReadInJoyPageItemCache == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.a = ReadInJoyHelper.a(paramInt, (QQAppInterface)ReadInJoyUtils.a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = paramReadInJoyPageItemCache;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.b = 1;
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString("mTaskID");
    Object localObject = (View)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localObject == null)
    {
      if (this.jdField_a_of_type_JavaUtilMap.size() < 2)
      {
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label106;
        }
        localObject = (KandianProgressView)this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(localObject);
      }
      for (;;)
      {
        ((KandianProgressView)localObject).setTag(paramString);
        ((KandianProgressView)localObject).setViewInformation(paramBundle);
        a((View)localObject);
        this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
        return;
        label106:
        localObject = new KandianProgressView(a(), paramBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianProgressView$ClickCallBack);
      }
    }
    ((View)localObject).setTag(paramString);
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(paramView);
    }
  }
  
  private void a(String paramString)
  {
    KandianProgressView localKandianProgressView = (KandianProgressView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localKandianProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(localKandianProgressView);
      this.jdField_a_of_type_JavaUtilList.add(localKandianProgressView);
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  private void b()
  {
    Iterator localIterator = KanDianVideoUploadUtils.a().iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      String str = localIntent.getStringExtra("mTaskID");
      QLog.d("KandianVideoUpload", 1, "is loading fail view:" + str + "map size" + this.jdField_a_of_type_JavaUtilMap.size());
      if (this.jdField_a_of_type_JavaUtilMap.get(str) == null) {
        KandianVideoUploadService.a(localIntent.getExtras(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$ICallBack);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
  }
  
  public ReadInJoyBaseViewController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController;
  }
  
  public RIJDataFetchManager a()
  {
    return null;
  }
  
  public void a() {}
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map<Integer, Boolean> paramMap);
  
  public abstract void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean);
  
  public abstract void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public abstract void b(Map<Integer, Boolean> paramMap);
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public abstract void g();
  
  public void h()
  {
    b();
    KandianVideoUploadService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$ICallBack);
  }
  
  public void i()
  {
    KandianVideoUploadService.a(null);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ReadInJoySuperMaskAdUtil.a().a(this.jdField_a_of_type_Int, true);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */
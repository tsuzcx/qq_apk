package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import bjxj;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nwi;
import oek;
import ore;
import ors;
import owy;
import qkk;
import qod;
import qoh;
import rpz;
import rrw;
import rrx;
import syp;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  public int a;
  public ReadInJoyXListView a;
  public final String a;
  List<KandianProgressView> jdField_a_of_type_JavaUtilList = new ArrayList();
  public Map<String, KandianProgressView> a;
  protected nwi a;
  protected ore a;
  public qoh a;
  rpz jdField_a_of_type_Rpz = new rrx(this);
  protected boolean a;
  
  public ReadInJoyBaseListViewGroup(nwi paramnwi, int paramInt, ore paramore)
  {
    super(paramnwi.a());
    this.jdField_a_of_type_JavaLangString = "ReadInJoyBaseListViewGroup";
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Qoh = new rrw(this);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Nwi = paramnwi;
    if (paramore == null)
    {
      this.jdField_a_of_type_Ore = new ore();
      this.jdField_a_of_type_Ore.a = bjxj.a(paramInt, (QQAppInterface)ors.a());
      return;
    }
    this.jdField_a_of_type_Ore = paramore;
    this.jdField_a_of_type_Ore.b = 1;
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
        localObject = new KandianProgressView(a(), paramBundle, this.jdField_a_of_type_Rpz);
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
    Iterator localIterator = qod.a().iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      String str = localIntent.getStringExtra("mTaskID");
      QLog.d("KandianVideoUpload", 1, "is loading fail view:" + str + "map size" + this.jdField_a_of_type_JavaUtilMap.size());
      if (this.jdField_a_of_type_JavaUtilMap.get(str) == null) {
        KandianVideoUploadService.a(localIntent.getExtras(), this.jdField_a_of_type_Qoh);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Nwi.a();
  }
  
  public void a() {}
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Map<Integer, Boolean> paramMap);
  
  public abstract void a(Map<Long, qkk> paramMap, boolean paramBoolean);
  
  public abstract void a(Set<Long> paramSet, Map<Long, qkk> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a()
  {
    return a() instanceof SplashActivity;
  }
  
  public abstract void b(Map<Integer, Boolean> paramMap);
  
  public void c(Map<Integer, qkk> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public abstract void g();
  
  public void h()
  {
    b();
    KandianVideoUploadService.a(this.jdField_a_of_type_Qoh);
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
      oek.a().a(this.jdField_a_of_type_Int, true);
      syp.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      owy.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadInJoyBaseListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    oek.a().a(this.jdField_a_of_type_Int, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */
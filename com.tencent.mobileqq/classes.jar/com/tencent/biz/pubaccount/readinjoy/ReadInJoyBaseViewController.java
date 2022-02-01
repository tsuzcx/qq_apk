package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.CallHotwordChange;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ReadInJoyBaseViewController
{
  int jdField_a_of_type_Int;
  protected Activity a;
  ReadinjoyTabFrame.CallHotwordChange jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange;
  protected Map<Integer, Set<Long>> a;
  protected Map<Integer, Boolean> b = new HashMap();
  protected Map<Integer, Map<Long, BaseReportData>> c = new HashMap();
  protected Map<Integer, BaseReportData> d = new HashMap();
  
  protected ReadInJoyBaseViewController()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  protected ReadInJoyBaseViewController(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public ViewGroup a()
  {
    return null;
  }
  
  public VideoPlayManager a()
  {
    return null;
  }
  
  public VideoRecommendManager a()
  {
    return null;
  }
  
  public Map<Long, BaseReportData> a(Integer paramInteger)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramInteger = (Map)this.c.get(paramInteger);
    if ((paramInteger != null) && (!paramInteger.isEmpty())) {
      localConcurrentHashMap.putAll(paramInteger);
    }
    return localConcurrentHashMap;
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    ReadInJoyHelper.e(true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(ReadinjoyTabFrame.CallHotwordChange paramCallHotwordChange, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange = paramCallHotwordChange;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.b.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public Map<Long, BaseReportData> b(Integer paramInteger)
  {
    Map localMap = (Map)this.c.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.c.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    ReadInJoyHelper.e(false);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void k() {}
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController
 * JD-Core Version:    0.7.0.1
 */
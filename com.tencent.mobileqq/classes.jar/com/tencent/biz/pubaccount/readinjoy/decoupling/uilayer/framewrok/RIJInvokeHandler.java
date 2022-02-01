package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerFactory;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerTask;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RIJInvokeHandler
{
  private SparseArray<BaseHandler> jdField_a_of_type_AndroidUtilSparseArray;
  public AbsListView.OnScrollListener a;
  private Set<RIJViewInterceptor> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public RIJInvokeHandler()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RIJInvokeHandler.1(this);
    this.jdField_a_of_type_JavaUtilSet.add(new RIJVideoViewInterceptor());
  }
  
  private Object a(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {
      return null;
    }
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < this.jdField_a_of_type_AndroidUtilSparseArray.size(); localObject1 = localObject2)
    {
      long l1 = SystemClock.currentThreadTimeMillis();
      BaseHandler localBaseHandler = (BaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      paramHandlerTask.a(localBaseHandler);
      localObject2 = localObject1;
      if (paramHandlerTask.a != null)
      {
        if (localObject1 != null) {
          break;
        }
        localObject2 = paramHandlerTask.a;
        localBaseHandler.a();
        paramHandlerTask.a = null;
      }
      long l2 = SystemClock.currentThreadTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("InvokeHandler", 2, new Object[] { "execute with return value handler job , id :%d, jobName :%s, cost :%ld ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), paramHandlerTask.a(), Long.valueOf(l2 - l1) });
      }
      i += 1;
    }
    return localObject1;
  }
  
  private void a(HandlerTask paramHandlerTask)
  {
    if (paramHandlerTask == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramHandlerTask.a((BaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("InvokeHandler", 2, new Object[] { "execute handler job , id :%d, jobName :%s, cost :%ld", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), paramHandlerTask.a(), Long.valueOf(l2 - l1) });
        }
        i += 1;
      }
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      RIJViewInterceptor localRIJViewInterceptor = (RIJViewInterceptor)localIterator.next();
      if (localRIJViewInterceptor.a(paramBaseArticleInfo)) {
        localRIJViewInterceptor.a(paramBaseArticleInfo, paramInt);
      }
    }
  }
  
  public SparseArray<BaseHandler> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public BaseHandler a()
  {
    return a(2);
  }
  
  public BaseHandler a(int paramInt)
  {
    return (BaseHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public VideoHandler a()
  {
    return (VideoHandler)a(0);
  }
  
  public Boolean a()
  {
    return (Boolean)a(new RIJInvokeHandler.25(this, "onBackPressed"));
  }
  
  public void a()
  {
    a(new RIJInvokeHandler.9(this, "onDestroy"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(new RIJInvokeHandler.10(this, "onActivityResult", paramInt1, paramInt2, paramIntent));
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    a(new RIJInvokeHandler.21(this, "onChannelArticleLoaded", paramInt, paramList));
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, String paramString, int paramInt)
  {
    a(new RIJInvokeHandler.18(this, "onImageClick", paramContext, paramArticleInfo, paramString, paramInt));
  }
  
  public void a(SparseArray<BaseHandler> paramSparseArray)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
  }
  
  public void a(SparseArray<BaseHandler> paramSparseArray, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    int i = 0;
    while (i < paramSparseArray.size())
    {
      ((BaseHandler)paramSparseArray.valueAt(i)).a(paramReadInJoyBaseAdapter);
      i += 1;
    }
  }
  
  public void a(View paramView1, View paramView2, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    a(new RIJInvokeHandler.27(this, "onPostGetAdapterView", paramView1, paramView2, paramBaseArticleInfo, paramInt));
    a(paramBaseArticleInfo, paramInt);
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(new RIJInvokeHandler.17(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
  }
  
  public void a(View paramView, ListView paramListView)
  {
    a(new RIJInvokeHandler.3(this, "onListViewGroupInited", paramView, paramListView));
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    a(new RIJInvokeHandler.2(this, "onListViewGroupInit", paramView, paramListView, paramLong));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    a(new RIJInvokeHandler.29(this, "OnDataChangedDrawCompletion", paramReadInJoyBaseListView));
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    a(new RIJInvokeHandler.16(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
  }
  
  public void a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = HandlerFactory.a(paramReadInJoyBaseListViewGroup);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    a(new RIJInvokeHandler.4(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(new RIJInvokeHandler.5(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(new RIJInvokeHandler.23(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    a(new RIJInvokeHandler.26(this, "onSetData", paramList));
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    a(new RIJInvokeHandler.6(this, "attachToViewGroup#1", paramMap));
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    a(new RIJInvokeHandler.8(this, "detachFromViewGroup", paramMap, paramBoolean));
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    a(new RIJInvokeHandler.7(this, "attachToViewGroup#2", paramSet, paramMap));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a(new RIJInvokeHandler.20(this, "onBackToTop", paramBoolean, paramInt));
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new RIJInvokeHandler.15(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void b()
  {
    a(new RIJInvokeHandler.11(this, "onResume"));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    a(new RIJInvokeHandler.22(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
  }
  
  public void c()
  {
    a(new RIJInvokeHandler.12(this, "onPause"));
  }
  
  public void d()
  {
    a(new RIJInvokeHandler.13(this, "onStart"));
  }
  
  public void e()
  {
    a(new RIJInvokeHandler.19(this, "onEndRefresh"));
  }
  
  public void f()
  {
    a(new RIJInvokeHandler.24(this, "onListViewDrawFinished"));
  }
  
  public void g()
  {
    a(new RIJInvokeHandler.28(this, "onNotifyDataSetChange"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler
 * JD-Core Version:    0.7.0.1
 */
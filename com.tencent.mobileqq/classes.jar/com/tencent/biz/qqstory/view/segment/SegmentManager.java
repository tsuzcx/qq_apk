package com.tencent.biz.qqstory.view.segment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.QQStoryIllegalException;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SegmentManager
  extends BaseAdapter
  implements SegmentRequestDataListener
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private SegmentManager.RequestDataCompletedListener jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener;
  private List<SegmentView> jdField_a_of_type_JavaUtilList;
  private Map<String, SegmentView> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  private Map<String, SegmentView> jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean = false;
  
  SegmentManager(@NonNull SegmentList paramSegmentList, @NonNull SegmentManager.RequestDataCompletedListener paramRequestDataCompletedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener = paramRequestDataCompletedListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new SegmentManager.1(this));
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      if (paramInt < j) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i -= ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).d();
      paramInt2 += 1;
    }
    return i;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
  }
  
  private void g()
  {
    AssertUtils.mainThreadCheck();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).P_();
    }
  }
  
  public int a(SegmentView paramSegmentView, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramSegmentView);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d();
      paramInt += 1;
    }
    return i;
  }
  
  public <T extends SegmentView> T a(String paramString)
  {
    try
    {
      paramString = (SegmentView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      SLog.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  String a()
  {
    StringBuilder localStringBuilder = (StringBuilder)StringAppendTool.a.get();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SegmentView localSegmentView = (SegmentView)((Iterator)localObject).next();
      localStringBuilder.append(localSegmentView.a());
      localStringBuilder.append(":");
      localStringBuilder.append(localSegmentView.d());
      localStringBuilder.append("(");
      localStringBuilder.append(localSegmentView.b());
      localStringBuilder.append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).b();
    }
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).f_(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (BaseViewHolder)paramView.getTag();
    if (paramView != null)
    {
      SegmentView localSegmentView = a(paramView.jdField_a_of_type_JavaLangString);
      if (localSegmentView != null) {
        localSegmentView.c(paramView);
      }
    }
  }
  
  void a(@NonNull SegmentView paramSegmentView)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() < 99)
    {
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramSegmentView.a()))
      {
        paramSegmentView.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
        this.jdField_a_of_type_JavaUtilMap.put(paramSegmentView.a(), paramSegmentView);
        this.jdField_a_of_type_JavaUtilList.add(paramSegmentView);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SegmentList is already have segment which key is :");
      localStringBuilder.append(paramSegmentView.a());
      localStringBuilder.append(".It is not allow add twice");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("SegmentView did not support too many segment!");
  }
  
  void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    b(3);
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_Boolean = false;
    if (!NetworkUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    if (paramString.a_(true))
    {
      this.jdField_b_of_type_JavaUtilMap.put(paramString.a(), paramString);
      return;
    }
    b(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilMap.remove(paramString);
    if (!paramBoolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty())
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int, SegmentList.e);
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int);
      }
      b(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 3;
    } else {
      i = 1;
    }
    b(i);
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext() == null) {
      return;
    }
    if (!NetworkUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int, SegmentList.d);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if (localSegmentView.a_(paramBoolean)) {
        this.jdField_b_of_type_JavaUtilMap.put(localSegmentView.a(), localSegmentView);
      }
    }
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty())
    {
      b(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).M_();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (BaseViewHolder)paramView.getTag();
    if (paramView != null)
    {
      SegmentView localSegmentView = a(paramView.jdField_a_of_type_JavaLangString);
      if (localSegmentView != null) {
        localSegmentView.a_(paramView);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).R_();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (BaseViewHolder)paramView.getTag();
    if (paramView != null)
    {
      SegmentView localSegmentView = a(paramView.jdField_a_of_type_JavaLangString);
      if (localSegmentView != null) {
        localSegmentView.b_(paramView);
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).d();
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((SegmentView)localIterator.next()).k();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      long l = System.currentTimeMillis();
      localSegmentView.c();
      SLog.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localSegmentView.a());
    }
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      j += ((SegmentView)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(j);
      int m = localSegmentView.d();
      int n = localSegmentView.d_();
      StringBuilder localStringBuilder;
      if (m >= 0)
      {
        m += k;
        if (paramInt < m)
        {
          paramInt = localSegmentView.a(paramInt - k);
          if (paramInt >= 0) {
            return i + paramInt;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localSegmentView.a());
          localStringBuilder.append(" getViewType=");
          localStringBuilder.append(paramInt);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        i += n;
        j += 1;
        k = m;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localSegmentView.a());
        localStringBuilder.append(" getCount=");
        localStringBuilder.append(m);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() >= j + 1)
    {
      SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localSegmentView != null)
      {
        TraceUtils.traceBegin("Segment.newView");
        Object localObject;
        if (paramView != null)
        {
          BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
          if (localBaseViewHolder != null)
          {
            localObject = localBaseViewHolder;
            if (localBaseViewHolder.jdField_a_of_type_Int == i) {}
          }
          else
          {
            localObject = localSegmentView.a(k, paramViewGroup);
          }
        }
        else
        {
          localObject = localSegmentView.a(k, paramViewGroup);
        }
        TraceUtils.traceEnd();
        if (localObject != null)
        {
          ((BaseViewHolder)localObject).jdField_a_of_type_Int = i;
          ((BaseViewHolder)localObject).b = k;
          ((BaseViewHolder)localObject).c = paramInt;
          ((BaseViewHolder)localObject).jdField_a_of_type_JavaLangString = localSegmentView.a();
          localObject = localSegmentView.a(k, (BaseViewHolder)localObject, paramViewGroup);
          TraceUtils.traceEnd();
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject;
        }
        paramView = new StringBuilder();
        paramView.append(localSegmentView.a());
        paramView.append(": newView return null !");
        throw new QQStoryIllegalException(paramView.toString());
      }
      paramView = new StringBuilder();
      paramView.append("getView error! segment is null! segmentIndex=");
      paramView.append(j);
      throw new IllegalStateException(paramView.toString());
    }
    paramView = new StringBuilder();
    paramView.append("getView error! segmentIndex=");
    paramView.append(j);
    throw new IllegalStateException(paramView.toString());
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 1;
    }
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SegmentView localSegmentView = (SegmentView)((Iterator)localObject).next();
      int j = localSegmentView.d_();
      if (j > 0)
      {
        i += j;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localSegmentView.a());
        ((StringBuilder)localObject).append(" viewTypeCount=");
        ((StringBuilder)localObject).append(j);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
    if ((localObject != null) && (((SegmentList)localObject).b())) {
      g();
    }
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new RuntimeException("getStackTrace").getStackTrace();
      String str = arrayOfStackTraceElement[1].toString();
      localObject = str;
      if (arrayOfStackTraceElement.length >= 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(arrayOfStackTraceElement[2].toString());
        localObject = ((StringBuilder)localObject).toString();
      }
      InfoPrinter.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", localObject });
    }
    catch (Exception localException)
    {
      label105:
      break label105;
    }
    InfoPrinter.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
    super.notifyDataSetChanged();
    return;
    SLog.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentManager
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oqq;

public class SegmentManager
  extends BaseAdapter
  implements SegmentRequestDataListener
{
  private int jdField_a_of_type_Int = 0;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private SegmentManager.RequestDataCompletedListener jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private Map jdField_b_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  SegmentManager(@NonNull SegmentList paramSegmentList, @NonNull SegmentManager.RequestDataCompletedListener paramRequestDataCompletedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener = paramRequestDataCompletedListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    super.registerDataSetObserver(new oqq(this));
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
    switch (this.jdField_a_of_type_Int)
    {
    }
  }
  
  private void g()
  {
    UIUtils.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).J_();
    }
  }
  
  public SegmentView a(String paramString)
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
      localStringBuilder.append(localSegmentView.a()).append(":").append(localSegmentView.d()).append("(").append(localSegmentView.b()).append(")||");
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
      ((SegmentView)localIterator.next()).e_(paramInt);
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
    if (this.jdField_a_of_type_JavaUtilList.size() >= 99) {
      throw new IllegalStateException("SegmentView did not support too many segment!");
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramSegmentView.a())) {
      throw new IllegalStateException("SegmentList is already have segment which key is :" + paramSegmentView.a() + ".It is not allow add twice");
    }
    paramSegmentView.a(this, this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList);
    this.jdField_a_of_type_JavaUtilMap.put(paramSegmentView.a(), paramSegmentView);
    this.jdField_a_of_type_JavaUtilList.add(paramSegmentView);
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
      if (!this.jdField_b_of_type_Boolean) {
        break label61;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int, SegmentList.e);
    }
    for (;;)
    {
      b(0);
      return;
      label61:
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 3;
      b(i);
      this.jdField_b_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_Boolean = false;
      if (NetworkUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.getContext())) {
        break label60;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int, SegmentList.d);
    }
    label60:
    do
    {
      return;
      i = 1;
      break;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SegmentView localSegmentView = (SegmentView)localIterator.next();
        if (localSegmentView.a_(paramBoolean)) {
          this.jdField_b_of_type_JavaUtilMap.put(localSegmentView.a(), localSegmentView);
        }
      }
    } while (!this.jdField_b_of_type_JavaUtilMap.isEmpty());
    b(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentManager$RequestDataCompletedListener.a(this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).e();
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    SegmentView localSegmentView;
    do
    {
      do
      {
        return;
        paramView = (BaseViewHolder)paramView.getTag();
      } while (paramView == null);
      localSegmentView = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localSegmentView == null);
    localSegmentView.a_(paramView);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).g();
    }
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {}
    SegmentView localSegmentView;
    do
    {
      do
      {
        return;
        paramView = (BaseViewHolder)paramView.getTag();
      } while (paramView == null);
      localSegmentView = a(paramView.jdField_a_of_type_JavaLangString);
    } while (localSegmentView == null);
    localSegmentView.b_(paramView);
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
    int n = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      int m = n;
      int i1;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(k);
        m = localSegmentView.d();
        i1 = localSegmentView.d_();
        if (m < 0) {
          throw new IllegalStateException(localSegmentView.a() + " getCount=" + m);
        }
        if (paramInt < m + j)
        {
          paramInt = localSegmentView.a(paramInt - j);
          if (paramInt < 0) {
            throw new IllegalStateException(localSegmentView.a() + " getViewType=" + paramInt);
          }
          m = i + paramInt;
        }
      }
      else
      {
        return m;
      }
      i += i1;
      j += m;
      k += 1;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.a("SegmentManager.getView");
    int i = getItemViewType(paramInt);
    int j = a(paramInt);
    int k = a(j, paramInt);
    if (this.jdField_a_of_type_JavaUtilList.size() < j + 1) {
      throw new IllegalStateException("getView error! segmentIndex=" + j);
    }
    SegmentView localSegmentView = (SegmentView)this.jdField_a_of_type_JavaUtilList.get(j);
    if (localSegmentView == null) {
      throw new IllegalStateException("getView error! segment is null! segmentIndex=" + j);
    }
    TraceUtils.a("Segment.newView");
    if (paramView != null)
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      if (localBaseViewHolder != null)
      {
        paramView = localBaseViewHolder;
        if (localBaseViewHolder.jdField_a_of_type_Int == i) {
          break label170;
        }
      }
    }
    for (paramView = localSegmentView.a(k, paramViewGroup);; paramView = localSegmentView.a(k, paramViewGroup))
    {
      label170:
      TraceUtils.a();
      if (paramView != null) {
        break;
      }
      throw new QQStoryIllegalException(localSegmentView.a() + ": newView return null !");
    }
    paramView.jdField_a_of_type_Int = i;
    paramView.b = k;
    paramView.c = paramInt;
    paramView.jdField_a_of_type_JavaLangString = localSegmentView.a();
    paramView = localSegmentView.a(k, paramView, paramViewGroup);
    TraceUtils.a();
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    int j;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      j = 1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      j = localSegmentView.d_();
      if (j <= 0) {
        throw new IllegalStateException(localSegmentView.a() + " viewTypeCount=" + j);
      }
      i += j;
    }
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.b()))
    {
      SLog.e("Q.qqstory.SegmentManager", "notifyDataSetChanged but have not set adapter");
      return;
    }
    g();
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new RuntimeException("getStackTrace").getStackTrace();
      String str2 = arrayOfStackTraceElement[1].toString();
      String str1 = str2;
      if (arrayOfStackTraceElement.length >= 3) {
        str1 = str2 + arrayOfStackTraceElement[2].toString();
      }
      InfoPrinter.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##", str1 });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        InfoPrinter.c("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged##" });
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentManager
 * JD-Core Version:    0.7.0.1
 */
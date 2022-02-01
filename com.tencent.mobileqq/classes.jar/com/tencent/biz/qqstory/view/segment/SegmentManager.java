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
  private int a = 0;
  private boolean b = false;
  private boolean c = false;
  private SegmentList d;
  private List<SegmentView> e;
  private Map<String, SegmentView> f;
  private Map<String, SegmentView> g;
  private SegmentManager.RequestDataCompletedListener h;
  
  SegmentManager(@NonNull SegmentList paramSegmentList, @NonNull SegmentManager.RequestDataCompletedListener paramRequestDataCompletedListener)
  {
    this.d = paramSegmentList;
    this.h = paramRequestDataCompletedListener;
    this.e = new ArrayList();
    this.f = new HashMap();
    this.g = new HashMap();
    super.registerDataSetObserver(new SegmentManager.1(this));
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      i -= ((SegmentView)this.e.get(paramInt2)).s();
      paramInt2 += 1;
    }
    return i;
  }
  
  private int b(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.e.size())
    {
      j += ((SegmentView)this.e.get(i)).s();
      if (paramInt < j) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void c(int paramInt)
  {
    this.a = paramInt;
    paramInt = this.a;
  }
  
  private void h()
  {
    AssertUtils.mainThreadCheck();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).br_();
    }
  }
  
  public int a(SegmentView paramSegmentView, int paramInt)
  {
    int k = this.e.indexOf(paramSegmentView);
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      i += ((SegmentView)this.e.get(paramInt)).s();
      paramInt += 1;
    }
    return i;
  }
  
  public void a()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).bs_();
    }
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (BaseViewHolder)paramView.getTag();
    if (paramView != null)
    {
      SegmentView localSegmentView = b(paramView.e);
      if (localSegmentView != null) {
        localSegmentView.c(paramView);
      }
    }
  }
  
  void a(@NonNull SegmentView paramSegmentView)
  {
    if (this.e.size() < 99)
    {
      if (!this.f.containsKey(paramSegmentView.b()))
      {
        paramSegmentView.a(this, this.d);
        this.f.put(paramSegmentView.b(), paramSegmentView);
        this.e.add(paramSegmentView);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SegmentList is already have segment which key is :");
      localStringBuilder.append(paramSegmentView.b());
      localStringBuilder.append(".It is not allow add twice");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("SegmentView did not support too many segment!");
  }
  
  void a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return;
    }
    c(3);
    this.g.clear();
    this.c = false;
    if (!NetworkUtil.a(this.d.getContext()))
    {
      this.h.a(this.a, SegmentList.f);
      return;
    }
    if (paramString.d(true))
    {
      this.g.put(paramString.b(), paramString);
      return;
    }
    c(0);
    this.h.a(this.a);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.g.remove(paramString);
    if (!paramBoolean) {
      this.c = true;
    }
    if (this.g.isEmpty())
    {
      if (this.c) {
        this.h.a(this.a, SegmentList.g);
      } else {
        this.h.a(this.a);
      }
      c(0);
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
    c(i);
    this.g.clear();
    this.c = false;
    if (this.d.getContext() == null) {
      return;
    }
    if (!NetworkUtil.a(this.d.getContext()))
    {
      this.h.a(this.a, SegmentList.f);
      return;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if (localSegmentView.d(paramBoolean)) {
        this.g.put(localSegmentView.b(), localSegmentView);
      }
    }
    if (this.g.isEmpty())
    {
      c(0);
      this.h.a(this.a);
    }
  }
  
  public <T extends SegmentView> T b(String paramString)
  {
    try
    {
      paramString = (SegmentView)this.f.get(paramString);
      return paramString;
    }
    catch (ClassCastException paramString)
    {
      SLog.b("Q.qqstory.SegmentManager", "Cast Exception %s", paramString.getMessage());
    }
    return null;
  }
  
  public void b()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).i();
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
      SegmentView localSegmentView = b(paramView.e);
      if (localSegmentView != null) {
        localSegmentView.a_(paramView);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).bz_();
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
      SegmentView localSegmentView = b(paramView.e);
      if (localSegmentView != null) {
        localSegmentView.b_(paramView);
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((SegmentView)localIterator.next()).h();
    }
  }
  
  void e()
  {
    if (this.b)
    {
      this.b = false;
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        ((SegmentView)localIterator.next()).o();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      long l = System.currentTimeMillis();
      localSegmentView.g();
      SLog.a("Q.qqstory.home.position", "initOnBackground take time:%s, %s", Long.valueOf(System.currentTimeMillis() - l), localSegmentView.b());
    }
  }
  
  String g()
  {
    StringBuilder localStringBuilder = (StringBuilder)StringAppendTool.a.get();
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SegmentView localSegmentView = (SegmentView)((Iterator)localObject).next();
      localStringBuilder.append(localSegmentView.b());
      localStringBuilder.append(":");
      localStringBuilder.append(localSegmentView.s());
      localStringBuilder.append("(");
      localStringBuilder.append(localSegmentView.x());
      localStringBuilder.append(")||");
    }
    localObject = localStringBuilder.toString();
    localStringBuilder.setLength(0);
    return localObject;
  }
  
  public int getCount()
  {
    int i = 0;
    int j = 0;
    while (i < this.e.size())
    {
      j += ((SegmentView)this.e.get(i)).s();
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
    while (j < this.e.size())
    {
      SegmentView localSegmentView = (SegmentView)this.e.get(j);
      int m = localSegmentView.s();
      int n = localSegmentView.f();
      StringBuilder localStringBuilder;
      if (m >= 0)
      {
        m += k;
        if (paramInt < m)
        {
          paramInt = localSegmentView.g_(paramInt - k);
          if (paramInt >= 0) {
            return i + paramInt;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localSegmentView.b());
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
        localStringBuilder.append(localSegmentView.b());
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
    int j = b(paramInt);
    int k = a(j, paramInt);
    if (this.e.size() >= j + 1)
    {
      SegmentView localSegmentView = (SegmentView)this.e.get(j);
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
            if (localBaseViewHolder.d == i) {}
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
          ((BaseViewHolder)localObject).d = i;
          ((BaseViewHolder)localObject).f = k;
          ((BaseViewHolder)localObject).g = paramInt;
          ((BaseViewHolder)localObject).e = localSegmentView.b();
          localObject = localSegmentView.a(k, (BaseViewHolder)localObject, paramViewGroup);
          TraceUtils.traceEnd();
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject;
        }
        paramView = new StringBuilder();
        paramView.append(localSegmentView.b());
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
    if (this.e.size() == 0) {
      return 1;
    }
    int i = 0;
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SegmentView localSegmentView = (SegmentView)((Iterator)localObject).next();
      int j = localSegmentView.f();
      if (j > 0)
      {
        i += j;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localSegmentView.b());
        ((StringBuilder)localObject).append(" viewTypeCount=");
        ((StringBuilder)localObject).append(j);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((SegmentList)localObject).r())) {
      h();
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
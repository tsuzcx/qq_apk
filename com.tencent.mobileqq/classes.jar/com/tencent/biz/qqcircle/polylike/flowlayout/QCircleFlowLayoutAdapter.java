package com.tencent.biz.qqcircle.polylike.flowlayout;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

public abstract class QCircleFlowLayoutAdapter<T>
{
  private List<T> a;
  private QCircleFlowLayoutAdapter.OnDataChangedListener b;
  @Deprecated
  private HashSet<Integer> c = new HashSet();
  
  public QCircleFlowLayoutAdapter(List<T> paramList)
  {
    this.a = paramList;
  }
  
  public abstract View a(QCircleFlowLayout paramQCircleFlowLayout, int paramInt, T paramT);
  
  public T a(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  @Deprecated
  HashSet<Integer> a()
  {
    return this.c;
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("onSelected ");
    paramView.append(paramInt);
    QLog.d("zhy", 1, paramView.toString());
  }
  
  void a(QCircleFlowLayoutAdapter.OnDataChangedListener paramOnDataChangedListener)
  {
    this.b = paramOnDataChangedListener;
  }
  
  public boolean a(int paramInt, T paramT)
  {
    return false;
  }
  
  public int b()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void b(int paramInt, View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("unSelected ");
    paramView.append(paramInt);
    QLog.d("zhy", 1, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.flowlayout.QCircleFlowLayoutAdapter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;

public class FastWebAdapterShowHelper
{
  private int a = -1;
  private int b = -1;
  
  public FastWebAdapterShowHelper(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    a(paramAbsListView, paramInt1, new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, Pair<Integer, Integer> paramPair)
  {
    paramInt = ((Integer)paramPair.first).intValue() - paramInt;
    int i = paramInt + (((Integer)paramPair.second).intValue() - ((Integer)paramPair.first).intValue());
    if (i > paramAbsListView.getChildCount()) {}
    for (;;)
    {
      return;
      while (paramInt <= i)
      {
        paramPair = paramAbsListView.getChildAt(paramInt);
        if ((paramPair != null) && ((paramPair.getTag() instanceof BaseItemViewHolder))) {
          ((BaseItemViewHolder)paramPair.getTag()).a();
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    paramInt2 = paramInt1 + paramInt2 - 1;
    if ((paramInt1 >= this.a) && (paramInt2 <= this.b)) {
      return;
    }
    Object localObject1;
    if (paramInt1 < this.a) {
      if (paramInt2 >= this.b)
      {
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(this.a - 1));
        label64:
        this.b = paramInt2;
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject3;
      if (paramInt2 > this.b)
      {
        if (paramInt1 > this.a) {
          break label176;
        }
        localObject1 = new Pair(Integer.valueOf(this.b + 1), Integer.valueOf(paramInt2));
      }
      for (;;)
      {
        this.b = paramInt2;
        if (paramAbsListView == null) {
          break;
        }
        if (localObject2 != null) {
          a(paramAbsListView, paramInt1, localObject2);
        }
        if (localObject1 == null) {
          break;
        }
        a(paramAbsListView, paramInt1, (Pair)localObject1);
        return;
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.a = paramInt1;
        break label64;
        label176:
        localObject1 = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        this.a = paramInt1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.FastWebAdapterShowHelper
 * JD-Core Version:    0.7.0.1
 */
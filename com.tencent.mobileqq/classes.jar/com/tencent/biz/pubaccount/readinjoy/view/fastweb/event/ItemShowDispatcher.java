package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mmy;
import mmz;
import mqq.os.MqqHandler;

public class ItemShowDispatcher
{
  private long jdField_a_of_type_Long;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private Pair jdField_a_of_type_ComTencentUtilPair;
  private Runnable jdField_a_of_type_JavaLangRunnable = new mmy(this);
  private String jdField_a_of_type_JavaLangString = ItemShowDispatcher.class.getSimpleName();
  private mmz jdField_a_of_type_Mmz;
  private int[] jdField_a_of_type_ArrayOfInt;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray;
  private Pair jdField_b_of_type_ComTencentUtilPair;
  private Pair c;
  
  private Pair a(Pair paramPair1, Pair paramPair2)
  {
    if ((paramPair1 == null) || (paramPair2 == null)) {
      return null;
    }
    if ((((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.first).intValue()) || (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.second).intValue())) {
      return null;
    }
    Integer localInteger;
    int i;
    if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.first).intValue())
    {
      localInteger = (Integer)paramPair1.first;
      i = localInteger.intValue();
      if (((Integer)paramPair1.second).intValue() >= ((Integer)paramPair2.second).intValue()) {
        break label158;
      }
    }
    label158:
    for (paramPair1 = (Integer)paramPair1.second;; paramPair1 = (Integer)paramPair2.second)
    {
      return new Pair(Integer.valueOf(i), Integer.valueOf(paramPair1.intValue()));
      localInteger = (Integer)paramPair2.first;
      break;
    }
  }
  
  private Pair a(AbsListView paramAbsListView)
  {
    int i = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getLastVisiblePosition();
    int m = n - i;
    for (;;)
    {
      int k;
      try
      {
        localView1 = paramAbsListView.getChildAt(0);
        View localView2 = paramAbsListView.getChildAt(m);
        i1 = paramAbsListView.getHeight();
        j = localView1.getBottom();
        k = 0;
        if (!a(j, this.jdField_a_of_type_ArrayOfInt[i]))
        {
          k += 1;
          i += 1;
          j = paramAbsListView.getChildAt(k).getBottom();
          continue;
        }
        k = this.jdField_a_of_type_ArrayOfInt[n] - (localView2.getBottom() - i1);
      }
      catch (Exception paramAbsListView)
      {
        View localView1;
        int i1;
        int j;
        return null;
      }
      if (!a(k, this.jdField_a_of_type_ArrayOfInt[n]))
      {
        n -= 1;
        m -= 1;
        localView1 = paramAbsListView.getChildAt(m);
        k = this.jdField_a_of_type_ArrayOfInt[n] - (localView1.getBottom() - i1);
      }
      else
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "  " + i + " - " + n + "         " + j + "  " + this.jdField_a_of_type_ArrayOfInt[i] + "   " + k + "   " + this.jdField_a_of_type_ArrayOfInt[n]);
        return new Pair(Integer.valueOf(i), Integer.valueOf(n));
      }
      if (k <= 0) {
        if (n >= 0) {}
      }
    }
  }
  
  private void a(Pair paramPair)
  {
    if ((paramPair == null) || (this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {}
    do
    {
      return;
      paramPair = a(paramPair, this.jdField_a_of_type_ComTencentUtilPair);
    } while (paramPair == null);
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one second : " + paramPair.first + " ---  " + paramPair.second);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((ItemShowDispatcher.ItemShowCallback)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramPair = localArrayList.iterator();
    while (paramPair.hasNext())
    {
      i = ((Integer)paramPair.next()).intValue();
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    }
    c();
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentUtilPair == null) && (this.jdField_b_of_type_ComTencentUtilPair == null)) {}
    while ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length == 0) || (((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) && ((this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)))) {
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (paramInt1 / paramInt2 < 0.5D) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
  }
  
  private void b(Pair paramPair)
  {
    if ((paramPair == null) || (this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) {
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "show : " + paramPair.first + " ---  " + paramPair.second);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((ItemShowDispatcher.ItemShowCallback)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramPair = localArrayList.iterator();
    while (paramPair.hasNext())
    {
      i = ((Integer)paramPair.next()).intValue();
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(i);
    }
    d();
  }
  
  private void b(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = a(paramAbsListView);
    b(a(paramAbsListView, this.jdField_b_of_type_ComTencentUtilPair));
    if ((this.c != null) && (this.jdField_a_of_type_Long > 0L))
    {
      Pair localPair = a(this.c, paramAbsListView);
      if ((localPair != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L)) {
        a(localPair);
      }
    }
    this.c = paramAbsListView;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void c()
  {
    int m = 2147483647;
    int j = -1;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int n = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      int k = m;
      if (n < m) {
        k = n;
      }
      m = j;
      if (n > j) {
        m = n;
      }
      i += 1;
      j = m;
      m = k;
    }
    this.jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(m), Integer.valueOf(j));
  }
  
  private void d()
  {
    int m = 2147483647;
    int j = -1;
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int n = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      int k = m;
      if (n < m) {
        k = n;
      }
      m = j;
      if (n > j) {
        m = n;
      }
      i += 1;
      j = m;
      m = k;
    }
    this.jdField_b_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(m), Integer.valueOf(j));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Mmz != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_Mmz);
    }
  }
  
  public void a(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    b();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramItemShowCallback);
    c();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "" + paramInt);
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_Mmz == null) {
      this.jdField_a_of_type_Mmz = new mmz(this, paramAbsListView, paramInt);
    }
    switch (paramInt)
    {
    default: 
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_Mmz);
      return;
    case 0: 
      b(paramAbsListView, paramInt);
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_Mmz);
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    b(paramAbsListView, paramInt);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Mmz, 1000L);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void b(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramItemShowCallback);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */
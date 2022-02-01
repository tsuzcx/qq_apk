package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import ors;
import soz;
import spa;
import tpk;

public class CommentItemShowDispatcher
{
  private SparseArray<spa> jdField_a_of_type_AndroidUtilSparseArray;
  private Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair;
  private ArrayList<soz> jdField_a_of_type_JavaUtilArrayList;
  public HashSet<Integer> a;
  private ors jdField_a_of_type_Ors;
  private SparseArray<spa> jdField_b_of_type_AndroidUtilSparseArray;
  private Pair<Integer, Integer> jdField_b_of_type_ComTencentUtilPair;
  
  private Pair<Integer, Integer> a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
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
  
  private Pair<Integer, Integer> a(AbsListView paramAbsListView)
  {
    int k = 0;
    int i;
    int j;
    int n;
    int m;
    if ((paramAbsListView instanceof ReadInJoyCommentListView))
    {
      i = tpk.a((ReadInJoyCommentListView)paramAbsListView);
      j = paramAbsListView.getFirstVisiblePosition() - i;
      n = paramAbsListView.getLastVisiblePosition() - i;
      m = n - j;
    }
    for (;;)
    {
      try
      {
        localView1 = paramAbsListView.getChildAt(0);
        View localView2 = paramAbsListView.getChildAt(m);
        i2 = paramAbsListView.getHeight();
        int i1 = localView1.getBottom();
        i = j;
        j = i1;
        if (!a(j, this.jdField_a_of_type_Ors.a(i)))
        {
          k += 1;
          j = paramAbsListView.getChildAt(k).getBottom();
          i += 1;
          continue;
        }
        k = this.jdField_a_of_type_Ors.a(n) - (localView2.getBottom() - i2);
      }
      catch (Exception paramAbsListView)
      {
        View localView1;
        int i2;
        return null;
      }
      if (!a(k, this.jdField_a_of_type_Ors.a(n)))
      {
        n -= 1;
        m -= 1;
        localView1 = paramAbsListView.getChildAt(m);
        k = this.jdField_a_of_type_Ors.a(n) - (localView1.getBottom() - i2);
      }
      else
      {
        QLog.d("CommentItemShowDispatcher", 2, "  " + i + " - " + n + "         " + j + "  " + this.jdField_a_of_type_Ors.a(i) + "   " + k + "   " + this.jdField_a_of_type_Ors.a(n));
        return new Pair(Integer.valueOf(i), Integer.valueOf(n));
        i = 0;
        break;
      }
      if (k <= 0) {
        if (n >= 0) {}
      }
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CommentItemShowDispatcher", 2, "doAdCallback(all) ");
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        soz localsoz = (soz)localIterator.next();
        if ((localsoz.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localsoz.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
        {
          localsoz.jdField_a_of_type_Long = (System.currentTimeMillis() - localsoz.jdField_a_of_type_JavaLangLong.longValue());
          localArrayList.add(Integer.valueOf(localsoz.jdField_a_of_type_Int));
          if (QLog.isColorLevel()) {
            QLog.d("CommentItemShowDispatcher", 2, "time is out , need report ,ad pos is =" + localsoz.jdField_a_of_type_Int + "  show time=" + localsoz.jdField_a_of_type_JavaLangLong);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    a(localArrayList);
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((paramPair == null) || (this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) {
      return;
    }
    QLog.d("CommentItemShowDispatcher", 2, "show : " + paramPair.first + " ---  " + paramPair.second);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((spa)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        ((List)localObject).add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramPair = ((List)localObject).iterator();
    for (;;)
    {
      if (!paramPair.hasNext()) {
        break label247;
      }
      i = ((Integer)paramPair.next()).intValue();
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(i);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        soz localsoz = (soz)((Iterator)localObject).next();
        if (localsoz.jdField_a_of_type_Int != i) {
          break;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(localsoz);
      }
    }
    label247:
    b();
  }
  
  private void a(AbsListView paramAbsListView, int paramInt)
  {
    a(a(a(paramAbsListView), this.jdField_b_of_type_ComTencentUtilPair));
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CommentItemShowDispatcher", 2, " (ArrayList<Integer> adPositionlist) ");
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Object localObject = (spa)this.jdField_a_of_type_AndroidUtilSparseArray.get(localInteger.intValue());
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CommentItemShowDispatcher", 2, "doAdCallback(ArrayList<Integer> adPositionlist) pos=" + localInteger);
          }
          ((spa)localObject).a();
          localArrayList.add(localInteger);
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(localInteger.intValue());
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            soz localsoz = (soz)((Iterator)localObject).next();
            if ((localsoz != null) && (localsoz.jdField_a_of_type_Int == localInteger.intValue())) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(localsoz);
            }
          }
          if (this.jdField_a_of_type_JavaUtilHashSet.contains(localInteger))
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(localInteger);
            if (QLog.isColorLevel()) {
              QLog.d("CommentItemShowDispatcher", 2, "invalidADExposurePos remove " + localInteger);
            }
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentUtilPair == null) && (this.jdField_b_of_type_ComTencentUtilPair == null)) {}
    while ((this.jdField_a_of_type_Ors == null) || (this.jdField_a_of_type_Ors.a() == 0) || (this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) || (this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) {
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
    int j = 2147483647;
    int i = -1;
    int m = i;
    int n = j;
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
    {
      int k = 0;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= this.jdField_b_of_type_AndroidUtilSparseArray.size()) {
          break;
        }
        n = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(k);
        m = j;
        if (n < j) {
          m = n;
        }
        j = i;
        if (n > i) {
          j = n;
        }
        k += 1;
        i = j;
        j = m;
      }
    }
    this.jdField_b_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(n), Integer.valueOf(m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */
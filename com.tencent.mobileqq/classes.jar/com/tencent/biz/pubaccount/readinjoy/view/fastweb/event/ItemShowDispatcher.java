package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import aciy;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import npi;
import qxn;
import qxp;
import qxq;

public class ItemShowDispatcher
{
  private static String jdField_a_of_type_JavaLangString = ItemShowDispatcher.class.getSimpleName();
  private final int jdField_a_of_type_Int = 1000;
  private SparseArray<qxq> jdField_a_of_type_AndroidUtilSparseArray;
  private ItemShowDispatcher.OneSecondCallbackLoop jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop;
  private Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ItemShowDispatcher.1(this);
  private ArrayList<qxp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<Integer> a;
  private qxn jdField_a_of_type_Qxn;
  private final int jdField_b_of_type_Int = 500;
  private SparseArray<qxq> jdField_b_of_type_AndroidUtilSparseArray;
  private Pair<Integer, Integer> jdField_b_of_type_ComTencentUtilPair;
  private ArrayList<qxp> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  
  public ItemShowDispatcher()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private float a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 < paramInt1) || (paramInt4 > paramInt1 + paramInt2)) {}
    for (;;)
    {
      return 0.0F;
      View localView = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localView != null) {
        try
        {
          paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
          paramInt2 = this.jdField_a_of_type_Qxn.a(paramInt4);
          if ((paramInt1 > 0) && (paramInt2 > 0)) {
            return paramInt1 / paramInt2;
          }
        }
        catch (RuntimeException paramAbsListView)
        {
          aciy.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
        }
      }
    }
    return 0.0F;
  }
  
  private int a(SparseArray<qxq> paramSparseArray, BaseData paramBaseData)
  {
    int j;
    if (paramSparseArray == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramSparseArray.size()) {
        break label47;
      }
      j = i;
      if (((qxq)paramSparseArray.valueAt(i)).a() == paramBaseData) {
        break;
      }
      i += 1;
    }
    label47:
    return -1;
  }
  
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
        if (!a(j, this.jdField_a_of_type_Qxn.a(i)))
        {
          k += 1;
          i += 1;
          j = paramAbsListView.getChildAt(k).getBottom();
          continue;
        }
        k = this.jdField_a_of_type_Qxn.a(n) - (localView2.getBottom() - i1);
      }
      catch (Exception paramAbsListView)
      {
        View localView1;
        int i1;
        int j;
        return null;
      }
      if (!a(k, this.jdField_a_of_type_Qxn.a(n)))
      {
        n -= 1;
        m -= 1;
        localView1 = paramAbsListView.getChildAt(m);
        k = this.jdField_a_of_type_Qxn.a(n) - (localView1.getBottom() - i1);
      }
      else
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "  " + i + " - " + n + "         " + j + "  " + this.jdField_a_of_type_Qxn.a(i) + "   " + k + "   " + this.jdField_a_of_type_Qxn.a(n));
        return new Pair(Integer.valueOf(i), Integer.valueOf(n));
      }
      if (k <= 0) {
        if (n >= 0) {}
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new ItemShowDispatcher.CheckAndStartWebProcessRunnable(paramQQAppInterface));
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((paramPair == null) || (this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "show : " + paramPair.first + " ---  " + paramPair.second);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((qxq)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).a();
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
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentUtilPair == null) && (this.jdField_b_of_type_ComTencentUtilPair == null)) {}
    while ((this.jdField_a_of_type_Qxn == null) || (this.jdField_a_of_type_Qxn.a() == 0) || (((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) && ((this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)))) {
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
  
  private boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (!AdData.a(paramBaseData)) {
      return false;
    }
    return npi.c((AdData)paramBaseData);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doAdCallback(all) ");
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        qxp localqxp = (qxp)localIterator.next();
        if ((localqxp.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localqxp.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
        {
          localqxp.jdField_a_of_type_Long = (System.currentTimeMillis() - localqxp.jdField_a_of_type_JavaLangLong.longValue());
          localArrayList.add(Integer.valueOf(localqxp.jdField_a_of_type_Int));
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "time is out , need report ,ad pos is =" + localqxp.jdField_a_of_type_Int + "  show time=" + localqxp.jdField_a_of_type_JavaLangLong);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    b(localArrayList);
  }
  
  private void b(AbsListView paramAbsListView, int paramInt)
  {
    a(a(a(paramAbsListView), this.jdField_b_of_type_ComTencentUtilPair));
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, " (ArrayList<Integer> adPositionlist) ");
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Object localObject = (qxq)this.jdField_a_of_type_AndroidUtilSparseArray.get(localInteger.intValue());
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doAdCallback(ArrayList<Integer> adPositionlist) pos=" + localInteger);
          }
          ((qxq)localObject).a();
          localArrayList.add(localInteger);
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(localInteger.intValue());
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            qxp localqxp = (qxp)((Iterator)localObject).next();
            if ((localqxp != null) && (localqxp.jdField_a_of_type_Int == localInteger.intValue())) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(localqxp);
            }
          }
          if (this.jdField_a_of_type_JavaUtilHashSet.contains(localInteger))
          {
            this.jdField_a_of_type_JavaUtilHashSet.remove(localInteger);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "invalidADExposurePos remove " + localInteger);
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    int j = 2147483647;
    int i = -1;
    int m = i;
    int n = j;
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int k = 0;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= this.jdField_a_of_type_AndroidUtilSparseArray.size()) {
          break;
        }
        n = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k);
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
    this.jdField_a_of_type_ComTencentUtilPair = new Pair(Integer.valueOf(n), Integer.valueOf(m));
  }
  
  private void d()
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
  
  public qxp a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    qxp localqxp;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localqxp = (qxp)localIterator.next();
    } while (localqxp.jdField_a_of_type_Int != paramInt);
    for (;;)
    {
      return localqxp;
      localqxp = null;
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int i;
      Object localObject;
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (qxq)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (qxq)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          qxp localqxp = (qxp)((Iterator)localObject).next();
          if (localqxp.jdField_a_of_type_Int == paramInt1) {
            ((Iterator)localObject).remove();
          } else if (localqxp.jdField_a_of_type_Int > paramInt1) {
            localqxp.jdField_a_of_type_Int -= 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, qxq paramqxq)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = a(this.jdField_a_of_type_AndroidUtilSparseArray, paramqxq.a());
    if (i >= 0) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramqxq);
    c();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      qxp localqxp = (qxp)localIterator.next();
      AdData localAdData = (AdData)localqxp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
      if ((localAdData != null) && (a(localqxp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) && (!this.jdField_b_of_type_JavaUtilHashSet.contains(localAdData.u)) && (a(paramAbsListView, paramInt1, paramInt2, localqxp.jdField_a_of_type_Int))) {
        if (localqxp.b == 0L)
        {
          localqxp.b = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkWebProcess set start time=, traceId=" + localAdData.u);
          }
        }
        else if (System.currentTimeMillis() - localqxp.b >= 500L)
        {
          this.jdField_b_of_type_JavaUtilHashSet.add(localAdData.u);
          a(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkWebProcess CHECK WebViwe! traceId=" + localAdData.u);
          }
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "" + paramInt);
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop = new ItemShowDispatcher.OneSecondCallbackLoop(this, paramAbsListView, paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramAbsListView, paramInt);
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
    b(paramAbsListView, paramInt);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a()) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        qxp localqxp = (qxp)localIterator.next();
        if (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localqxp.jdField_a_of_type_Int))
        {
          if ((localqxp.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localqxp.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
          {
            localArrayList.add(Integer.valueOf(localqxp.jdField_a_of_type_Int));
            localqxp.jdField_a_of_type_Long = (System.currentTimeMillis() - localqxp.jdField_a_of_type_JavaLangLong.longValue());
            localqxp.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localqxp.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "need report ,ad pos is =" + localqxp.jdField_a_of_type_Int + "  show time=" + localqxp.jdField_a_of_type_JavaLangLong + " exposureTime = " + localqxp.jdField_a_of_type_Long + " exposureArea = " + localqxp.jdField_a_of_type_Float);
            }
          }
          else if (localqxp.jdField_a_of_type_JavaLangLong.longValue() == 0L)
          {
            localqxp.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localqxp.jdField_a_of_type_Int);
            localqxp.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
          }
        }
        else {
          localqxp.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
        }
      }
    } while (localArrayList.size() <= 0);
    b(localArrayList);
  }
  
  public void a(ArrayList<qxp> paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label125;
      }
      qxp localqxp1 = (qxp)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      qxp localqxp2;
      while (localIterator2.hasNext())
      {
        localqxp2 = (qxp)localIterator2.next();
        if (localqxp1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == localqxp2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData) {
          localqxp1.a(localqxp2);
        }
      }
      localIterator2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      if (localIterator2.hasNext())
      {
        localqxp2 = (qxp)localIterator2.next();
        if (localqxp1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData != localqxp2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData) {
          break;
        }
        localqxp1.a(localqxp2);
      }
    }
    label125:
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(qxn paramqxn)
  {
    this.jdField_a_of_type_Qxn = paramqxn;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < paramInt1) || (paramInt3 > paramInt1 + paramInt2)) {}
    for (;;)
    {
      return false;
      View localView = paramAbsListView.getChildAt(paramInt3 - paramInt1);
      if (localView != null) {
        try
        {
          paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
          if (paramInt1 > 0) {
            return true;
          }
        }
        catch (RuntimeException paramAbsListView)
        {
          aciy.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt3, paramAbsListView);
        }
      }
    }
    return false;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 < paramInt1) || (paramInt4 > paramInt1 + paramInt2)) {}
    View localView;
    do
    {
      return false;
      localView = paramAbsListView.getChildAt(paramInt4 - paramInt1);
    } while (localView == null);
    try
    {
      paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
      if ((paramInt1 > 0) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt4))))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt4));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "invalidADExposurePos add " + paramInt4 + " showHeight = " + paramInt1 + " viewHeight = " + this.jdField_a_of_type_Qxn.a(paramInt4));
        }
      }
      boolean bool = a(Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop()), this.jdField_a_of_type_Qxn.a(paramInt4));
      return bool;
    }
    catch (RuntimeException paramAbsListView)
    {
      aciy.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
    }
    return false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "doBeforeAddItem pos = ", Integer.valueOf(paramInt1), ", oldSize = ", Integer.valueOf(paramInt2) });
    if (paramInt1 >= 0)
    {
      Object localObject;
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        int i = paramInt2 - 1;
        while (i >= paramInt1)
        {
          localObject = (qxq)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i + 1, localObject);
          }
          i -= 1;
        }
      }
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          localObject = (qxq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt2);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2 + 1, localObject);
          }
          paramInt2 -= 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          qxp localqxp = (qxp)((Iterator)localObject).next();
          if (localqxp.jdField_a_of_type_Int >= paramInt1) {
            localqxp.jdField_a_of_type_Int += 1;
          }
        }
      }
      d();
    }
  }
  
  public void b(int paramInt, qxq paramqxq)
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = a(this.jdField_b_of_type_AndroidUtilSparseArray, paramqxq.a());
    if (i >= 0) {
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(i);
    }
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramqxq);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */
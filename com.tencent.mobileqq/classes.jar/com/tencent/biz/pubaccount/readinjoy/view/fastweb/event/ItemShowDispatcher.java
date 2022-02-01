package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import tgl;
import tgn;
import tgo;
import ukr;

public class ItemShowDispatcher
{
  private static String jdField_a_of_type_JavaLangString = ItemShowDispatcher.class.getSimpleName();
  private SparseArray<tgo> jdField_a_of_type_AndroidUtilSparseArray;
  private ItemShowDispatcher.OneSecondCallbackLoop jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher$OneSecondCallbackLoop;
  private Pair<Integer, Integer> jdField_a_of_type_ComTencentUtilPair;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ItemShowDispatcher.1(this);
  private ArrayList<tgn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<Integer> a;
  private tgl jdField_a_of_type_Tgl;
  private SparseArray<tgo> jdField_b_of_type_AndroidUtilSparseArray;
  private Pair<Integer, Integer> jdField_b_of_type_ComTencentUtilPair;
  private ArrayList<tgn> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet<String> b;
  private SparseArray<tgo> c;
  private SparseArray<tgo> d;
  
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
          paramInt2 = this.jdField_a_of_type_Tgl.a(paramInt4);
          if ((paramInt1 > 0) && (paramInt2 > 0)) {
            return paramInt1 / paramInt2;
          }
        }
        catch (RuntimeException paramAbsListView)
        {
          AIOUtils.catchedExceptionInReleaseV2("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
        }
      }
    }
    return 0.0F;
  }
  
  private int a(SparseArray<tgo> paramSparseArray, BaseData paramBaseData)
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
      if (((tgo)paramSparseArray.valueAt(i)).a() == paramBaseData) {
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
        if (!a(j, this.jdField_a_of_type_Tgl.a(i), 50))
        {
          k += 1;
          i += 1;
          j = paramAbsListView.getChildAt(k).getBottom();
          continue;
        }
        k = this.jdField_a_of_type_Tgl.a(n) - (localView2.getBottom() - i1);
      }
      catch (Exception paramAbsListView)
      {
        View localView1;
        int i1;
        int j;
        return null;
      }
      if (!a(k, this.jdField_a_of_type_Tgl.a(n), 50))
      {
        n -= 1;
        m -= 1;
        localView1 = paramAbsListView.getChildAt(m);
        k = this.jdField_a_of_type_Tgl.a(n) - (localView1.getBottom() - i1);
      }
      else
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "  " + i + " - " + n + "         " + j + "  " + this.jdField_a_of_type_Tgl.a(i) + "   " + k + "   " + this.jdField_a_of_type_Tgl.a(n));
        return new Pair(Integer.valueOf(i), Integer.valueOf(n));
      }
      if (k <= 0) {
        if (n >= 0) {}
      }
    }
  }
  
  private tgo a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) {
      return null;
    }
    return (tgo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new ItemShowDispatcher.CheckAndStartWebProcessRunnable(paramQQAppInterface));
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((paramPair == null) || (this.d == null) || (this.d.size() == 0)) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "show : " + paramPair.first + " ---  " + paramPair.second);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.d.size())
    {
      int j = this.d.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((tgo)this.d.valueAt(i)).a();
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramPair = localArrayList.iterator();
    while (paramPair.hasNext())
    {
      i = ((Integer)paramPair.next()).intValue();
      this.d.remove(i);
    }
    d();
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentUtilPair == null) && (this.jdField_b_of_type_ComTencentUtilPair == null)) {}
    while ((this.jdField_a_of_type_Tgl == null) || (this.jdField_a_of_type_Tgl.a() == 0) || (((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) && ((this.d == null) || (this.d.size() == 0)) && ((this.jdField_b_of_type_AndroidUtilSparseArray == null) || (this.jdField_b_of_type_AndroidUtilSparseArray.size() == 0)) && ((this.c == null) || (this.c.size() == 0)))) {
      return false;
    }
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (paramInt1 / paramInt2 < paramInt3 / 100.0F) {
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
    return ukr.c((AdData)paramBaseData);
  }
  
  private tgo b(int paramInt)
  {
    if ((this.c == null) || (this.c.size() == 0)) {
      return null;
    }
    return (tgo)this.c.get(paramInt);
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
        tgn localtgn = (tgn)localIterator.next();
        if ((localtgn.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localtgn.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
        {
          localtgn.jdField_a_of_type_Long = (System.currentTimeMillis() - localtgn.jdField_a_of_type_JavaLangLong.longValue());
          localArrayList.add(Integer.valueOf(localtgn.jdField_a_of_type_Int));
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "time is out , need report ,ad pos is =" + localtgn.jdField_a_of_type_Int + "  show time=" + localtgn.jdField_a_of_type_JavaLangLong);
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
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Object localObject = (tgo)this.jdField_a_of_type_AndroidUtilSparseArray.get(localInteger.intValue());
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doAdCallback(ArrayList<Integer> adPositionlist) pos=" + localInteger);
          }
          ((tgo)localObject).a();
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(localInteger.intValue());
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            tgn localtgn = (tgn)((Iterator)localObject).next();
            if ((localtgn != null) && (localtgn.jdField_a_of_type_Int == localInteger.intValue())) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(localtgn);
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
    if (this.d != null)
    {
      int k = 0;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= this.d.size()) {
          break;
        }
        n = this.d.keyAt(k);
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
  
  public tgn a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    tgn localtgn;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localtgn = (tgn)localIterator.next();
    } while (localtgn.jdField_a_of_type_Int != paramInt);
    for (;;)
    {
      return localtgn;
      localtgn = null;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.d != null) {
      this.d.clear();
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
      this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.c != null) {
      this.c.clear();
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
      if (this.d != null)
      {
        this.d.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (tgo)this.d.get(i);
          if (localObject != null)
          {
            this.d.delete(i);
            this.d.put(i - 1, localObject);
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
          localObject = (tgo)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.jdField_b_of_type_AndroidUtilSparseArray != null)
      {
        this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (tgo)this.jdField_b_of_type_AndroidUtilSparseArray.get(i);
          if (localObject != null)
          {
            this.jdField_b_of_type_AndroidUtilSparseArray.delete(i);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.c != null)
      {
        this.c.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (tgo)this.c.get(i);
          if (localObject != null)
          {
            this.c.delete(i);
            this.c.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          tgn localtgn = (tgn)((Iterator)localObject).next();
          if (localtgn.jdField_a_of_type_Int == paramInt1) {
            ((Iterator)localObject).remove();
          } else if (localtgn.jdField_a_of_type_Int > paramInt1) {
            localtgn.jdField_a_of_type_Int -= 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, tgo paramtgo)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if (this.c == null) {
      this.c = new SparseArray();
    }
    int i = a(this.jdField_a_of_type_AndroidUtilSparseArray, paramtgo.a());
    if (i >= 0)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(i);
      this.c.remove(i);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramtgo);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramtgo);
    this.c.put(paramInt, paramtgo);
    c();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      tgn localtgn = (tgn)localIterator.next();
      AdData localAdData = (AdData)localtgn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
      if ((localAdData != null) && (a(localtgn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) && (!this.jdField_b_of_type_JavaUtilHashSet.contains(localAdData.m)) && (a(paramAbsListView, paramInt1, paramInt2, localtgn.jdField_a_of_type_Int))) {
        if (localtgn.b == 0L)
        {
          localtgn.b = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkWebProcess set start time=, traceId=" + localAdData.m);
          }
        }
        else if (System.currentTimeMillis() - localtgn.b >= 500L)
        {
          this.jdField_b_of_type_JavaUtilHashSet.add(localAdData.m);
          a(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkWebProcess CHECK WebViwe! traceId=" + localAdData.m);
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
        tgn localtgn = (tgn)localIterator.next();
        tgo localtgo = a(localtgn.jdField_a_of_type_Int);
        if ((localtgo != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localtgn.jdField_a_of_type_Int, localtgo.a())))
        {
          localtgo.c();
          this.jdField_b_of_type_AndroidUtilSparseArray.remove(localtgn.jdField_a_of_type_Int);
        }
        localtgo = b(localtgn.jdField_a_of_type_Int);
        if ((localtgo != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localtgn.jdField_a_of_type_Int, 1)))
        {
          localtgo.b();
          this.c.remove(localtgn.jdField_a_of_type_Int);
        }
        if (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localtgn.jdField_a_of_type_Int, 50))
        {
          if ((localtgn.jdField_a_of_type_JavaLangLong.longValue() != 0L) && (System.currentTimeMillis() - localtgn.jdField_a_of_type_JavaLangLong.longValue() >= 1000L))
          {
            localArrayList.add(Integer.valueOf(localtgn.jdField_a_of_type_Int));
            localtgn.jdField_a_of_type_Long = (System.currentTimeMillis() - localtgn.jdField_a_of_type_JavaLangLong.longValue());
            localtgn.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localtgn.jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "need report ,ad pos is =" + localtgn.jdField_a_of_type_Int + "  show time=" + localtgn.jdField_a_of_type_JavaLangLong + " exposureTime = " + localtgn.jdField_a_of_type_Long + " exposureArea = " + localtgn.jdField_a_of_type_Float);
            }
          }
          else if (localtgn.jdField_a_of_type_JavaLangLong.longValue() == 0L)
          {
            localtgn.jdField_a_of_type_Float = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localtgn.jdField_a_of_type_Int);
            localtgn.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
          }
        }
        else {
          localtgn.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
        }
      }
    } while (localArrayList.size() <= 0);
    b(localArrayList);
  }
  
  public void a(ArrayList<tgn> paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label125;
      }
      tgn localtgn1 = (tgn)localIterator1.next();
      Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      tgn localtgn2;
      while (localIterator2.hasNext())
      {
        localtgn2 = (tgn)localIterator2.next();
        if (localtgn1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData == localtgn2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData) {
          localtgn1.a(localtgn2);
        }
      }
      localIterator2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      if (localIterator2.hasNext())
      {
        localtgn2 = (tgn)localIterator2.next();
        if (localtgn1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData != localtgn2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData) {
          break;
        }
        localtgn1.a(localtgn2);
      }
    }
    label125:
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
  }
  
  public void a(tgl paramtgl)
  {
    this.jdField_a_of_type_Tgl = paramtgl;
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
          AIOUtils.catchedExceptionInReleaseV2("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt3, paramAbsListView);
        }
      }
    }
    return false;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "invalidADExposurePos add " + paramInt4 + " showHeight = " + paramInt1 + " viewHeight = " + this.jdField_a_of_type_Tgl.a(paramInt4));
        }
      }
      boolean bool = a(Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop()), this.jdField_a_of_type_Tgl.a(paramInt4), paramInt5);
      return bool;
    }
    catch (RuntimeException paramAbsListView)
    {
      AIOUtils.catchedExceptionInReleaseV2("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
    }
    return false;
  }
  
  public void b(int paramInt, tgo paramtgo)
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    int i = a(this.d, paramtgo.a());
    if (i >= 0) {
      this.d.remove(i);
    }
    this.d.put(paramInt, paramtgo);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */
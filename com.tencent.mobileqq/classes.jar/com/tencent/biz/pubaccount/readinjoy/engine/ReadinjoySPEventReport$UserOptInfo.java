package com.tencent.biz.pubaccount.readinjoy.engine;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadinjoySPEventReport$UserOptInfo
  implements AbsListView.OnScrollListener
{
  public int a;
  public long a;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ReadinjoySPEventReport.ScreenFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo;
  public ArrayList<Long> a;
  private HashMap<Long, ReadinjoySPEventReport.ArticleExposureInfoForReport> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int;
  public long b;
  private ReadinjoySPEventReport.ScreenFeedsInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo;
  public ArrayList<Long> b;
  private HashMap<Long, Float> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_c_of_type_Int;
  public long c;
  private ArrayList<ReadinjoySPEventReport.ScrollStep> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  public long d;
  private int e;
  public long e;
  private int f = 0;
  
  public ReadinjoySPEventReport$UserOptInfo(ReadinjoySPEventReport paramReadinjoySPEventReport)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private ReadinjoySPEventReport.ScreenFeedsInfo a(AbsListView paramAbsListView)
  {
    if ((paramAbsListView == null) || (paramAbsListView.getChildCount() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramAbsListView.getFirstVisiblePosition();
    int i = 0;
    if (i < paramAbsListView.getChildCount())
    {
      Object localObject = a(paramAbsListView, k + i);
      if (((localObject instanceof AdvertisementInfo)) || (!(localObject instanceof BaseArticleInfo))) {}
      label173:
      label187:
      for (;;)
      {
        i += 1;
        break;
        View localView = paramAbsListView.getChildAt(i);
        if (localView.getHeight() > 0)
        {
          int j;
          if (localView.getBottom() > paramAbsListView.getHeight())
          {
            j = paramAbsListView.getHeight();
            label105:
            if (localView.getTop() <= 0) {
              break label173;
            }
          }
          for (float f1 = (j - localView.getTop()) * 1.0F / localView.getHeight();; f1 = j * 1.0F / localView.getHeight())
          {
            if (f1 <= 0.0F) {
              break label187;
            }
            localArrayList.add(new Pair((BaseArticleInfo)localObject, Float.valueOf(f1)));
            break;
            j = localView.getBottom();
            break label105;
          }
        }
      }
    }
    paramAbsListView = new ReadinjoySPEventReport.ScreenFeedsInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, null);
    paramAbsListView.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    paramAbsListView.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo == null) {}
    for (long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;; l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo.jdField_a_of_type_Long)
    {
      paramAbsListView.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo = paramAbsListView;
      QLog.d("ReadinjoySPEventReport", 2, new Object[] { paramAbsListView });
      return paramAbsListView;
    }
  }
  
  private ReadinjoySPEventReport.ScrollStep a(AbsListView paramAbsListView)
  {
    ReadinjoySPEventReport.ScrollStep localScrollStep = new ReadinjoySPEventReport.ScrollStep();
    localScrollStep.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
    localScrollStep.f = this.jdField_c_of_type_Int;
    if (this.jdField_d_of_type_Int - this.f > 0) {}
    for (int i = this.jdField_d_of_type_Int - this.f;; i = 0)
    {
      localScrollStep.g = i;
      localScrollStep.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
      localScrollStep.jdField_a_of_type_Long = (this.jdField_c_of_type_Long - this.jdField_b_of_type_Long);
      localScrollStep.h = this.f;
      localScrollStep.i = paramAbsListView.getWidth();
      localScrollStep.jdField_a_of_type_ArrayOfFloat = ((float[])((ReadInJoyXListView)paramAbsListView).jdField_a_of_type_ArrayOfFloat.clone());
      localScrollStep.b = ((float[])((ReadInJoyXListView)paramAbsListView).b.clone());
      return localScrollStep;
    }
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView == null) || (paramInt < 0) || (paramAbsListView.getAdapter() == null)) {}
    do
    {
      return null;
      paramAbsListView = paramAbsListView.getAdapter();
    } while (paramInt >= paramAbsListView.getCount());
    try
    {
      paramAbsListView = paramAbsListView.getItem(paramInt);
      return paramAbsListView;
    }
    catch (Exception paramAbsListView)
    {
      paramAbsListView.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
  }
  
  public String a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
    Collections.sort((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append((ReadinjoySPEventReport.ArticleExposureInfoForReport)((Iterator)localObject).next()).append("|");
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  /* Error */
  public void a(int paramInt, AbsListView paramAbsListView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 217	java/lang/StringBuilder
    //   5: dup
    //   6: new 217	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 257
    //   16: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 262
    //   26: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload_2
    //   38: ifnull +21 -> 59
    //   41: aload_2
    //   42: invokevirtual 77	com/tencent/widget/AbsListView:getChildCount	()I
    //   45: ifle +14 -> 59
    //   48: aload_0
    //   49: getfield 40	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_d_of_type_Long	J
    //   52: lstore_3
    //   53: lload_3
    //   54: lconst_0
    //   55: lcmp
    //   56: ifne +6 -> 62
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: getfield 56	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   66: invokevirtual 271	java/util/ArrayList:size	()I
    //   69: ifle +12 -> 81
    //   72: aload_0
    //   73: getfield 60	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_Int	I
    //   76: iload_1
    //   77: iand
    //   78: ifne -19 -> 59
    //   81: iload_1
    //   82: iconst_2
    //   83: iand
    //   84: ifeq +15 -> 99
    //   87: aload_0
    //   88: getfield 62	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_Boolean	Z
    //   91: ifeq -32 -> 59
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 62	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_Boolean	Z
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 60	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_Int	I
    //   104: iload_1
    //   105: ior
    //   106: putfield 60	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_Int	I
    //   109: aload_0
    //   110: aload_2
    //   111: invokespecial 273	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:a	(Lcom/tencent/widget/AbsListView;)Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ScreenFeedsInfo;
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull -57 -> 59
    //   119: aload_0
    //   120: aload_2
    //   121: invokevirtual 276	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:a	(Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ScreenFeedsInfo;)V
    //   124: aload_0
    //   125: aload_2
    //   126: invokevirtual 279	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ScreenFeedsInfo:a	()Ljava/util/ArrayList;
    //   129: putfield 56	com/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$UserOptInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   132: ldc 136
    //   134: iconst_2
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload 5
    //   143: aload_2
    //   144: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: aastore
    //   148: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   151: goto -92 -> 59
    //   154: astore_2
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	UserOptInfo
    //   0	159	1	paramInt	int
    //   0	159	2	paramAbsListView	AbsListView
    //   52	2	3	l	long
    //   35	107	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	37	154	finally
    //   41	53	154	finally
    //   62	81	154	finally
    //   87	99	154	finally
    //   99	115	154	finally
    //   119	151	154	finally
  }
  
  public void a(View paramView, AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramView == null) || (paramBaseArticleInfo == null) || (paramAbsListView == null)) {
      return;
    }
    float f1 = paramView.getHeight() / 2.0F;
    float f2 = paramView.getTop();
    float f3 = paramAbsListView.getHeight();
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramBaseArticleInfo.mArticleID), Float.valueOf((f1 + f2) / f3));
  }
  
  public void a(ReadinjoySPEventReport.ScreenFeedsInfo paramScreenFeedsInfo)
  {
    if ((paramScreenFeedsInfo == null) || (this.jdField_d_of_type_Long == 0L)) {
      return;
    }
    Iterator localIterator = paramScreenFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
    label23:
    Object localObject;
    long l1;
    float f1;
    long l2;
    if (localIterator.hasNext())
    {
      localObject = (Pair)localIterator.next();
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Pair)localObject).first;
      l1 = paramScreenFeedsInfo.jdField_b_of_type_Long;
      f1 = ((Float)((Pair)localObject).second).floatValue();
      ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localBaseArticleInfo.mArticleID));
      localObject = localArticleExposureInfoForReport;
      if (localArticleExposureInfoForReport == null)
      {
        localObject = new ReadinjoySPEventReport.ArticleExposureInfoForReport(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport, null);
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Long = localBaseArticleInfo.mRecommendSeq;
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_b_of_type_Long = localBaseArticleInfo.mArticleID;
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_JavaLangString = localBaseArticleInfo.mTitle;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localBaseArticleInfo.mArticleID), localObject);
      }
      l2 = ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_c_of_type_Long;
      if (f1 <= 0.8F) {
        break label204;
      }
    }
    for (;;)
    {
      ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_c_of_type_Long = (l1 + l2);
      ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Float = Math.max(((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).jdField_a_of_type_Float, f1);
      break label23;
      break;
      label204:
      l1 = 0L;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_d_of_type_Long != 0L) {}
      for (long l = this.jdField_d_of_type_Long;; l = System.currentTimeMillis())
      {
        this.jdField_d_of_type_Long = l;
        return;
      }
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label70:
    StringBuilder localStringBuilder;
    label96:
    Long localLong;
    ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo != null)
    {
      localArrayList1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo.a();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo == null) {
        break label267;
      }
      localArrayList2 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo.a();
      localStringBuilder = new StringBuilder("exposure info : \n");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLong = (Long)localIterator.next();
        localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.jdField_a_of_type_JavaUtilHashMap.get(localLong);
      } while (localArticleExposureInfoForReport == null);
      localArticleExposureInfoForReport.jdField_a_of_type_Int = 1;
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localLong)) {
        break label273;
      }
    }
    for (localArticleExposureInfoForReport.jdField_a_of_type_Int = 0;; localArticleExposureInfoForReport.jdField_a_of_type_Int = 2) {
      label267:
      label273:
      do
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.contains(localLong)) {
          localArticleExposureInfoForReport.jdField_a_of_type_Boolean = true;
        }
        if ((localArrayList2 != null) && (localArrayList2.contains(localLong))) {
          localArticleExposureInfoForReport.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(localLong)) {
          localArticleExposureInfoForReport.jdField_b_of_type_JavaLangString = String.format("%.2f", new Object[] { this.jdField_b_of_type_JavaUtilHashMap.get(localLong) });
        }
        localStringBuilder.append(localArticleExposureInfoForReport.toString()).append("\n");
        break label96;
        localArrayList1 = null;
        break;
        localArrayList2 = null;
        break label70;
      } while ((localArrayList1 == null) || (!localArrayList1.contains(localLong)));
    }
    QLog.d("ReadinjoySPEventReport", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport.b = this;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport.a = new UserOptInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
    {
      localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)this.jdField_c_of_type_JavaUtilArrayList.get(i)).a()).append("|");
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt1 + paramInt2 - 1;
    int i = paramAbsListView.getChildCount();
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = (paramInt1 + 1);
      this.jdField_c_of_type_Int = paramInt1;
    }
    int j;
    int k;
    View localView;
    if (paramInt1 < this.jdField_b_of_type_Int)
    {
      this.jdField_e_of_type_Int = 1;
      j = this.jdField_b_of_type_Int;
      paramInt2 = 0;
      if ((paramInt2 < i) && (paramInt2 < j - paramInt1))
      {
        k = paramInt1 + paramInt2;
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(k) != null)
        {
          int m = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = (((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).intValue() + m);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          localView = paramAbsListView.getChildAt(paramInt2);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(k, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
      }
      this.jdField_b_of_type_Int = paramInt1;
    }
    if (paramInt3 > this.jdField_c_of_type_Int)
    {
      this.jdField_e_of_type_Int = 0;
      paramInt2 = this.jdField_c_of_type_Int;
      paramInt1 = i - 1;
      if (i - 1 - paramInt1 < paramInt3 - paramInt2)
      {
        j = paramInt3 - (i - 1 - paramInt1);
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(j) != null)
        {
          k = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = (((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(j)).intValue() + k);
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          localView = paramAbsListView.getChildAt(paramInt1);
          if (localView != null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(j, Integer.valueOf(localView.getHeight()));
            this.jdField_d_of_type_Int += localView.getHeight();
          }
        }
      }
      this.jdField_c_of_type_Int = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    ReadinjoySPEventReport.ScrollStep localScrollStep;
    int i;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      localScrollStep = a(paramAbsListView);
      this.jdField_c_of_type_JavaUtilArrayList.add(localScrollStep);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
      if ((paramAbsListView instanceof ReadInJoyXListView))
      {
        i = ((ReadInJoyXListView)paramAbsListView).g;
        int j = ((ReadInJoyXListView)paramAbsListView).h;
        paramInt = Math.min(i, j);
        i = Math.max(i, j);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        QLog.d("ReadinjoySPEventReport", 2, "finger touch min :" + paramInt + ", max : " + i);
      }
    case 1: 
      while ((paramInt <= i) && (paramInt < paramAbsListView.getCount()))
      {
        Object localObject = a(paramAbsListView, paramInt);
        if (((localObject instanceof ArticleInfo)) && (!(localObject instanceof AdvertisementInfo))) {
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ArticleInfo)localObject).mArticleID));
        }
        paramInt += 1;
        continue;
        b();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.f = paramAbsListView.getHeight();
        if (this.jdField_a_of_type_Long == 0L) {
          this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo);
        return;
      }
      QLog.d("ReadinjoySPEventReport", 2, "one scroll " + localScrollStep.a());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo = a(paramAbsListView);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ScreenFeedsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo
 * JD-Core Version:    0.7.0.1
 */
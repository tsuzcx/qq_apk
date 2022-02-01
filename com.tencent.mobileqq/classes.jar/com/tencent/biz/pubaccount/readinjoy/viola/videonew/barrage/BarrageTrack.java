package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack;", "", "()V", "bakBarrageData", "Ljava/util/ArrayDeque;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageInfo;", "barrageConfig", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageConfig;", "barrageData", "barrageLineCallback", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLineCallback;", "getBarrageLineCallback", "()Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLineCallback;", "setBarrageLineCallback", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLineCallback;)V", "handler", "Landroid/os/Handler;", "isFirstTimePlaceBarrage", "", "lines", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageTrack$BarrageLine;", "Lkotlin/collections/ArrayList;", "canPlaceInThisLine", "index", "", "barrageType", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$BarrageType;", "checkPlaceLineIsValidate", "barrageLines", "", "findSuitableBarrageLines", "getIdleLineCount", "getPlaceLineCount", "handleBarrageDataForLoop", "", "init", "innerPlaceBarrageInLine", "barrageInfo", "notifyLineIdle", "placeBarrageInLine", "delay", "", "placeOneBarrageInLine", "reset", "tryPlaceBarragesInLine", "BarrageLine", "BarrageLineCallback", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BarrageTrack
{
  public static final BarrageTrack.Companion a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private BarrageConfig jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig = new BarrageConfig();
  @Nullable
  private BarrageTrack.BarrageLineCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageTrack$BarrageLineCallback;
  private ArrayDeque<BarrageInfo> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private final ArrayList<BarrageTrack.BarrageLine> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayDeque<BarrageInfo> b = new ArrayDeque();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageTrack$Companion = new BarrageTrack.Companion(null);
  }
  
  private final int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((BarrageTrack.BarrageLine)localIterator.next()).a()) {
        break label43;
      }
      i += 1;
    }
    label43:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private final int a(BarrageItemView.BarrageType paramBarrageType)
  {
    if (paramBarrageType == BarrageItemView.BarrageType.DOUBLE_LINE) {
      return 2;
    }
    return 1;
  }
  
  private final List<BarrageTrack.BarrageLine> a(BarrageItemView.BarrageType paramBarrageType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        BarrageTrack.BarrageLine localBarrageLine = (BarrageTrack.BarrageLine)localIterator.next();
        if ((localArrayList.isEmpty()) && (!a(localBarrageLine.a(), paramBarrageType))) {
          continue;
        }
        if (!localBarrageLine.a()) {
          break label129;
        }
        localArrayList.add(localBarrageLine);
      }
      while (localArrayList.size() == a(paramBarrageType))
      {
        if (!a((List)localArrayList, paramBarrageType))
        {
          QLog.w("BarrageTrack", 1, "checkPlaceLineIsValidate not validate, barrageType:" + paramBarrageType);
          localArrayList.clear();
        }
        return (List)localArrayList;
        label129:
        localArrayList.clear();
      }
    }
  }
  
  private final void a(BarrageInfo paramBarrageInfo, long paramLong)
  {
    if (paramBarrageInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new BarrageTrack.placeBarrageInLine.1(this, paramBarrageInfo), paramLong);
  }
  
  private final void a(BarrageInfo paramBarrageInfo, List<BarrageTrack.BarrageLine> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      for (int i = 1; localIterator.hasNext(); i = 0)
      {
        BarrageTrack.BarrageLine localBarrageLine = (BarrageTrack.BarrageLine)localIterator.next();
        if (i == 0) {
          ((StringBuilder)localObject).append(",");
        }
        ((StringBuilder)localObject).append(localBarrageLine.a());
      }
      QLog.d("BarrageTrack", 2, "placeOneBarrageInLine barrageInfo:" + paramBarrageInfo.b + "    barrageLines:" + ((StringBuilder)localObject).toString());
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BarrageTrack.BarrageLine)((Iterator)localObject).next()).a(false);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageTrack$BarrageLineCallback;
    if (localObject != null) {
      ((BarrageTrack.BarrageLineCallback)localObject).a(paramBarrageInfo, paramList);
    }
  }
  
  private final boolean a(int paramInt, BarrageItemView.BarrageType paramBarrageType)
  {
    return true;
  }
  
  private final boolean a(BarrageInfo paramBarrageInfo)
  {
    List localList = a(BarrageItemView.a.a(paramBarrageInfo.b));
    if (localList.isEmpty())
    {
      QLog.w("BarrageTrack", 2, "InnerPlaceBarrageInLine failed for no idle barrageLine.");
      return false;
    }
    a(paramBarrageInfo, localList);
    return true;
  }
  
  private final boolean a(List<BarrageTrack.BarrageLine> paramList, BarrageItemView.BarrageType paramBarrageType)
  {
    return a(paramBarrageType) == paramList.size();
  }
  
  private final void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig.a()) && (this.jdField_a_of_type_JavaUtilArrayDeque.size() < this.b.size()))
    {
      this.jdField_a_of_type_JavaUtilArrayDeque.addAll((Collection)this.b.clone());
      this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new BarrageTrack.handleBarrageDataForLoop.1(this));
    }
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      j = ((Collection)this.jdField_a_of_type_JavaUtilArrayList).size();
      i = 0;
      while (i < j)
      {
        a((BarrageInfo)this.jdField_a_of_type_JavaUtilArrayDeque.poll(), i * 500L);
        i += 1;
      }
    }
    int j = a();
    int i = 0;
    while (i < j)
    {
      i += 1;
      BarrageInfo localBarrageInfo = (BarrageInfo)this.jdField_a_of_type_JavaUtilArrayDeque.peek();
      if (localBarrageInfo != null) {
        if (a(localBarrageInfo)) {
          this.jdField_a_of_type_JavaUtilArrayDeque.remove(localBarrageInfo);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  public final void a(@NotNull BarrageConfig paramBarrageConfig, @NotNull List<? extends BarrageInfo> paramList)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramBarrageConfig, "barrageConfig");
    Intrinsics.checkParameterIsNotNull(paramList, "barrageData");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageConfig = paramBarrageConfig;
    c();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int m = BarrageItemView.a.a();
    int n = DisplayUtil.b((Context)BaseApplication.getContext(), paramBarrageConfig.b());
    int i1 = paramBarrageConfig.a();
    int k;
    for (int j = 0; i < i1; j = k)
    {
      paramBarrageConfig = new BarrageTrack.BarrageLine();
      paramBarrageConfig.a(true);
      paramBarrageConfig.a(i);
      k = j;
      if (i != 0) {
        k = j + (m + n);
      }
      paramBarrageConfig.b(k);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBarrageConfig);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayDeque.clear();
    this.jdField_a_of_type_JavaUtilArrayDeque.addAll((Collection)paramList);
    paramBarrageConfig = this.jdField_a_of_type_JavaUtilArrayDeque.clone();
    Intrinsics.checkExpressionValueIsNotNull(paramBarrageConfig, "this.barrageData.clone()");
    this.b = paramBarrageConfig;
  }
  
  public final void a(@Nullable BarrageTrack.BarrageLineCallback paramBarrageLineCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewBarrageBarrageTrack$BarrageLineCallback = paramBarrageLineCallback;
  }
  
  public final void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageTrack
 * JD-Core Version:    0.7.0.1
 */
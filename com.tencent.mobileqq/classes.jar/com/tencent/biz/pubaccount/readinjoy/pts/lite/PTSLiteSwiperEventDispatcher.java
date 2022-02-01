package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.FeedsOperation;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qav.thread.ThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLiteSwiperEventDispatcher;", "", "()V", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "Lkotlin/collections/HashMap;", "positionMap", "", "getBehaviorTypeAndStayTimeMillis", "Landroid/util/Pair;", "", "channelId", "handleSwiperDrag", "", "identifier", "dataSet", "view", "Landroid/view/View;", "handleSwiperItemExposure", "folderStatus", "Builder", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher
{
  public static final PTSLiteSwiperEventDispatcher.Companion a;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, ArticleInfo> b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLitePTSLiteSwiperEventDispatcher$Companion = new PTSLiteSwiperEventDispatcher.Companion(null);
  }
  
  private final Pair<Integer, Long> a(int paramInt)
  {
    long l2 = 0L;
    int j = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
    if (localObject != null)
    {
      localObject = ((ReadInJoyBaseAdapter)localObject).a();
      if (!(localObject instanceof ReadInJoyNewFeedsActivity)) {
        break label274;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
      if (localObject == null) {
        break label72;
      }
    }
    label72:
    for (localObject = ((ReadInJoyBaseAdapter)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        break label78;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      localObject = null;
      break;
    }
    label78:
    long l1;
    if (((ReadInJoyNewFeedsActivity)localObject).a() > 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
      if (localObject != null) {}
      for (localObject = ((ReadInJoyBaseAdapter)localObject).a(); localObject == null; localObject = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      }
      l1 = ((ReadInJoyNewFeedsActivity)localObject).a();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
      if (localObject == null) {
        break label233;
      }
    }
    label233:
    for (localObject = ((ReadInJoyBaseAdapter)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        break label239;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      l1 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
      if (localObject != null) {}
      for (localObject = ((ReadInJoyBaseAdapter)localObject).a(); localObject == null; localObject = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity");
      }
      l1 -= ((ReadInJoyNewFeedsActivity)localObject).b();
      break;
    }
    label239:
    if (((ReadInJoyNewFeedsActivity)localObject).b()) {
      paramInt = 0;
    }
    label274:
    label405:
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt), Long.valueOf(l1));
      paramInt = 1;
      continue;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
      if (localObject != null)
      {
        localObject = ((ReadInJoyBaseAdapter)localObject).a();
        label292:
        if (!(localObject instanceof SplashActivity)) {
          break label377;
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
        if (localObject == null) {
          break label366;
        }
        localObject = ((ReadInJoyBaseAdapter)localObject).a();
        label318:
        localObject = RIJJumpUtils.a((Context)localObject);
        if (localObject == null) {
          break label405;
        }
        localObject = ((RIJTabFrameBase)localObject).a();
        if (((RIJTabFrameBase.FeedsOperation)localObject).a() == 0) {
          break label372;
        }
      }
      label366:
      label372:
      for (paramInt = j;; paramInt = 1)
      {
        l1 = ((RIJTabFrameBase.FeedsOperation)localObject).a();
        break;
        localObject = null;
        break label292;
        localObject = null;
        break label318;
      }
      label377:
      if (DailyModeConfigHandler.c(paramInt))
      {
        l1 = l2;
        paramInt = i;
        if (KandianDailyReportUtils.b() == 0)
        {
          paramInt = 1;
          l1 = l2;
        }
      }
      else
      {
        paramInt = -1;
        l1 = l2;
      }
    }
  }
  
  public final void a(@Nullable String paramString, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    ThreadManager.a((Runnable)new PTSLiteSwiperEventDispatcher.handleSwiperDrag.1(paramString, paramHashMap));
  }
  
  public final void a(@Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    ThreadManager.a((Runnable)new PTSLiteSwiperEventDispatcher.handleSwiperItemExposure.1(this, paramString1, paramString2, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteSwiperEventDispatcher
 * JD-Core Version:    0.7.0.1
 */
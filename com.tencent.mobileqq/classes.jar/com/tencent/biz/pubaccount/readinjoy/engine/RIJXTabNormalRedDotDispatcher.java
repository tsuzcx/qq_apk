package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabNormalRedDotDispatcher;", "Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJXTabNormalRedDotConsumer;", "()V", "consumers", "", "getConsumers", "()Ljava/util/List;", "consumers$delegate", "Lkotlin/Lazy;", "addConsumer", "", "consumer", "beforeShowingRedDot", "info", "Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabRedDotInfo;", "removeAllConsumers", "removeConsumer", "", "showRedDot", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabNormalRedDotDispatcher
  implements IRIJXTabNormalRedDotConsumer
{
  public static final RIJXTabNormalRedDotDispatcher a;
  private static final Lazy a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotDispatcher = new RIJXTabNormalRedDotDispatcher();
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJXTabNormalRedDotDispatcher.consumers.2.INSTANCE);
  }
  
  private final List<IRIJXTabNormalRedDotConsumer> a()
  {
    return (List)jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public final void a(@NotNull IRIJXTabNormalRedDotConsumer paramIRIJXTabNormalRedDotConsumer)
  {
    Intrinsics.checkParameterIsNotNull(paramIRIJXTabNormalRedDotConsumer, "consumer");
    if (!a().contains(paramIRIJXTabNormalRedDotConsumer)) {
      a().add(paramIRIJXTabNormalRedDotConsumer);
    }
  }
  
  public void a(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    Iterator localIterator = ((Iterable)a()).iterator();
    while (localIterator.hasNext()) {
      ((IRIJXTabNormalRedDotConsumer)localIterator.next()).a(paramRIJXTabRedDotInfo);
    }
  }
  
  public final boolean a(@NotNull IRIJXTabNormalRedDotConsumer paramIRIJXTabNormalRedDotConsumer)
  {
    Intrinsics.checkParameterIsNotNull(paramIRIJXTabNormalRedDotConsumer, "consumer");
    return a().remove(paramIRIJXTabNormalRedDotConsumer);
  }
  
  public void b(@NotNull RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJXTabRedDotInfo, "info");
    Iterator localIterator = ((Iterable)a()).iterator();
    while (localIterator.hasNext()) {
      ((IRIJXTabNormalRedDotConsumer)localIterator.next()).b(paramRIJXTabRedDotInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotDispatcher
 * JD-Core Version:    0.7.0.1
 */
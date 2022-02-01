package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler.Companion;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/RIJXTabNormalRedDotInterceptor;", "Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJNormalRedDotInterceptor;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mergeManager", "Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;)V", "channelNotExist", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "isXTabRedDotMsg", "kandianTabHasRedNum", "onNotifyRedDotMsg", "onReceiveRedDotMsg", "onSaveRedDotMsg", "", "shouldIntercept", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabNormalRedDotInterceptor
  implements IRIJNormalRedDotInterceptor
{
  public static final RIJXTabNormalRedDotInterceptor.Companion a;
  private final KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineRIJXTabNormalRedDotInterceptor$Companion = new RIJXTabNormalRedDotInterceptor.Companion(null);
  }
  
  public RIJXTabNormalRedDotInterceptor(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = paramKandianMergeManager;
  }
  
  private final boolean d(MessageRecord paramMessageRecord)
  {
    if (KandianMergeManager.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {}
    while (RIJXTabRedDotInfoKt.a(paramMessageRecord) == null) {
      return false;
    }
    return true;
  }
  
  private final boolean e(MessageRecord paramMessageRecord)
  {
    return (!RIJXTabFrameUtils.a.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e() > 0);
  }
  
  private final boolean f(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = RIJXTabRedDotInfoKt.a(paramMessageRecord);
    Iterator localIterator;
    if (paramMessageRecord != null) {
      localIterator = ((Iterable)RIJXTabConfigHandler.a.a().a()).iterator();
    }
    while (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == paramMessageRecord.getChannelId())
      {
        return false;
        return true;
      }
    }
    return true;
  }
  
  public int a(@NotNull MessageRecord paramMessageRecord)
  {
    int j = -1;
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    paramMessageRecord = RIJXTabRedDotInfoKt.a(paramMessageRecord);
    int i = j;
    if (paramMessageRecord != null)
    {
      boolean bool = RIJXTabNormalRedDotStore.a.a(paramMessageRecord);
      QLog.d("RIJXTabNormalRedDotInterceptor", 2, "onSaveRedDotMsg:(" + bool + ") " + paramMessageRecord);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.g();
      i = j;
      if (bool) {
        i = 1;
      }
    }
    return i;
  }
  
  public boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    boolean bool = d(paramMessageRecord);
    QLog.d("RIJXTabNormalRedDotInterceptor", 2, "shouldIntercept(" + bool + ") --> " + "from:" + KandianMergeManager.a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + ',' + "redDotInfo:" + RIJXTabRedDotInfoKt.a(paramMessageRecord));
    return bool;
  }
  
  public boolean b(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    if ((!RIJXTabConfigHandler.a.a().a()) || (e(paramMessageRecord)) || (f(paramMessageRecord))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RIJXTabNormalRedDotInterceptor", 2, "onReceiveRedDotMsg(" + bool + ") --> " + "isXTabMode:" + RIJXTabConfigHandler.a.a().a() + ", " + "kandianTabHasRedNum:" + e(paramMessageRecord) + ", " + "channelNotExist:" + f(paramMessageRecord));
      return bool;
    }
  }
  
  public boolean c(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    paramMessageRecord = RIJXTabRedDotInfoKt.a(paramMessageRecord);
    if (paramMessageRecord != null) {
      ThreadManager.getUIHandler().post((Runnable)new RIJXTabNormalRedDotInterceptor.onNotifyRedDotMsg.1(paramMessageRecord));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.RIJXTabNormalRedDotInterceptor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClient;", "", "()V", "TAG", "", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterface;", "rijAidlInterface", "getRijAidlInterface", "()Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterface;", "rijServiceConnection", "Lcom/tencent/biz/pubaccount/readinjoy/reward/aidl/RIJAidlClient$RIJServiceConnection;", "bindService", "", "context", "Landroid/content/Context;", "getInstance", "unbindService", "RIJServiceConnection", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJAidlClient
{
  @Nullable
  private static IRIJAidlInterface jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlIRIJAidlInterface;
  private static final RIJAidlClient.RIJServiceConnection jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlRIJAidlClient$RIJServiceConnection = new RIJAidlClient.RIJServiceConnection();
  public static final RIJAidlClient a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlRIJAidlClient = new RIJAidlClient();
  }
  
  @JvmStatic
  @NotNull
  public static final RIJAidlClient a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlRIJAidlClient;
  }
  
  @Nullable
  public final IRIJAidlInterface a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlIRIJAidlInterface;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      paramContext.bindService(new Intent(paramContext, KandianVideoUploadService.class), (ServiceConnection)jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardAidlRIJAidlClient$RIJServiceConnection, 1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("RIJAidlClient", 1, QLog.getStackTraceString((Throwable)paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClient
 * JD-Core Version:    0.7.0.1
 */
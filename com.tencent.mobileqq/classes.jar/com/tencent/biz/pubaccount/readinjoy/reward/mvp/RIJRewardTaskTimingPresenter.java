package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJUserLevelTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class RIJRewardTaskTimingPresenter
  implements IRIJRewardTaskTimingContract.IPresenter
{
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @NotNull
  private IRIJRewardTaskTimingContract.IModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel;
  private IRIJRewardTaskTimingContract.IView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IView;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  
  private RIJRewardTaskTimingPresenter(@NotNull IRIJRewardTaskTimingContract.IModel paramIModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel = paramIModel;
  }
  
  private int a()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Long > 0L) {
      l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long;
    }
    return (int)Math.max(l, 33L);
  }
  
  public static RIJRewardTaskTimingPresenter a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModel());
    }
    return new RIJRewardTaskTimingPresenter(new RIJRewardTaskTimingModelForTool());
  }
  
  private Runnable a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    return new RIJRewardTaskTimingPresenter.1(this, paramInt1, paramString, paramInt2);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 > 600000L)
    {
      bool1 = bool2;
      if (RIJUserLevelTimeUtils.a())
      {
        RIJUserLevelTimeUtils.b(paramInt1);
        bool1 = true;
      }
    }
    if ((paramInt1 > paramInt2) && (RIJRewardTaskConfig.a()))
    {
      b();
      return true;
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean, RIJRewardTask paramRIJRewardTask, int paramInt)
  {
    boolean bool2 = false;
    int i = paramRIJRewardTask.c();
    boolean bool1 = bool2;
    if (i > RIJUserLevelTimeUtils.a())
    {
      bool1 = bool2;
      if (RIJUserLevelTimeUtils.a()) {
        bool1 = true;
      }
    }
    if (!paramBoolean)
    {
      paramBoolean = bool1;
      if (i <= paramInt) {}
    }
    else
    {
      paramBoolean = bool1;
      if (RIJRewardTaskConfig.a()) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    if (localRIJRewardTask == null) {
      return;
    }
    QLog.i("RIJRewardTaskTimingPresenter", 1, "stop timing --> curTask: " + localRIJRewardTask.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a(localRIJRewardTask.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.b(localRIJRewardTask);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a(null);
  }
  
  public void a(IRIJRewardTaskTimingContract.IView paramIView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IView = paramIView;
  }
  
  public void a(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    int j = 0;
    RIJRewardTask localRIJRewardTask3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.b();
    RIJRewardTask localRIJRewardTask2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    RIJRewardTask localRIJRewardTask1 = localRIJRewardTask2;
    if (localRIJRewardTask2 == null)
    {
      localRIJRewardTask2 = new RIJRewardTask(paramString, paramInt2, paramInt1, 0);
      localRIJRewardTask1 = localRIJRewardTask2;
      if (localRIJRewardTask3 != null)
      {
        localRIJRewardTask1 = localRIJRewardTask2;
        if (localRIJRewardTask3.a().equals(localRIJRewardTask2.a()))
        {
          localRIJRewardTask2.a(localRIJRewardTask2.c() + localRIJRewardTask3.c());
          localRIJRewardTask1 = localRIJRewardTask2;
        }
      }
    }
    int i = j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a(paramString))
    {
      i = j;
      if (localRIJRewardTask3 != null)
      {
        i = j;
        if (!localRIJRewardTask3.a().equals(paramString)) {
          i = 1;
        }
      }
    }
    if (i != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a(localRIJRewardTask1);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaLangRunnable = a(paramString, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b()
  {
    RIJRewardTask localRIJRewardTask = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a();
    if (localRIJRewardTask == null) {
      return;
    }
    QLog.i("RIJRewardTaskTimingPresenter", 1, "report task progress --> task: " + localRIJRewardTask.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardMvpIRIJRewardTaskTimingContract$IModel.a(localRIJRewardTask.a(), localRIJRewardTask.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter
 * JD-Core Version:    0.7.0.1
 */
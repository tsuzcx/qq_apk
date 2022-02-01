package com.tencent.mobileqq.activity.aio.helper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/helper/PlusRedPointHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "mPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "TAG", "", "mAppList", "Ljava/util/ArrayList;", "mViewModel", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PlusPanelViewModel;", "getAppList", "", "getTag", "interestedIn", "", "onMoveToState", "", "state", "", "setAppList", "list", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PluginData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PlusRedPointHelper
  implements ILifeCycleHelper
{
  private final String a;
  private PlusPanelViewModel b;
  private ArrayList<String> c;
  private final BaseChatPie d;
  
  public PlusRedPointHelper(@Nullable BaseChatPie paramBaseChatPie)
  {
    this.d = paramBaseChatPie;
    this.a = "PlusRedPointHelper";
  }
  
  private final void a(ArrayList<PluginData> paramArrayList)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (PluginData)paramArrayList.next();
      ArrayList localArrayList = this.c;
      if (localArrayList != null) {
        localArrayList.add(((PluginData)localObject).f);
      }
    }
  }
  
  @Nullable
  public final List<String> a()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((PlusPanelViewModel)localObject).c(this.d);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)((Iterator)localObject).next();
            ArrayList localArrayList = this.c;
            if (localArrayList == null) {
              Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(localPlusPanelAppInfo, "it");
            localArrayList.add(String.valueOf(localPlusPanelAppInfo.getRedDotID()));
          }
        }
      }
    }
    return (List)this.c;
  }
  
  @NotNull
  public String getTag()
  {
    return this.a;
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9) {
      return;
    }
    QLog.d(this.a, 1, "onShowFirst create pluspanel");
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((BaseChatPie)localObject1).aX();
    } else {
      localObject1 = null;
    }
    if (!(localObject1 instanceof BaseActivity)) {
      return;
    }
    if (QVipSDKProcessor.e().f())
    {
      localObject1 = LifeCycleFragment.a((QBaseActivity)localObject1);
      this.b = ((PlusPanelViewModel)ViewModelProviderHelper.a((ViewModelStoreOwner)localObject1, PlusPanelViewModel.e).get(PlusPanelViewModel.class));
      localObject2 = this.b;
      if (localObject2 != null)
      {
        localObject2 = ((PlusPanelViewModel)localObject2).b();
        if (localObject2 != null) {
          ((MutableLiveData)localObject2).observe((LifecycleOwner)localObject1, (Observer)new PlusRedPointHelper.onMoveToState.1(this));
        }
      }
      ThreadManagerV2.executeOnSubThread((Runnable)new PlusRedPointHelper.sam.java_lang_Runnable.0((Function0)new PlusRedPointHelper.onMoveToState.block.1(this)));
      return;
    }
    localObject1 = LifeCycleFragment.a((QBaseActivity)localObject1);
    this.b = ((PlusPanelViewModel)ViewModelProviderHelper.a((ViewModelStoreOwner)localObject1, PlusPanelViewModel.e).get(PlusPanelViewModel.class));
    Object localObject2 = this.b;
    if (localObject2 != null) {
      ((PlusPanelViewModel)localObject2).a(this.d);
    }
    localObject2 = this.b;
    if (localObject2 != null) {
      ((PlusPanelViewModel)localObject2).b(this.d);
    }
    localObject2 = this.b;
    if (localObject2 != null)
    {
      localObject2 = ((PlusPanelViewModel)localObject2).b();
      if (localObject2 != null) {
        ((MutableLiveData)localObject2).observe((LifecycleOwner)localObject1, (Observer)new PlusRedPointHelper.onMoveToState.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.helper;

import android.support.v4.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.mvvm.ActivityExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
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
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PlusPanelViewModel jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public PlusRedPointHelper(@Nullable BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaLangString = "PlusRedPointHelper";
  }
  
  private final void a(ArrayList<PluginData> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (PluginData)paramArrayList.next();
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null) {
        localArrayList.add(((PluginData)localObject).c);
      }
    }
  }
  
  @Nullable
  public final List<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
      if (localObject != null)
      {
        localObject = ((PlusPanelViewModel)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)((Iterator)localObject).next();
            ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
            if (localArrayList == null) {
              Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(localPlusPanelAppInfo, "it");
            localArrayList.add(String.valueOf(localPlusPanelAppInfo.getRedDotID()));
          }
        }
      }
    }
    return (List)this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  @NotNull
  public String getTag()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    Object localObject1;
    Object localObject2;
    label171:
    do
    {
      do
      {
        for (;;)
        {
          return;
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onShowFirst create pluspanel");
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if (localObject1 != null) {}
          for (localObject1 = ((BaseChatPie)localObject1).a(); (localObject1 instanceof FragmentActivity); localObject1 = null)
          {
            if (!QVipSDKProcessor.c().e()) {
              break label171;
            }
            localObject1 = ActivityExtKt.a((FragmentActivity)localObject1);
            localObject2 = (ViewModelStoreOwner)localObject1;
            localFactory = PlusPanelViewModel.a;
            Intrinsics.checkExpressionValueIsNotNull(localFactory, "PlusPanelViewModel.sPlusPanelViewModelFactory");
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel = ((PlusPanelViewModel)LifeCycleExtKt.a((ViewModelStoreOwner)localObject2, localFactory).get(PlusPanelViewModel.class));
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
            if (localObject2 != null)
            {
              localObject2 = ((PlusPanelViewModel)localObject2).a();
              if (localObject2 != null) {
                ((MutableLiveData)localObject2).observe((LifecycleOwner)localObject1, (Observer)new PlusRedPointHelper.onMoveToState.1(this));
              }
            }
            ThreadManagerV2.executeOnSubThread((Runnable)new PlusRedPointHelper.sam.java_lang_Runnable.0((Function0)new PlusRedPointHelper.onMoveToState.block.1(this)));
            return;
          }
        }
        localObject1 = ActivityExtKt.a((FragmentActivity)localObject1);
        localObject2 = (ViewModelStoreOwner)localObject1;
        ViewModelProvider.Factory localFactory = PlusPanelViewModel.a;
        Intrinsics.checkExpressionValueIsNotNull(localFactory, "PlusPanelViewModel.sPlusPanelViewModelFactory");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel = ((PlusPanelViewModel)LifeCycleExtKt.a((ViewModelStoreOwner)localObject2, localFactory).get(PlusPanelViewModel.class));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
        if (localObject2 != null) {
          ((PlusPanelViewModel)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
        if (localObject2 != null) {
          ((PlusPanelViewModel)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
      } while (localObject2 == null);
      localObject2 = ((PlusPanelViewModel)localObject2).a();
    } while (localObject2 == null);
    ((MutableLiveData)localObject2).observe((LifecycleOwner)localObject1, (Observer)new PlusRedPointHelper.onMoveToState.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper
 * JD-Core Version:    0.7.0.1
 */
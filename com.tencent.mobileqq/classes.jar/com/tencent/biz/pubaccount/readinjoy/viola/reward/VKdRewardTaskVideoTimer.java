package com.tencent.biz.pubaccount.readinjoy.viola.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJUserLevelTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.reward.IRIJRewardTaskTimer;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import cooperation.readinjoy.ReadInJoyHelper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VKdRewardTaskVideoTimer
  extends VComponentContainer<VKdRewardTaskLayout>
  implements IRIJRewardTaskTimer
{
  private static final String TAG = "VKdRewardTaskVideoTimer";
  private ReadInJoyObserver mObserver;
  private RIJRewardTaskTimingPresenter rewardTimingPresenter = RIJRewardTaskTimingPresenter.a();
  
  public VKdRewardTaskVideoTimer(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void attachDebugView(Activity paramActivity)
  {
    if (!ReadInJoyHelper.k(ReadInJoyHelper.a())) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    if (localViewGroup.findViewById(2131376609) == null) {
      localViewGroup.addView(LayoutInflater.from(paramActivity).inflate(2131562892, localViewGroup, false));
    }
    paramActivity = new VKdRewardTaskVideoTimer.2(this, (TextView)localViewGroup.findViewById(2131379733), (TextView)localViewGroup.findViewById(2131363064), (TextView)localViewGroup.findViewById(2131363065), (TextView)localViewGroup.findViewById(2131379727), (TextView)localViewGroup.findViewById(2131365502));
    this.rewardTimingPresenter.a(paramActivity);
  }
  
  public boolean enabled()
  {
    return (RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a());
  }
  
  @JSMethod
  public void endTiming()
  {
    if (!enabled()) {
      return;
    }
    stopTiming();
  }
  
  public VKdRewardTaskLayout initComponentHostView(Context paramContext)
  {
    paramContext = new VKdRewardTaskLayout(paramContext);
    paramContext.a(this);
    this.mObserver = new VKdRewardTaskVideoTimer.1(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.mObserver);
    if (getInstance().getActivity() != null) {
      attachDebugView(getInstance().getActivity());
    }
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.mObserver);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    stopTiming();
  }
  
  public void removedByJs()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.mObserver);
  }
  
  public void startTiming(@NotNull String paramString, int paramInt)
  {
    this.rewardTimingPresenter.a(paramString, paramInt, 2);
  }
  
  @JSMethod
  public void startTiming(JSONObject paramJSONObject)
  {
    if (!enabled()) {}
    String str;
    do
    {
      do
      {
        return;
      } while (paramJSONObject == null);
      str = paramJSONObject.optString("rowkey");
    } while (TextUtils.isEmpty(str));
    startTiming(str, paramJSONObject.optInt("duration"));
  }
  
  public void stopTiming()
  {
    this.rewardTimingPresenter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */
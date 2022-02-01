package com.tencent.biz.pubaccount.readinjoy.viola.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import bkwm;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import pkp;
import pkt;
import qxs;
import qzk;
import tmb;
import tmc;

public class VKdRewardTaskVideoTimer
  extends VComponentContainer<VKdRewardTaskLayout>
{
  private static final String TAG = "VKdRewardTaskVideoTimer";
  private pkt mObserver;
  private qzk rewardTimingPresenter = qzk.a();
  
  public VKdRewardTaskVideoTimer(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void attachDebugView(Activity paramActivity)
  {
    if (!bkwm.j(bkwm.a())) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    if (localViewGroup.findViewById(2131375972) == null) {
      localViewGroup.addView(LayoutInflater.from(paramActivity).inflate(2131562678, localViewGroup, false));
    }
    paramActivity = new tmc(this, (TextView)localViewGroup.findViewById(2131379014), (TextView)localViewGroup.findViewById(2131363005), (TextView)localViewGroup.findViewById(2131363006), (TextView)localViewGroup.findViewById(2131379010), (TextView)localViewGroup.findViewById(2131365259));
    this.rewardTimingPresenter.a(paramActivity);
  }
  
  public boolean enabled()
  {
    return qxs.a();
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
    this.mObserver = new tmb(this);
    pkp.a().a(this.mObserver);
    if (getInstance().getActivity() != null) {
      attachDebugView(getInstance().getActivity());
    }
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    pkp.a().b(this.mObserver);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    stopTiming();
  }
  
  public void removedByJs()
  {
    pkp.a().b(this.mObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */
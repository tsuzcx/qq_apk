package com.tencent.biz.pubaccount.readinjoy.viola.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import bmhv;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import prj;
import pvm;
import pvq;
import rjy;
import rlq;
import tzp;
import tzq;

public class VKdRewardTaskVideoTimer
  extends VComponentContainer<VKdRewardTaskLayout>
{
  private static final String TAG = "VKdRewardTaskVideoTimer";
  private pvq mObserver;
  private rlq rewardTimingPresenter = rlq.a();
  
  public VKdRewardTaskVideoTimer(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void attachDebugView(Activity paramActivity)
  {
    if (!bmhv.j(bmhv.a())) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
    if (localViewGroup.findViewById(2131376219) == null) {
      localViewGroup.addView(LayoutInflater.from(paramActivity).inflate(2131562749, localViewGroup, false));
    }
    paramActivity = new tzq(this, (TextView)localViewGroup.findViewById(2131379310), (TextView)localViewGroup.findViewById(2131363022), (TextView)localViewGroup.findViewById(2131363023), (TextView)localViewGroup.findViewById(2131379304), (TextView)localViewGroup.findViewById(2131365353));
    this.rewardTimingPresenter.a(paramActivity);
  }
  
  public boolean enabled()
  {
    return (rjy.a()) || (prj.a());
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
    this.mObserver = new tzp(this);
    pvm.a().a(this.mObserver);
    if (getInstance().getActivity() != null) {
      attachDebugView(getInstance().getActivity());
    }
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    pvm.a().b(this.mObserver);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    stopTiming();
  }
  
  public void removedByJs()
  {
    pvm.a().b(this.mObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */
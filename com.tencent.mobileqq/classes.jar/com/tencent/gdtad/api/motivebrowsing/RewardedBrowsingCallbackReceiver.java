package com.tencent.gdtad.api.motivebrowsing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.RewardedVideoAdPlugin;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/RewardedBrowsingCallbackReceiver;", "Landroid/content/BroadcastReceiver;", "plugin", "Lcom/tencent/qqmini/proxyimpl/RewardedVideoAdPlugin;", "proxy", "Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;", "(Lcom/tencent/qqmini/proxyimpl/RewardedVideoAdPlugin;Lcom/tencent/qqmini/proxyimpl/AdProxyImpl;)V", "mPlugin", "Lmqq/util/WeakReference;", "mProxy", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class RewardedBrowsingCallbackReceiver
  extends BroadcastReceiver
{
  public static final RewardedBrowsingCallbackReceiver.Companion a;
  private final WeakReference<RewardedVideoAdPlugin> a;
  private final WeakReference<AdProxyImpl> b;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadApiMotivebrowsingRewardedBrowsingCallbackReceiver$Companion = new RewardedBrowsingCallbackReceiver.Companion(null);
  }
  
  public RewardedBrowsingCallbackReceiver()
  {
    this(null, null, 3, null);
  }
  
  public RewardedBrowsingCallbackReceiver(@Nullable RewardedVideoAdPlugin paramRewardedVideoAdPlugin, @Nullable AdProxyImpl paramAdProxyImpl)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramRewardedVideoAdPlugin);
    this.b = new WeakReference(paramAdProxyImpl);
  }
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RewardedBrowsingCallbackReceiver", 2, "RewardedBrowsingCallbackReceiver onReceive");
    }
    if ((paramIntent != null) && (TextUtils.equals((CharSequence)paramIntent.getAction(), (CharSequence)"AD_PROXY_ACTION_MOTIVE_BROWSING_END")))
    {
      paramContext = (AdProxyImpl)this.b.get();
      if (paramContext != null) {
        paramContext.a(paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver
 * JD-Core Version:    0.7.0.1
 */